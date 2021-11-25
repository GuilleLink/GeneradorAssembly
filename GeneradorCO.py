#Universidad del Valle de Guatemala
#Juan Guillermo Sandoval Lacayo - 17577
#Proyecto generador de codigo objetivo (target)

#Librerias
import sys
from antlr4 import *
from DecafLexer import DecafLexer
from DecafParser import DecafParser
from DecafListener import DecafListener
#from GeneradorCI import *

class GeneradorCO():
    def __init__(self):
        self.memory = {}
        self.registros = {
            'r0' : [],
            'r1' : [],
            'r2' : [],
            'r3' : [],
            'r4' : [],
            'r5' : [],
            'r6' : [],
            'r7' : [],
            'r8' : [],
            'r9' : [],
            'r10': []
        }
        self.functionSize = 30
        self.code = ".global _start \n"

    def main(self):
        file = open("./Intermedios/factorialIntermedio.txt", "r")
        call = 0
        param = 0
        inputFlag = False
        outputFlag = False
        condicionales = {
            '==': 'beq',
            '<=': 'ble',
            '>=': 'bge',
            '<' : 'blt',
            '>' : 'bgt',
            '!=': 'bne',
        }
        lines = file.readlines()
        for line in lines:
            if len(line.split()) > 0:
                #Si no es el cierre de una definicion de funcion
                if "DEF" in line and "EXIT" not in line:
                    self.registros = {
                        'r0' : [],
                        'r1' : [],
                        'r2' : [],
                        'r3' : [],
                        'r4' : [],
                        'r5' : [],
                        'r6' : [],
                        'r7' : [],
                        'r8' : [],
                        'r9' : [],
                        'r10': []
                    }
                    call = 0
                    #funcionSize = self.functionSize[line[4:-2]][0]
                    if "main"  in line:
                        self.code += "start:\n"
                    else:
                        line = line.replace("\n", "")
                        posDef = line.find("DEF")+4
                        functionName = line[posDef:]
                        self.code += f"{functionName}:\n"

                    if "InputInt" in line:
                        inputFlag = True
                    if "OutputInt" in line:
                        outputFlag = True

                    if outputFlag:
                        outputFlag = False
                    elif inputFlag:
                        inputFlag = False
                    elif not inputFlag and not outputFlag:
                        self.code += "\tpush {r11,lr}\n"
                        self.code += "\tmov r11, sp\n"
                        self.code += "\tsub sp, sp, #4\n"

                elif "EXIT" in line and "DEF" in line:
                    if (call > 0):                        
                        self.code += "\tmov sp, r11\n"
                        self.code += "\tpop {r11, lr}\n"
                        self.code += f"\tbx lr\n"
                    else:
                        if "OutputInt" in line:
                            self.code += "\tsub sp, sp, #4\n"
                            self.code += "\tldr r1, =0xFF201000\n"
                            self.code += "\tadd r0, r0, #48\n"
                            self.code += "\tstr r0, [r1]\n"
                            self.code += "\tadd sp, sp, #4\n"
                            self.code += "\tbx lr\n"
                        elif "InputInt" in line:
                            self.code += "\tsub sp, sp, #0\n"
                            self.code += "\tldr r1, =0xFF200050\n"
                            self.code += "\tldr r0, [r0]\n"
                            self.code += "\tadd sp, sp, #0\n"
                            self.code += "\tbx lr\n"
                        else:
                            self.code += "\tpush {r11, lr}\n"
                            self.code += "\tadd r11, sp, #0\n"
                            self.code += f"\tsub sp, sp, #{self.functionSize}\n"

                            self.code += "\tadd sp, r11, #0\n"
                            self.code += "\tpop {r11, lr}\n"
                            self.code += "\tbx lr\n"

                elif "PARAM" in line:
                    line = line.strip()
                    registerParam = 'r' + str(param)
                    param +=1
                    posVariable = line.find("PARAM")
                    variable = line[posVariable+6:]
                    
                    #En este caso se manejan solo variables locales para los parametros
                    if "L" in variable:
                        value = str(variable[2:-1])                        
                        if value.isnumeric():
                            variable = f"[sp, #{value}]"
                        else:
                            start = variable.find("[")
                            end = variable.find("]")
                            temporal = variable[start+1:end]
                            #Se busca que se encuentre en los registros el valor buscado
                            for key, value in self.registros.items():
                                if temporal in value:
                                    variable = f"[sp, #{key}]"
                                    break
                        self.code += f"\tstr {registerParam}, {variable}\n"
                        self.code += f"\tldr {registerParam}, {variable}\n"

                elif "CALL" in line:
                    param = 0
                    call += 1
                    line = line.strip()
                    posFunc = line.find(",")
                    nombreFunc = line[5:posFunc]
                    self.code += f"\tbl {nombreFunc}\n"
                    self.registros['r0'] = ['R']
                    self.memory['R'] = ['R', 'r0']

                elif "RETURN" in line:
                    line = line.strip()
                    valorRetorno = line[7:]
                    tempCode = ""

                    if "L" in valorRetorno:
                        val = valorRetorno[2:-1]
                        if val.isnumeric():
                            tempCode = f"[sp, #{val}]"
                        else:
                            start = val.find("[")
                            end = val.find("]")
                            temporal = val[start+1:end]
                            for key, value in self.registros.items():
                                if temporal in value:
                                    tempCode = f"[sp, {key}]"
                                    break                            

                        self.code += f"\tldr r0, {tempCode}\n"

                    elif "G" in valorRetorno:
                        reg = self.getReg(str(valorRetorno))
                        self.code += f"\tmov r0, {reg}\n"

                    elif "t" in valorRetorno:
                        reg = self.getReg(str(valorRetorno))
                        self.code += f"\tmov r0, {reg}\n"
                    else:
                        number = line[7:]
                        self.code += f"\tmov r0, #{number}\n"

                elif ("IF_TRUE" in line or "IF_FALSE" in line or "WHILE_TRUE" in line) and "GOTO" not in line:
                    line = line.strip()
                    self.code += f"{line}:\n"

                elif "IF" in line and "END" not in line:
                    line = line.strip()
                    endIf = line.find("GOTO")
                    nombreCondicional = line[endIf+5:]
                    cond = line[3:endIf]
                    tempCode = ""
                    ldrVal = ""
                    condicional = ""

                    for key, value in condicionales.items():
                        if key in cond:
                            condicional = value
                            comparativa = key

                    posCond = line.find(comparativa)
                    val1 = line[:posCond]
                    val2 = line[posCond+len(comparativa)+1]

                    if ("L" in val1):
                        val = val1[2:-1]
                        if val.isnumeric():
                            ldrVal = f"[sp, #{val}]"
                        else:
                            start = val1.find("[")
                            end = val1.find("]")
                            temporal = val1[start+1:end]
                            for key, value in self.registros.items():
                                if temporal in value:
                                    ldrVal = f"[sp, {key}]"
                                    break

                    elif ("G" in val1):
                        val = self.getReg(val1)
                    elif ("t" in val1):
                        val = self.getReg(line)
                    else:
                        #Por arreglar esto de aqui porque no obtiene adecuadamente
                        self.code += f"\tmov {val}, #{val}"

                    if comparativa in line:
                        #Por arreglar esto de aqui porque no obtiene adecuadamente los valores para el cmp
                        #val1 = self.getReg(val1)
                        #val2 = self.getReg(val2)
                        #self.code += f"\tcmp {val1}, {val2}\n"
                        self.code += f"\t{condicional} {nombreCondicional}\n"
                    else:
                        self.code += f"\tb {nombreCondicional}\n"
                

                elif "GOTO" in line:
                    line = line.strip()
                    function = line[5:]
                    self.code += f"\tb {function}\n"

                elif "END_IF" in line or "END_WHILE" in line:
                    line = line.strip()
                    self.code += f"{line}:\n"
                
                elif "BEGIN_WHILE_" in line:
                    line = line.strip()
                    self.code += f"\tb {line}\n"
                    self.code += f"\t{line}:\n"    
                
                else:
                    self.getReg(line)

        print(self.code)            

    def getReg(self, inst):
        #Limpieza de la linea

        linea = str(inst).strip().replace("\t","").replace(" ","")        
        flagop = False
        op = ""
        opline = ""
        operadores = {
            '+': 'add',
            '-': 'sub',
            '*': 'mul',
            '/': 'div'
        }
        Codigo3Direcciones = {
            'x' : '',
            'y' : '',
            'z' : ''
        }

        registros = self.registros.keys()

        #Se verifica la operacion y se asigna su "linea"
        for key,value in operadores.items():
            #Si lo encuentra no es una asignacion de valor
            if key in linea:
                flagop = True
                op = key
                instruccionOp = value
                opline += value

        #Si encuentra una instruccion de 3 direcciones
        if flagop:
            pos_eq = linea.find("=")
            pos_op = linea.find(op)
            x = linea[:pos_eq]
            y = linea[pos_eq+1:pos_op]
            z = linea[pos_op+1:]
            if x not in registros:
                self.memory[x] = [] if 't' == x[0] else [x]
            if y not in registros:
                self.memory[y] = [] if 't' == y[0] else [y]
            if z not in registros:
                self.memory[z] = [] if 't' == z[0] else [z]

            Codigo3Direcciones['x'] = x
            Codigo3Direcciones['y'] = y
            Codigo3Direcciones['z'] = z


            #Se revisan los casos 1 y 2 del libro
            for key, value in self.registros.items():
                #Se verifica si el valor de y ya se encuentra en los registros asi se evita el hacer la instruccion de cargar
                if y in value:
                    Codigo3Direcciones['y'] = key
                    break
                #Si y no se encuentra en los registros y hay un registro disponible se asigna uno para Ry
                if y not in value:
                    if len(value)==0:
                        self.registros[key] = [y]
                        self.memory[y].append(key)
                        if y.isnumeric():
                            self.code += f"\tmov {key}, #{y}\n"    
                            self.code += f"\t{instruccionOp} {key}, {key}, #{y}"
                        else:
                            pass                    
                        break

            for key, value in self.registros.items():
                for key2, value2 in self.memory.items():
                    #Si el registro que tengo en los registros tambien lo tengo asignado en memoria entonces puedo liberar dicho registro
                    if key == key2:
                        pass

            return registros    
        #Si no se anda trabajando una operacion, es una asignacion
        else:
            pos_eq = linea.find("=")
            pos_op = linea.find(op)
            x = linea[:pos_eq]
            y = linea[pos_eq+1:]
            if x not in registros:
                self.memory[x] = [] if 't' == x[0] else [x]
            if y not in registros:
                self.memory[y] = [] if 't' == y[0] else [y]

            #Se llama igual aunque solo se a de una asignacion
            Codigo3Direcciones['x'] = x
            Codigo3Direcciones['y'] = y

            for key, value in self.registros.items():
                if inst in value:
                    return key

generador = GeneradorCO()
generador.main()
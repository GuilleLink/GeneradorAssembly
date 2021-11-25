#Universidad del Valle de Guatemala
#Juan Guillermo Sandoval Lacayo - 17577
#Proyecto generador de code intermedio

#Librerias
import sys
from antlr4 import *
from DecafLexer import DecafLexer
from DecafParser import DecafParser
from DecafListener import DecafListener
#from DecafVisitor import DecafVisitor

class SymbolTable():
    def __init__(self, id, var_type, offset, size, value,  array, params=False, scope="global"):
        self.id = id
        self.var_type = var_type
        self.offset = offset
        self.size = size
        self.scope = scope
        self.value = value
        self.params = params
        self.array = array

class DecafWalker(DecafListener):
    def __init__(self) -> None:
        #Tabla de simbolos importando la idea del proyecto 1
        self.symbolTable = {'global': [None,None,{}]}
        self.ifCounter = 0
        self.whileCounter = 0
        self.tempCounter = 0
        self.lastCondition = ''
        self.typeTable = {
            "int": [4, 0],
            "char": [2, ""],
            "boolean": [1, "true"],
            "void": [0, ""]
            }
        #Cambio a que todos los offsets se manejen de la siguiente forma {scope:offset}
        self.offsets = {}
        self.code = {}
        self.temporalScope = []
        self.intermediateCode = ''

    
    def enterProgram(self, ctx: DecafParser.ProgramContext):
        self.temporalScope.append('global')
        self.offsets[self.temporalScope[-1]] = []
        self.offsets[self.temporalScope[-1]].append(0)

    def exitProgram(self, ctx: DecafParser.ProgramContext):

        #for key, value in self.symbolTable.items():
        #    print('Scope:', key)
        #    print('Parent:', value[0])
        #    print('Type:', value[1])

#            for key2, value2 in value[2].items():
#                print('Variable', value2.id, 'offset:', value2.offset)

#            print('')

        declaration = ctx.declaration()

        #for i in self.code:
        #    print(i.getText())

        print(self.intermediateCode)

    def exitDeclaration(self, ctx: DecafParser.DeclarationContext):
        if(type(ctx.getChild(0)) == DecafParser.MethodDeclarationContext):
            self.code[ctx] = self.code[ctx.getChild(0)]
            if(ctx.getChild(0) in self.code[ctx.getChild(0)]):
                self.code[ctx] = self.code[ctx.getChild(0)]
        elif(type(ctx.getChild(0)) == DecafParser.VarDeclarationContext):
            self.code[ctx] = self.code[ctx.getChild(0)]


    def enterMethodDeclaration(self, ctx: DecafParser.MethodDeclarationContext):
        self.temporalScope.append(ctx.ID().getText())               
        self.offsets[self.temporalScope[-1]] = [0]
        returnType = ctx.methodType().getText()
        self.intermediateCode += f'DEF {ctx.ID().getText()}: \n'
        try:
            #print("ENTERMETHODDECLARATION")
            for x in range(ctx.getChildCount()):
                try:
                    #print(ctx.getChild(x).getText())
                    pass
                except:
                    pass
            #self.intermediateCode += f'{ctx.getChild(0).getText()}'
        except:
            pass
        self.symbolTable[self.temporalScope[-1]] = [self.temporalScope[-2], returnType, {}]

        #Todo el recorrido de parametros de cada metodo
        for x in range(ctx.getChildCount()):
            if isinstance(ctx.getChild(x), DecafParser.ParameterContext):
                paramType = ctx.getChild(x).parameterType().getText()
                if(paramType != 'void'):
                    paramID = ctx.getChild(x).ID().getText()
                else:
                    return
                size = self.typeTable[paramType][0]
                offset = self.offsets[self.temporalScope[-1]][-1]

                self.symbolTable[self.temporalScope[-1]][2][paramID] = SymbolTable(paramID, paramType, offset, size, value=None, array=None, params=True, scope=self.temporalScope[-1])
                offset += size
                self.offsets[self.temporalScope[-1]].append(offset)

    def exitMethodDeclaration(self, ctx: DecafParser.MethodDeclarationContext):
        code = 'DEF ' + ctx.ID().getText()+':' + self.code[ctx.block()]['code'] + 'EXIT DEF' + ctx.ID().getText()
        self.code[ctx] ={
            'code' : code
        }
        self.temporalScope.pop()
        self.intermediateCode += f'EXIT DEF {ctx.ID().getText()} \n'

    def enterLocation(self, ctx:DecafParser.LocationContext):
        if (ctx.location() is None):
            return

        locationID = str(ctx.getChild(2).ID())

        val = self.checkOnTable(locationID, self.temporalScope[-1])
        isArray = val.array

        if (not isArray):
            name = ctx.getChild(0).getText()

            locationType = val.var_type

            self.IterationOnChildren(ctx.location(), locationType)

            self.code[ctx] = {
                'code' : + [code]
            }


    #Solamente se obtiene a partir del Var_id o array_id
    def exitLocation(self, ctx: DecafParser.LocationContext):
        if(ctx not in self.code.keys()):
            if (ctx.getChild(2)):
                try:
                    literalType = self.code[ctx.var_id()]
                except:
                    literalType = self.code[ctx.int_literal()]
                varID = ctx.getChild(0).ID().getText()
                val = self.checkOnTable(varID, self.temporalScope[-1])
                valType = val.var_type
                size = self.typeTable[valType][0]

                t = self.newTemp()
                addr = self.newTemp()
                value = literalType['addr'] + '*' + str(size)
                c1 = t + '=' + value
                c2 = addr + '=' + str(value.offset) + ' + '+ t
                code = c1+c2
                self.code[ctx] = {
                    'addr' : addr,
                    'code' : code
                }
            else:
                varID = ctx.getChild(0).ID().getText()
                addr = self.top_get(varID, self.temporalScope[-1])

                self.code[ctx] = {
                    'addr' : addr,
                    'code' : ''
                }

    def exitStatement_methodCall(self, ctx: DecafParser.Statement_methodCallContext):
        self.code[ctx] = self.code[ctx.methodCall()]

    def enterExpression_parenthesis(self, ctx:DecafParser.Expression_parenthesisContext):
        self.code[ctx.expression()] = self.code[ctx]

    def exitExpression_parenthesis(self, ctx:DecafParser.Expression_parenthesisContext):
        child = ctx.expression()
        self.code[ctx] = self.code[child]

    def exitExpression_methodCall(self, ctx: DecafParser.Expression_methodCallContext):
        self.code[ctx] = self.code[ctx.methodCall()]

    def exitMethodCall(self, ctx: DecafParser.MethodCallContext):
        expr = ctx.expression()
        methodID = ctx.ID().getText()
        code = ''

        for exp in expr:
            try:
                if('[' in exp.location().getText()):
                    code += self.code[exp]['code']
                code += ' PARAM ' + self.code[exp]['addr']
            except:
                pass

        call = 'CALL ' + methodID + ', ' + str(len(expr)) +'\n'
        
        self.code[ctx] = {
            'code' : code,
            'addr' : 'R'
        }
        self.intermediateCode += call


    def exitVar_id(self, ctx:DecafParser.Var_idContext):
        name = ctx.getText()

        self.code[ctx] = {
            'code' : '',
            'addr' : ''
        } 


    def exitArray_id(self, ctx:DecafParser.Array_idContext):
        parent = ctx.parentCtx
        id = ctx.getChild(0).getText()

        topget = self.top_get(id, self.temporalScope[-1])


    def exitExpression_location(self, ctx: DecafParser.Expression_locationContext):        
        self.code[ctx] = self.code[ctx.getChild(0)]
        addr = self.newTemp()
        L = self.code[ctx.location()]
        top = self.top_get(ctx.getChild(0).getChild(0).ID().getText(), self.temporalScope[-1])
        self.code[ctx] = {
            'code': self.code[ctx.location()]['code'],
            'addr': top
        }

    def enterStructDeclaration(self, ctx: DecafParser.StructDeclarationContext):
        structName = ctx.getChild(0).getText() + ctx.getChild(1).getText()

    def exitStructDeclaration(self, ctx: DecafParser.StructDeclarationContext):

        struct = ''
        name = ''
        for x in range(ctx.getChildCount()):
            if x == 0:
                struct = ctx.getChild(x).getText()
            elif x==1:
                name = ctx.getChild(x).getText()

        newDataType = struct + name
        self.typeTable[newDataType] = [4,""]

    def enterVarType_struct(self, ctx: DecafParser.VarType_structContext):
        pass

    def exitVarType_struct(self, ctx: DecafParser.VarType_structContext):
        pass

    def enterVarDeclaration_ID(self, ctx: DecafParser.VarDeclaration_IDContext):                

        if(ctx.varType() is not None):
            varType = ctx.varType().getText()
            varID = ctx.ID().getText()
            size = self.typeTable[varType][0]
            offset = self.offsets[self.temporalScope[-1]][-1]
            self.symbolTable[self.temporalScope[-1]][2][varID] = SymbolTable(varID, varType, offset, size, value=None, array=True, params=False, scope=self.temporalScope)
            offset = offset+size
            self.offsets[self.temporalScope[-1]].append(offset)

    def enterVarDeclaration_Array(self, ctx: DecafParser.VarDeclaration_ArrayContext):
        if(ctx.varType() is not None):
            varType = ctx.varType().getText()
            varID = ctx.getChild(1).getText()
            try:
                arraySize = ctx.NUM().getText()
            except:
                arraySize = ctx.getChild(3).getText()
                offset = self.checkOnTable(varID,self.temporalScope[-1]).offset
            size = self.typeTable[varType][0]
            size = size*int(arraySize)
            offset = self.offsets[self.temporalScope[-1]][-1]
            self.symbolTable[self.temporalScope[-1]][2][varID] = SymbolTable(varID, varType, offset, size, value=None, array=True, params=False, scope=self.temporalScope)
            offset = offset+size
            self.offsets[self.temporalScope[-1]].append(offset)


    def exitVarDeclaration_Array(self, ctx: DecafParser.VarDeclaration_ArrayContext):
        
        for x in range(ctx.getChildCount()):
            if (x==0):
                #Se consigue el valor del desplazamiento del offset
                varType = ctx.getChild(x).getText()                
                variableOffset = self.typeTable[varType][0]
            elif (x==1):
                #Se consigue el nombre de la variable que se esta registrando aunque se modifique a t#
                var_id = ctx.getChild(x).getText()
            elif (x==3):
                ctx.getChild(x).getText()

        topget = self.top_get(var_id, self.temporalScope[-1])
        code = {
            'addr': topget,
            'code': ''
        }


    def enterStatement_if(self, ctx: DecafParser.Statement_ifContext):

        end = f'END_IF_{self.ifCounter} \n'
        true = f'IF_TRUE_{self.ifCounter}: \n'
        false = f'IF_FALSE_{self.ifCounter}: \n'

        self.intermediateCode += true

        if(len(ctx.children) > 5):
            expr = ctx.getChild(2)
            ifBlock = ctx.getChild(4)
            elseBlock = ctx.getChild(6)
            self.code[expr] = {
                'code': '',
                'true':true,
                'false':false
            }
            self.code[ifBlock] = {
                'next': end
            }
            self.code[elseBlock] = {
                'next': end
            }
        else:
            expr = ctx.getChild(2)
            block = ctx.getChild(4)
            
            self.code[expr] = {
                'code': '',
                'true': true,
                'false': end
            }
        
            self.code[block] = {
                'next': end
            }



    def exitStatement_if(self, ctx: DecafParser.Statement_ifContext):
        if(len(ctx.children) > 5):
            expr = ctx.expression()
            block1 = ctx.getChild(4)
            block2 = ctx.getChild(6)
            B = self.code[expr]
            S1 = self.code[block1]
            S2 = self.code[block2]

            self.code[ctx] = {
                'code': B['code']+B['true']+S1['code']+'GOTO '+S1['next']+B['false'] +S2['code']+S1['next']
            }
            #self.intermediateCode += self.code[ctx]['code']
            
        else:
            expr = ctx.expression()
            block = ctx.getChild(4)
            B = self.code[expr]
            S = self.code[block]
            self.code[ctx] = {
                'code': B['code'] + B['true'] + S['code'] + B['false']
            }
            #self.intermediateCode += self.code[ctx]['code']
        
        self.ifCounter +=1
        
    def enterStatement_while(self, ctx: DecafParser.Statement_whileContext):
        false = f'END_WHILE_{self.whileCounter} \n'
        true = f'WHILE_TRUE_{self.whileCounter}:\n'
        start = f'BEGIN_WHILE_{self.whileCounter}:\n'
        condition = f'IF {self.lastCondition} GO TO {true}GO TO {false}'

        self.intermediateCode += start+condition+true

        expr = ctx.expression()
        block = ctx.block()

        self.code[expr] = {
            'code' : '',
            'true' : true,
            'false' : false
        }
        self.code[block] = {
            'next' : start
        }

    def exitStatement_while(self, ctx: DecafParser.Statement_whileContext):
        self.whileCounter +=1
        expr = ctx.expression()
        block = ctx.block()
        B = self.code[expr]
        S = self.code[block]

        code = S['next']+B['code']+B['true']+S['code']+' GOTO ' + S['next'] + B['false']

        self.code[ctx] = {
            'code' : code
        }

        self.intermediateCode += 'GOTO ' + S['next'] + B['false']

    def exitVarDeclaration_ID(self, ctx: DecafParser.VarDeclaration_IDContext):

        for x in range(ctx.getChildCount()):
            if (x==0):
                #Se consigue el valor del desplazamiento del offset
                varType = ctx.getChild(x).getText()                
                variableOffset = self.typeTable[varType][0]
            elif (x==1):
                #Se consigue el nombre de la variable que se esta registrando aunque se modifique a t#
                var_id = ctx.getChild(x).getText()

        topget = self.top_get(var_id, self.temporalScope[-1])
        code = {
            'addr': topget,
            'code': ''
        }

    def exitStatement_return(self, ctx: DecafParser.Statement_returnContext):
        expr = ctx.expression()

        code = 'RETURN ' + self.code[expr]['addr']
        self.code[ctx] = {
            'code' : code
        }
        self.intermediateCode += code +'\n'

    def exitStatement_expression(self, ctx: DecafParser.Statement_expressionContext):
        pass

    def exitExpression_firstPrecedence(self, ctx:DecafParser.Expression_firstPrecedenceContext):
        op = ctx.getChild(1).getText()
        CodeE1 = self.code[ctx.getChild(0)]
        CodeE2 = self.code[ctx.getChild(2)]
        addr = self.newTemp()

        self.code[ctx] = {
            'addr' : addr,
            'code' : CodeE1['code'] + CodeE2['code'] + addr + '=' + CodeE1['addr'] + op + CodeE2['addr']
        }

    def exitExpression_SecondPrecedence(self, ctx: DecafParser.Expression_SecondPrecedenceContext):
        op = ctx.getChild(1).getText()
        CodeE1 = self.code[ctx.getChild(0)]
        CodeE2 = self.code[ctx.getChild(2)]
        addr = self.newTemp()

        self.code[ctx] = {
            'addr' : addr,
            'code' : CodeE1['code'] + CodeE2['code'] + '\n' + addr + '=' + CodeE1['addr'] + op + CodeE2['addr']
        }

    def enterArith_op_and(self, ctx:DecafParser.Arith_op_andContext):
        
        for expr in ctx.expression():
            self.code[expr] = self.code[ctx]

        b_true = self.crearEtiqueta('EXPR')
        cont = 0
        for expr in ctx.expression():
            if cont == 0:
                self.code[expr] = {
                    'true': b_true,
                    'false': self.code[expr]['false']
                }
            cont += 1

    def exitArith_op_and(self, ctx:DecafParser.Arith_op_andContext):
        expr1 = ctx.getChild(0)
        expr2 = ctx.getChild(2)
        B = self.code[ctx]
        B1 = self.code[expr1]
        B2 = self.code[expr2]
        B1_true = B1['true'] 
        B1_false = B['false']
        B2_true = B['true']
        B2_false = B['false']
        self.code[expr1] = {
            'true': B1_true,
            'false': B1_false,
            'code': B1['code']
        }
        self.code[expr2] = {
            'true': B2_true,
            'false': B2_false,
            'code': B2['code']
        }
        code = self.code[expr1]['code']+[B1_true]+self.code[expr2]['code']
        self.code[ctx] = {
            'code' : code,
            'true' : self.code[ctx]['true'],
            'false': self.code[ctx]['false']
        }

    def enterArith_op_or(self, ctx:DecafParser.Arith_op_orContext):
        
        for expr in ctx.expression():
            self.code[expr] = self.code[ctx]

        b_false = self.crearEtiqueta('EXPR')
        cont = 0
        for expr in ctx.expression():
            if cont == 0:
                self.code[expr] = {
                    'true': self.code[expr]['true'],
                    'false': b_false
                }
            cont += 1

    def exitArith_op_or(self, ctx:DecafParser.Arith_op_orContext):
        expr1 = ctx.getChild(0)
        expr2 = ctx.getChild(2)
        B = self.code[ctx]
        B1 = self.code[expr1]
        B2 = self.code[expr2]
        B1_true = B['true'] 
        B1_false = B1['false']
        B2_true = B['true']
        B2_false = B['false']

        self.code[expr1] = {
            'code': B1['code'],
            'true': B1_true,
            'false': B1_false,
        }
        self.code[expr2] = {
            'code': B2['code'],
            'true': B2_true,
            'false': B2_false,
        }
        code = self.code[expr1]['code']+[B1_false]+self.code[expr2]['code']
        self.code[ctx] = {
            'code' : code,
            'true' : self.code[ctx]['true'],
            'false': self.code[ctx]['false']
        }

    def enterExpression_compare(self, ctx:DecafParser.Expression_compareContext):
        mem1 = ''
        mem2 = ''
        try:
            try:
                LSvariable = ctx.getChild(0).location().var_id().ID().getText()
            except:
                LSvariable = ctx.getChild(0).location().array_id().ID().getText()
                
            mem1 = self.top_get(LSvariable, self.temporalScope[-1])
        except:
            mem1 = ctx.getChild(0).getText()
        try:
            try:
                RSvariable = LSvariable = ctx.getChild(2).location().var_id().ID().getText()
            except:
                RSvariable = LSvariable = ctx.getChild(2).location().array_id().ID().getText()
            mem2 = self.top_get(RSvariable, self.temporalScope[-1])
        except:
            mem2 = ctx.getChild(2).getText()

        code = mem1 + ctx.getChild(1).getText() + mem2
        self.code[ctx] = {
            'code' : code,
            'addr' : '',
            'true' : '',
            'false' : '',
            'next' : '',
        }
        #print('CONDITION')
        #print(code)
        self.lastCondition = code

    def exitExpression_compare(self, ctx:DecafParser.Expression_compareContext):
        self.code[ctx]


    #Se envia al padre
    def exitExpression_literal(self, ctx:DecafParser.Expression_literalContext):
        self.code[ctx] = self.code[ctx.getChild(0)]

    #Se envia al padre
    def exitLiteral(self, ctx:DecafParser.LiteralContext):
        self.code[ctx] = self.code[ctx.getChild(0)]
        
    #Se settea en el hijo
    def exitInt_literal(self, ctx: DecafParser.Int_literalContext):
        self.code[ctx] = {
            'code' : '',
            'addr' : ctx.getText()
        }

    #Se settea en el hijo
    def exitBool_literal(self, ctx: DecafParser.Bool_literalContext):
        self.code[ctx] = {
            'code' : '',
            'addr' : ctx.getText()
        }

    def exitChar_literal(self, ctx:DecafParser.Char_literalContext):
        self.code[ctx] = {
            'code' : '',
            'addr' : ctx.getText()
        }

    def exitStatement_assignValue(self, ctx: DecafParser.Statement_assignValueContext):

        toAssign = ctx.location()
        assignedValue = ctx.expression()

        E = self.code[assignedValue]
        L = self.code[toAssign]

        code = ''

        try:
            if(ctx.expression().methodCall()):
                self.code[ctx] = self.code[ctx.getChild(0)]
        except:
            pass
        if(ctx.location().location()):
            code = L['code']+E['code']+L['addr'] +' = ' +E['addr']
            self.code[ctx] = {
                'addr' : '',
                'code' : L['code']+E['code']+L['addr'] +' = ' +E['addr']
            }

        if toAssign.var_id():
            id = toAssign.var_id().getText()
            topget = self.top_get(id, self.temporalScope[-1])

            code = E['code'] + '\n' + topget + "=" + E['addr'] + '\n'

            self.code[ctx] = {
                'code' : code,
                'addr' : E['addr']
            }



        if toAssign.array_id():
            array_id = toAssign.array_id().ID().getText()
            topget = self.top_get(array_id, self.temporalScope[-1])
            addr = E['addr']

            code = self.code[toAssign]['code'] + E['code'] + \
                f'{topget}'

            self.code[ctx] = {
                'code' : code,
                'addr' : addr
            }

        self.intermediateCode += code

    def exitBlock(self, ctx:DecafParser.BlockContext):           
        if (type(ctx.parentCtx) == DecafParser.Statement_ifContext or type(ctx.parentCtx) == DecafParser.Statement_whileContext):
            statements = ctx.statement()
            code = ''
            for statement in statements:
                try:
                    #print(self.code[statement.expression().methodCall()])
                    pass
                except:
                    pass
                code += self.code[statement]['code']

            self.code[ctx]['code'] = code

        else:
            statements = ctx.statement()
            code = ''
            for statement in statements:
                #print(statement.getText())
                code += self.code[statement]['code']

            self.code[ctx] = {
                'addr': '',
                'code': code
            }

    def newTemp(self):
        createdTemp = "t"+str(self.tempCounter)
        self.tempCounter += 1
        return createdTemp

    def checkOnTable(self, id, scope):
        found = False
        for key in reversed(list(self.symbolTable.keys())):
            if((found == False) and (key in self.temporalScope)):
                for keyInKeys, value in self.symbolTable[key][2].items():
                    if(id==value.id):
                        found = True
                        return value

    def top_get(self, id, scope, Array_value=None):
        memType = ''
        offset = self.checkOnTable(id, scope).offset
        if(scope == 'global'):
            memType = f'G[{offset}]'
        else:
            memType = f'L[{offset}]'            

        return memType

    def IterationOnChildren(self, location, parent_type):
        try:
            name = str(location.getChild(2).ID())
            v = self.getTableInfo(name,True)
            esArray = v.array
        except:
            esArray = location.getChild(2)

        if esArray:
            pass
        else:
            if location.location() is None:
                id = location.getChild(0).getText()
                child = self.checkOnTable(id,self.temporalScope[-1])                
                num = child.offset
                
                total = {
                    'code': [],
                    'addr': str(num)
                }
                self.code[location] = total
                return total
            id = location.getChild(0).getText()
            
            child = self.getTableInfo(id,True)
            child_type = child.var_type
            num = self.IterateChildren(location.location(), child_type)

            temp = self.crearTemporal()
            code = [temp + ' = ' + str(num['addr']) + ' + ' + str(child.offset)]
            allCode = {
                'code': num['code'] + code,
                'addr': temp
            }            
            self.code[location] = allCode
            return  allCode

def main():
    input_stream = FileStream('fibonacci_1.txt')
    lexer = DecafLexer(input_stream)
    stream = CommonTokenStream(lexer)
    parser = DecafParser(stream)
    tree = parser.program()

    listener = DecafWalker()
    walker = ParseTreeWalker()
    walker.walk(listener, tree)

main()

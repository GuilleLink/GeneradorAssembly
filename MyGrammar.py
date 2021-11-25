#Universidad del Valle de Guatemala
#Juan Guillermo Sandoval Lacayo - 17577
#Proyecto Listener

#Librerias UI
from tkinter.constants import END, INSERT
import tkinter as tk
from tkinter import filedialog as fd

#Librerias
import sys
from antlr4 import *
from DecafLexer import DecafLexer
from DecafParser import DecafParser
from DecafListener import DecafListener
#from DecafVisitor import DecafVisitor

global offset
global errors
global actualScope
global classScope
global numberDepth
global identation
identation = 0
offset = 0
errors = []
actualScope = ""
classScope = ""
numberDepth = 0
hashtable = {}
typeTable = {
    "int": [4, 0],
    "char": [2, ""],
    "boolean": [1, "true"],
    "void": [0, ""],
}

class DecafWalker(DecafListener):
    def __init__(self) -> None:
        super().__init__()
    
    def enterProgram(self, ctx: DecafParser.ProgramContext):
        '''
        for x in range(ctx.getChildCount()):
            try:
                print("Program: ", ctx.declaration(x).getText())
                pass
            except:
                pass
        '''
        global actualScope
        global classScope
        actualScope = "Program"
        classScope = "Program"
        hashtable[classScope] = {}
        hashtable[classScope][classScope] = SymbolInTable("Program", "void", "class", "global", None, None, None)
                
        for key,value in hashtable.items():
            print(value)
            for key2,value2 in value.items():
                print(value2.getAll())
        
    def exitProgram(self, ctx):
        pass

    def enterMethodDeclaration(self, ctx: DecafParser.MethodDeclarationContext):
        global offset
        global actualScope
        global classScope
        global numberDepth
        numberDepth += 1
        LocalOffset = offset
        try:
            _type = ctx.methodType().getText()
            _name = ctx.ID().getText()        
            actualScope = _name
            _param = ctx.getChildCount()
            _paramTypes = []
            _paramIDS = []
            for x in range(_param):
                try:
                    if(ctx.getChild(x).ID().getText() in _paramIDS):
                        print("Variable ", ctx.getChild(x).ID().getText(), " already previously defined in parameters")
                        errors.append("Variable ", ctx.getChild(x).ID().getText(), " already previously defined in parameters")
                    else:
                        _paramIDS.append(ctx.getChild(x).ID().getText())
                    _paramTypes.append(ctx.getChild(x).parameterType().getText())
                except:
                    pass
            
                hashtable[classScope][actualScope] = {}
                hashtable[classScope][actualScope][actualScope] = SymbolInTable(_name, _type, "function", _name, LocalOffset, None, _paramTypes)
                #print(hashtable[classScope][actualScope][actualScope].getAll())
        except:
            pass
        

    def exitMethodDeclaration(self, ctx: DecafParser.MethodDeclarationContext):
        global numberDepth
        numberDepth -= 1

    def enterMethodCall(self, ctx: DecafParser.MethodCallContext):
        try:
            #print(ctx.expression())
            pass
        except:
            print("Data type on function ", ctx.ID() ," not valid")
            pass

    def exitMethodCall(self, ctx):
        return super().exitMethodCall(ctx)

    def enterExpression_location(self, ctx: DecafParser.Expression_locationContext):
        try:
            #print(ctx.location().getText())
            pass
        except:
            pass

    def exitExpression_location(self, ctx):
        return super().exitExpression_location(ctx)

    def enterStructDeclaration(self, ctx: DecafParser.StructDeclarationContext):
        global classScope
        global actualScope
        try:
            actualScope = "struct " + ctx.ID().getText()
            hashtable[classScope][actualScope] = {}
        except:
            pass

    def exitStructDeclaration(self, ctx):
        return super().exitStructDeclaration(ctx)

    def enterVarType_struct(self, ctx: DecafParser.VarType_structContext):
        global classScope
        try:
            _type = "struct " + ctx.ID().getText()
            _definitionStruct = hashtable[classScope][_type]
        except:
            print("Struct struct", ctx.ID().getText() ,"is not defined")

    def enterVarDeclaration_ID(self, ctx: DecafParser.VarDeclaration_IDContext):        
        global offset
        global actualScope
        global numberDepth
        global classScope
        try:
            try:
                Localoffset = offset
                _name = ctx.ID().getText()
                try:
                    _type = ctx.varType().ID().getText()
                except:
                    _type = ctx.varType().getText()
                Localoffset += typeTable[_type][0]
                _defaultValue = typeTable[_type][1]
                if(_name not in hashtable[actualScope]):
                    hashtable[actualScope][_name] = SymbolInTable(_name, _type, "variable", actualScope, Localoffset, _defaultValue, None)
                else:
                    print("Variable ", _name, " type ", _type, " already defined in scope ", actualScope)
                    errors.append("Variable ", _name, " type ", _type,  " already defined", actualScope)
                offset = Localoffset
            except:
                Localoffset = offset
                _name = ctx.ID().getText()
                _type = ctx.varType().getText()
                if("struct" in _type):
                    _type = "struct " + ctx.varType().ID().getText()                    
                    _defaultValue = hashtable[classScope][_type]
                else:
                    Localoffset += typeTable[_type][0]
                    _defaultValue = typeTable[_type][1]                
                if(_name not in hashtable[classScope][actualScope]):
                    hashtable[classScope][actualScope][_name] = SymbolInTable(_name, _type, "variable", actualScope, Localoffset, _defaultValue, None)
                else: 
                    print("Variable ", _name, " type ", _type,  " already defined in scope ", actualScope)
                    errors.append("Variable ", _name, " type ", _type,  " already defined", actualScope)
                offset = Localoffset
        except:            
            pass

    def exitVarDeclaration_ID(self, ctx):
        return super().exitVarDeclaration_ID(ctx)


    def enterVarDeclaration_Array(self, ctx: DecafParser.VarDeclaration_ArrayContext):
        global offset
        global actualScope
        global numberDepth
        global classScope
        try:
            try:
                LocalOffset = offset
                _name = ctx.ID().getText()
                _type = ctx.varType().getText()
                _objType = "array"
                _typeSize = typeTable[_type][0]
                try:
                    ctx.NUM().getText()
                except:
                    ctx.var_id().getText()
                _size = int(ctx.NUM().getText())*_typeSize
                if(_size > 0):
                    LocalOffset += _size
                    hashtable[classScope][actualScope][_name] = SymbolInTable(_name, _type, _objType, actualScope, LocalOffset, [], None)
                    offset = LocalOffset
                else:
                    print("Size of an array cannot be less or equal to 0.")
                    errors.append("Size of an array cannot be less or equal to 0.")
            except:
                LocalOffset = offset
                _name = ctx.ID().getText()
                _type = ctx.varType().getText()
                _objType = "array"
                _typeSize = typeTable[_type][0]
                _size = int(ctx.NUM().getText())*_typeSize
                if(_size > 0):
                    LocalOffset += _size
                    hashtable[actualScope][_name] = SymbolInTable(_name, _type, _objType, actualScope, LocalOffset, [], None)
                    offset = LocalOffset
                else:
                    print("Size of an array cannot be less or equal to 0.")
                    errors.append("Size of an array cannot be less or equal to 0.")
        except:
            pass

    def enterStatement_if(self, ctx: DecafParser.Statement_ifContext):
        try:
            pass
            #print("If Condition:", ctx.expression().getText())
        except:
            pass
    
    def exitStatement_if(self, ctx):
        return super().exitStatement_if(ctx)

    def enterStatement_return(self, ctx: DecafParser.Statement_returnContext):
        try:
            try:
                #Return de enteros
                try:
                    _returnValue = int(ctx.expression().getText())
                    _returnValueType = "int"
                except:
                    _returnValue = ctx.expression().getText()
                    for key,value in hashtable.items():
                        #value == global variables/scopes
                        for key2,value2 in value.items():                            
                            try:
                                _returnValueType = hashtable[classScope][key2][_returnValue].getType()
                            except:
                                pass
                    _returnFunctionType = hashtable[classScope][actualScope][actualScope].getType()
                    if(_returnFunctionType == _returnValueType):
                        pass
                    else:
                        print("Data Type for return not valid, expected ", _returnFunctionType, " instead received ", _returnValueType)
                        errors.append("Data Type for return not valid, expected ", _returnFunctionType, " instead received ", _returnValueType)
            except:
                pass
            #print("Function return: ", ctx.expression().location().var_id().ID().getText())
            #print("Statement: ",ctx.expression().getText())
            #print("Statement: ",ctx.expression().literal().int_literal().getText())
        except:
            pass

    def exitStatement_return(self, ctx):
        pass

    def enterStatement_assignValue(self, ctx: DecafParser.Statement_assignValueContext):
        try:
            #print("assign: " , ctx.location().var_id().getText())
            try:
                pass
                #print("newValue: ", ctx.expression().literal().getText())
            except:
                pass
        except:
            pass
    
    def exitStatement_assignValue(self, ctx):
        return super().exitStatement_assignValue(ctx)

    def enterStatement_increment(self, ctx: DecafParser.Statement_incrementContext):
        try:
            pass
        except:
            pass

    def exitStatement_increment(self, ctx):
        return super().exitStatement_increment(ctx)

    def enterStatement_decrement(self, ctx: DecafParser.Statement_decrementContext):
        try:
            pass
        except:
            pass

class SymbolInTable():

    #Diferenciacion entre vartype y objType es para las funciones con sus returns
    #Esto debido a que vartype es el tipo de la variable (incluyendo variables de retorno)
    #Mientras que el objType es el tipo del objeto como tal. Ej:
    #int suma(num1, num2){ return(num1 + num2) } su tipo seria entero pero su objType es func.

    def __init__(self, var_id, vartype, objType, scope, offset, value, params):
        self.var_id = var_id
        self.type = vartype
        self.objType = objType
        self.scope = scope
        self.offset = offset
        self.value = value  
        self.params = params  

    def getVar_id(self):
        return self.var_id

    def getType(self):
        return self.type

    def getObjType(self):
        return self.objType

    def getScope(self):
        return self.scope

    def getOffset(self):
        return self.offset
    
    def getValue(self):
        return self.value

    def getParams(self):
        return self.params

    def getAll(self):
        return self.var_id, self.type, self.objType, self.scope, self.offset, self.value, self.params

    def setValue(self, value):
        self.value = value

def main():
    input_stream = FileStream('fact_array.txt')
    lexer = DecafLexer(input_stream)
    stream = CommonTokenStream(lexer)
    parser = DecafParser(stream)
    tree = parser.program()

    listener = DecafWalker()
    walker = ParseTreeWalker()
    walker.walk(listener, tree)

    print(hashtable)

main()
# Generated from Decaf.g4 by ANTLR 4.9
from antlr4 import *
if __name__ is not None and "." in __name__:
    from .DecafParser import DecafParser
else:
    from DecafParser import DecafParser

# This class defines a complete listener for a parse tree produced by DecafParser.
class DecafListener(ParseTreeListener):

    # Enter a parse tree produced by DecafParser#program.
    def enterProgram(self, ctx:DecafParser.ProgramContext):
        pass

    # Exit a parse tree produced by DecafParser#program.
    def exitProgram(self, ctx:DecafParser.ProgramContext):
        pass


    # Enter a parse tree produced by DecafParser#declaration.
    def enterDeclaration(self, ctx:DecafParser.DeclarationContext):
        pass

    # Exit a parse tree produced by DecafParser#declaration.
    def exitDeclaration(self, ctx:DecafParser.DeclarationContext):
        pass


    # Enter a parse tree produced by DecafParser#varDeclaration_ID.
    def enterVarDeclaration_ID(self, ctx:DecafParser.VarDeclaration_IDContext):
        pass

    # Exit a parse tree produced by DecafParser#varDeclaration_ID.
    def exitVarDeclaration_ID(self, ctx:DecafParser.VarDeclaration_IDContext):
        pass


    # Enter a parse tree produced by DecafParser#varDeclaration_Array.
    def enterVarDeclaration_Array(self, ctx:DecafParser.VarDeclaration_ArrayContext):
        pass

    # Exit a parse tree produced by DecafParser#varDeclaration_Array.
    def exitVarDeclaration_Array(self, ctx:DecafParser.VarDeclaration_ArrayContext):
        pass


    # Enter a parse tree produced by DecafParser#structDeclaration.
    def enterStructDeclaration(self, ctx:DecafParser.StructDeclarationContext):
        pass

    # Exit a parse tree produced by DecafParser#structDeclaration.
    def exitStructDeclaration(self, ctx:DecafParser.StructDeclarationContext):
        pass


    # Enter a parse tree produced by DecafParser#varType_int.
    def enterVarType_int(self, ctx:DecafParser.VarType_intContext):
        pass

    # Exit a parse tree produced by DecafParser#varType_int.
    def exitVarType_int(self, ctx:DecafParser.VarType_intContext):
        pass


    # Enter a parse tree produced by DecafParser#varType_boolean.
    def enterVarType_boolean(self, ctx:DecafParser.VarType_booleanContext):
        pass

    # Exit a parse tree produced by DecafParser#varType_boolean.
    def exitVarType_boolean(self, ctx:DecafParser.VarType_booleanContext):
        pass


    # Enter a parse tree produced by DecafParser#varType_char.
    def enterVarType_char(self, ctx:DecafParser.VarType_charContext):
        pass

    # Exit a parse tree produced by DecafParser#varType_char.
    def exitVarType_char(self, ctx:DecafParser.VarType_charContext):
        pass


    # Enter a parse tree produced by DecafParser#varType_struct.
    def enterVarType_struct(self, ctx:DecafParser.VarType_structContext):
        pass

    # Exit a parse tree produced by DecafParser#varType_struct.
    def exitVarType_struct(self, ctx:DecafParser.VarType_structContext):
        pass


    # Enter a parse tree produced by DecafParser#varType_structDeclaration.
    def enterVarType_structDeclaration(self, ctx:DecafParser.VarType_structDeclarationContext):
        pass

    # Exit a parse tree produced by DecafParser#varType_structDeclaration.
    def exitVarType_structDeclaration(self, ctx:DecafParser.VarType_structDeclarationContext):
        pass


    # Enter a parse tree produced by DecafParser#varType_void.
    def enterVarType_void(self, ctx:DecafParser.VarType_voidContext):
        pass

    # Exit a parse tree produced by DecafParser#varType_void.
    def exitVarType_void(self, ctx:DecafParser.VarType_voidContext):
        pass


    # Enter a parse tree produced by DecafParser#methodDeclaration.
    def enterMethodDeclaration(self, ctx:DecafParser.MethodDeclarationContext):
        pass

    # Exit a parse tree produced by DecafParser#methodDeclaration.
    def exitMethodDeclaration(self, ctx:DecafParser.MethodDeclarationContext):
        pass


    # Enter a parse tree produced by DecafParser#methodType_int.
    def enterMethodType_int(self, ctx:DecafParser.MethodType_intContext):
        pass

    # Exit a parse tree produced by DecafParser#methodType_int.
    def exitMethodType_int(self, ctx:DecafParser.MethodType_intContext):
        pass


    # Enter a parse tree produced by DecafParser#methodType_char.
    def enterMethodType_char(self, ctx:DecafParser.MethodType_charContext):
        pass

    # Exit a parse tree produced by DecafParser#methodType_char.
    def exitMethodType_char(self, ctx:DecafParser.MethodType_charContext):
        pass


    # Enter a parse tree produced by DecafParser#methodType_boolean.
    def enterMethodType_boolean(self, ctx:DecafParser.MethodType_booleanContext):
        pass

    # Exit a parse tree produced by DecafParser#methodType_boolean.
    def exitMethodType_boolean(self, ctx:DecafParser.MethodType_booleanContext):
        pass


    # Enter a parse tree produced by DecafParser#methodType_void.
    def enterMethodType_void(self, ctx:DecafParser.MethodType_voidContext):
        pass

    # Exit a parse tree produced by DecafParser#methodType_void.
    def exitMethodType_void(self, ctx:DecafParser.MethodType_voidContext):
        pass


    # Enter a parse tree produced by DecafParser#parameter.
    def enterParameter(self, ctx:DecafParser.ParameterContext):
        pass

    # Exit a parse tree produced by DecafParser#parameter.
    def exitParameter(self, ctx:DecafParser.ParameterContext):
        pass


    # Enter a parse tree produced by DecafParser#parameterType_int.
    def enterParameterType_int(self, ctx:DecafParser.ParameterType_intContext):
        pass

    # Exit a parse tree produced by DecafParser#parameterType_int.
    def exitParameterType_int(self, ctx:DecafParser.ParameterType_intContext):
        pass


    # Enter a parse tree produced by DecafParser#parameterType_char.
    def enterParameterType_char(self, ctx:DecafParser.ParameterType_charContext):
        pass

    # Exit a parse tree produced by DecafParser#parameterType_char.
    def exitParameterType_char(self, ctx:DecafParser.ParameterType_charContext):
        pass


    # Enter a parse tree produced by DecafParser#parameterType_boolean.
    def enterParameterType_boolean(self, ctx:DecafParser.ParameterType_booleanContext):
        pass

    # Exit a parse tree produced by DecafParser#parameterType_boolean.
    def exitParameterType_boolean(self, ctx:DecafParser.ParameterType_booleanContext):
        pass


    # Enter a parse tree produced by DecafParser#parameterType_void.
    def enterParameterType_void(self, ctx:DecafParser.ParameterType_voidContext):
        pass

    # Exit a parse tree produced by DecafParser#parameterType_void.
    def exitParameterType_void(self, ctx:DecafParser.ParameterType_voidContext):
        pass


    # Enter a parse tree produced by DecafParser#block.
    def enterBlock(self, ctx:DecafParser.BlockContext):
        pass

    # Exit a parse tree produced by DecafParser#block.
    def exitBlock(self, ctx:DecafParser.BlockContext):
        pass


    # Enter a parse tree produced by DecafParser#statement_if.
    def enterStatement_if(self, ctx:DecafParser.Statement_ifContext):
        pass

    # Exit a parse tree produced by DecafParser#statement_if.
    def exitStatement_if(self, ctx:DecafParser.Statement_ifContext):
        pass


    # Enter a parse tree produced by DecafParser#statement_while.
    def enterStatement_while(self, ctx:DecafParser.Statement_whileContext):
        pass

    # Exit a parse tree produced by DecafParser#statement_while.
    def exitStatement_while(self, ctx:DecafParser.Statement_whileContext):
        pass


    # Enter a parse tree produced by DecafParser#statement_return.
    def enterStatement_return(self, ctx:DecafParser.Statement_returnContext):
        pass

    # Exit a parse tree produced by DecafParser#statement_return.
    def exitStatement_return(self, ctx:DecafParser.Statement_returnContext):
        pass


    # Enter a parse tree produced by DecafParser#statement_methodCall.
    def enterStatement_methodCall(self, ctx:DecafParser.Statement_methodCallContext):
        pass

    # Exit a parse tree produced by DecafParser#statement_methodCall.
    def exitStatement_methodCall(self, ctx:DecafParser.Statement_methodCallContext):
        pass


    # Enter a parse tree produced by DecafParser#statement_block.
    def enterStatement_block(self, ctx:DecafParser.Statement_blockContext):
        pass

    # Exit a parse tree produced by DecafParser#statement_block.
    def exitStatement_block(self, ctx:DecafParser.Statement_blockContext):
        pass


    # Enter a parse tree produced by DecafParser#statement_assignValue.
    def enterStatement_assignValue(self, ctx:DecafParser.Statement_assignValueContext):
        pass

    # Exit a parse tree produced by DecafParser#statement_assignValue.
    def exitStatement_assignValue(self, ctx:DecafParser.Statement_assignValueContext):
        pass


    # Enter a parse tree produced by DecafParser#statement_expression.
    def enterStatement_expression(self, ctx:DecafParser.Statement_expressionContext):
        pass

    # Exit a parse tree produced by DecafParser#statement_expression.
    def exitStatement_expression(self, ctx:DecafParser.Statement_expressionContext):
        pass


    # Enter a parse tree produced by DecafParser#location.
    def enterLocation(self, ctx:DecafParser.LocationContext):
        pass

    # Exit a parse tree produced by DecafParser#location.
    def exitLocation(self, ctx:DecafParser.LocationContext):
        pass


    # Enter a parse tree produced by DecafParser#var_id.
    def enterVar_id(self, ctx:DecafParser.Var_idContext):
        pass

    # Exit a parse tree produced by DecafParser#var_id.
    def exitVar_id(self, ctx:DecafParser.Var_idContext):
        pass


    # Enter a parse tree produced by DecafParser#array_id.
    def enterArray_id(self, ctx:DecafParser.Array_idContext):
        pass

    # Exit a parse tree produced by DecafParser#array_id.
    def exitArray_id(self, ctx:DecafParser.Array_idContext):
        pass


    # Enter a parse tree produced by DecafParser#expression_SecondPrecedence.
    def enterExpression_SecondPrecedence(self, ctx:DecafParser.Expression_SecondPrecedenceContext):
        pass

    # Exit a parse tree produced by DecafParser#expression_SecondPrecedence.
    def exitExpression_SecondPrecedence(self, ctx:DecafParser.Expression_SecondPrecedenceContext):
        pass


    # Enter a parse tree produced by DecafParser#expression_literal.
    def enterExpression_literal(self, ctx:DecafParser.Expression_literalContext):
        pass

    # Exit a parse tree produced by DecafParser#expression_literal.
    def exitExpression_literal(self, ctx:DecafParser.Expression_literalContext):
        pass


    # Enter a parse tree produced by DecafParser#expression_or.
    def enterExpression_or(self, ctx:DecafParser.Expression_orContext):
        pass

    # Exit a parse tree produced by DecafParser#expression_or.
    def exitExpression_or(self, ctx:DecafParser.Expression_orContext):
        pass


    # Enter a parse tree produced by DecafParser#expression_location.
    def enterExpression_location(self, ctx:DecafParser.Expression_locationContext):
        pass

    # Exit a parse tree produced by DecafParser#expression_location.
    def exitExpression_location(self, ctx:DecafParser.Expression_locationContext):
        pass


    # Enter a parse tree produced by DecafParser#expression_negative_int.
    def enterExpression_negative_int(self, ctx:DecafParser.Expression_negative_intContext):
        pass

    # Exit a parse tree produced by DecafParser#expression_negative_int.
    def exitExpression_negative_int(self, ctx:DecafParser.Expression_negative_intContext):
        pass


    # Enter a parse tree produced by DecafParser#expression_firstPrecedence.
    def enterExpression_firstPrecedence(self, ctx:DecafParser.Expression_firstPrecedenceContext):
        pass

    # Exit a parse tree produced by DecafParser#expression_firstPrecedence.
    def exitExpression_firstPrecedence(self, ctx:DecafParser.Expression_firstPrecedenceContext):
        pass


    # Enter a parse tree produced by DecafParser#expression_negate_bool.
    def enterExpression_negate_bool(self, ctx:DecafParser.Expression_negate_boolContext):
        pass

    # Exit a parse tree produced by DecafParser#expression_negate_bool.
    def exitExpression_negate_bool(self, ctx:DecafParser.Expression_negate_boolContext):
        pass


    # Enter a parse tree produced by DecafParser#expression_methodCall.
    def enterExpression_methodCall(self, ctx:DecafParser.Expression_methodCallContext):
        pass

    # Exit a parse tree produced by DecafParser#expression_methodCall.
    def exitExpression_methodCall(self, ctx:DecafParser.Expression_methodCallContext):
        pass


    # Enter a parse tree produced by DecafParser#expression_parenthesis.
    def enterExpression_parenthesis(self, ctx:DecafParser.Expression_parenthesisContext):
        pass

    # Exit a parse tree produced by DecafParser#expression_parenthesis.
    def exitExpression_parenthesis(self, ctx:DecafParser.Expression_parenthesisContext):
        pass


    # Enter a parse tree produced by DecafParser#expression_compare.
    def enterExpression_compare(self, ctx:DecafParser.Expression_compareContext):
        pass

    # Exit a parse tree produced by DecafParser#expression_compare.
    def exitExpression_compare(self, ctx:DecafParser.Expression_compareContext):
        pass


    # Enter a parse tree produced by DecafParser#expression_and.
    def enterExpression_and(self, ctx:DecafParser.Expression_andContext):
        pass

    # Exit a parse tree produced by DecafParser#expression_and.
    def exitExpression_and(self, ctx:DecafParser.Expression_andContext):
        pass


    # Enter a parse tree produced by DecafParser#methodCall.
    def enterMethodCall(self, ctx:DecafParser.MethodCallContext):
        pass

    # Exit a parse tree produced by DecafParser#methodCall.
    def exitMethodCall(self, ctx:DecafParser.MethodCallContext):
        pass


    # Enter a parse tree produced by DecafParser#arith_op_cmp.
    def enterArith_op_cmp(self, ctx:DecafParser.Arith_op_cmpContext):
        pass

    # Exit a parse tree produced by DecafParser#arith_op_cmp.
    def exitArith_op_cmp(self, ctx:DecafParser.Arith_op_cmpContext):
        pass


    # Enter a parse tree produced by DecafParser#arith_op_and.
    def enterArith_op_and(self, ctx:DecafParser.Arith_op_andContext):
        pass

    # Exit a parse tree produced by DecafParser#arith_op_and.
    def exitArith_op_and(self, ctx:DecafParser.Arith_op_andContext):
        pass


    # Enter a parse tree produced by DecafParser#arith_op_or.
    def enterArith_op_or(self, ctx:DecafParser.Arith_op_orContext):
        pass

    # Exit a parse tree produced by DecafParser#arith_op_or.
    def exitArith_op_or(self, ctx:DecafParser.Arith_op_orContext):
        pass


    # Enter a parse tree produced by DecafParser#literal.
    def enterLiteral(self, ctx:DecafParser.LiteralContext):
        pass

    # Exit a parse tree produced by DecafParser#literal.
    def exitLiteral(self, ctx:DecafParser.LiteralContext):
        pass


    # Enter a parse tree produced by DecafParser#int_literal.
    def enterInt_literal(self, ctx:DecafParser.Int_literalContext):
        pass

    # Exit a parse tree produced by DecafParser#int_literal.
    def exitInt_literal(self, ctx:DecafParser.Int_literalContext):
        pass


    # Enter a parse tree produced by DecafParser#bool_literal.
    def enterBool_literal(self, ctx:DecafParser.Bool_literalContext):
        pass

    # Exit a parse tree produced by DecafParser#bool_literal.
    def exitBool_literal(self, ctx:DecafParser.Bool_literalContext):
        pass


    # Enter a parse tree produced by DecafParser#char_literal.
    def enterChar_literal(self, ctx:DecafParser.Char_literalContext):
        pass

    # Exit a parse tree produced by DecafParser#char_literal.
    def exitChar_literal(self, ctx:DecafParser.Char_literalContext):
        pass



del DecafParser
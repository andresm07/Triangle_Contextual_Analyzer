/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

/**
 * FORCOMMAND CLASS ADDED
 * DEFINED AS: loop for IDENTIFIER ~ EXPRESSION to EXPRESSION do COMMAND repeat.
 * @author isfa9
 */
public class ForDoCommand extends Command
{
    public ForDoCommand(Identifier iAST, Expression eAST, Expression e2AST,
            Command commandAST, SourcePosition commandPos)
    {
    	super(commandPos);
    	I = iAST;
    	E1 = eAST;
        E2 = e2AST;
    	C = commandAST;
    }

    @Override
    public Object visit(Visitor v, Object o)
    {
        return v.visitForDoCommand(this, o);
    }
    
    public Identifier I;
    public Expression E1;
    public Expression E2;
    public Command C;
}

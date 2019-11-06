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
    public ForDoCommand(Declaration dAST, Expression eAST, Command cAST, SourcePosition commandPos)
    {
    	super(commandPos);
    	D = dAST;
        E = eAST;
        C = cAST;
    }

    @Override
    public Object visit(Visitor v, Object o)
    {
        return v.visitForDoCommand(this, o);
    }
    
    public Declaration D;
    public Expression E;
    public Command C;
}

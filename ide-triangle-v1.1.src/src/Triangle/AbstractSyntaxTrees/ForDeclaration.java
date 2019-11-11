/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

/**
 *
 * @author isfa9
 */
public class ForDeclaration extends Declaration
{
    public ForDeclaration(Identifier iAST, Expression eAST, SourcePosition thePosition)
    {
        super(thePosition);
        I = iAST;
        E = eAST;
    }
    
    public Identifier I;
    public Expression E;

    @Override
    public Object visit(Visitor v, Object o)
    {
        return v.visitForDeclaration(this, o);
    }
    
}

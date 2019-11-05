/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle.AbstractSyntaxTrees;

/**
 *
 * @author richie
 */
import Triangle.SyntacticAnalyzer.SourcePosition;

public class Commentary {
    
    public String spelling;
    public SourcePosition position;
    
    public Commentary (SourcePosition thePosition, String spelling) {
        this.spelling = spelling;
        position = thePosition;
    }
    
}


/*
 * @(#)VarDeclaration.java                        2.1 2003/10/07
 *
 * Copyright (C) 1999, 2003 D.A. Watt and D.F. Brown
 * Dept. of Computing Science, University of Glasgow, Glasgow G12 8QQ Scotland
 * and School of Computer and Math Sciences, The Robert Gordon University,
 * St. Andrew Street, Aberdeen AB25 1HG, Scotland.
 * All rights reserved.
 *
 * This software is provided free for educational use only. It may
 * not be used for commercial purposes without the prior written permission
 * of the authors.
 */

 //LOCAL DECLARATION, USED ON LOCAL CASE ON COMPOUND DECLARATION on 10/14/19 by andres.mirandaarias@gmail.com

 package Triangle.AbstractSyntaxTrees;

 import Triangle.SyntacticAnalyzer.SourcePosition;
 
 public class LocalDeclaration extends Declaration {
 
   public LocalDeclaration (Declaration dcl1, Declaration dcl2,SourcePosition thePosition) {
     super (thePosition);
     this.dcl1 = dcl1;
     this.dcl2 = dcl2;
   }
 
   public Object visit(Visitor v, Object o) {
     return v.visitLocalDeclaration(this, o);
   }
 
   public Declaration dcl1, dcl2;
 }
 
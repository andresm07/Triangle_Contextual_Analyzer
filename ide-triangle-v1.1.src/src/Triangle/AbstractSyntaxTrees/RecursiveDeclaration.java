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

//RECURSIVE DECLARATION, USED IN CASE RECURSIVE ON COMPOUND DECLARATION on 10/14/19 by andres.mirandaarias@gmail.com

 package Triangle.AbstractSyntaxTrees;

 import Triangle.SyntacticAnalyzer.SourcePosition;
 
 public class RecursiveDeclaration extends Declaration {
 
   public RecursiveDeclaration (Declaration procFuncAST,SourcePosition thePosition) {
     super (thePosition);
     this.procFuncAST = procFuncAST;
   }
 
   public Object visit(Visitor v, Object o) {
     return v.visitRecursiveDeclaration(this, o);
   }
 
   public Declaration procFuncAST;
 }
 
/*
 * @(#)IdentificationTable.java                2.1 2003/10/07
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

package Triangle.ContextualAnalyzer;

import Triangle.AbstractSyntaxTrees.Declaration;

public final class IdentificationTable {

  private int level;
  private IdEntry latest;
  protected boolean localScope = false; //ADDED ON 11/06/19 BY ANDRES.MIRANDAARIAS@GMAIL.COM
  

  public IdentificationTable () {
    level = 0;
    latest = null;
  }

  // Opens a new level in the identification table, 1 higher than the
  // current topmost level.

  public void openScope () {

    level ++;
  }
  
  //OPENLOCALSCOPE ADDED ON 11/06/19 BY ANDRES.MIRANDAARIAS@GMAIL.COM
  public void openLocalScope(){
      localScope = true; //Start marking nodes as local
  }
  
  // Closes the topmost level in the identification table, discarding
  // all entries belonging to that level.

  public void closeScope () {

    IdEntry entry, local;

    // Presumably, idTable.level > 0.
    entry = this.latest;
    while (entry.level == this.level) {
      local = entry;
      entry = local.previous;
    }
    this.level--;
    this.latest = entry;
  }
  
  //CLOSELOCALSCOPE ADDED ON 11/06/19 BY ANDRES.MIRANDAARIAS@GMAIL.COM
  public void closeLocalScope(){
      localScope = false; //Stop marking nodes as local
  }
  
  //CLEARLOCALSCOPE ADDED ON 11/06/19 BY ANDRES.MIRANDAARIAS@GMAIL.COM
  public void clearLocalScope(){
    //Eliminate last level of nodes marked as local
    IdEntry entry, local, localDeclaration;
    entry = this.latest;
    localDeclaration = this.latest.previous;
    while(localDeclaration.localLevel != true){
        local = entry;
        entry = local.previous;
        localDeclaration = local.previous;
    }
    entry.previous = localDeclaration.previous;
    this.latest = entry;
  }

  // Makes a new entry in the identification table for the given identifier
  // and attribute. The new entry belongs to the current level.
  // duplicated is set to to true iff there is already an entry for the
  // same identifier at the current level.

  public void enter (String id, Declaration attr) {

    IdEntry entry = this.latest;
    boolean present = false, searching = true;

    // Check for duplicate entry ...
    while (searching) {
      if (entry == null || entry.level < this.level)
        searching = false;
      else if (entry.id.equals(id)) {
        present = true;
        searching = false;
       } else
       entry = entry.previous;
    }

    attr.duplicated = present;
    if(localScope){
        entry = new IdEntry(id, attr, this.level, this.latest, true);
    }
    else{
        entry = new IdEntry(id, attr, this.level, this.latest, false);
    }
    this.latest = entry;
  }

  // Finds an entry for the given identifier in the identification table,
  // if any. If there are several entries for that identifier, finds the
  // entry at the highest level, in accordance with the scope rules.
  // Returns null iff no entry is found.
  // otherwise returns the attribute field of the entry found.

  public Declaration retrieve (String id) {

    IdEntry entry;
    Declaration attr = null;
    boolean present = false, searching = true;

    entry = this.latest;
    while (searching) {
      if (entry == null)
        searching = false;
      else if (entry.id.equals(id)) {
        present = true;
        searching = false;
        attr = entry.attr;
      } else
        entry = entry.previous;
    }

    return attr;
  }

}

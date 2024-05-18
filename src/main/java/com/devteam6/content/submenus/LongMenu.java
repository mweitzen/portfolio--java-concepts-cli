package com.devteam6.content.submenus;

import com.devteam6.io.*;
import com.devteam6.content.screens.*;
import com.devteam6.display.Menu;

final public class LongMenu extends Menu {
  public LongMenu() {
    super(
        "Long (Primitive Data Type)",
        "Select",
        new String[] {
            "Description",
            "Syntax",
            "Example",
            "Demo"
        });
  }

  /**
   * Selection Handlers
   *
   */
  public int handleSelection(int selection) {
    // User navigating backwards in menus
    if (selection < 0) {
      return selection;
    }
    switch (selection) {
      /**
       * Character Description Screen
       *
       */
      case 1:
        CharacterDescription characterDescription = new CharacterDescription();
        characterDescription.display();
        characterDescription.waitForEnter();
        break;
      /**
       * Character Syntax Screen
       *
       */
      case 2:
        break;
      /**
       * Character Example Screen
       *
       */
      case 3:
        break;
      default:
        AppConsole.handleError("Selection not available.");
        break;
    }

    return 0;
  }
}

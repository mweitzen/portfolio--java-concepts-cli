package com.devteam6.content.submenus;

import com.devteam6.io.*;
import com.devteam6.display.*;
import com.devteam6.content.screens.*;

final public class BooleanMenu extends Menu {
  public BooleanMenu() {
    super(
        "Boolean (Primitive Data Type)",
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
  @Override
  public int handleSelection(int selection) {
    // User navigating backwards in menus
    if (selection < 0)
      return selection;

    Screen screen = null;

    switch (selection) {
      case 1:
        screen = new CharacterDescription();
        break;
      case 2:
      case 3:
        screen = new CharacterDescription();
        break;
      default:
        AppConsole.handleError("Selection not available.");
        break;
    }

    if (screen != null) {
      screen.display();
      screen.waitForEnter();
    }

    return 1;
  }
}

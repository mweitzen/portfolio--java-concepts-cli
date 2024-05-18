package com.devteam6.content.menus;

import com.devteam6.io.*;
import com.devteam6.display.*;
import com.devteam6.content.submenus.*;

final public class PrimitiveTypes extends Menu {
  /**
   * Constructor
   *
   */
  public PrimitiveTypes() {
    super(
        "Primitive Data Types",
        "Explore",
        new String[] {
            "Character",
            "Byte",
            "Short",
            "Integer",
            "Long",
            "Float",
            "Double",
            "Boolean"
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

    // Loop until user navigates back.
    int nextSelection = 0;
    Menu submenu = null;
    do {
      switch (selection) {
        case 1:
          submenu = new CharacterMenu();
          break;
        case 2:
          submenu = new ByteMenu();
          break;
        case 3:
          submenu = new ShortMenu();
          break;
        case 4:
          submenu = new IntegerMenu();
          break;
        case 5:
          submenu = new LongMenu();
          break;
        case 6:
          submenu = new FloatMenu();
          break;
        case 7:
          submenu = new DoubleMenu();
          break;
        case 8:
          submenu = new BooleanMenu();
          break;
        default:
          AppConsole.handleError("Selection didn't match available option.");
          break;
      }
      nextSelection = submenu.prompt();
      submenu.handleSelection(nextSelection);
      submenu.close();
    } while (nextSelection > 0);

    return nextSelection;
  }
}

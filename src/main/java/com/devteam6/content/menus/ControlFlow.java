package com.devteam6.content.menus;

import com.devteam6.io.*;
import com.devteam6.display.*;

final public class ControlFlow extends Menu {
  /**
   * Constructor
   *
   */
  public ControlFlow() {
    super(
        "Control Flow",
        "Explore",
        new String[] {
            "If...Then...",
            "For...",
            "While...",
            "Do...While...",
            "Try...Catch..."
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
        case 2:
        case 3:
        case 4:
        case 5:
          AppConsole.deadend();
          break;
        default:
          AppConsole.handleError("Selection didn't match available option.");
          break;
      }
      // nextSelection = submenu.prompt();
      // submenu.handleSelection(nextSelection);
      // submenu.close();
    } while (nextSelection > 0);

    return nextSelection;
  }
}

package com.devteam6.content.menus;

import com.devteam6.io.*;
import com.devteam6.display.*;
import com.devteam6.content.screens.*;

final public class JavaFundamentals extends Menu {
  /**
   * Constructor
   *
   */
  public JavaFundamentals() {
    super(
        "Java Fundamentals",
        "Explore",
        new String[] {
            "Overview",
            "History",
            "Packages",
            "Frameworks",
            "Build Tools"
        });
  }

  /**
   * Selection Handlers
   *
   */
  @Override
  public int handleSelection(int selection) {
    if (selection < 0)
      return 0;

    // Loop until user navigates back.
    int nextSelection = 0;
    do {
      switch (selection) {
        /**
         * Overview
         *
         */
        case 1:
          Screen overviewScreen = new Screen("Java Overview", "Something here", new String[] { "Lines of code." });
          overviewScreen.display();
          overviewScreen.waitForEnter();
          break;
        /**
         * History
         *
         */
        case 2:
          JavaHistory historyScreen = new JavaHistory();
          historyScreen.display();
          historyScreen.waitForEnter();
          break;
        /**
         * Rest...
         *
         */
        case 3:
        case 4:
        case 5:
          AppConsole.deadend();
          break;
        /**
         * Invalid
         *
         */
        default:
          AppConsole.handleError("Selection didn't match available option.");
          break;
      }
    } while (nextSelection > 0);

    return 0;
  }
}

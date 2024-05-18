package com.devteam6.display;

import com.devteam6.App;
import com.devteam6.io.*;

public class Menu {
  private String title;
  private String description;
  private String[] options;
  static int menuDepth = 0;

  /**
   * Constructor
   *
   */
  public Menu(String title, String description, String[] options) {
    this.title = title;
    this.description = description;
    this.options = options;
    menuDepth++;
  }

  /**
   * Format and display the menu option
   *
   */
  private void displayOption(String key, String value) {
    String formattedOption;
    try {
      Integer.parseInt(key);
      formattedOption = key + ") " + value;
    } catch (Exception e) {
      formattedOption = "* " + key + ") " + value;
    }
    System.out.println(formattedOption);
  }

  /**
   * "Close" menu
   *
   */
  final public void close() {
    AppConsole.clear();
    menuDepth--;
  }

  /**
   * Prompt user for selection
   *
   */
  final public int prompt() {
    int selection = 0;

    do {
      AppConsole.clear();

      // Display Menu Title
      AppConsole.displayTitle(this.title);

      // Display Menu Description
      System.out.println(this.description);
      System.out.println();

      // Display Menu Options
      for (int i = 0; i < options.length; i++) {
        String selectionNumber = Integer.toString(i + 1);
        displayOption(selectionNumber, options[i]);
      }

      // Menu navigation based on menu depth
      System.out.println();
      System.out.println("---------------------");
      if (menuDepth > 1) {
        displayOption("p", "Previous Menu");
      }
      if (menuDepth > 2) {
        displayOption("m", "Main Menu");
      }
      displayOption("q", "Quit Application");
      System.out.println("---------------------");
      System.out.println();

      // Read input
      String input = AppConsole.prompt("Enter selection");

      // User submitted nothin
      if (input.length() < 1)
        continue;

      // User selected "Previous Menu"
      if (input.charAt(0) == 'p' && menuDepth > 1) {
        selection = -1;
        continue;
      }

      // User selected "Main Menu"
      if (input.charAt(0) == 'm' && menuDepth > 2) {
        selection = -2;
        continue;
      }

      // User selected "Quit Application"
      if (input.charAt(0) == 'q' || input.contentEquals("exit")) {
        App.quit();
      }

      try {
        // Cast input to int to read input
        int selected = Integer.parseInt(input);

        // Make sure option in bounds
        if (selected > options.length || selected < 0) {
          AppConsole.handleError("Option not available.");
        } else {
          // Valid input, return selection
          selection = selected;
        }
      } catch (Exception e) {
        AppConsole.handleError("Invalid entry.");
      }

      // Any non-integer or negative values will be handled previously
    } while (selection == 0);

    // Only returns valid selection, other cases handled previously
    return selection;
  }

  /**
   * Handle selection (Implemented by child class)
   *
   */
  public int handleSelection(int selection) {
    return 0;
  }

}

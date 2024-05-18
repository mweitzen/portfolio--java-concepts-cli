package com.devteam6.display;

import com.devteam6.io.*;

public class Screen {
  private String title;
  private String description;
  private String[] lines;

  /**
   * Constructor
   *
   */
  public Screen(String title, String description, String[] lines) {
    this.title = title;
    this.description = title;
    this.lines = lines;
  }

  /**
   * Display screen contents
   *
   */
  public void display() {
    AppConsole.clear();

    // Display Screen Title
    AppConsole.displayTitle(this.title);

    // Display Screen Description
    System.out.println();
    System.out.println(this.description);
    System.out.println();
    AppConsole.spacer();

    // Display lines of text
    for (String line : lines) {
      System.out.println(line);
    }
  }

  /**
   * Display "press (enter)..." to close the screen
   *
   */
  public void waitForEnter() {
    AppConsole.spacer();
    System.out.print("Press (enter) to continue.");

    // Wait for enter`
    AppConsole.read();
  }
}

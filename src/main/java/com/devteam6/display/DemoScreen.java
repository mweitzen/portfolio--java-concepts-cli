package com.devteam6.display;

import com.devteam6.io.*;

public class DemoScreen extends Screen {
  /**
   * Constructor
   *
   */
  public DemoScreen(String title, String description, String[] lines) {
    super(title, description, lines);
  }

  /**
   * Add Demo Screen Disclaimer
   *
   */
  @Override
  public void display() {
    super.display();
    AppConsole.spacer();
    AppConsole.prompt("Enter something");
    AppConsole.spacer();
    System.out.println("To exit the demo screen at any time, type \"exit()\" and press (enter).");
  }

  /**
   * Exit Demo Screen
   *
   */
  public void exit() {
    System.out.println("Exit");
  }
}

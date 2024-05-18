package com.devteam6.io;

import java.util.Scanner;

public class AppConsole {
  private static Scanner scanner = new Scanner(System.in);

  /**
   * Clear out existing steam and text.
   *
   */
  final public static void clear() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  /**
   * Close the scanner and clear contents
   *
   */
  public static void close() {
    clear();
    scanner.close();
  }

  /**
   * Read Input (Expect string back)
   *
   */
  final public static String read() {
    return scanner.nextLine();
  }

  /**
   * Prompt for user input;
   *
   */
  final public static String prompt(String message) {
    System.out.print(message + ": ");
    return scanner.nextLine();
  }

  /**
   * Handle Error (Generally with input)
   *
   */
  final public static void handleError(String message) {
    System.out.println("* " + message);
    System.out.println();
    waitForEnter("Press (enter) to try again.");
  }

  /**
   * Display title
   *
   */
  public static void displayTitle(String title) {
    // Pad title for display
    title = " * " + title + " * ";

    // Create line separator of same length
    String separator = "";
    for (int i = 0; i < title.length(); i++)
      separator += "-";

    // Print to terminal
    System.out.println(separator);
    System.out.println(title);
    System.out.println(separator);
    System.out.println();
  }

  /**
   * Print a spacer
   *
   */
  final public static void spacer() {
    System.out.println();
    System.out.println("------------------------");
    System.out.println();
  }

  /**
   * Display dead end.
   *
   */
  final public static void deadend() {
    System.out.println();
    displayTitle("Dead end. Press (enter) to continue.");
    read();
  }

  /**
   * Wait for Enter (Overloaded to accept custom message.)
   *
   */
  final public static void waitForEnter() {
    String enter;
    do {
      System.out.print("Press (enter) to continue.");
      enter = read();
    } while (enter != "");

  }

  final public static void waitForEnter(String message) {
    String enter;
    do {
      System.out.print(message);
      enter = read();
    } while (enter != "");
  }
}

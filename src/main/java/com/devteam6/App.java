package com.devteam6;

import com.devteam6.io.*;
import com.devteam6.display.*;
import com.devteam6.content.menus.*;

/**
 * Java Concepts and Fundamentals!
 *
 */
public class App {
    /**
     * Quit App (invoked from Menu class)
     *
     */
    final public static void quit() {
        AppConsole.close();
        System.exit(0);
    };

    /**
     * Main
     *
     */
    public static void main(String[] args) {
        /**
         * Welcome Screen, Hello Text
         *
         */
        AppConsole.clear();

        System.out.println("******************************************");
        System.out.println("******************************************");
        System.out.println("****                                  ****");
        System.out.println("****       JAVA CONCEPT EXPLORER      ****");
        System.out.println("****                                  ****");
        System.out.println("******************************************");
        System.out.println("******************************************");
        System.out.println();

        // Wait for enter
        AppConsole.waitForEnter("Press (enter) to begin.");

        /**
         * Main Menu Loop
         *
         */
        while (true) {
            // Create Main Menu
            Menu mainMenu = new Menu(
                    "Welcome to the Java concepts explorer.",
                    "Select an option to explore the concept, or enter (q) to quit:",
                    new String[] {
                            "Primitive Data Types",
                            "Non Primitive Data Types",
                            "Control Flow",
                            "Advanced Concepts",
                            "Java Language Fundamentals",
                    });

            // Display Main Menu
            int selection = mainMenu.prompt();

            /**
             * Sub Menu Loop
             *
             */
            int nextSelection = 0;
            int subMenuSelection = 0;
            Menu submenu = null;
            do {
                // Determine which menu to create
                switch (selection) {
                    case 1:
                        submenu = new PrimitiveTypes();
                        break;
                    case 2:
                        submenu = new NonPrimitiveTypes();
                        break;
                    case 3:
                        submenu = new ControlFlow();
                        break;
                    case 4:
                        submenu = new AdvancedConcepts();
                        break;
                    case 5:
                        submenu = new JavaFundamentals();
                        break;
                    default:
                        AppConsole.handleError("Selection didn't match available option.");
                        break;
                }

                // User selected a valid option
                if (submenu != null) {
                    // Display sub-menu and promp for next menu selection
                    nextSelection = submenu.prompt();
                    // Handle the user's next selection
                    subMenuSelection = submenu.handleSelection(nextSelection);
                    // Close menu
                    submenu.close();
                    // User selected "Main Menu"
                    if (subMenuSelection == -2)
                        break;
                }
            } while (nextSelection > 0);

            // Close main menu and redisplay
            mainMenu.close();
        }
        /**
         * End of Main Menu Loop
         */
    }
}

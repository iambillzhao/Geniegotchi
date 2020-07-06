/**
 * GeniegotchiDemo is the main program with the option to initialize a personal Geniegotchi for the user.
 *
 * @author Bill Zhao
 */

import java.util.*; //import java util library for scanner
import java.io.*; //import java i/o library for input stream

public class GeniegotchiDemo
{
    public static void main(String[] args) {
        Geniegotchi o = new Geniegotchi(); //creating an object o
        Scanner input = new Scanner(System.in); //creating a scanner to record users' input
        printMenu(); //prints the menu to the console
        int choice = input.nextInt(); //record user's choice
        while (choice != 0) { //if the user decides not to exit, perform the following accordingly
            if (choice == 1){ //if the user chooses 1, ask for and set the user's input
                System.out.println("Enter your new name:"); //Prompt the user to enter a name
                String newName = input.next(); //record user's input of name
                o.setName(newName); //set the name of Geniegotchi to the new name
                printMenu(); //print the menu again, and record user's choice
                choice = input.nextInt();
            }
            else if (choice == 2) { //if the user chooses 2, display Geniegotchi's info
                o.getieinfo();
                printMenu(); //print the menu again, and record user's choice
                choice = input.nextInt();
            }
            else if (choice == 3) { //if the user chooses 3, feed the Geniegotchi
                o.feed();
                printMenu(); //print the menu again, and record user's choice
                choice = input.nextInt();
            }
            else if (choice == 4) { //if the user chooses 4, the following code will be performed
                o.play(); //call the play method to play with Geniegotchi
                if (o.getHappiness() <= 0) { //if the user's happiness runs out, display the message and quit the program
                    System.out.println("Your Geniegotchi runs out of happiness. :( AND RUN AWAY");
                    System.out.println("Thank you for using Geniegotchi");
                    System.exit(0);
                }
                else if (o.getEndurance() <= 0) { //if the user's happiness runs out, display the message and quit the program
                    System.out.println("Your Geniegotchi runs out of endurance. :( AND RUN AWAY");
                    System.out.println("Thank you for using Geniegotchi");
                    System.exit(0);
                }
                printMenu(); //print the menu again, and record user's choice
                choice = input.nextInt();
            }
            else if (choice == 5) { //if the user chooses 5, the following code will be performed
                o.askFortune(); //call the method to ask fortune
                if (o.getHappiness() <= 0) { //if the user's happiness runs out, display the message and quit the program
                    System.out.println("Your Geniegotchi runs out of happiness. :( AND RUN AWAY");
                    System.out.println("Thank you for using Geniegotchi");
                    System.exit(0);
                }
                else if (o.getEndurance() <= 0) { //if the user's happiness runs out, display the message and quit the program
                    System.out.println("Your Geniegotchi runs out of endurance. :( AND RUN AWAY");
                    System.out.println("Thank you for using Geniegotchi");
                    System.exit(0);
                }
                printMenu(); //print the menu again, and record user's choice
                choice = input.nextInt();
            }
            else if (choice == 6) { //if the user chooses 6, print the menu again, and record user's choice
                printMenu();
                choice = input.nextInt();
            }
        } 
        if (choice == 0) { //if the user chooses to quit the program, thank the user and quit
            System.out.println("Thank you for using Geniegotchi");
            System.exit(0);
        }
    }

    /**
     * Displays the menu to prompt the user to make a choice
     * no @param
     * 
     * no @return
     */
    public static void printMenu() {
        System.out.println(""); //prints the blank lines and options
        System.out.println("Welcome to Geniegotchi");
        System.out.println("Enter 0 to quit the program");
        System.out.println("Enter 1 to rename your Geniegotchi");
        System.out.println("Enter 2 to get current stats on Geniegotchi");
        System.out.println("Enter 3 to feed your Geniegotchi");
        System.out.println("Enter 4 to play with your Geniegotchi");
        System.out.println("Enter 5 to ask for your fortune");
        System.out.println("Enter 6 to print this menu again");
    }

} //class GeniegotchiDemo ends

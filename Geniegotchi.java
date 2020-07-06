/**
 * Geniegotchi constructs a customizable Geniegotchi object that allows users to rename, feed, play, rename, and ask
 *             for fortunes randomly chosen from the pre-generated list.
 *
 * @author Bill Zhao
 */

import java.util.*; //import java util library for scanner
import java.io.*; //import java i/o library for input stream

public class Geniegotchi  {
    //Private variables are set to be used inside of the program
    private String name = "Bob"; //declare and set the private String name to Bob
    private int endurance = 4; //declare and set the private integer endurance to 4
    private int happiness = 3; //declare and set the private integer happiness to 3
    private int num = 0; //declare and set the private integer num, the random number, to 0
    private int count = 0; //declare and set the private integer count, line numbers, to 0

    /**
     * Uses the user's input as the name of Geniegotchi and display for confirmation
     * @param newName the user's input for the new name of Geniegotchi
     * 
     * no @return
     */
    public void setName(String newName) {
        this.name = newName; //set the variabe name to newName
        System.out.println("Your name has been confirmed, " + name); //confirm user's input
    }

    /**
     * Gets the info of Geniegotchi and display them to console
     * no @param
     * 
     * no @return
     */
    public void getieinfo() {
        System.out.println("Welcome, player: " + name); //display name
        System.out.println("Your endurance level: " + this.getEndurance()); //display endurance
        System.out.println("Your happiness level: " + this.getHappiness()); //display happiness
    }

    /**
     * Gets Geniegotchi's endurance value
     * no @param
     * 
     * @return endurance the endurance value of Geniegotchi
     */
    public int getEndurance() {
        return endurance; //returns endurance to the program
    }

    /**
     * Gets Geniegotchi's happiness value
     * no @param
     * 
     * @return happiness the happiness value of Geniegotchi
     */
    public int getHappiness() {
        return happiness; //returns happiness to the program
    }

    /**
     * Feeds the Geniegotchi if endurance hasn't reached 10 and display the corresponding message
     * no @param
     * 
     * no @return
     */
    public void feed() {
        if (this.getEndurance() < 10) { //if the user has an endurance less than 10, feed Geniegotchi
            endurance++; //feeding increases endurance
            System.out.println("You fed the Geniegotchi.");
        }
        else //if the user has an endurance of 10, display the message
            System.out.println("No, thanks...");
    }

    /**
     * Plays with the Geniegotchi if happiness hasn't reached 10 and display the corresponding message
     * no @param
     * 
     * no @return
     */
    public void play() {
        if (this.getHappiness() < 10) { //if the user has a happiness less than 10, play with Geniegotchi
            happiness++; //playing increases happiness
            endurance -= 2; //playing decreases endurance
            System.out.println("You played with the Geniegotchi.");
        }
        else //if the user has a happiness of 10, display the message                                               
            System.out.println("No, thanks...");
    }

    /**
     * Displays the fortune message if requirements are met (happiness > 6 & endurance > 5) from the file
     * Displays corresponding messages if any value does not met the requirement
     * no @param
     * 
     * no @return
     */
    public void askFortune() { 
        if (this.getHappiness() > 6 && this.getEndurance() > 5) { //if the requirements are met, display a random fortune message
            num = (int) (Math.random() * 100) + 1; //generate a random number from 1 to 100
            Scanner fis = null; //create scanner fis
            String fortune = null; //create String fortune to store the message
            try { //try block to implement the file input stream
                fis = new Scanner(new FileInputStream("fortunes.txt")); //create file input stream
                while (fis.hasNextLine()) //detect the line of the random number
                {
                    count++; //count the line number
                    fortune = fis.nextLine(); //String fortune will record the line
                    if (count == num) //if the numbers match, display the fortune message
                        System.out.println(fortune);
                }
                fis.close(); //close the file input stream
            }
            catch (FileNotFoundException e) //if the file cannot be found, display the message and quit
            {
                System.out.println("File not found");
                System.exit(0);
            }
        }
        else if (this.getHappiness() > 6 && this.getEndurance() <= 5) { //if endurance doesn't met the requirement, display the message
            System.out.println(name + ", your endurance is low.");
        }
        else if (this.getEndurance() > 5 && this.getHappiness() <= 6) { //if happiness doesn't met the requirement, display the message
            System.out.println(name + ", you happiness is low.");
        }
        else if (this.getEndurance() <= 5 && this.getHappiness() <= 6) { //if neither met the requirement, display the message to play and feed
            System.out.println(name + ", feed and play with the Geniegotchi.");
        }
        endurance--; //every time this method runs, deduct one point from endurance
        happiness--; //every time this method runs, deduct one point from happiness
        count = 0; //reset the count value in case of the user ask for fortune again
    }
} //class Geniegotchi ends
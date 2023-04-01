import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class GameLogic {
    static Scanner scanner = new Scanner(System.in);


    public static int choice(String prompt, int userChoices) {
        int input;
        do {
            System.out.println(prompt);
            try {
                input = Integer.parseInt(scanner.next());
            }
            catch (Exception e ){
                input = -1;
                System.out.println("please enter an integer");
            }
        }while (input < 1 || input > userChoices);
        return input;
    }
    public static void  clearConsole(){
        for (int i =0 ; i <100; i++);
        System.out.println();
    }
    public static void printSeparator(int n){
        for (int i=0; i < n;i++)
            System.out.print("-");
        System.out.println();
    }
    public static void printHeading(String title){
        printSeparator(30);
        System.out.println(title);
        printSeparator(30);
    }
    public static void anythingToContinue(){
        System.out.println("Please enter anything to continue...");
        scanner.next();
    }

    public static String askUserName(){
        boolean nameSet = false;
        String name;
        clearConsole();
        anythingToContinue();
        do {
            clearConsole();
            printHeading("What's your name ?");
            name = scanner.next();
            clearConsole();
            nameSet=true;
        }while (!nameSet);

        return name;
    }

    public static Pet askUserPet(){
        boolean namePetSet = false;
        Pet selectedPet = null;
        do {
            clearConsole();
            printHeading("What is your favorite pet ?");

            System.out.println( "(1)" + Pet.CAT);
            System.out.println( "(2)" + Pet.OWL);
            System.out.println( "(3)" + Pet.RAT);
            System.out.println( "(4)" + Pet.TOAD);
            int input = choice("->",4);

            switch(input) {
                case 1:
                    selectedPet = Pet.CAT;
                    namePetSet = true;
                    break;
                case 2:
                    selectedPet = Pet.OWL;
                    namePetSet = true;
                    break;
                case 3:
                    selectedPet = Pet.RAT;
                    namePetSet = true;
                    break;
                case 4:
                    selectedPet = Pet.TOAD;
                    namePetSet = true;
                    break;
            }
        }while (!namePetSet);

        return selectedPet;
    }

    public static Wand getRandomWand() {

        // This random value will be in [21; 30] interval
        int randomSize = (int)( (Math.random()*10) + 21 );

        int random = (int)(Math.random() * 2 );
        Core randomCore = null;
        switch (random){
            case 0:
                randomCore=Core.PHOENIX_FEATHER;
                break;
            case 1:
                randomCore=Core.DRAGON_HEARTSTRING;
                break;
        }
        Wand wand = new Wand(randomCore, randomSize);
        return wand;
    }

    public static void startGame(){

        // Name selection
        String username = askUserName();
        System.out.println("Welcome to Harry Poter at home, you are now a young wizard, congratulation !");

        // Pet selection
        Pet selectedPet = askUserPet();
        System.out.println("Your pet is now a "+ selectedPet);

        // Wand selection (randomly)
        Wand selectedWand = getRandomWand();
        System.out.println("Your wand is "+ selectedWand);

        Wizard wizard = new Wizard(username, 10, selectedPet, selectedWand);
        System.out.println("Your are "+ wizard);

        // Create an example of spell
        Spell newSpell = new Spell("Test", 0.4);
        wizard.addKnownSpell(newSpell);
        System.out.println("Allowed spells "+ wizard.getKnownspell());
    }
}

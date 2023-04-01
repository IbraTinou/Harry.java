import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class GameLogic {
    static Scanner scanner = new Scanner(System.in);
    static Wizard wizard;
    static Wand wand;
    static SortingHat sortingHat;
    static House house;
    static House getHouse(){
        return house;
    }
    static Pet pet;

    static Pet getPet() {
        return pet;
    }
    static Spell knownspell;
    static Potion potions;

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
    public static void startGame(){
        boolean nameSet= false;
        String name;
        clearConsole();
        anythingToContinue();
        do {
            clearConsole();
            printHeading("What's your name ?");
            name = scanner.next();
            clearConsole();
            printHeading("Your name is "+ name+".\nright?");
            System.out.println("(1)Yes");
            System.out.println("(2)No it's not");
            int input = choice("->",2);
            if (input==1)
                nameSet=true;
        }while (!nameSet);
        System.out.println("Welcome to Harry Poter at home, you are now a young wizard, congratulation !");
        System.out.println("which core do you want for your wand ?");
        int input = choice("Phenix (1) or dragon (2)",2);
                if(input==1){
                    wand = new Wand(Core.PHOENIX_FEATHER,10);
                }else wand= new Wand(Core.DRAGON_HEARTSTRING,10);

                System.out.println("You are a "+ house);//refaire
                //wizard = new Wizard(name,100,wand,pet,house, (List<Spell>) knownspell, (List<Potion>) potions);
                //verifier l'intitialisation du sorcier
    }
}

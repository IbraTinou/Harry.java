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
    public static void gameover(Wizard wizard){
        if (wizard.hp<0){System.exit(0);}
    }


    public static void battle(Wizard wizard, AbstarctEnnemy ennemy){
        System.out.println("Un ennemi veut se battre");
        gameover(wizard);
        //boucle
        while(wizard.hp>0 && ennemy.hp>0) {
            printHeading("What will you do ?");
            System.out.println("(1) attack");
            System.out.println("(2) Use a potion");
            int input = choice("->", 2);
            switch (input) {
                case 1:
                    // choose your spell
                    Spell selectedSpell = chooseSpell(wizard.getKnownspell());
                    // attack ennemy
                    int success = wizard.attack(ennemy, selectedSpell);
                    if (success == 0){
                        System.out.println("Vous avez ratée");
                    }
                    else{
                        System.out.println("Ennemy touché:"+success );
                    }
                case 2:
                    //
            if (ennemy.hp>0) {
                printHeading("l'ennemi attaque");
                int badhit = ennemy.ennemyattack(wizard);
                System.out.println("l'ennemi vous a touché, vous avez perdu "+badhit+ "hp");


            }

            }
        }
    }

    public static void exp(){
        printHeading("Which stat do you want to improve ?");
        System.out.println("(1) hp");
        System.out.println("(2) attack");
        int input = choice("->", 2);
        switch (input) {
            // improve hp
            case 1:

                break;
                // improve attack
            case 2:

                break;


    }


    }


    public static Spell chooseSpell(ArrayList<Spell> spells){
        boolean spellSet = false;
        Spell selectedSpell = null;
        do{
            clearConsole();
            System.out.println(spells.toString());
            printHeading("Which spell would you use ?");
            int spellCounter = 0;
            for(Spell spell : spells){
                System.out.println("(" + spellCounter+1 + ") :" + spell.toString());
                spellCounter = spellCounter + 1;
            }
            int input = choice("->", spellCounter);
            if (input >= 0){
                selectedSpell = spells.get(input-1);
                System.out.println("Selected spell is :" + selectedSpell);
                spellSet = true;
            }

        }while (!spellSet);

        return selectedSpell;
    }

    public static Object chooseChoice(ArrayList<Object> elements){
        boolean elementIsChoosen = false;
        Object selectedElement = null;
        do{
            clearConsole();
            printHeading("Which spell would you use ?");
            int spellCounter = 0;
            for(Object element : elements){
                System.out.println("(" + spellCounter+1 + ") :" + element.toString());
                spellCounter = spellCounter + 1;
            }
            int input = choice("->", spellCounter);
            if (input >= 0){
                selectedElement = elements.get(input-1);
                System.out.println("Selected spell is :" + selectedElement);
                elementIsChoosen = true;
            }

        }while (!elementIsChoosen);

        return selectedElement;
    }



    public static void startGame() {

        // Name selection
        String username = askUserName();
        System.out.println("Welcome to Harry Poter at home, you are now a young wizard, congratulation !");

        // Pet selection
        Pet selectedPet = askUserPet();
        System.out.println("Your pet is now a " + selectedPet);



        // Wand selection (randomly)
        System.out.println("Are tou ready to have your wand ?");
        System.out.println("(1) Yes");
        int input = choice("->", 1);
        Wand selectedWand = getRandomWand();
        System.out.println("Your wand is " + selectedWand);
        //House
        System.out.println("the sorting hat gone assigned you a house are tou ready ?");
        System.out.println("(1) Yes");
        input = choice("->", 1);
        House house = SortingHat.houseAllocation();
        System.out.println("you are a " + house.getName());


        Wizard wizard = new Wizard(username, 10, selectedPet, selectedWand, house);


        System.out.println("Your adventure will begin, are tou ready ?");
        System.out.println("(1) Yes");
        input = choice("->", 1);
        clearConsole();
        System.out.println("En tant qu'étiduant en premier année à poudlard, vous commencez à étudier la magie avec passion,");
        System.out.println("et aprés de nombreux effort, vous maitrisez votre premier sort et concoctez votre première potion.");
        // Create an example of spell
                Spell wingardiumLeviosa = new Spell("Wingardium Leviosa", 0.95, 10);
                wizard.addKnownSpell(wingardiumLeviosa);
                System.out.println("Allowed spells "+ wizard.getKnownspell());

        //Give potions for the advanture
        Potion potion = new Potion();
        wizard.AddPotions(potion);
        System.out.println("You have a potion");
        anythingToContinue();

        // CHOOSE spell
        //chooseSpell(wizard.getKnownspell());

        //Combat troll niveaux 1
        System.out.println("Vous devez affronter le méchant Troll qui se trouve dans les toilettes à côté du Donjon");
        Boss troll = new Boss("Troll",10,10);
        battle(wizard,troll);
        System.out.println("Vous avez fait tomber des objet sur la tete du troll, il est vaincu");
        System.out.println("Vous avez terminée le niveaux 1");
        anythingToContinue();
        clearConsole();
        printSeparator(40);

        //Niveaux 2
        System.out.println("Votre deuxieme année commence, vous apprenez le sort accio en cours");
        anythingToContinue();
        Spell accio = new Spell("Accio", 0.95, 15);
        wizard.addKnownSpell(accio);
        System.out.println("Allowed spells "+ wizard.getKnownspell());
        Ennemy serpent = new Ennemy("serpent",10,10);
        battle(wizard,serpent);
        anythingToContinue();
        System.out.println("Vous entrée dans la chambre des secrets et vous tombez sur le basilic");
        Boss basilic = new Boss("basilic",15,15);

        if (house.getName() == "GRYFFINDOR"){
            System.out.println("vous utilisez l'épée griffondor pour tuer le basilic");
        }
        else {
            battle(wizard,basilic);
            System.out.println("vous utlisé accio pour arracher un des crocs du basilic");
        }


        System.out.println("vous avez terminer le niveaux 2");
        anythingToContinue();
        //niveaux 3
        System.out.println("Votre troisieme année commence, vous apprenez à utiliser votre patronus");
        Spell patromus = new Spell("Expecto patromus", 0.95, 10);
        wizard.addKnownSpell(patromus);
        System.out.println("Allowed spells "+ wizard.getKnownspell());
        anythingToContinue();
        battle(wizard,serpent);
        anythingToContinue();
        System.out.println("Vous dans le Lac dans la Forêt Interdite et les détraqueur vous attaque");
        Boss détraqueur = new Boss("détraqueurs",10,10);
        battle(wizard,détraqueur);
        System.out.println("Vous mettez les détrqueur en fuite à l'aide de votre patromus");
        anythingToContinue();
        System.out.println("vous avez terminer le niveaux 3");
        anythingToContinue();
        //niveaux 4
        System.out.println("Votre 4eme année commence");
        anythingToContinue();
        System.out.println("Vous êtes dans le Cimetière de Little Hangleton");
        System.out.println("Vous vous faite attaquer par Peter Pettigrow");
        Boss peter = new Boss("Peter Pettigrow",10,10);
        battle(wizard,peter);
        System.out.println("Voldemort arrive vous etes dans la sauce");
        System.out.println("Vous devez vous rapprocher du Portolion, l’attirer à vous (accio) et vous enfuir");
        System.out.println("Voulez-vous utilisez accio ?");
        System.out.println("(1) Yes");
        input = choice("->", 1);
        System.out.println("Vous arrivez à vous enfuir");
        System.out.println("vous avez terminer le niveaux 4");
        anythingToContinue();
        System.out.println("Votre 5eme année commence");
        anythingToContinue();
        System.out.println("Vous affrontez dolores hombrage dans la salle d'examen");
        Boss dolores = new Boss("dolores lombrage",10, 10);
        battle(wizard,dolores);
        System.out.println("Vous obtenez des feux d'artifice et la fete commence");
        anythingToContinue();
        System.out.println("vous avez terminer le niveaux 5");
        anythingToContinue();
        System.out.println("Votre 6eme année commence");
        anythingToContinue();
        System.out.println("Vous devez élimé les mangemort dans la tour d'astronomie");
        Boss mangemort= new Boss("mangemort",10,10);
        if (house.getName() == "SLYTHERIN") {
            System.out.println("Vous pouvez rejoindre les mangemort que choisisez vous ?");
            System.out.println("(1) Yes");
            System.out.println("(1) No");
            input = choice("->", 2);
            switch (input) {
                case 1:
                    System.out.println("Vous avez rejoins les mangemort, le jeu s'arrete");
                    System.exit(0);
                    break;
                case 2:
                    battle(wizard, mangemort);
                    break;
            }
        } else {
            battle(wizard, mangemort);
        }
        System.out.println("Vous avez élimé les mangemort dans la tour d'astronomie");
        anythingToContinue();
        System.out.println("vous avez terminer le niveaux 6");
        anythingToContinue();
        System.out.println("Votre derniére année commence, Vous apprenez un sort interdit");
        Spell expeliermus= new Spell("expeliermus", 0.95, 10);
        wizard.addKnownSpell(expeliermus);
        System.out.println("Allowed spells "+ wizard.getKnownspell());
        anythingToContinue();
        System.out.println("Vous devez mettre hors d’état de nuire Voldemort et Bellatrix Lestrange.");
        Boss bela = new Boss("bellatrix",10,10);
        battle(wizard,bela);
        System.out.println("vous avez battu belletrix, maintenant au tour de Voldemort");
        anythingToContinue();
        Boss voldemort = new Boss("voldemort",10,10);
        Wand vwand = getRandomWand();
        System.out.println("La baguette de Voldemort est "+ vwand);
        anythingToContinue();
        if (wizard.getWand().getCore() == vwand.getCore()){
            System.out.println("Vos baguette ayant le coeur, vous explosez tous les 2.");
            System.out.println("GAME OVER");
            System.exit(0);
        }else{
            battle(wizard,voldemort);

        System.out.println("Vous avez battu voldemort et sauver l'académie des sorciers");
        anythingToContinue();
        System.out.println("Vous avez fini le jeu félicitation");
    }

    }






}

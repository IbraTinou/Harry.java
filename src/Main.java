public class Main {
    public static void main(String[] args) {

        // GameLogic.startGame();
        Wand wand = new Wand(Core.PHOENIX_FEATHER, 10);
        Pet pet = Pet.CAT;

        SortingHat sortingHat = new SortingHat();
        Wizard wizard = new Wizard("Martin", 10, pet, null, null);



        System.out.println(wizard);
    }
}
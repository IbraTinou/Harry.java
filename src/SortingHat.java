import java.util.concurrent.ThreadLocalRandom;

public class SortingHat {

    public static House houseAllocation(){
        int random = (int)(Math.random() * 4);

        House house = null;

        switch (random){
            case 0:
                house = new House("GRYFFINDOR", 10, 15, 0, 10);
                break;
            case 1:
                house = new House("SLYTHERIN", 15, 10, 0, 10);
                break;
            case 2:
                house = new House("HUFFLEPUFF", 10, 10, 0, 15);
                break;
            case 3:
                house = new House("RAVENCLOW", 10, 10, 0.25, 10);
                break;
        }

        return house;

    }
}


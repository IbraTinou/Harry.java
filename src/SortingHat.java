import java.util.concurrent.ThreadLocalRandom;

public class SortingHat {

    public static House houseAllocation(){
        int random = (int)(Math.random() * 4);

        House house = null;

        switch (random){
            case 0:
                house = House.GRYFFINDOR;
                break;
            case 1:
                house = House.SLYTHERIN;
                break;
            case 2:
                house = House.HUFFLEPUFF;
                break;
            case 3:
                house = House.RAVENCLOW;
                break;
        }

        return house;
    }
}


import java.util.ArrayList;
import java.util.List;

public class Wizard extends Character{
    private Pet pet;
    private Wand wand;
    private House house;
    private ArrayList<Spell> knownspell;
    private ArrayList<Potion> potions;

    public int defend() {
        return 0;
    }

    public Wizard(String name, int maxHp, Pet pet, List<Spell> knownspell, List<Potion>potions) {
        super(name, maxHp);
        this.house = SortingHat.houseAllocation();
        this.wand = wand;
        this.pet = pet;
        this.knownspell = (ArrayList<Spell>) knownspell;
        this.potions= (ArrayList<Potion>) potions;
    }


    public void setWand(Wand wand){
        this.wand = wand;
    }
    

    @Override
    public int attack() {
        return 0;
    }

    @Override
    public int accuracy() {
        return 0;
    }
}

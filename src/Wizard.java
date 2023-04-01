import java.util.ArrayList;
import java.util.List;

public class Wizard extends Character{
    private Pet pet;
    private Wand wand;
    private House house;
    private ArrayList<Spell> knownspell;
    private List<Potion> potions;

    public int defend() {
        return 0;
    }

    public Wizard(String name, int maxHp, Pet pet, Wand wand) {
        super(name, maxHp);
        this.house = SortingHat.houseAllocation();
        this.wand = wand;
        this.pet = pet;
        this.knownspell = new ArrayList<Spell>();
        this.potions= new ArrayList<Potion>();
    }

    public String toString(){
        return "Wizard :" + this.name + " with MaxHP " + this.maxHp;
    }

    public void setWand(Wand wand){
        this.wand = wand;
    }

    // Attacks methods
    @Override
    public int attack(Character character) {
        return 0;
    }

    @Override
    public int attack(Character character, Spell spell) {
        return 0;
    }

    public void addKnownSpell(Spell spell){
        this.knownspell.add(spell);
    }

    public ArrayList<Spell> getKnownspell(){
        return this.knownspell;
    }


}

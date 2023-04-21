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

    public Wizard(String name, int maxHp, Pet pet, Wand wand,House house) {
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

    public Wand getWand(){
        return this.wand;
    }

    // Attacks methods
    //@Override
    //public int attack(Character character, Spell speel) {
    //    return 0;
    // }

    @Override
    public int attack(Character character) {
        return 0;
    }

    @Override
    public int attack(Character character, Spell spell) {
        int spellPower = spell.getPower();
        double spellAccuracy = spell.getAccuracy();
        double houseAttackRate = this.house.getAttackRate();
        //double houseAttackRate = 0.97;
        double houseAccuracyRate = this.house.getAccuracyRate();
        //double houseAccuracyRate = 0.97;
        int impactOfHP = (int)(spellPower*houseAttackRate); // HP to remove to the character
        double successRate = (int)((Math.random()*2 + houseAccuracyRate) * spellAccuracy);

        if (successRate == 1){
          character.hitMe(impactOfHP);
          return impactOfHP;
        }
        return 0;
    }

    public void addKnownSpell(Spell spell){
        this.knownspell.add(spell);
    }

    public ArrayList<Spell> getKnownspell(){
        return this.knownspell;
    }
    public void AddPotions(Potion potion){this.potions.add(potion);}
    public List<Potion> getPotions(){return  this.potions;}

    public House getHouse(){
        return this.house;
    }
}

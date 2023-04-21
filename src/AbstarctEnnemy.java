import java.util.ArrayList;

public abstract class AbstarctEnnemy extends Character{
    private ArrayList<Spell> knownspell;

    public AbstarctEnnemy(String name, int maxHp) {
        super(name, maxHp);
        this.knownspell = new ArrayList<Spell>();

        Spell attack = new Spell("attack", 0.95, 10);
        this.addKnownSpell(attack);
    }
    public void addKnownSpell(Spell spell){
        this.knownspell.add(spell);
    }

    public ArrayList<Spell> getKnownspell(){
        return this.knownspell;
    }
    public int ennemyattack(Character character){
        return 1;
    }

}

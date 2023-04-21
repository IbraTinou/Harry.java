public class Boss extends AbstarctEnnemy{


    public Boss(String name, int maxHp,int hp) {
        super(name, maxHp);
        this.hp = maxHp;

    }
    @Override
    public int attack(Character character){return 0; }
    @Override
    public int attack(Character character, Spell spell) {
        return 0;
    }


}

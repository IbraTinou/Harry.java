public class Ennemy extends AbstarctEnnemy{
    @Override
    public int attack(Character character) {
        return 0;
    }

    @Override
    public int attack(Character character, Spell spell) {
        return 0;
    }

    public Ennemy(String name, int maxHp,int hp) {
        super(name, maxHp);
        this.hp = maxHp;
    }
}

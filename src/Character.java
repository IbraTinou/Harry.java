public abstract class Character {
    public String name;
    public int maxHp,hp;

    public abstract int attack(Character character);
    public abstract int attack(Character character, Spell spell);

    public Character (String name,int maxHp){
        this.name = name;
        this.maxHp = maxHp;
        this.hp = maxHp;
    }
}

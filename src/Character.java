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

    public void hitMe(int impactOfHp){
        int diff = this.hp - impactOfHp;
        if (diff > 0){
            this.hp = diff;
        } else {
            this.hp = 0;
        }
    }
}

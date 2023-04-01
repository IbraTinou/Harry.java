public abstract class Character {
    public String name;
    public int maxHp,hp;

    public abstract int attack();

    public Character (String name,int maxHp){
        this.name = name;
        this.maxHp = maxHp;
        this.hp = maxHp;
    }
}

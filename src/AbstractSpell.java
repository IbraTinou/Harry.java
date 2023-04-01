public abstract class AbstractSpell {
    private String name;
    private double accuracy;

    private int power; // Range value : 0 - 100

    public AbstractSpell(String name, double accuracy){
        this.name = name;
        this.accuracy = accuracy;
    }

    public String toString(){
        return "Spell :" + this.name + " with accuracy " + this.accuracy;
    }

    public String getName(){
        return this.name;
    }
    public double getAccuracy(){
        return this.accuracy;
    }
    public int getPower(){
        return this.power;
    }

}

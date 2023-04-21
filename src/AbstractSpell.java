public abstract class AbstractSpell {
    private String name;
    private double accuracy; // Range value [0,1]

    private int power; // Range value : 0 - 100

    public AbstractSpell(String name, double accuracy, int power){
        this.name = name;
        this.accuracy = accuracy;
        this.power = power;
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

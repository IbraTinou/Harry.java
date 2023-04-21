public class House{
    private String name;
    private double attackRate;
    private double defendRate;
    private double accuracyRate; // [0, 0.25]
    private double potionImpact;

    public House(String name, double attackRate, double defendRate, double accuracyRate, double potionImpact){
        this.name= name;
        this.attackRate= attackRate;
        this.defendRate=defendRate;
        this.accuracyRate=accuracyRate;
        this.potionImpact=potionImpact;
    }
    public double getAttackRate(){
        return this.attackRate;
    }

    public double getAccuracyRate(){
        return this.accuracyRate;
    }
    public String getName() {
        return name;
    }
}

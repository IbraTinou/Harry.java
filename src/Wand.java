public class Wand {
private Core core;
private int size;

    public Wand(Core core,int size){
        this.core = core;
        this.size = size;
    }

    public String toString(){
        return "Wand : " + this.core + " " + this.size;
    }

    public int getSize() {
        return size;
    }
    public Core getCore() {
        return core;
    }

}

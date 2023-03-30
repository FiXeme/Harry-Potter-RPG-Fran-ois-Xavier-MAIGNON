package sorcier.baguette;


public class Baguette {
    private int size;
    private Coeur core;

    public Baguette (int size, Coeur core){
        this.size = size;
        this.core = core;
    }

    public int getSize() {
        return size;
    }

    public void setSize() {
        this.size = size;
    }

    public Coeur getCore() {
        return core;
    }

    public void setCore() {
        this.core = core;
    }
}

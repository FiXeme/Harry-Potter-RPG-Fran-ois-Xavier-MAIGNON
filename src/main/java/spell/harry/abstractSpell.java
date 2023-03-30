package spell.harry;

public abstract class abstractSpell {

    private String name;
    private double accuracy;
    private String effect;
    private int damage;

    public abstractSpell(String name, double accuracy, String effect, int damage) {
        this.name = name;
        this.accuracy = accuracy;
        this.effect = effect;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public String toString() {
        return "abstractSpell{" +
                "name='" + name + '\'' +
                ", accuracy=" + accuracy +
                ", effect='" + effect + '\'' +
                ", damage=" + damage +
                '}';
    }
}

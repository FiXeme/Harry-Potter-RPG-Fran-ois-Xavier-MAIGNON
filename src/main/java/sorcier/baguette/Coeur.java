package sorcier.baguette;

public enum Coeur {
    Phoenix_Feather, Dragon_Heartstring;

    public static Coeur assignCoeur(){
        int Coeurnum = (int) (Math.random() * 4);
        if (Coeurnum == 0) {
            return Coeur.Phoenix_Feather;
        }
        else {
            return Coeur.Dragon_Heartstring;
        }
    }
}

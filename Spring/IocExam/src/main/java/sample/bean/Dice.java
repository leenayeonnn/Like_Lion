package sample.bean;

public class Dice {
    private int face;

    public Dice() {
        System.out.println("Dice generate");
    }

    public Dice (int face){
        this.face = face;
        System.out.println("Dice generate with face");
    }
    public int getNumber(){
        return (int)(Math.random() * face) +1;
    }
}
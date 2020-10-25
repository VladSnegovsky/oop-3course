package com.company;

public class RoundTable extends Knight{
    public static Knight[] knights;

    public RoundTable(String knight_name, Shop shop) {
        super(knight_name, shop);
    }

    public void addKnights(Shop shop){
        knights[1] = new Knight("Sir Aglovale de Galis", shop);
        knights[2] = new Knight("Elyan the White", shop);
        knights[3] = new Knight("Gawain", shop);
        knights[4] = new Knight("Lancelot", shop);
        knights[5] = new Knight("Lionel", shop);
        knights[6] = new Knight("Mordred", shop);
        knights[7] = new Knight("Percival", shop);
        knights[8] = new Knight("Safir", shop);
        knights[9] = new Knight("Segwarides", shop);
        knights[10] = new Knight("Tristan", shop);
        knights[11] = new Knight("Urien", shop);
    }
}

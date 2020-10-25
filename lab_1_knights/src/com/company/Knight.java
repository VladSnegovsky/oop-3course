package com.company;
import java.lang.String;
import java.util.Random;

public class Knight {
    String Name;

    String Shirt;
    String Pants;
    String Armor;
    String ChainMail;
    int Footwear;
    int Sword;

    int Weight;
    int Cost;

    public Knight(String knight_name, Shop shop){
        Name = knight_name;
        Cost = 0;
        selectShirt(shop);
        selectPants(shop);
        selectArmor(shop);
        selectChainMail(shop);
        selectFootwear(shop);
        selectSword(shop);
    }

    public void selectShirt(Shop shop){
        int i = shop.countShirt;
        Random rand = new Random();
        int j = rand.nextInt(i-1);
        j++;
        Shirt = shop.shirt[j].Size;
        Cost += shop.shirt[j].Cost;
        Weight += shop.shirt[j].Weight;
    }

    public void selectPants(Shop shop){
        int i = shop.countPants;
        Random rand = new Random();
        int j = rand.nextInt(i-1);
        j++;
        Pants = shop.pants[j].Size;
        Cost += shop.pants[j].Cost;
        Weight += shop.pants[j].Weight;
    }

    public void selectArmor(Shop shop){
        int i = shop.countArmor;
        Random rand = new Random();
        int j = rand.nextInt(i-1);
        j++;
        Armor = shop.armor[j].Size;
        Cost += shop.armor[j].Cost;
        Weight += shop.armor[j].Weight;
    }

    public void selectChainMail(Shop shop){
        int i = shop.countChainMail;
        Random rand = new Random();
        int j = rand.nextInt(i-1);
        j++;
        ChainMail = shop.chainmail[j].Size;
        Cost += shop.chainmail[j].Cost;
        Weight += shop.chainmail[j].Weight;
    }

    public void selectFootwear(Shop shop){
        int i = shop.countFootwear;
        Random rand = new Random();
        int j = rand.nextInt(i-1);
        j++;
        Footwear = shop.footwear[j].Size;
        Cost += shop.footwear[j].Cost;
        Weight += shop.footwear[j].Weight;
    }

    public void selectSword(Shop shop){
        int i = shop.countSword;
        Random rand = new Random();
        int j = rand.nextInt(i-1);
        j++;
        Sword = shop.sword[j].Size;
        Cost += shop.sword[j].Cost;
        Weight += shop.sword[j].Weight;
    }
}

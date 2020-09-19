package com.company;
import javax.xml.crypto.Data;
import java.lang.String;
import java.sql.DatabaseMetaData;
import java.util.Random;
import java.util.Scanner;

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

    public Knight(String knight_name){
        Name = knight_name;
        Cost = 0;
        selectShirt();
        selectPants();
        selectArmor();
        selectChainMail();
        selectFootwear();
        selectSword();
    }

    public Knight() {
    }

    public void selectShirt(){
        int i = DataBase.shirt[0][0];
        Random rand = new Random();
        int j = rand.nextInt(i-1);
        j++;
        Shirt = DataBase.shirt_sizes[j];
        Cost += DataBase.shirt[0][j];
        Weight += DataBase.shirt[1][j];
    }

    public void selectPants(){
        int i = DataBase.pants[0][0];
        Random rand = new Random();
        int j = rand.nextInt(i-1);
        j++;
        Pants = DataBase.pants_sizes[j];
        Cost += DataBase.pants[0][j];
        Weight += DataBase.pants[1][j];
    }

    public void selectArmor(){
        int i = DataBase.armor[0][0];
        Random rand = new Random();
        int j = rand.nextInt(i-1);
        j++;
        Armor = DataBase.armor_sizes[j];
        Cost += DataBase.armor[0][j];
        Weight += DataBase.armor[1][j];
    }

    public void selectChainMail(){
        int i = DataBase.chainmail[0][0];
        Random rand = new Random();
        int j = rand.nextInt(i-1);
        j++;
        ChainMail = DataBase.chainmail_sizes[j];
        Cost += DataBase.chainmail[0][j];
        Weight += DataBase.chainmail[1][j];
    }

    public void selectFootwear(){
        int i = DataBase.footwear[0][0];
        Random rand = new Random();
        int j = rand.nextInt(i-1);
        j++;
        Footwear = DataBase.footwear[0][j];
        Cost += DataBase.footwear[1][j];
        Weight += DataBase.footwear[2][j];
    }

    public void selectSword(){
        int i = DataBase.sword[0][0];
        Random rand = new Random();
        int j = rand.nextInt(i-1);
        j++;
        Sword = DataBase.sword[0][j];
        Cost += DataBase.sword[1][j];
        Weight += DataBase.sword[2][j];
    }
}

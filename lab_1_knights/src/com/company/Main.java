package com.company;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runners.JUnit4;

import javax.xml.crypto.Data;
import java.util.Scanner;
import java.lang.String;
import java.sql.SQLException;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, InterruptedException {
        DataBase.Conn();
        DataBase.CreateDB();
        DataBase.ReadDB();
        DataBase.CloseDB();

        String str = "Dark times have come!\nAnglo-Saxons Colgrim gathered an army and move towards Camelot!We urgently need to gather the knights\n of the Round Table!\n";
        for (int i = 0; i < str.length(); i++){
            char str1 = str.charAt(i);
            System.out.print(str1);
            Thread.sleep(50);
        }

        Thread.sleep(3000);
        System.out.println("Let's get King Arthur Pendragon ready for battle!\n Let's go to the barracks and see what kind of stuff and armor we can take.");
        Thread.sleep(3000);
        DataBase.SortTwoArr(DataBase.shirt, DataBase.shirt_sizes, true);
        Thread.sleep(3000);
        System.out.println("\nArthur fits the XL size, it will cost 5 coins.\n");
        Thread.sleep(3000);
        RoundTable.knights = new Knight[20];
        RoundTable.knights[0] = new Knight("Arthur Pendragon");
        RoundTable.knights[0].Shirt = "XL";
        RoundTable.knights[0].Cost = 5;
        RoundTable.knights[0].Weight = 263;

        Thread.sleep(3000);
        System.out.println("Pants:");
        DataBase.SortTwoArr(DataBase.pants, DataBase.pants_sizes, false);
        Thread.sleep(3000);
        System.out.println("\nPants size L is what suits us. We take! 5 more coins.\n");
        Thread.sleep(3000);
        RoundTable.knights[0].Pants = "L";
        RoundTable.knights[0].Cost = 5;
        RoundTable.knights[0].Weight += 246;

        Thread.sleep(3000);
        System.out.println("We also need a footwear:");
        DataBase.SortOneArr(DataBase.footwear, false);
        Thread.sleep(3000);
        System.out.println("\nArthur has 42nd foot size, so we will take this size. 6 coins.\n");
        Thread.sleep(3000);
        RoundTable.knights[0].Footwear = 42;
        RoundTable.knights[0].Cost = 6;
        RoundTable.knights[0].Weight += 419;

        Thread.sleep(3000);
        System.out.println("Chain Mail:");
        DataBase.SortTwoArr(DataBase.chainmail,DataBase.chainmail_sizes, false);
        Thread.sleep(3000);
        System.out.println("\nXL size! 31 coins.\n");
        Thread.sleep(3000);
        RoundTable.knights[0].Armor = "XL";
        RoundTable.knights[0].Cost += 31;
        RoundTable.knights[0].Weight += 7594;

        Thread.sleep(3000);
        System.out.println("Now let's choose protection:");
        DataBase.SortTwoArr(DataBase.armor,DataBase.armor_sizes, false);
        Thread.sleep(3000);
        System.out.println("\nTake XL size! 5 coins.\n");
        Thread.sleep(3000);
        RoundTable.knights[0].Armor = "XL";
        RoundTable.knights[0].Cost += 5;
        RoundTable.knights[0].Weight += 5037;

        System.out.println("Okay, now let's buy Arthur a sword! We need to go to the blacksmith.");
        Thread.sleep(3000);
        DataBase.SortOneArr(DataBase.sword, false);
        System.out.println("\n We need to take Arthur's longest sword!\n");
        RoundTable.knights[0].Sword = 66;
        RoundTable.knights[0].Cost += 21;
        RoundTable.knights[0].Weight += 2098;

        System.out.println("\nArthur is ready. Let's get the rest!\n");
        System.out.print("Press 1 to gather Knights or 2 to have a feast:");
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        if (num == 1){
            System.out.println("Collect...\n");
            Thread.sleep(3000);
            RoundTable Table = new RoundTable();
            System.out.println("Knights:\n");
            for (int i = 0; i < 12; i++){
                System.out.println(RoundTable.knights[i].Name + ": size of shirt:" + RoundTable.knights[i].Shirt + ", size of pants:" + RoundTable.knights[i].Pants + ", size of footwear:" + RoundTable.knights[i].Footwear + ", size if chain mail:" + RoundTable.knights[i].ChainMail + ", size of armor:" + RoundTable.knights[i].Armor + ", length of sword:" + RoundTable.knights[i].Sword + ". Weight of stuff = " + RoundTable.knights[i].Weight + ". Total cost = " + RoundTable.knights[i].Cost);
            }
            System.out.println("The Knights are ready and we will definitely Win!");
        }
        else {
            System.out.println("No time to feast! We must gather Knights!!!");
            System.out.println("Collect...\n");
            Thread.sleep(3000);
            RoundTable Table = new RoundTable();
            System.out.println("Knights:\n");
            for (int i = 0; i < 12; i++){
                System.out.println(RoundTable.knights[i].Name + ": size of shirt:" + RoundTable.knights[i].Shirt + ", size of pants:" + RoundTable.knights[i].Pants + ", size of footwear:" + RoundTable.knights[i].Footwear + ", size if chain mail:" + RoundTable.knights[i].ChainMail + ", size of armor:" + RoundTable.knights[i].Armor + ", length of sword:" + RoundTable.knights[i].Sword + ". Weight of stuff = " + RoundTable.knights[i].Weight + ". Total cost = " + RoundTable.knights[i].Cost);
            }
            System.out.println("The Knights are ready and we will definitely Win!");
        }

        boolean exit = false;
        while (!exit){
            System.out.println("\n\nShop:\nChoose what you want:\nShirt (1)\nPants(2)\nFootwear(3)\nChain Mail(4)\nArmor(5)\nSword(6)\nExit(7)\nYour Choice:");
            Scanner sh = new Scanner(System.in);
            int choice = sh.nextInt();
            if (choice == 7)
                exit = true;
            else {
                System.out.println("Enter minimum cost:");
                int min = sh.nextInt();
                System.out.println("Enter maximum cost:");
                int max = sh.nextInt();
                DataBase.ShowByCost(min, max, choice);
            }
        }
    }
}

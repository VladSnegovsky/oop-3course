package com.company;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DataBase {
    public static Connection conn;
    public static Statement statmt;
    public static ResultSet resSet;

//    public static int[][] sword;

    
    public static int [][] ftTest;

    public static void Conn() throws ClassNotFoundException, SQLException {
        conn = null;
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:knight.s3db");
    }

    public static void CreateDB() throws ClassNotFoundException, SQLException {
        statmt = conn.createStatement();
//        statmt.execute("CREATE TABLE if not exists 'Footwear' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' text, 'phone' INT);");

//        System.out.println("Table created/exists");
    }

    //Shop
    public static void ShowByCost(int min, int max, int arr, Shop shop){
        boolean thereis = false;
        switch (arr){
            case 1:
                for (int i = 0; i < shop.countShirt; i++){
                    if (shop.shirt[i].Cost >= min && shop.shirt[i].Cost <= max){
                        System.out.println(shop.shirt[i].Size + " " + shop.shirt[i].Cost + " coins " + shop.shirt[i].Weight + " gr.");
                        thereis = true;
                    }
                }

                if(!thereis)
                    System.out.println("No things in this price range.");
                break;
            case 2:
                for (int i = 0; i < shop.countPants; i++){
                    if (shop.pants[i].Cost >= min && shop.pants[i].Cost <= max){
                        System.out.println(shop.pants[i].Size + " " + shop.pants[i].Cost + " coins " + shop.pants[i].Weight + " gr.");
                        thereis = true;
                    }
                }

                if(!thereis)
                    System.out.println("No things in this price range.");
                break;
            case 3:
                for (int i = 0; i < shop.countFootwear; i++){
                    if (shop.footwear[i].Cost >= min && shop.footwear[i].Cost <= max){
                        System.out.println(shop.footwear[i].Size + " " + shop.footwear[i].Cost + " coins " + shop.footwear[i].Weight + " gr.");
                        thereis = true;
                    }
                }

                if(!thereis)
                    System.out.println("No things in this price range.");
                break;
            case 4:
                for (int i = 0; i < shop.countChainMail; i++){
                    if (shop.chainmail[i].Cost >= min && shop.chainmail[i].Cost <= max){
                        System.out.println(shop.chainmail[i].Size + " " + shop.chainmail[i].Cost + " coins " + shop.chainmail[i].Weight + " gr.");
                        thereis = true;
                    }
                }

                if(!thereis)
                    System.out.println("No things in this price range.");
                break;
            case 5:
                for (int i = 0; i < shop.countArmor; i++){
                    if (shop.armor[i].Cost >= min && shop.armor[i].Cost <= max){
                        System.out.println(shop.armor[i].Size + " " + shop.armor[i].Cost + " coins " + shop.armor[i].Weight + " gr.");
                        thereis = true;
                    }
                }

                if(!thereis)
                    System.out.println("No things in this price range.");
                break;
            case 6:
                for (int i = 0; i < shop.countSword; i++){
                    if (shop.sword[i].Cost >= min && shop.sword[i].Cost <= max){
                        System.out.println(shop.sword[i].Size + " " + shop.sword[i].Cost + " coins " + shop.sword[i].Weight + " gr.");
                        thereis = true;
                    }
                }

                if(!thereis)
                    System.out.println("No things in this price range.");
                break;
            default:
                break;
        }
    }

    //Read DB
    public static void readFootwear(Shop openShop) throws ClassNotFoundException, SQLException {
        resSet = statmt.executeQuery("SELECT * FROM Footwear");
        while(resSet.next()) {
            openShop.addFootwear(resSet.getInt("Size"), resSet.getInt("Cost"), resSet.getInt("Weight"));
        }
    }

    public static void readSword(Shop openShop) throws ClassNotFoundException, SQLException {
        resSet = statmt.executeQuery("SELECT * FROM Sword");
        while(resSet.next()) {
            openShop.addSword(resSet.getInt("Length"), resSet.getInt("Cost"), resSet.getInt("Weight"));
        }
    }

    public static void readArmor(Shop openShop) throws ClassNotFoundException, SQLException {
        resSet = statmt.executeQuery("SELECT * FROM Armor");
        while(resSet.next()) {
            openShop.addArmor(resSet.getString("Size"), resSet.getInt("Cost"), resSet.getInt("Weight"));
        }
    }

    public static void readShirt(Shop openShop) throws ClassNotFoundException, SQLException {
        resSet = statmt.executeQuery("SELECT * FROM Shirts");
        while(resSet.next()) {
            openShop.addShirt(resSet.getString("Size"), resSet.getInt("Cost"), resSet.getInt("Weight"));
        }
    }

    public static void readChainMail(Shop openShop) throws ClassNotFoundException, SQLException {
        resSet = statmt.executeQuery("SELECT * FROM ChainMail");
        while(resSet.next()) {
            openShop.addChainMail(resSet.getString("Size"), resSet.getInt("Cost"), resSet.getInt("Weight"));
        }
    }

    public static void readPants(Shop openShop) throws ClassNotFoundException, SQLException {
        resSet = statmt.executeQuery("SELECT * FROM Pants");
        while(resSet.next()) {
            openShop.addPants(resSet.getString("Size"), resSet.getInt("Cost"), resSet.getInt("Weight"));
        }
    }

    public static void ReadDB(Shop openShop) throws SQLException, ClassNotFoundException {
        readFootwear(openShop);
        readSword(openShop);
        readArmor(openShop);
        readShirt(openShop);
        readChainMail(openShop);
        readPants(openShop);
    }

    public static void CloseDB() throws ClassNotFoundException, SQLException {
        conn.close();
        statmt.close();
        resSet.close();
    }
}

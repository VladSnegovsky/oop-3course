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

// Size - Cost - Weight
    public static int[][] sword;
    public static int[][] footwear;
// Size
// Cost - Weight
    public static String [] armor_sizes;
    public static int [][] armor;

    public static String [] shirt_sizes;
    public static int [][] shirt;

    public static String [] chainmail_sizes;
    public static int [][] chainmail;

    public static String [] pants_sizes;
    public static int [][] pants;




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

    public static void ShowByCost(int min, int max, int arr){
        boolean thereis = false;
        switch (arr){
            case 1:
                for (int i = 1; i < shirt[0][0]; i++){
                    if (shirt[0][i] >= min && shirt[0][i] <= max){
                        System.out.println(shirt_sizes[i] + " " + shirt[0][i] + " coins " + shirt[1][i] + " gr.");
                        thereis = true;
                    }
                }

                if(!thereis)
                    System.out.println("No things in this price range.");
                break;
            case 2:
                for (int i = 1; i < pants[0][0]; i++){
                    if (pants[0][i] >= min && pants[0][i] <= max){
                        System.out.println(pants_sizes[i] + " " + pants[0][i] + " coins " + pants[1][i] + " gr.");
                        thereis = true;
                    }
                }

                if(!thereis)
                    System.out.println("No things in this price range.");
                break;
            case 3:
                for (int i = 1; i < footwear[0][0]; i++){
                    if (footwear[1][i] >= min && footwear[1][i] <= max){
                        System.out.println(footwear[0][i] + " " + footwear[1][i] + " coins " + footwear[2][i] + " gr.");
                        thereis = true;
                    }
                }

                if(!thereis)
                    System.out.println("No things in this price range.");
                break;
            case 4:
                for (int i = 1; i < chainmail[0][0]; i++){
                    if (chainmail[0][i] >= min && chainmail[0][i] <= max){
                        System.out.println(chainmail_sizes[i] + " " + chainmail[0][i] + " coins " + chainmail[1][i] + " gr.");
                        thereis = true;
                    }
                }

                if(!thereis)
                    System.out.println("No things in this price range.");
                break;
            case 5:
                for (int i = 1; i < armor[0][0]; i++){
                    if (armor[0][i] >= min && armor[0][i] <= max){
                        System.out.println(armor_sizes[i] + " " + armor[0][i] + " coins " + armor[1][i] + " gr.");
                        thereis = true;
                    }
                }

                if(!thereis)
                    System.out.println("No things in this price range.");
                break;
            case 6:
                for (int i = 1; i < sword[0][0]; i++){
                    if (sword[1][i] >= min && sword[1][i] <= max){
                        System.out.println(sword[0][i] + " " + sword[1][i] + " coins " + sword[2][i] + " gr.");
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

    //Sort

    public static void SortOneArr(int[][] arr, boolean game) {
        if (game) {
            System.out.println("What a mess!:");
            for (int i = 1; i <= arr[0][0]; i++){
                System.out.println(Integer.toString(arr[0][i]) + " cm = " + Integer.toString(arr[1][i]) + " coins " + Integer.toString(arr[2][i]) + "gr");
            }
        }

        if (game) {
            System.out.println("We need to ask the blacksmith to put everything in its place.");
            System.out.println("Press any number to ask... :");
            Scanner in = new Scanner(System.in);
            int num = in.nextInt();
        }

        int temp = 0;
        int temp1 = 0;
        int temp2 = 0;
        boolean sorted = false;

        while (!sorted){
            sorted = true;
            for (int i = 1; i < arr[0][0]; i++){
                if (arr[2][i] > arr[2][i+1]){
                    temp = arr[1][i];
                    temp1 = arr[0][i];
                    temp2 = arr[2][i];
                    arr[1][i] = arr[1][i+1];
                    arr[0][i] = arr[0][i+1];
                    arr[2][i] = arr[2][i+1];
                    arr[1][i+1] = temp;
                    arr[0][i+1] = temp1;
                    arr[2][i+1] = temp2;
                    sorted = false;
                }
            }
        }

        if (game)
            System.out.println("Good:");
        for (int i = 1; i <= arr[0][0]; i++){
            System.out.println(Integer.toString(arr[0][i]) + " cm = " + Integer.toString(arr[1][i]) + " " + Integer.toString(arr[2][i]) + "gr");
        }
    }

    public static void SortTwoArr(int[][] arr, String[] arr1, boolean game) {
        if (game) {
            System.out.println("Ohh noo! Enemies are trying to prevent us from building an army,\n everything is scattered!:");
            for (int i = 1; i <= arr[0][0]; i++){
                System.out.println(arr1[i] + ": " + arr[0][i] + " coins " + arr[1][i] + "gr");
            }
        }

        if (game) {
            System.out.println("Let's put everything in place. Press any number to help with sorting... :");
            Scanner in = new Scanner(System.in);
            int num = in.nextInt();
        }

        int temp = 0;
        int temp1 = 0;
        String temp2 = "";
        boolean sorted = false;

        while (!sorted){
            sorted = true;
            for (int i = 1; i < arr[0][0]; i++){
                if (arr[1][i] > arr[1][i+1]){
                    temp = arr[1][i];
                    temp1 = arr[0][i];
                    temp2 = arr1[i];
                    arr[1][i] = arr[1][i+1];
                    arr[0][i] = arr[0][i+1];
                    arr1[i] = arr1[i+1];
                    arr[1][i+1] = temp;
                    arr[0][i+1] = temp1;
                    arr1[i+1] = temp2;
                    sorted = false;
                }
            }
        }

        if (game)
            System.out.println("Good:");
        for (int i = 1; i <= arr[0][0]; i++){
            System.out.println(arr1[i] + ": " + Integer.toString(arr[0][i]) + " coins " + Integer.toString(arr[1][i]) + "gr");
        }
    }

    //Read DB
    public static void readFootwear() throws ClassNotFoundException, SQLException {
        resSet = statmt.executeQuery("SELECT * FROM Footwear");
        footwear = new int[5][20];
        int i = 1;
        while(resSet.next()) {
            footwear[0][i] = resSet.getInt("Size");
            footwear[1][i] = resSet.getInt("Cost");
            footwear[2][i] = resSet.getInt("Weight");
            i++;
        }
        footwear[0][0] = i-1;
    }

    public static void readSword() throws ClassNotFoundException, SQLException {
        resSet = statmt.executeQuery("SELECT * FROM Sword");
        sword = new int[5][20];
        int i = 1;
        while(resSet.next()) {
            sword[0][i] = resSet.getInt("Length");
            sword[1][i] = resSet.getInt("Cost");
            sword[2][i] = resSet.getInt("Weight");
            i++;
        }
        sword[0][0] = i-1;
    }

    public static void readArmor() throws ClassNotFoundException, SQLException {
        resSet = statmt.executeQuery("SELECT * FROM Armor");
        armor_sizes = new String[20];
        armor = new int[5][20];
        int i = 1;
        while(resSet.next()) {
            armor_sizes[i] = resSet.getString("Size");
            armor[0][i] = resSet.getInt("Cost");
            armor[1][i] = resSet.getInt("Weight");
            i++;
        }
        armor[0][0] = i-1;
    }

    public static void readShirt() throws ClassNotFoundException, SQLException {
        resSet = statmt.executeQuery("SELECT * FROM Shirts");
        shirt_sizes = new String[20];
        shirt = new int[5][20];
        int i = 1;
        while(resSet.next()) {
            shirt_sizes[i] = resSet.getString("Size");
            shirt[0][i] = resSet.getInt("Cost");
            shirt[1][i] = resSet.getInt("Weight");
            i++;
        }
        shirt[0][0] = i-1;
    }

    public static void readChainMail() throws ClassNotFoundException, SQLException {
        resSet = statmt.executeQuery("SELECT * FROM ChainMail");
        chainmail_sizes = new String[20];
        chainmail = new int[5][20];
        int i = 1;
        while(resSet.next()) {
            chainmail_sizes[i] = resSet.getString("Size");
            chainmail[0][i] = resSet.getInt("Cost");
            chainmail[1][i] = resSet.getInt("Weight");
            i++;
        }
        chainmail[0][0] = i-1;
    }

    public static void readPants() throws ClassNotFoundException, SQLException {
        resSet = statmt.executeQuery("SELECT * FROM Pants");
        pants_sizes = new String[20];
        pants = new int[5][20];
        int i = 1;
        while(resSet.next()) {
            pants_sizes[i] = resSet.getString("Size");
            pants[0][i] = resSet.getInt("Cost");
            pants[1][i] = resSet.getInt("Weight");
            i++;
        }
        pants[0][0] = i-1;
    }

    public static void ReadDB() throws SQLException, ClassNotFoundException {
        readFootwear();
        readSword();
        readArmor();
        readShirt();
        readChainMail();
        readPants();
    }

    public static void CloseDB() throws ClassNotFoundException, SQLException {
        conn.close();
        statmt.close();
        resSet.close();
    }
}

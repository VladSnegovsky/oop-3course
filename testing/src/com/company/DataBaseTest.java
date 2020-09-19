package com.company;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

import static org.junit.jupiter.api.Assertions.*;

class DataBaseTest {
//    JUnitCore runner = new JUnitCore();
//    Result result = runner.run(DataBaseTest.class);
//    System.out.println("run tests: " + result.getRunCount());
//    System.out.println("failed tests: " + result.getFailureCount());
//    System.out.println("ignored tests: " + result.getIgnoreCount());
//    System.out.println("success: " + result.wasSuccessful());
    @Test
    public void test(){
        assertTrue(1 == 1);
    }
    @Test
    public void testSort(){
        System.out.println("Testing ..........");
        int temp = 0;
        int temp1 = 0;
        boolean sorted = false;

        while (!sorted){
            sorted = true;
            for (int i = 1; i < DataBase.ftTest[0][0]; i++){
                if (DataBase.ftTest[1][i] > DataBase.ftTest[1][i+1]){
                    temp = DataBase.ftTest[1][i];
                    temp1 = DataBase.ftTest[0][i];
                    DataBase.ftTest[1][i] = DataBase.ftTest[1][i+1];
                    DataBase.ftTest[0][i] = DataBase.ftTest[0][i+1];
                    DataBase.ftTest[1][i+1] = temp;
                    DataBase.ftTest[0][i+1] = temp1;
                    sorted = false;
                }
            }
        }

        System.out.println("Testing ..........");

        assertTrue(DataBase.ftTest[0][1] == 38);
        assertTrue(DataBase.ftTest[1][1] == 5);
        assertTrue(DataBase.ftTest[0][2] == 40);
        assertTrue(DataBase.ftTest[1][2] == 6);
        assertTrue(DataBase.ftTest[0][3] == 42);
        assertTrue(DataBase.ftTest[1][3] == 7);
        assertTrue(DataBase.ftTest[0][4] == 44);
        assertTrue(DataBase.ftTest[1][4] == 8);
        assertTrue(DataBase.ftTest[0][5] == 46);
        assertTrue(DataBase.ftTest[1][5] == 9);
    }
}
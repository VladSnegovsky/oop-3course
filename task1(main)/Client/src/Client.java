import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.Socket;
import java.io.IOException;
import java.util.Scanner;


public class Client implements Runnable{
    @Override
    public void run() {
        try (Socket socket = new Socket("127.0.0.1", 8000);
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {
            System.out.println("Connected to Server!");

            System.out.println("Enter Name: ");
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();

            System.out.println("Enter Second Name: ");
            String sec_name = scanner.nextLine();

            System.out.println("Enter Age: ");
            String age = scanner.nextLine();

            System.out.println("Enter Height: ");
            String height = scanner.nextLine();

            Man newMan = new Man(name, sec_name, age, height);
            String request = newMan.toJSon();

            writer.write(request);
            writer.newLine();
            writer.flush();

            String response = reader.readLine();
            System.out.println("Response: " + response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
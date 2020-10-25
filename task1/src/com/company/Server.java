package com.company;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server implements Runnable {

    public static Man deserialize(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Man.class);
    }

    static private ServerSocket server;
    static private Socket connection;
    static private ObjectOutputStream output;
    static private ObjectInputStream intput;

    @Override
    public void run() {
        try {
            server = new ServerSocket(5678, 10);
            while (true){
                String income;
                connection = server.accept();
                output = new ObjectOutputStream(connection.getOutputStream());
                intput = new ObjectInputStream(connection.getInputStream());
                Man newMan = deserialize((String)intput.readObject());
                output.writeObject("You send: " + newMan.show());
            }
        } catch (UnknownHostException e) {
        } catch (IOException e) {
        } catch (ClassNotFoundException e) {}
    }
}

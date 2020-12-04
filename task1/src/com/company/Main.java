package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main extends JFrame implements Runnable{

    static private Socket connection;
    static private ObjectOutputStream output;
    static private ObjectInputStream intput;

    public static void main(String[] args) {
        new Thread(new Main("Test")).start();
        new Thread(new Server()).start();
    }

    public Main(String name){
        super(name);
        setLayout(new FlowLayout());
        setSize(360, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);setLocationRelativeTo(null);

        final JTextField text1 = new JTextField(10);
        final JTextField text2 = new JTextField(10);
        final JTextField text3 = new JTextField(10);
        final JTextField text4 = new JTextField(10);
        final JButton button1 = new JButton("Send");
        final JLabel label1 = new JLabel("Name");
        final JLabel label2 = new JLabel("Second Name");
        final JLabel label3 = new JLabel("Age");
        final JLabel label4 = new JLabel("Height");

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == button1){
                    try {
                        Man newMan = new Man(text1.getText(), text2.getText(), text3.getText(), text4.getText());
                        sendData(newMan.toJSon());
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
        });

        add(label1);
        add(text1);

        add(label2);
        add(text2);

        add(label3);
        add(text3);

        add(label4);
        add(text4);

        add(button1);
    }

    @Override
    public void run() {
        try {
            while (true){
                connection = new Socket(InetAddress.getByName("127.0.0.1"), 5678);
                output = new ObjectOutputStream(connection.getOutputStream());
                intput = new ObjectInputStream(connection.getInputStream());
                JOptionPane.showMessageDialog(null, (String)intput.readObject());
            }
        } catch (UnknownHostException e) {
        } catch (IOException e) {
        } catch (ClassNotFoundException e) {}
    }

    private static void sendData(Object obj) throws IOException {
        try {
            output.flush();
            output.writeObject(obj);
        } catch (IOException e){}
    }
}

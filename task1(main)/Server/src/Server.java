import com.google.gson.Gson;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static Man deserialize(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Man.class);
    }

    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(8000)){

            while (true){
                try (
                        Socket socket = server.accept();
                        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))
                ) {
                    String request = reader.readLine();
                    Man newMan = deserialize(request);
                    String response = newMan.show();

                    System.out.println("Server: " + response);

                    writer.write(response);
                    writer.newLine();
                    writer.flush();
                }catch (NullPointerException e){
                    e.printStackTrace();
                }
            }
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
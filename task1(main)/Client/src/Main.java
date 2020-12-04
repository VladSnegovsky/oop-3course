import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true){
            System.out.println("To add new Client enter 1, else enter 2 to exit:");
            Scanner scanner = new Scanner(System.in);
            if (scanner.nextInt() == 1){
                Client newClient = new Client();
                newClient.run();
            }
            else
                break;
        }
    }
}

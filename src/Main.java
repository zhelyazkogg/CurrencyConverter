import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new FileReader("E:\\MY Stuff\\Universty\\ComputerLinguistic\\currencies.txt"));
        String currency = reader.readLine();
        
        System.out.println(currency);  // reading the first line of the txt file
    }
}

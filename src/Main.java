import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    private static String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String DB_CONNECTION = "jdbc:mysql://localhost:3306/currency";
    private static String DB_USER = "root";
    private static String DB_PASSWORD = "9706194543";

    public static void main(String[] args) throws SQLException {
       /* BufferedReader reader = new BufferedReader(new FileReader(
                "E:\\MY Stuff\\Universty\\ComputerLinguistic\\currencies.txt"));*/

      //   textReader(); //calling the method i guess

        Scanner option = new Scanner(System.in);
        String readOptions;
        System.out.println("From which currency do you wish to convert to BGN?: ");
        System.out.println("1. Euro/EUR");
        System.out.println("2. Pound/GBP");
        System.out.println("3. Dollar/USD");
        System.out.println("4. Franc/CHF");
        System.out.println("5. Cancel");

        do {
            System.out.println("Select an option:");
            readOptions = option.next();

            switch (readOptions){
                case "1":
                    optionEuro();
                    break;
                case "2":
                    optionPound();
                    break;
                case "3":
                    optionDollar();
                    break;
                case "4":
                    optionFranc();
                    break;
                case "5":
                    System.out.println("Canceled");
                    break;
                default:
                    System.out.println("Invalid selection");
                    break;
            }
        }
        while (!readOptions.equals("5"));
    }

    private static void textReader(BufferedReader reader) throws FileNotFoundException {
        reader = new BufferedReader(new FileReader(
                "E:\\MY Stuff\\Universty\\ComputerLinguistic\\currencies.txt"));
    }

    private static void optionEuro() {

    }

    private static void optionPound(){

    }

    private static void optionDollar(){

    }

    private static void optionFranc(){

    }

}

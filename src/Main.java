import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
    /*    Scanner input = new Scanner(System.in);
        System.out.println("Please choose the a currency which you would like to convert: ");    //+ input);
        BufferedReader reader = new BufferedReader(new FileReader(
                "E:\\MY Stuff\\Universty\\ComputerLinguistic\\currencies.txt"));
        String currency = reader.readLine();
    */

        Scanner option = new Scanner(System.in);
        String readOptions;
        System.out.println("| From which currency do you wish to convert to BGN?: ");
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

    private static void optionEuro() {

    }

    private static void optionPound(){

    }

    private static void optionDollar(){

    }

    private static void optionFranc(){

    }
}

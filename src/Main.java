import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/currency",
                    "root", "9706194543");
            Statement statement = conn.createStatement();
            String sql = "SELECT * FROM currency.currencies";
            ResultSet resultSet = statement.executeQuery(sql);

            Path path = Paths.get("E:\\My Stuff\\Universty\\ComputerLinguistic\\currencies.txt");
            StringBuilder str = new StringBuilder();
            try {
                BufferedReader reader = Files.newBufferedReader(path);
                StringBuilder finalStr = str;
                reader.lines().forEach(s -> finalStr.append(s).append(" "));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            String regex = "(\\p{Sc}\\s\\d+[.,]?\\d+)|([A-Z]{3,}\\s\\d+[.,]?\\d+)|(\\d+[,.]?\\d+\\s[a-z]+)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(str);
            while (matcher.find()) {
                System.out.println(matcher.group());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Scanner choice = new Scanner(System.in);
        System.out.println("Which currency do you wish to convert into BGN?:");
        System.out.println("1. Euro/EUR\n2. Dollars/USD\n3. Pounds/GBP\n4. Franc/CHF");
        choice.next();

        }
    }

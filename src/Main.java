import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner choice = new Scanner(System.in);
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
            String text = str.toString();
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(text);
            String currency;
            String currencyValue;
            String calculatedCurrency;
            System.out.println(text);
            DecimalFormat df = new DecimalFormat("#.##");
            while (matcher.find()) {
                while(resultSet.next()){
                    currency = matcher.group().split("\\s")[0];
                    currencyValue = matcher.group().split("\\s")[1];

                    if (currency.equalsIgnoreCase(resultSet.getString("currency"))){
                        calculatedCurrency =
                                String.valueOf(df.format(Double.parseDouble(currencyValue)
                                        * Double.parseDouble(resultSet.getString("value"))));

                        text = text.replaceAll(currencyValue, calculatedCurrency);

                        if (currency.matches("[A-Z]{3,}")){
                            text = text.replaceAll(currency.trim(), "|BGN");
                        } else {
                            text = text.replaceAll("\\p{Sc}", "|lv");
                        }
                    }
                    if (currencyValue.equalsIgnoreCase(resultSet.getString("currency"))){
                        calculatedCurrency = String.valueOf(df.format(Double.parseDouble(currency)
                                * Double.parseDouble(resultSet.getString("value"))));
                        text = text.replaceAll(currency, calculatedCurrency);
                        text = text.replaceAll(currencyValue.trim(), "leva|");
                    }
                }
                resultSet.beforeFirst();
            }
            conn.close();
            System.out.println(text);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

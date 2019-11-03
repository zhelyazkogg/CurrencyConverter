import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
       try{
           Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/currency",
                   "root","9706194543");
           Statement statement = conn.createStatement();
           String sql = "SELECT * FROM currency.currencies";
           ResultSet resultSet = statement.executeQuery(sql);
           /* while(resultSet.next()){
               System.out.println(resultSet.getString("EUR"));
           } */
       } catch (SQLException e){
           e.printStackTrace();
        }

        Path path = Paths.get("E:\\My Stuff\\Universty\\ComputerLinguistic\\currencies.txt");
        StringBuilder str = new StringBuilder();
        try {
         BufferedReader reader = Files.newBufferedReader(path);
         reader.lines().forEach(s -> str.append(s + " "));
       } catch (IOException e){
           System.out.println(e.getMessage());
       }

        Pattern pattern = Pattern.compile("([A-Z]{3})\\s\\d.+");
        Matcher matcher = pattern.matcher(str);
        // System.out.println(str);
        while(matcher.find()) {
            System.out.println(matcher.group(1));
        }

    }
}

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabasePopulateService {

    public static void main(String[] args) throws SQLException {

        String filePath = "sql/populate_db.sql";

        String content = null;
        try {
            content = ReadFile.readFile(filePath, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Database database = Database.getInstance();
        Connection connection = database.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(content);
        preparedStatement.executeUpdate();
        database.close();
    }

}
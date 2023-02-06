package databaseServices;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DatabaseInitService {
    public static void main(String[] args) {

        try (Connection connection = Database.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ReadFile.readFile("sql/find_max_projects_client.sql", StandardCharsets.UTF_8))) {
            preparedStatement.executeUpdate();
        } catch(SQLException | IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}





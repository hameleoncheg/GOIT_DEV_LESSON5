package databaseServices;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabasePopulateService {

    public static void main(String[] args) {

        try (Connection connection = Database.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ReadFile.readFile("sql/populate_db.sql", StandardCharsets.UTF_8))) {
             preparedStatement.executeUpdate();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
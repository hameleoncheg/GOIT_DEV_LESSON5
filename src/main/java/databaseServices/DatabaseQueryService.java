package databaseServices;

import dataDto.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DatabaseQueryService {
    public List<MaxProjectCountClient> findMaxProjectsClient() throws SQLException {
        List<MaxProjectCountClient> maxProjectCountClients = new ArrayList<>();
        Database database = Database.getInstance();
        try (Connection connection = database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ReadFile.readFile("sql/find_max_projects_client.sql", StandardCharsets.UTF_8));
             ResultSet rs = preparedStatement.executeQuery();){
            while (rs.next()) {
                String name = rs.getString("name");
                int project_count = rs.getInt("project_count");
                maxProjectCountClients.add(new MaxProjectCountClient(rs.getString("name"), rs.getInt("project_count")));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return maxProjectCountClients;
    }

    public List<MaxSalaryWorker> findMaxSalaryWorker() throws SQLException {
        List<MaxSalaryWorker> MaxSalaryWorker = new ArrayList<>();
        Database database = Database.getInstance();
        try(Connection connection = database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(ReadFile.readFile("sql/find_max_salary_worker.sql", StandardCharsets.UTF_8));
            ResultSet rs = preparedStatement.executeQuery();) {
            while (rs.next()) {
                String name = rs.getString("name");
                int salary = rs.getInt("salary");
                MaxSalaryWorker.add(new MaxSalaryWorker(rs.getString("name"), rs.getInt("salary")));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return MaxSalaryWorker;
    }

    public List<YoungestEldestWorkers> findYoungestEldestWorkers() throws SQLException {
        List<YoungestEldestWorkers> YoungestEldestWorkers = new ArrayList<>();
        Database database = Database.getInstance();

        try (Connection connection = database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ReadFile.readFile("sql/find_youngest_eldest_workers.sql", StandardCharsets.UTF_8));
             ResultSet rs = preparedStatement.executeQuery();) {
            while (rs.next()) {
                String type = rs.getString("type");
                String name = rs.getString("name");
                Date birthday = rs.getDate("birthday");
                YoungestEldestWorkers.add(new YoungestEldestWorkers(rs.getString("type"), rs.getString("name"), rs.getDate("birthday")));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return YoungestEldestWorkers;
    }

    public List<ProjectPrices> printProjectPrices() throws SQLException {
        List<ProjectPrices> ProjectPrices = new ArrayList<>();
        Database database = Database.getInstance();
        String content = null;
        try (Connection connection = database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ReadFile.readFile("sql/print_project_prices.sql", StandardCharsets.UTF_8));
             ResultSet rs = preparedStatement.executeQuery();) {
            while (rs.next()) {
                String name = rs.getString("name");
                long price = rs.getLong("price");
                ProjectPrices.add(new ProjectPrices(rs.getString("name"), rs.getLong("price")));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return ProjectPrices;
    }

    public List<LongestProject> findLongestProject() {
        List<LongestProject> LongestProject = new ArrayList<>();
        Database database = Database.getInstance();
        try (Connection connection = database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ReadFile.readFile("sql/find_longest_project.sql", StandardCharsets.UTF_8));
             ResultSet rs = preparedStatement.executeQuery();) {
            while (rs.next()) {
                String name = rs.getString("name");
                int month_count = rs.getInt("month_count");
                LongestProject.add(new LongestProject(rs.getString("name"), rs.getInt("month_count")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return LongestProject;
    }

}
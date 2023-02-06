package databaseServices;

import dataDto.Client;
import dataDto.Project;
import dataDto.ProjectWorker;
import dataDto.Worker;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class DatabasePopulateService {
    private Database db;

    public DatabasePopulateService(Database db) throws SQLException {
        this.db = db;
    }

    public static void main(String[] args) throws SQLException {
        List<Worker> workers = Arrays.asList(
                new Worker( 1,"Gregor", LocalDate.parse("2003-11-03"), "Trainee", 400),
                new Worker( 2,"Ivan", LocalDate.parse("2003-11-03"), "Senior", 5000),
                new Worker( 3,"Rostyslav", LocalDate.parse("2003-11-03"), "Middle", 3000),
                new Worker( 4,"Stepnan", LocalDate.parse("2003-11-03"), "Junior", 400));

        List<Client> clients = Arrays.asList(
                new Client(1, "Alex"),
                new Client(1, "Jonny"),
                new Client(1, "Nikola"),
                new Client(1, "Antonio"),
                new Client(1, "Anastas"));

        List<ProjectWorker> projectsWorkers = Arrays.asList(
                new ProjectWorker(1, 1),
                new ProjectWorker(1, 2),
                new ProjectWorker(1, 3),
                new ProjectWorker(1, 4),
                new ProjectWorker(1, 5),
                new ProjectWorker(1, 6),
                new ProjectWorker(1, 7),
                new ProjectWorker(1, 8),
                new ProjectWorker(1, 8),
                new ProjectWorker(2, 1),
                new ProjectWorker(2, 2),
                new ProjectWorker(2, 3),
                new ProjectWorker(2, 4),
                new ProjectWorker(2, 5));

        List<Project> projects = Arrays.asList(
                new Project(1, 1, LocalDate.parse("2022-10-05"), LocalDate.parse("2028-12-17")),
                new Project(2, 1, LocalDate.parse("2022-10-05"), LocalDate.parse("2028-12-17")),
                new Project(3, 2, LocalDate.parse("2022-10-05"), LocalDate.parse("2028-12-17")),
                new Project(4, 3, LocalDate.parse("2022-10-05"), LocalDate.parse("2028-12-17")),
                new Project(5, 3, LocalDate.parse("2022-10-05"), LocalDate.parse("2028-12-17")));

        DatabasePopulateService populateService = new DatabasePopulateService(Database.getInstance());

        populateService.insertIntoWorker(workers);
        populateService.insertIntoClients(clients);
        populateService.insertIntoProjects(projects);
        populateService.insertIntoProjectsWorkers(projectsWorkers);

    }
    public void insertIntoWorker(List<Worker> workers) {
        try (PreparedStatement insertIntoWorkerSt =
                     Database.getInstance().getConnection()
                             .prepareStatement("INSERT INTO worker (name, birthday, level, salary) VALUES (? , ? , ? , ? )")) {
            for (int i = 0; i < workers.size(); i++) {
                insertIntoWorkerSt.setString(1, workers.get(i).getName());
                insertIntoWorkerSt.setString(2, workers.get(i).getBirthday().toString());
                insertIntoWorkerSt.setString(3, workers.get(i).getGrade());
                insertIntoWorkerSt.setInt(4, workers.get(i).getSalary());
                insertIntoWorkerSt.addBatch();
            }
            insertIntoWorkerSt.executeBatch();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void insertIntoClients(List<Client> clients) {
        try (PreparedStatement insertIntoClientSt =
                     Database.getInstance().getConnection()
                             .prepareStatement("INSERT INTO client (name) VALUES (?)")) {
            for (int i = 0; i < clients.size(); i++) {
                insertIntoClientSt.setString(1, clients.get(i).getName());
                insertIntoClientSt.addBatch();
            }
            insertIntoClientSt.executeBatch();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void insertIntoProjects(List<Project> projects) {
        try (PreparedStatement insertIntoProjectSt =
                     Database.getInstance().getConnection()
                             .prepareStatement("INSERT INTO project (client_id, start_date, finish_date) VALUES ( ?, ?, ?)")) {
            for (int i = 0; i < projects.size(); i++) {
                insertIntoProjectSt.setInt(1, projects.get(i).getClient_Id());
                insertIntoProjectSt.setString(2, projects.get(i).getStart_Date().toString());
                insertIntoProjectSt.setString(3, projects.get(i).getFinish_Date().toString());
                insertIntoProjectSt.addBatch();
            }
            insertIntoProjectSt.executeBatch();
        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    private void insertIntoProjectsWorkers(List<ProjectWorker> projectsWorkers) throws SQLException {
        try (PreparedStatement insertIntoProjectWorkerSt =
                     Database.getInstance().getConnection()
                             .prepareStatement("INSERT INTO project_worker (project_id, worker_id) VALUES ( ? , ? )")) {
            for (int i = 0; i < projectsWorkers.size(); i++) {
                insertIntoProjectWorkerSt.setInt(1, projectsWorkers.get(i).getProject_Id());
                insertIntoProjectWorkerSt.setInt(2, projectsWorkers.get(i).getWorker_Id());
                insertIntoProjectWorkerSt.addBatch();
            }
            insertIntoProjectWorkerSt.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
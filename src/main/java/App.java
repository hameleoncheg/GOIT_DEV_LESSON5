import dataDto.*;
import databaseServices.DatabaseQueryService;

import java.sql.*;
import java.util.List;

public class App {
    public static void main(String[] args) throws SQLException {
      List<MaxProjectCountClient> maxProjectCountClients = new DatabaseQueryService().findMaxProjectsClient();
      List<MaxSalaryWorker> maxSalaryWorker = new DatabaseQueryService().findMaxSalaryWorker();
      List<YoungestEldestWorkers> YoungestEldestWorkers = new DatabaseQueryService().findYoungestEldestWorkers();
      List<ProjectPrices> ProjectPrices = new DatabaseQueryService().printProjectPrices();
      List<LongestProject> LongestProject = new DatabaseQueryService().findLongestProject();

      System.out.println("maxProjectCountClients.toString() = " + maxProjectCountClients.toString());
      System.out.println("maxSalaryWorker.toString() = " + maxSalaryWorker.toString());
      System.out.println("dataDto.YoungestEldestWorkers.toString() = " + YoungestEldestWorkers.toString());
      System.out.println("dataDto.ProjectPrices.toString() = " + ProjectPrices.toString());
      System.out.println("dataDto.LongestProject.toString() = " + LongestProject.toString());
    }

}



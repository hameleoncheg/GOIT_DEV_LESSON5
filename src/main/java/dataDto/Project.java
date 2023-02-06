package dataDto;

import java.time.LocalDate;

public class Project {
    private int id;
    private int client_Id;
    private LocalDate start_Date;
    private LocalDate finish_Date;

    public Project(int id, int client_Id, LocalDate start_Date, LocalDate finish_Date) {
        this.id = id;
        this.client_Id = client_Id;
        this.start_Date = start_Date;
        this.finish_Date = finish_Date;
    }

    public int getId() {
        return id;
    }

    public int getClient_Id() {
        return client_Id;
    }

    public LocalDate getStart_Date() {
        return start_Date;
    }

    public LocalDate getFinish_Date() {
        return finish_Date;
    }
}
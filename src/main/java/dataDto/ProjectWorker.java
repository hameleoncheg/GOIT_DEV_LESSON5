package dataDto;

public class ProjectWorker {
    private int project_Id;
    private int worker_Id;

    public ProjectWorker(int project_Id, int worker_Id) {
        this.project_Id = project_Id;
        this.worker_Id = worker_Id;
    }

    public int getProject_Id() {
        return project_Id;
    }

    public int getWorker_Id() {
        return worker_Id;
    }
}
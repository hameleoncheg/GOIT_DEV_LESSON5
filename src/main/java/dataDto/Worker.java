package dataDto;

import java.time.LocalDate;

public class Worker {
    private int id;
    private String name;
    private LocalDate birthday;
    private String level;
    private int salary;

    public Worker(int id, String name, LocalDate birthday, String grade, int salary) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.level = grade;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getGrade() {
        return level;
    }

    public int getSalary() {
        return salary;
    }
}
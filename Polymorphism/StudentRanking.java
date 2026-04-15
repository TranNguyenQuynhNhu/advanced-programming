package Polymorphism;

import java.util.*;

abstract class Student {
    protected int id;
    protected String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public abstract double score();

    @Override
    public String toString() {
        return id + " - " + name + " - Score: " + score();
    }
}

class ExamStudent extends Student {
    private double midterm;
    private double finall;

    public ExamStudent(int id, String name, double midterm, double finall) {
        super(id, name);
        this.midterm = midterm;
        this.finall = finall;
    }

    public double getMidterm() {
        return midterm;
    }

    public double getFinal() {
        return finall;
    }

    @Override
    public double score() {
        return midterm + finall;
    }
}

class ProjectStudent extends Student {
    private double report;
    private double demo;
    private double peer;

    public ProjectStudent(int id, String name, double report, double demo, double peer) {
        super(id, name);
        this.report = report;
        this.demo = demo;
        this.peer = peer;
    }

    @Override
    public double score() {
        return report + demo + peer;
    }
}

public class StudentRanking {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new ExamStudent(103, "An", 8, 9));
        list.add(new ProjectStudent(101, "Binh", 7, 8, 9));
        list.add(new ExamStudent(102, "Cuong", 10, 6));
        list.add(new ProjectStudent(104, "Dung", 9, 9, 9));
        list.add(new ExamStudent(100, "Ha", 8.5, 8.5));
        int k = 3;
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student a, Student b) {
                int cmp = Double.compare(b.score(), a.score());
                if (cmp == 0) {
                    return Integer.compare(a.getId(), b.getId());
                }
                return cmp;
            }
        });
        for (int i = 0; i < Math.min(k, list.size()); i++) {
            System.out.println(list.get(i));
        }
    }
}
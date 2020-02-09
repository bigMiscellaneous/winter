package com.wzk.datastructure.array;

public class Student {

    private String name;
    private int score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Student(){

    }

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    public static void main(String[] args){
        Array<Student> list = new Array<>(10);
        Student one = new Student("one",100);
        Student two = new Student("two",99);
        Student three = new Student("three",66);
        list.addLast(one);
        list.addLast(two);
        list.addLast(three);
        System.out.println(list);
    }
}

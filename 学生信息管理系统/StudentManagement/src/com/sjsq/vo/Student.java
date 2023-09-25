package com.sjsq.vo;



public class Student {

    // 学号
    private Integer id;
    // 姓名
    private String name;
    // 年龄
    private Integer age;
    // 性别
    private String sex;
    // 民族
    private String nation;
    // 省份
    private String place;
    // 专业
    private String major;
    // 班级
    private String classes;

    private String grade;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getgrade() {
        return grade;
    }

    public void setgrade(String grade) {
        this.grade = grade;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", nation='" + nation + '\'' +
                ", place='" + place + '\'' +
                ", major='" + major + '\'' +
                ", classes='" + classes + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}

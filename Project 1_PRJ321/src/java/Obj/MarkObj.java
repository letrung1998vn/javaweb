/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Obj;

import java.util.Comparator;

/**
 *
 * @author letru
 */
public class MarkObj implements Comparable<MarkObj> {

    int id;
    String classID;
    String studentID;
    String subjectID;
    int block;
    String semester;
    float year;
    float subjectAvg;
    String status;

    public MarkObj(String subjectID, int block, String semester, float year, float subjectAvg, String status) {
        this.subjectID = subjectID;
        this.block = block;
        this.semester = semester;
        this.year = year;
        this.subjectAvg = subjectAvg;
        this.status = status;
    }

    public MarkObj(int block, String semester, float year, String status) {
        this.block = block;
        this.semester = semester;
        this.year = year;
        this.status = status;
    }

    public MarkObj(String subjectID, float subjectAvg, String status) {
        this.subjectID = subjectID;
        this.subjectAvg = subjectAvg;
        this.status = status;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(String subjectID) {
        this.subjectID = subjectID;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public float getYear() {
        return year;
    }

    public void setYear(float year) {
        this.year = year;
    }

    public float getSubjectAvg() {
        return subjectAvg;
    }

    public void setSubjectAvg(float subjectAvg) {
        this.subjectAvg = subjectAvg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public MarkObj() {
    }

    @Override
    public int compareTo(MarkObj o) {
        if (this.year > o.year) {
            return -1;
        } else if (this.year == o.year) {
            if (this.semester.equals("Spring") && o.semester.equals("Summer")) {
                return 1;
            } else if (this.semester.equals("Spring") && o.semester.equals("Fall")) {
                return 1;
            } else if (this.semester.equals("Spring") && o.semester.equals("Winter")) {
                return 1;
            } else if (this.semester.equals("Summer") && o.semester.equals("Spring")) {
                return -1;
            } else if (this.semester.equals("Summer") && o.semester.equals("Fall")) {
                return 1;
            } else if (this.semester.equals("Summer") && o.semester.equals("Winter")) {
                return 1;
            } else if (this.semester.equals("Fall") && o.semester.equals("Spring")) {
                return -1;
            } else if (this.semester.equals("Fall") && o.semester.equals("Summer")) {
                return -1;
            } else if (this.semester.equals("Fall") && o.semester.equals("Winter")) {
                return 1;
            } else if (this.semester.equals("Winter") && o.semester.equals("Spring")) {
                return -1;
            } else if (this.semester.equals("Winter") && o.semester.equals("Summer")) {
                return -1;
            } else if (this.semester.equals("Winter") && o.semester.equals("Fall")) {
                return -1;
            } else if (this.semester.equals(o.semester)) {
                if (this.block > o.block) {
                    return -1;
                } else if (this.block == o.block) {
                    return 0;
                } else if (this.block < o.block) {
                    return 1;
                }
            }
        }
        return 1;
    }

}

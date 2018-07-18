/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author letru
 */
public class SubjectDTO {
    String subjectID;
    String subjectName;
    int NoOfSlot;
    String prerequisite;
    int credits;

    public String getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(String subjectID) {
        this.subjectID = subjectID;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getNoOfSlot() {
        return NoOfSlot;
    }

    public void setNoOfSlot(int NoOfSlot) {
        this.NoOfSlot = NoOfSlot;
    }

    public String getPrerequisite() {
        return prerequisite;
    }

    public void setPrerequisite(String prerequisite) {
        this.prerequisite = prerequisite;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public SubjectDTO(String subjectID, String subjectName, int NoOfSlot, String prerequisite, int credits) {
        this.subjectID = subjectID;
        this.subjectName = subjectName;
        this.NoOfSlot = NoOfSlot;
        this.prerequisite = prerequisite;
        this.credits = credits;
    }

    public SubjectDTO() {
    }
    
}

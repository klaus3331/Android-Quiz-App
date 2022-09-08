package edu.gatech.seclass.sdpvocabquiz.edu.gatech.seclass.sdpvocabquiz.designclasses;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.io.Serializable;

import static edu.gatech.seclass.sdpvocabquiz.Database.DaoUtility.getStudentByUsername;

@Entity(indices = {@Index(value = "ownerName")},
        foreignKeys = @ForeignKey(entity = Student.class,
                                  parentColumns = "username",
                                  childColumns = "ownerName"))
public class Quiz implements Serializable {

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() { return description; }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getOwnerName() {
        return ownerName;
    }
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public SolutionSpace getSolutionSpace() {
        return solutionSpace;
    }
    public void setSolutionSpace(SolutionSpace solutionSpace) { this.solutionSpace = solutionSpace; }

    public Student getCreatedBy() {
        return createdBy;
    }
    public void setCreatedBy(Student createdBy) {
        this.createdBy = createdBy;
    }


    @NonNull
    @PrimaryKey
    private String name;
    private String description;
    private String ownerName; // foreign key to Student
    @Embedded
    private SolutionSpace solutionSpace;
    @Ignore
    private Student createdBy;

    // constructor used by DB (when the quiz is fetched from DB)
    public Quiz(String name, String description, String ownerName, SolutionSpace solutionSpace) {
        this.name = name;
        this.description = description;
        this.ownerName = ownerName;
        this.solutionSpace = solutionSpace;
        this.createdBy = getStudentByUsername(this.ownerName);
    }

    // Constructor used when this quiz is created on the first time
    @Ignore
    public Quiz(String name, String description, SolutionSpace solutionSpace, Student createdBy) {
        this.name = name;
        this.description = description;
        this.solutionSpace = solutionSpace;
        this.createdBy = createdBy;
        this.ownerName = this.createdBy.getUsername();
    }

    public int getNumQuestions() {
        return this.solutionSpace.getNumQuestions();
    }

}

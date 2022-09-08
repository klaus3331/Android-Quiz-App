package edu.gatech.seclass.sdpvocabquiz.edu.gatech.seclass.sdpvocabquiz.designclasses;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;
import java.io.Serializable;
import edu.gatech.seclass.sdpvocabquiz.Database.SeniorityLevelConverter;

@Entity(indices = {@Index(value = "emailAddress", unique = true)})
public class Student implements Serializable{
    public void setUsername(String username) { this.username = username; }
    public String getUsername() {
        return username;
    }

    public void setMajor(String major) { this.major = major; }
    public String getMajor() {
        return major;
    }

    public void setSeniorityLevel(SeniorityLevel seniorityLevel) { this.seniorityLevel = seniorityLevel; }
    public SeniorityLevel getSeniorityLevel() {
        return seniorityLevel;
    }

    public void setEmailAddress(String emailAddress) { this.emailAddress = emailAddress; }
    public String getEmailAddress() {
        return emailAddress;
    }

    @NonNull
    @PrimaryKey
    private String username;

    private String major;
    @TypeConverters(SeniorityLevelConverter.class)
    private SeniorityLevel seniorityLevel;
    private String emailAddress;

    public Student(String username, String major, SeniorityLevel seniorityLevel, String emailAddress) {
        this.username = username;
        this.major = major;
        this.seniorityLevel = seniorityLevel;
        this.emailAddress = emailAddress;
    }
}

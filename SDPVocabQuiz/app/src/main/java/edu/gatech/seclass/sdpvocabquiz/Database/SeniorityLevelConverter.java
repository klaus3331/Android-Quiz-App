package edu.gatech.seclass.sdpvocabquiz.Database;

import android.arch.persistence.room.TypeConverter;

import edu.gatech.seclass.sdpvocabquiz.edu.gatech.seclass.sdpvocabquiz.designclasses.SeniorityLevel;

public class SeniorityLevelConverter {
    @TypeConverter
    public static SeniorityLevel toSeniority(String seniority){
        switch (seniority){
            case "Freshman": return SeniorityLevel.Freshman;
            case "Sophomore": return SeniorityLevel.Sophomore;
            case "Junior": return SeniorityLevel.Junior;
            case "Senior": return SeniorityLevel.Senior;
            case "Grad": return SeniorityLevel.Grad;
        }
        throw new IllegalArgumentException("Could not recognize status");
    }

    @TypeConverter
    public static String toString(SeniorityLevel seniorityLevel){
        switch (seniorityLevel){
            case Freshman: return "Freshman";
            case Sophomore: return "Sophomore";
            case Junior: return "Junior";
            case Senior: return "Senior";
            case Grad: return "Grad";
        }
        throw new IllegalArgumentException("Could not recognize status");
    }
}

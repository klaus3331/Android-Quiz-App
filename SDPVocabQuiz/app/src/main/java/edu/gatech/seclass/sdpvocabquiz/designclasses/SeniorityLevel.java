package edu.gatech.seclass.sdpvocabquiz.edu.gatech.seclass.sdpvocabquiz.designclasses;

public enum SeniorityLevel {
    Freshman("Freshman"),
    Sophomore("Sophomore"),
    Junior("Junior"),
    Senior("Senior"),
    Grad("Grad");

    private String friendlyName;

    private SeniorityLevel(String friendlyName){
        this.friendlyName = friendlyName;
    }

    @Override
    public String toString(){
        return friendlyName;
    }
}

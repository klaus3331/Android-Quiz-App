package edu.gatech.seclass.sdpvocabquiz.edu.gatech.seclass.sdpvocabquiz.designclasses;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PracticeQuestion implements Serializable {
    private String word;
    private String correctDefinition;
    private List<String> incorrectDefinitions;

    public PracticeQuestion(String word, String correctDefinition, List<String> incorrectDefinitions) {
        if (incorrectDefinitions.size() != 3) {
            throw new IllegalArgumentException("Must provide exactly 3 incorrect definitions per question.");
        }
        this.word = word;
        this.correctDefinition = correctDefinition;
        this.incorrectDefinitions = incorrectDefinitions;
    }

    public boolean checkAnswer(String answer) {
        return correctDefinition.equals(answer);
    }

    public String getWord() {
        return word;
    }

    public String getCorrectDefinition() {
        return correctDefinition;
    }

    public List<String> getChoices() {
        List<String> choices = new ArrayList<>(incorrectDefinitions);
        choices.add(correctDefinition);
        Collections.shuffle(choices);
        return choices;
    }
}

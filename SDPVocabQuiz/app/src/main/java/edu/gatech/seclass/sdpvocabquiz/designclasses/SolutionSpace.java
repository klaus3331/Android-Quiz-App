package edu.gatech.seclass.sdpvocabquiz.edu.gatech.seclass.sdpvocabquiz.designclasses;

import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.TypeConverters;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import edu.gatech.seclass.sdpvocabquiz.Database.StringListConverter;

@TypeConverters(StringListConverter.class)
public class SolutionSpace {

    public SolutionSpace(List<String> words, List<String> correctDefinitions, List<String> incorrectDefinitions) {
        this.words = words;
        this.correctDefinitions = correctDefinitions;
        this.incorrectDefinitions = incorrectDefinitions;
    }
    @Ignore
    public SolutionSpace() {
        this.words = new ArrayList<>();
        this.correctDefinitions = new ArrayList<>();
        this.incorrectDefinitions = new ArrayList<>();
    }

    public List<String> getWords() {
        return words;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }

    public List<String> getCorrectDefinitions() {
        return correctDefinitions;
    }

    public void setCorrectDefinitions(List<String> correctDefinitions) {
        this.correctDefinitions = correctDefinitions;
    }

    public List<String> getIncorrectDefinitions() {
        return incorrectDefinitions;
    }

    public void setIncorrectDefinitions(List<String> incorrectDefinitions) {
        this.incorrectDefinitions = incorrectDefinitions;
    }

    private List<String> words;
    private List<String> correctDefinitions;
    private List<String> incorrectDefinitions;

    public void shuffle() {
        long seed = System.nanoTime();
        Collections.shuffle(words, new Random(seed));
        Collections.shuffle(correctDefinitions, new Random(seed));
        Collections.shuffle(incorrectDefinitions);
    }

    public void addWord(String word, String correctDefinition, List<String> incorrectDefinitions) {
        if (incorrectDefinitions.size() != 3) {
            throw new IllegalArgumentException("Must provide exactly 3 incorrect definitions per word.");
        }
        this.words.add(word);
        this.correctDefinitions.add(correctDefinition);
        this.incorrectDefinitions.addAll(incorrectDefinitions);
    }

    public String getWordAtIndex(int index) {
        return words.get(index);
    }

    public String getCorrectDefinitionAtIndex(int index) {
        return correctDefinitions.get(index);
    }

    public List<String> getIncorrectDefinitionsRandomly(int dontIncludeIndex) {
        List<String> defs = new ArrayList<>();
        defs.addAll(incorrectDefinitions);
        List<String> correctDefs = new ArrayList<>();
        correctDefs.addAll(correctDefinitions);
        correctDefs.remove(correctDefinitions.get(dontIncludeIndex));
        defs.addAll(correctDefs);
        Collections.shuffle(defs);
        correctDefs.clear();
        correctDefs.add(defs.get(0));
        correctDefs.add(defs.get(1));
        correctDefs.add(defs.get(2));
        return correctDefs;
    }

    public int getNumQuestions() {
        return this.words.size();
    }
}

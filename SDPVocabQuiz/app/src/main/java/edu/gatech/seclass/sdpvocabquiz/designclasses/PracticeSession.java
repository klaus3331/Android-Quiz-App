package edu.gatech.seclass.sdpvocabquiz.edu.gatech.seclass.sdpvocabquiz.designclasses;

import java.util.List;

public class PracticeSession {
    private Student student;
    private Quiz quiz;
    private int currentCorrect;

    private int currentQuestionNumber;

    public PracticeSession(Student student, Quiz quiz) {
        this.student = student;
        this.quiz = quiz;
        this.quiz.getSolutionSpace().shuffle();
        this.currentCorrect = 0;
        this.currentQuestionNumber = 0;
    }

    public void incrementScore() {
        currentCorrect++;
    }

    public String getQuizName() {
        return quiz.getName();
    }

    public int getQuestionsRemaining() {
        return quiz.getNumQuestions() - currentQuestionNumber;
    }

    public PracticeQuestion getNextQuestion() {
        SolutionSpace space = this.quiz.getSolutionSpace();
        String word = space.getWordAtIndex(currentQuestionNumber);
        String correctDefinition = space.getCorrectDefinitionAtIndex(currentQuestionNumber);
        List<String> incorrectDefinitions = space.getIncorrectDefinitionsRandomly(currentQuestionNumber);
        currentQuestionNumber++;
        return new PracticeQuestion(word, correctDefinition, incorrectDefinitions);
    }

    public Statistic getScore() {
        return new Statistic((double)currentCorrect/this.quiz.getNumQuestions(), this.student, this.quiz);
    }
}

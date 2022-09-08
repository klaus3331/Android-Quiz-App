package edu.gatech.seclass.sdpvocabquiz;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import edu.gatech.seclass.sdpvocabquiz.edu.gatech.seclass.sdpvocabquiz.designclasses.PracticeQuestion;
import edu.gatech.seclass.sdpvocabquiz.edu.gatech.seclass.sdpvocabquiz.designclasses.PracticeSession;
import edu.gatech.seclass.sdpvocabquiz.edu.gatech.seclass.sdpvocabquiz.designclasses.Quiz;
import edu.gatech.seclass.sdpvocabquiz.edu.gatech.seclass.sdpvocabquiz.designclasses.SeniorityLevel;
import edu.gatech.seclass.sdpvocabquiz.edu.gatech.seclass.sdpvocabquiz.designclasses.SolutionSpace;
import edu.gatech.seclass.sdpvocabquiz.edu.gatech.seclass.sdpvocabquiz.designclasses.Student;

import static edu.gatech.seclass.sdpvocabquiz.edu.gatech.seclass.sdpvocabquiz.designclasses.SeniorityLevel.Freshman;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(MockitoJUnitRunner.class)


public class SolutionSpaceUnitTest {

    private PracticeSession practiceSession;
    private PracticeQuestion practiceQuestion;
    private Quiz quiz;
    private SolutionSpace solutionSpace;

    @Before
    public void setup(){

        List<String> quizWords = new ArrayList<String>();
        quizWords.add("word1");
        quizWords.add("word2");

        List<String> quizIncorrectDefinition = new ArrayList<String>();
        quizIncorrectDefinition.add("quizIncorrect1");
        quizIncorrectDefinition.add("quizIncorrect2");
        quizIncorrectDefinition.add("quizIncorrect3");
        quizIncorrectDefinition.add("quizIncorrect4");
        quizIncorrectDefinition.add("quizIncorrect5");
        quizIncorrectDefinition.add("quizIncorrect6");

        List<String> quizCorrectDefinition = new ArrayList<String>();
        quizCorrectDefinition.add("quizCorrect1");
        quizCorrectDefinition.add("quizCorrect2");

        SolutionSpace solutionSpace = new SolutionSpace(quizWords, quizCorrectDefinition, quizIncorrectDefinition);

    }


    @Test
    public void getWordsForQuiz() {
        List<String> quizWords = new ArrayList<String>();
        quizWords.add("word1");
        quizWords.add("word2");

        List<String> quizIncorrectDefinition = new ArrayList<String>();
        quizIncorrectDefinition.add("quizIncorrect1");
        quizIncorrectDefinition.add("quizIncorrect2");
        quizIncorrectDefinition.add("quizIncorrect3");
        quizIncorrectDefinition.add("quizIncorrect4");
        quizIncorrectDefinition.add("quizIncorrect5");
        quizIncorrectDefinition.add("quizIncorrect6");

        List<String> quizCorrectDefinition = new ArrayList<String>();
        quizCorrectDefinition.add("quizCorrect1");
        quizCorrectDefinition.add("quizCorrect2");

        SolutionSpace solutionSpace = new SolutionSpace(quizWords, quizCorrectDefinition, quizIncorrectDefinition);
        solutionSpace.getWords();

//        practiceQuestion.checkAnswer("correct");
    }

    @Test
    public void setWords(){
        List<String> quizWords = new ArrayList<String>();
        quizWords.add("word1");


        List<String> quizIncorrectDefinition = new ArrayList<String>();
        quizIncorrectDefinition.add("quizIncorrect1");


        List<String> quizCorrectDefinition = new ArrayList<String>();
        quizCorrectDefinition.add("quizCorrect1");

        String questionWord = "word1";
        String questionCorrectDefinition = "correctDefinition";

        List<String> questionIncorrectDefinitions = new ArrayList<String>();
        questionIncorrectDefinitions.add("incorrect1");
        questionIncorrectDefinitions.add("incorrect2");
        questionIncorrectDefinitions.add("incorrect3");

        SolutionSpace solutionSpace = new SolutionSpace(quizWords, quizCorrectDefinition, quizIncorrectDefinition);
        solutionSpace.addWord(questionWord, questionCorrectDefinition, questionIncorrectDefinitions);
//        System.out.println("TESTER");
    }

    @Test(expected = IllegalArgumentException.class)
    public void addWordsIncorrectAmount(){
        List<String> quizWords = new ArrayList<String>();
        quizWords.add("word1");


        List<String> quizIncorrectDefinition = new ArrayList<String>();
        quizIncorrectDefinition.add("quizIncorrect1");


        List<String> quizCorrectDefinition = new ArrayList<String>();
        quizCorrectDefinition.add("quizCorrect1");

        String questionWord = "word1";
        String questionCorrectDefinition = "correctDefinition";

        List<String> questionIncorrectDefinitions = new ArrayList<String>();
        questionIncorrectDefinitions.add("incorrect1");
        questionIncorrectDefinitions.add("incorrect2");

        SolutionSpace solutionSpace = new SolutionSpace(quizWords, quizCorrectDefinition, quizIncorrectDefinition);
        solutionSpace.addWord(questionWord, questionCorrectDefinition, questionIncorrectDefinitions);
    }

}
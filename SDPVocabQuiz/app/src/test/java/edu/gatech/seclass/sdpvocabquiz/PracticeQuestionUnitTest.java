package edu.gatech.seclass.sdpvocabquiz;



import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import edu.gatech.seclass.sdpvocabquiz.edu.gatech.seclass.sdpvocabquiz.designclasses.PracticeQuestion;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(MockitoJUnitRunner.class)


public class PracticeQuestionUnitTest {

    @Before
    public void setup(){
    }

    @Test
    public void practiceCorrectAnswer() {
        String word = "test";
        String correctDefinition = "correct";
        List<String> incorrectDefinitions = new ArrayList<String>();
        incorrectDefinitions.add("wrong");
        incorrectDefinitions.add("wrong");
        incorrectDefinitions.add("wrong");
        PracticeQuestion practiceQuestion = new PracticeQuestion("test","test", incorrectDefinitions);
        practiceQuestion.checkAnswer("correct");
    }

    @Test
    public void retrieveQuizWord() {
        String word = "test";
        String correctDefinition = "correct";
        List<String> incorrectDefinitions = new ArrayList<String>();
        incorrectDefinitions.add("wrong");
        incorrectDefinitions.add("wrong");
        incorrectDefinitions.add("wrong");
        PracticeQuestion practiceQuestion = new PracticeQuestion("test","test", incorrectDefinitions);
        practiceQuestion.getWord();
    }

    @Test
    public void retrieveCorrectDefinition() {
        String word = "test";
        String correctDefinition = "correct";
        List<String> incorrectDefinitions = new ArrayList<String>();
        incorrectDefinitions.add("wrong");
        incorrectDefinitions.add("wrong");
        incorrectDefinitions.add("wrong");
        PracticeQuestion practiceQuestion = new PracticeQuestion("test","test", incorrectDefinitions);
        practiceQuestion.getCorrectDefinition();
    }

    @Test
    public void retrieveChoices() {
        String word = "test";
        String correctDefinition = "correct";
        List<String> incorrectDefinitions = new ArrayList<String>();
        incorrectDefinitions.add("wrong");
        incorrectDefinitions.add("wrong");
        incorrectDefinitions.add("wrong");
        PracticeQuestion practiceQuestion = new PracticeQuestion("test","test", incorrectDefinitions);
        practiceQuestion.getChoices();
    }
}
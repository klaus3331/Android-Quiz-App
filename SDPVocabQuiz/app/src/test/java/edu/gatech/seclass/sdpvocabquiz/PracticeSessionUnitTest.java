package edu.gatech.seclass.sdpvocabquiz;


import org.junit.Test;

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
//@RunWith(MockitoJUnitRunner.class)


public class PracticeSessionUnitTest {

    PracticeSession practiceSession;
    PracticeQuestion practiceQuestion;
    Quiz quiz;
    SolutionSpace solutionSpace;

//    @Before
//    public void setup(){
//        String questionWord = "test";
//        String correctDefinition = "correct";
//        List<String> incorrectDefinitions = new ArrayList<String>();
//        incorrectDefinitions.add("wrong");
//        incorrectDefinitions.add("wrong");
//        incorrectDefinitions.add("wrong");
//        PracticeQuestion practiceQuestion = new PracticeQuestion(questionWord,correctDefinition, incorrectDefinitions);
//
//        String username = "usernametest";
//        String major = "major test";
//        SeniorityLevel seniorityLevel = Freshman;
//        String emailAddress = "userNameTest@edu.com";
//        Student student = new Student( username,  major,  seniorityLevel,  emailAddress);
//
//        List<String> quizWords = new ArrayList<String>();
//        quizWords.add("word1");
//        quizWords.add("word2");
//
//        List<String> quizIncorrectDefinition = new ArrayList<String>();
//        quizIncorrectDefinition.add("quizIncorrect1");
//        quizIncorrectDefinition.add("quizIncorrect2");
//        quizIncorrectDefinition.add("quizIncorrect3");
//        quizIncorrectDefinition.add("quizIncorrect4");
//        quizIncorrectDefinition.add("quizIncorrect5");
//        quizIncorrectDefinition.add("quizIncorrect6");
//
//        List<String> quizCorrectDefinition = new ArrayList<String>();
//        quizCorrectDefinition.add("quizCorrect1");
//        quizCorrectDefinition.add("quizCorrect2");
//
//        SolutionSpace solutionSpace = new SolutionSpace(quizWords, quizCorrectDefinition, quizIncorrectDefinition);
//
//        String description = "description test";
//        String ownerName = "usernametest";
//        String quizName = "Quiz Test";
//
//        Quiz quiz = new Quiz(quizName, description, ownerName, solutionSpace);
//    }

    @Test
    public void incrementingScore() {

        String questionWord = "test";
        String correctDefinition = "correct";
        List<String> incorrectDefinitions = new ArrayList<String>();
        incorrectDefinitions.add("wrong");
        incorrectDefinitions.add("wrong");
        incorrectDefinitions.add("wrong");
        PracticeQuestion practiceQuestion = new PracticeQuestion(questionWord,correctDefinition, incorrectDefinitions);

        String username = "usernametest";
        String major = "major test";
        SeniorityLevel seniorityLevel = Freshman;
        String emailAddress = "userNameTest@edu.com";
        Student student = new Student( username,  major,  seniorityLevel,  emailAddress);

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

        String description = "description test";
        String ownerName = "usernametest";
        String quizName = "Quiz Test";

        Quiz quiz = new Quiz(quizName, description, ownerName, solutionSpace);

        PracticeSession practiceSession = new PracticeSession(student, quiz);
        practiceSession.incrementScore();

//        practiceQuestion.checkAnswer("correct");
    }


}
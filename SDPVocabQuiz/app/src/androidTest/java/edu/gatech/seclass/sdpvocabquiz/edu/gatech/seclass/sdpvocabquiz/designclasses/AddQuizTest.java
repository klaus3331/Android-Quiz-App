package edu.gatech.seclass.sdpvocabquiz.edu.gatech.seclass.sdpvocabquiz.designclasses;


import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import edu.gatech.seclass.sdpvocabquiz.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.pressImeActionButton;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class AddQuizTest {

    @Rule
    public ActivityTestRule<QuizApplication> mActivityTestRule = new ActivityTestRule<>(QuizApplication.class);

    @Test
    public void addQuizTest() {
        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.reg_new_student), withText("Register New Student"),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout2),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                3),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction editText = onView(
                allOf(withId(R.id.username),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                2),
                        isDisplayed()));
        editText.perform(click());

        ViewInteraction editText2 = onView(
                allOf(withId(R.id.username),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                2),
                        isDisplayed()));
        editText2.perform(replaceText("test"), closeSoftKeyboard());

        ViewInteraction editText3 = onView(
                allOf(withId(R.id.major),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                9),
                        isDisplayed()));
        editText3.perform(replaceText("test"), closeSoftKeyboard());

        ViewInteraction editText4 = onView(
                allOf(withId(R.id.email),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                5),
                        isDisplayed()));
        editText4.perform(replaceText("test@tes.edu"), closeSoftKeyboard());

        ViewInteraction editText5 = onView(
                allOf(withId(R.id.email), withText("test@tes.edu"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                5),
                        isDisplayed()));
        editText5.perform(pressImeActionButton());

        ViewInteraction button = onView(
                allOf(withId(R.id.ok_register), withText("OK"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                7),
                        isDisplayed()));
        button.perform(click());

        ViewInteraction button2 = onView(
                allOf(withId(R.id.add_button), withText("Add Quiz"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                1),
                        isDisplayed()));
        button2.perform(click());

        ViewInteraction editText6 = onView(
                allOf(withId(R.id.quiz_name),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout3),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                2),
                        isDisplayed()));
        editText6.perform(click());

        ViewInteraction editText7 = onView(
                allOf(withId(R.id.quiz_name),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout3),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                2),
                        isDisplayed()));
        editText7.perform(replaceText("test"), closeSoftKeyboard());

        ViewInteraction editText8 = onView(
                allOf(withId(R.id.description),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout3),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                4),
                        isDisplayed()));
        editText8.perform(replaceText("test"), closeSoftKeyboard());

        ViewInteraction editText9 = onView(
                allOf(withId(R.id.editText3),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout3),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                6),
                        isDisplayed()));
        editText9.perform(replaceText("3"), closeSoftKeyboard());

        ViewInteraction editText10 = onView(
                allOf(withId(R.id.editText3), withText("3"),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout3),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                6),
                        isDisplayed()));
        editText10.perform(pressImeActionButton());

        ViewInteraction button3 = onView(
                allOf(withId(R.id.ok_add_btn), withText("OK"),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout3),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                8),
                        isDisplayed()));
        button3.perform(click());

        ViewInteraction editText11 = onView(
                allOf(withId(R.id.quiz_word),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        editText11.perform(click());

        ViewInteraction editText12 = onView(
                allOf(withId(R.id.quiz_word),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        editText12.perform(replaceText("word1"), closeSoftKeyboard());

        ViewInteraction editText13 = onView(
                allOf(withId(R.id.correct_def),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                4),
                        isDisplayed()));
        editText13.perform(replaceText("c1"), closeSoftKeyboard());

        ViewInteraction editText14 = onView(
                allOf(withId(R.id.incorrect_def1),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                6),
                        isDisplayed()));
        editText14.perform(replaceText("i1"), closeSoftKeyboard());

        ViewInteraction editText15 = onView(
                allOf(withId(R.id.incorrect_def2),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                7),
                        isDisplayed()));
        editText15.perform(replaceText("i1"), closeSoftKeyboard());

        ViewInteraction editText16 = onView(
                allOf(withId(R.id.incorrect_def3),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                8),
                        isDisplayed()));
        editText16.perform(replaceText("i1"), closeSoftKeyboard());

        ViewInteraction button4 = onView(
                allOf(withId(R.id.ok_add_form_btn), withText("Next"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                10),
                        isDisplayed()));
        button4.perform(click());

        ViewInteraction editText17 = onView(
                allOf(withId(R.id.quiz_word),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        editText17.perform(replaceText("word2"), closeSoftKeyboard());

        ViewInteraction editText18 = onView(
                allOf(withId(R.id.correct_def),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                4),
                        isDisplayed()));
        editText18.perform(replaceText("c2"), closeSoftKeyboard());

        ViewInteraction editText19 = onView(
                allOf(withId(R.id.incorrect_def1),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                6),
                        isDisplayed()));
        editText19.perform(replaceText("i2"), closeSoftKeyboard());

        ViewInteraction editText20 = onView(
                allOf(withId(R.id.incorrect_def2),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                7),
                        isDisplayed()));
        editText20.perform(replaceText("i2"), closeSoftKeyboard());

        ViewInteraction editText21 = onView(
                allOf(withId(R.id.incorrect_def3),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                8),
                        isDisplayed()));
        editText21.perform(replaceText("i2"), closeSoftKeyboard());

        ViewInteraction button5 = onView(
                allOf(withId(R.id.ok_add_form_btn), withText("Next"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                10),
                        isDisplayed()));
        button5.perform(click());

        ViewInteraction editText22 = onView(
                allOf(withId(R.id.quiz_word),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        editText22.perform(click());

        ViewInteraction editText23 = onView(
                allOf(withId(R.id.quiz_word),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        editText23.perform(replaceText("word3"), closeSoftKeyboard());

        ViewInteraction editText24 = onView(
                allOf(withId(R.id.correct_def),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                4),
                        isDisplayed()));
        editText24.perform(replaceText("c3"), closeSoftKeyboard());

        ViewInteraction editText25 = onView(
                allOf(withId(R.id.incorrect_def1),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                6),
                        isDisplayed()));
        editText25.perform(replaceText("i3"), closeSoftKeyboard());

        ViewInteraction editText26 = onView(
                allOf(withId(R.id.incorrect_def2),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                7),
                        isDisplayed()));
        editText26.perform(replaceText("i3"), closeSoftKeyboard());

        ViewInteraction editText27 = onView(
                allOf(withId(R.id.incorrect_def3),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                8),
                        isDisplayed()));
        editText27.perform(replaceText("i3"), closeSoftKeyboard());

        ViewInteraction button6 = onView(
                allOf(withId(R.id.ok_add_form_btn), withText("Next"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                10),
                        isDisplayed()));
        button6.perform(click());

        ViewInteraction button7 = onView(
                allOf(withId(R.id.select_remove), withText("Remove Quiz"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                2),
                        isDisplayed()));
        button7.perform(click());

        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.list_quizzes),
                        childAtPosition(
                                withId(R.id.linearLayout),
                                3)));
        recyclerView.perform(actionOnItemAtPosition(0, click()));

    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}

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
public class PracticeQuizTest {

    @Rule
    public ActivityTestRule<QuizApplication> mActivityTestRule = new ActivityTestRule<>(QuizApplication.class);

    @Test
    public void practiceQuizTest() {
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
                allOf(withId(android.R.id.button1), withText("OK"),
                        childAtPosition(
                                allOf(withClassName(is("com.android.internal.widget.ButtonBarLayout")),
                                        childAtPosition(
                                                withClassName(is("android.widget.LinearLayout")),
                                                3)),
                                3),
                        isDisplayed()));
        button2.perform(click());

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
        editText4.perform(replaceText("test@test.com"), closeSoftKeyboard());

        ViewInteraction button3 = onView(
                allOf(withId(R.id.ok_register), withText("OK"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                7),
                        isDisplayed()));
        button3.perform(click());

        ViewInteraction button4 = onView(
                allOf(withId(R.id.add_button), withText("Add Quiz"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                1),
                        isDisplayed()));
        button4.perform(click());

        ViewInteraction editText5 = onView(
                allOf(withId(R.id.quiz_name),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout3),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                2),
                        isDisplayed()));
        editText5.perform(click());

        ViewInteraction editText6 = onView(
                allOf(withId(R.id.quiz_name),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout3),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                2),
                        isDisplayed()));
        editText6.perform(replaceText("test"), closeSoftKeyboard());

        ViewInteraction editText7 = onView(
                allOf(withId(R.id.description),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout3),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                4),
                        isDisplayed()));
        editText7.perform(replaceText("test description"), closeSoftKeyboard());

        ViewInteraction editText8 = onView(
                allOf(withId(R.id.editText3),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout3),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                6),
                        isDisplayed()));
        editText8.perform(replaceText("1"), closeSoftKeyboard());

        ViewInteraction button5 = onView(
                allOf(withId(R.id.ok_add_btn), withText("OK"),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout3),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                8),
                        isDisplayed()));
        button5.perform(click());

        ViewInteraction editText9 = onView(
                allOf(withId(R.id.quiz_word),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        editText9.perform(replaceText("word"), closeSoftKeyboard());

        ViewInteraction editText10 = onView(
                allOf(withId(R.id.correct_def),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                4),
                        isDisplayed()));
        editText10.perform(replaceText("c"), closeSoftKeyboard());

        ViewInteraction editText11 = onView(
                allOf(withId(R.id.incorrect_def1),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                6),
                        isDisplayed()));
        editText11.perform(replaceText("i"), closeSoftKeyboard());

        ViewInteraction editText12 = onView(
                allOf(withId(R.id.incorrect_def2),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                7),
                        isDisplayed()));
        editText12.perform(replaceText("i"), closeSoftKeyboard());

        ViewInteraction editText13 = onView(
                allOf(withId(R.id.incorrect_def3),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                8),
                        isDisplayed()));
        editText13.perform(replaceText("i"), closeSoftKeyboard());

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
                allOf(withId(R.id.exit), withText("Exit"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                5),
                        isDisplayed()));
        button7.perform(click());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.reg_new_student), withText("Register New Student"),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout2),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                3),
                        isDisplayed()));
        appCompatButton2.perform(click());

        ViewInteraction editText14 = onView(
                allOf(withId(R.id.username),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                2),
                        isDisplayed()));
        editText14.perform(replaceText("test2"), closeSoftKeyboard());

        ViewInteraction editText15 = onView(
                allOf(withId(R.id.major),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                9),
                        isDisplayed()));
        editText15.perform(replaceText("Computer"), closeSoftKeyboard());

        ViewInteraction editText16 = onView(
                allOf(withId(R.id.email),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                5),
                        isDisplayed()));
        editText16.perform(replaceText("test@te.com"), closeSoftKeyboard());

        ViewInteraction editText17 = onView(
                allOf(withId(R.id.email), withText("test@te.com"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                5),
                        isDisplayed()));
        editText17.perform(pressImeActionButton());

        ViewInteraction button8 = onView(
                allOf(withId(R.id.ok_register), withText("OK"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                7),
                        isDisplayed()));
        button8.perform(click());

        ViewInteraction button9 = onView(
                allOf(withId(R.id.practice_button), withText("Practice Quiz"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                3),
                        isDisplayed()));
        button9.perform(click());

        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.practice_list),
                        childAtPosition(
                                withId(R.id.linearLayout),
                                3)));
        recyclerView.perform(actionOnItemAtPosition(0, click()));

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(android.R.id.button1), withText("Confirm"),
                        childAtPosition(
                                allOf(withClassName(is("com.android.internal.widget.ButtonBarLayout")),
                                        childAtPosition(
                                                withClassName(is("android.widget.LinearLayout")),
                                                3)),
                                3),
                        isDisplayed()));
        appCompatButton3.perform(click());

        ViewInteraction radioButton = onView(
                allOf(withId(R.id.definition2),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        radioButton.perform(click());

        ViewInteraction button10 = onView(
                allOf(withId(R.id.ok_questions_btn), withText("OK"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                11),
                        isDisplayed()));
        button10.perform(click());

        ViewInteraction button11 = onView(
                allOf(withId(android.R.id.button1), withText("Next Question"),
                        childAtPosition(
                                allOf(withClassName(is("com.android.internal.widget.ButtonBarLayout")),
                                        childAtPosition(
                                                withClassName(is("android.widget.LinearLayout")),
                                                3)),
                                3),
                        isDisplayed()));
        button11.perform(click());

        ViewInteraction appCompatButton4 = onView(
                allOf(withId(android.R.id.button1), withText("Exit"),
                        childAtPosition(
                                allOf(withClassName(is("com.android.internal.widget.ButtonBarLayout")),
                                        childAtPosition(
                                                withClassName(is("android.widget.LinearLayout")),
                                                3)),
                                3),
                        isDisplayed()));
        appCompatButton4.perform(click());

        ViewInteraction button12 = onView(
                allOf(withId(R.id.view_stats), withText("View Statistics"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                4),
                        isDisplayed()));
        button12.perform(click());

        ViewInteraction recyclerView2 = onView(
                allOf(withId(R.id.stats_quiz_list),
                        childAtPosition(
                                withClassName(is("android.support.constraint.ConstraintLayout")),
                                3)));
        recyclerView2.perform(actionOnItemAtPosition(0, click()));

        ViewInteraction button13 = onView(
                allOf(withId(R.id.ok_stats), withText("OK"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                14),
                        isDisplayed()));
        button13.perform(click());

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

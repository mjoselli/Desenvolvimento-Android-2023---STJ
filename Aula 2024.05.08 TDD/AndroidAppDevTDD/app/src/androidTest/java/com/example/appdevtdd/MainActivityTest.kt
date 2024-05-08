package com.example.appdevtdd

import androidx.test.core.app.ActivityScenario.launch
import androidx.test.core.app.takeScreenshot
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.clearText
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @Test
    fun canRecreate(){
        val scenario = launch(MainActivity::class.java)
        scenario.recreate()
    }
    @Test
    fun viewsExists(){
        launch(MainActivity::class.java)
        onView(withId(R.id.num1EditText)).check(matches(isDisplayed()))
        onView(withId(R.id.num2EditText)).check(matches(isDisplayed()))
        onView(withId(R.id.sumButton)).check(matches(isDisplayed()))
        onView(withId(R.id.subtractionButton)).check(matches(isDisplayed()))
        onView(withId(R.id.resultTextView)).check(matches(isDisplayed()))
    }
    @Test
    fun testSum(){
        launch(MainActivity::class.java)
        onView(withId(R.id.num1EditText)).perform(
                                        clearText(),
                                        typeText("3")
                                        )
        onView(withId(R.id.num2EditText)).perform(
                                        clearText(),
                                        typeText("2")
        )
        onView(withId(R.id.sumButton)).perform(click())
        onView(withId(R.id.resultTextView)).check(matches(withText("5")))

    }
    @Test
    fun testSubtraction(){
        launch(MainActivity::class.java)
        onView(withId(R.id.num1EditText)).perform(
            clearText(),
            typeText("3")
        )
        onView(withId(R.id.num2EditText)).perform(
            clearText(),
            typeText("2")
        )
        onView(withId(R.id.subtractionButton)).perform(click())
        onView(withId(R.id.resultTextView)).check(matches(withText("1")))
    }
    @Before
    fun setUp(){

    }
    @After
    fun tearDown(){

    }
}
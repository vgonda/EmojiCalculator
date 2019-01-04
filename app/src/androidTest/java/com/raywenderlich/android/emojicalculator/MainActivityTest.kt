package com.raywenderlich.android.emojicalculator

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.CoreMatchers.allOf
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

  @Test
  fun appLaunchesSuccessfully() {
    ActivityScenario.launch(MainActivity::class.java)
  }
  
  @Test
  fun onLaunchCheckAmountInputIsDisplayed() {
    ActivityScenario.launch(MainActivity::class.java)

    onView(withId(R.id.inputAmount))
        .check(matches(isDisplayed()))
  }

  @Test
  fun onLaunchOkayButtonIsDisplayed() {
    ActivityScenario.launch(MainActivity::class.java)

    onView(withText(R.string.okay))
        .check(matches(isDisplayed()))
  }

  @Test
  fun whenOkayButtonIsPressedAndAmountIsEmptyTipIsEmpty() {
    ActivityScenario.launch(MainActivity::class.java)

    onView(withId(R.id.buttonOkay))
        .perform(click())

    onView(allOf(withId(R.id.textTip), withText("")))
        .check(matches(isDisplayed()))
  }

  @Test
  fun whenOkayButtonIsPressedAndAmountIsFilledTipIsSet() {
    ActivityScenario.launch(MainActivity::class.java)

    inputCheckAmountAndSelectOkayButton("11")

    verifyTipIsCorrect("1.98")
  }

  @Test
  fun whenOkayButtonIsPressedAndRoundSwitchIsSelectedAmountIsCorrect() {
    ActivityScenario.launch(MainActivity::class.java)

    onView(withId(R.id.switchRound))
        .perform(click())
    inputCheckAmountAndSelectOkayButton("11")

    verifyTipIsCorrect("2.00")
  }

  //region Screen Robots
  private fun inputCheckAmountAndSelectOkayButton(input: String) {
    onView(withId(R.id.inputAmount))
        .perform(typeText(input))
    onView(withId(R.id.buttonOkay))
        .perform(click())
  }

  private fun verifyTipIsCorrect(tip: String) {
    onView(allOf(withId(R.id.textTip), withText(tip)))
        .check(matches(isDisplayed()))
  }
  //endregion
}
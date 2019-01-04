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
  fun onLaunchRoundSwitchIsDisplayed() {
    ActivityScenario.launch(MainActivity::class.java)

    onView(withId(R.id.switchRound))
        .check(matches(isDisplayed()))
  }

  @Test
  fun onLaunchBadButtonIsDisplayed() {
    ActivityScenario.launch(MainActivity::class.java)

    onView(withText(R.string.bad))
        .check(matches(isDisplayed()))
  }

  @Test
  fun onLaunchOkayButtonIsDisplayed() {
    ActivityScenario.launch(MainActivity::class.java)

    onView(withText(R.string.okay))
        .check(matches(isDisplayed()))
  }

  @Test
  fun onLaunchGreatButtonIsDisplayed() {
    ActivityScenario.launch(MainActivity::class.java)

    onView(withText(R.string.great))
        .check(matches(isDisplayed()))
  }

  @Test
  fun onLaunchTipLabelIsDisplayed() {
    ActivityScenario.launch(MainActivity::class.java)

    onView(withId(R.id.textTipLabel))
        .check(matches(isDisplayed()))
  }

  @Test
  fun onLaunchTotalLabelIsDisplayed() {
    ActivityScenario.launch(MainActivity::class.java)

    onView(withId(R.id.textTotal))
        .check(matches(isDisplayed()))
  }

  @Test
  fun whenBadButtonIsPressedAndAmountIsEmptyTipIsEmpty() {
    ActivityScenario.launch(MainActivity::class.java)

    onView(withId(R.id.buttonBad))
        .perform(click())

    onView(allOf(withId(R.id.textTip), withText("")))
        .check(matches(isDisplayed()))
  }

  @Test
  fun whenBadButtonIsPressedAndAmountIsEmptyTotalIsEmpty() {
    ActivityScenario.launch(MainActivity::class.java)

    onView(withId(R.id.buttonBad))
        .perform(click())

    onView(allOf(withId(R.id.textTotal), withText("")))
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
  fun whenOkayButtonIsPressedAndAmountIsEmptyTotalIsEmpty() {
    ActivityScenario.launch(MainActivity::class.java)

    onView(withId(R.id.buttonOkay))
        .perform(click())

    onView(allOf(withId(R.id.textTotal), withText("")))
        .check(matches(isDisplayed()))
  }

  @Test
  fun whenGreatButtonIsPressedAndAmountIsEmptyTipIsEmpty() {
    ActivityScenario.launch(MainActivity::class.java)

    onView(withId(R.id.buttonGreat))
        .perform(click())

    onView(allOf(withId(R.id.textTip), withText("")))
        .check(matches(isDisplayed()))
  }

  @Test
  fun whenGreatButtonIsPressedAndAmountIsEmptyTotalIsEmpty() {
    ActivityScenario.launch(MainActivity::class.java)

    onView(withId(R.id.buttonGreat))
        .perform(click())

    onView(allOf(withId(R.id.textTotal), withText("")))
        .check(matches(isDisplayed()))
  }

  @Test
  fun whenBadButtonIsPressedAndAmountIsFilledTipIsSet() {
    ActivityScenario.launch(MainActivity::class.java)

    inputCheckAmountAndSelectBadButton("11")

    verifyTipIsCorrect("1.65")
  }

  @Test
  fun whenBadButtonIsPressedAndAmountIsFilledTotalIsSet() {
    ActivityScenario.launch(MainActivity::class.java)

    inputCheckAmountAndSelectBadButton("11")

    verifyTotalIsCorrect("12.65")
  }

  @Test
  fun whenBadButtonIsPressedAndAmountIsFilledPercentIsSet() {
    ActivityScenario.launch(MainActivity::class.java)

    inputCheckAmountAndSelectBadButton("11")

    verifyPercentIsCorrect("15.00%")
  }

  @Test
  fun whenOkayButtonIsPressedAndAmountIsFilledTipIsSet() {
    ActivityScenario.launch(MainActivity::class.java)

    inputCheckAmountAndSelectOkayButton("11")

    verifyTipIsCorrect("1.98")
  }

  @Test
  fun whenOkayButtonIsPressedAndAmountIsFilledTotalIsSet() {
    ActivityScenario.launch(MainActivity::class.java)

    inputCheckAmountAndSelectOkayButton("11")

    verifyTotalIsCorrect("12.98")
  }

  @Test
  fun whenOkayButtonIsPressedAndAmountIsFilledPercentIsSet() {
    ActivityScenario.launch(MainActivity::class.java)

    inputCheckAmountAndSelectOkayButton("11")

    verifyPercentIsCorrect("18.00%")
  }

  @Test
  fun whenGreatButtonIsPressedAndAmountIsFilledTipIsSet() {
    ActivityScenario.launch(MainActivity::class.java)

    inputCheckAmountAndSelectGreatButton("11")

    verifyTipIsCorrect("2.20")
  }

  @Test
  fun whenGreatButtonIsPressedAndAmountIsFilledTotalIsSet() {
    ActivityScenario.launch(MainActivity::class.java)

    inputCheckAmountAndSelectGreatButton("11")

    verifyTotalIsCorrect("13.20")
  }

  @Test
  fun whenGreatButtonIsPressedAndAmountIsFilledPercentIsSet() {
    ActivityScenario.launch(MainActivity::class.java)

    inputCheckAmountAndSelectGreatButton("11")

    verifyPercentIsCorrect("20.00%")
  }

  @Test
  fun whenBadButtonIsPressedAndRoundSwitchIsSelectedTipIsCorrect() {
    ActivityScenario.launch(MainActivity::class.java)

    onView(withId(R.id.switchRound))
        .perform(click())
    inputCheckAmountAndSelectOkayButton("11")

    verifyTipIsCorrect("2.00")
  }

  @Test
  fun whenBadButtonIsPressedAndRoundSwitchIsSelectedTotalIsCorrect() {
    ActivityScenario.launch(MainActivity::class.java)

    onView(withId(R.id.switchRound))
        .perform(click())
    inputCheckAmountAndSelectOkayButton("11")

    verifyTotalIsCorrect("13.00")
  }

  @Test
  fun whenBadButtonIsPressedAndRoundSwitchIsSelectedPercentIsCorrect() {
    ActivityScenario.launch(MainActivity::class.java)

    onView(withId(R.id.switchRound))
        .perform(click())
    inputCheckAmountAndSelectBadButton("11")

    verifyPercentIsCorrect("18.18%")
  }

  @Test
  fun whenOkayButtonIsPressedAndRoundSwitchIsSelectedTipIsCorrect() {
    ActivityScenario.launch(MainActivity::class.java)

    onView(withId(R.id.switchRound))
        .perform(click())
    inputCheckAmountAndSelectOkayButton("11")

    verifyTipIsCorrect("2.00")
  }

  @Test
  fun whenOkayButtonIsPressedAndRoundSwitchIsSelectedTotalIsCorrect() {
    ActivityScenario.launch(MainActivity::class.java)

    onView(withId(R.id.switchRound))
        .perform(click())
    inputCheckAmountAndSelectOkayButton("11")

    verifyTotalIsCorrect("13.00")
  }

  @Test
  fun whenOkayButtonIsPressedAndRoundSwitchIsSelectedPercentIsCorrect() {
    ActivityScenario.launch(MainActivity::class.java)

    onView(withId(R.id.switchRound))
        .perform(click())
    inputCheckAmountAndSelectOkayButton("11")

    verifyPercentIsCorrect("18.18%")
  }

  @Test
  fun whenGreatButtonIsPressedAndRoundSwitchIsSelectedTipIsCorrect() {
    ActivityScenario.launch(MainActivity::class.java)

    onView(withId(R.id.switchRound))
        .perform(click())
    inputCheckAmountAndSelectGreatButton("11")

    verifyTipIsCorrect("3.00")
  }

  @Test
  fun whenGreatButtonIsPressedAndRoundSwitchIsSelectedTotalIsCorrect() {
    ActivityScenario.launch(MainActivity::class.java)

    onView(withId(R.id.switchRound))
        .perform(click())
    inputCheckAmountAndSelectGreatButton("11")

    verifyTotalIsCorrect("14.00")
  }

  @Test
  fun whenGreatButtonIsPressedAndRoundSwitchIsSelectedPercentIsCorrect() {
    ActivityScenario.launch(MainActivity::class.java)

    onView(withId(R.id.switchRound))
        .perform(click())
    inputCheckAmountAndSelectGreatButton("11")

    verifyPercentIsCorrect("27.27%")
  }

  //region Screen Robots
  private fun inputCheckAmountAndSelectBadButton(input: String) {
    onView(withId(R.id.inputAmount))
        .perform(typeText(input))
    onView(withId(R.id.buttonBad))
        .perform(click())
  }

  private fun inputCheckAmountAndSelectOkayButton(input: String) {
    onView(withId(R.id.inputAmount))
        .perform(typeText(input))
    onView(withId(R.id.buttonOkay))
        .perform(click())
  }

  private fun inputCheckAmountAndSelectGreatButton(input: String) {
    onView(withId(R.id.inputAmount))
        .perform(typeText(input))
    onView(withId(R.id.buttonGreat))
        .perform(click())
  }

  private fun verifyTipIsCorrect(tip: String) {
    onView(allOf(withId(R.id.textTip), withText(tip)))
        .check(matches(isDisplayed()))
  }

  private fun verifyTotalIsCorrect(total: String) {
    onView(allOf(withId(R.id.textTotal), withText(total)))
        .check(matches(isDisplayed()))
  }

  private fun verifyPercentIsCorrect(percent: String) {
    onView(allOf(withId(R.id.textPercent), withText(percent)))
        .check(matches(isDisplayed()))
  }
  //endregion
}
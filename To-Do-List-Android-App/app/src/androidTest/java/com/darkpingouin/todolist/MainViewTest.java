package com.darkpingouin.todolist;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.darkpingouin.todolist.screens.MainScreen;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.AllOf.allOf;

@RunWith(AndroidJUnit4.class)
public class MainViewTest {
    @Rule
    public ActivityScenarioRule<MainActivity> testRule = new ActivityScenarioRule<>(MainActivity.class);
    MainScreen mainscreen = new MainScreen();

    @Test
    public void firstTest() {
        mainscreen.addButton().check(matches(allOf(isDisplayed(), isClickable())));
        mainscreen.header().check(matches(isDisplayed()));
    }

    @Test
    public void editTaskTest() {
        mainscreen.getTask("task2").check(matches(isDisplayed()));
        mainscreen.chooseTask("task2").enterTaskName("task2").enterDefaultDate().enterDefaultTime().saveChanges();
        mainscreen.getTask("task2").check(matches(isDisplayed()));
    }

    @Test
    public void createTaskTest() {
        mainscreen.getTask("newTask").check(doesNotExist());
        mainscreen.clickAddButton().enterTaskName("newTask").enterTaskText("task").enterNewDefaultDate().enterNewDefaultTime().addTask();
        mainscreen.getTask("newTask").check(matches(isDisplayed()));
    }

    @Test
    public void deleteTaskTest() {
        mainscreen.getTask("newTask").check(matches(isDisplayed()));
        mainscreen.chooseTask("newTask");
        mainscreen.getTask("newTask").check(doesNotExist());
    }

    @Test
    public void doneNotVisibleTaskTest() {
        mainscreen.getTask("task2").check(matches(isDisplayed()));
        mainscreen.setDone("task2").setDoneNotVisible().getTask("task2").check(doesNotExist());
    }


    @Test
    public void createCategory() {
        mainscreen.openSide().openCategorySettings().clickAddButton().setName("lala2").clickSave().clickCloseButton();
        Assert.assertThat(mainscreen.getTaskName("lala2"), equalTo("lala2"));
    }
}

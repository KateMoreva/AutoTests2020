package com.darkpingouin.todolist.screens;



import android.widget.ListView;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.ViewMatchers;

import com.darkpingouin.todolist.CatAdapter;
import com.darkpingouin.todolist.R;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.swipeLeft;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.DrawerMatchers.isClosed;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static com.darkpingouin.todolist.utils.TaskWrapper.getName;
import static com.darkpingouin.todolist.utils.Utils.scrollToTask;
import static com.darkpingouin.todolist.utils.Utils.setChecked;

public class MainScreen {
    public ViewInteraction addButton() {
        return onView(ViewMatchers.withId(R.id.add_btn));
    }

    public NewTaskScreen clickAddButton() {
        onView(ViewMatchers.withId(R.id.add_btn)).perform(click());
        return new NewTaskScreen();
    }

    public ViewInteraction header() {
        return onView(ViewMatchers.withId(R.id.top));
    }

    public ViewInteraction getTask(String taskName) {
        return scrollToTask(taskName);
    }

    public String getTaskName(String taskName) {
        return getName(scrollToTask(taskName));
    }

    public EditTaskScreen chooseTask(String taskName) {
        scrollToTask(taskName).check(matches(isDisplayed()));
        onView(withText(taskName)).perform(click());
        return new EditTaskScreen();
    }

    public MainScreen setDone(String taskName) {
        scrollToTask(taskName).check(matches(isDisplayed()));
        onView(withText(taskName)).perform(swipeLeft());
        onView(withId(R.id.doneB)).perform(click());
        return this;
    }

    public MainScreen setDoneNotVisible() {
        onView(withId(R.id.expanded_menu)).perform(click());
        onView(withId(R.id.switch_done)).perform(setChecked(false));
        onView(withId(R.id.close_extended)).perform(click());
        return this;
    }


    public CategoryScreen openCategorySettings() {
        onView(withId(R.id.expanded_menu)).perform(click());
        onView(withId(R.id.open_category)).perform(click());
        return new CategoryScreen();
    }

    public MainScreen openSide() {
        onView(withId(R.id.expanded_menu)).perform(click());
        return this;
    }

    public MainScreen closeSide() {
        onView(withId(R.id.close_extended)).perform(click());
        return this;
    }

}

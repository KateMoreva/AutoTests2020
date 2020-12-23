package com.darkpingouin.todolist.screens;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.ViewMatchers;

import com.darkpingouin.todolist.R;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static com.darkpingouin.todolist.utils.Utils.scrollToTask;

public class CategoryScreen {

    public AddCategoryScreen clickAddButton() {
        onView(ViewMatchers.withId(R.id.add_btn)).perform(click());
        return new AddCategoryScreen();
    }

    public MainScreen clickCloseButton() {
        onView(ViewMatchers.withId(R.id.close_category)).perform(click());
        return new MainScreen();
    }

    public ViewInteraction getCategory(String taskName) {
        return scrollToTask(taskName);
    }

}

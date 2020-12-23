package com.darkpingouin.todolist.screens;

import androidx.test.espresso.action.ViewActions;

import com.darkpingouin.todolist.R;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class AddCategoryScreen {
    public AddCategoryScreen setName(String name) {
        onView(withId(R.id.catName)).perform(
                ViewActions.clearText(),
                ViewActions.typeText(name),
                ViewActions.closeSoftKeyboard()
        );
     return this;
    }
    public CategoryScreen clickSave() {
        onView(withId(R.id.ok)).perform(click());
        return new CategoryScreen();
    }

}

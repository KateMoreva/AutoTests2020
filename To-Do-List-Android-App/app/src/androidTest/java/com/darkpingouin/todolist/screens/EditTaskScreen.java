package com.darkpingouin.todolist.screens;

import android.widget.DatePicker;
import android.widget.TimePicker;

import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.contrib.PickerActions;
import androidx.test.espresso.matcher.ViewMatchers;

import com.darkpingouin.todolist.R;

import java.util.Calendar;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class EditTaskScreen {

    public EditTaskScreen enterTaskName(String name) {
        onView(ViewMatchers.withId(R.id.title)).perform(
                ViewActions.clearText(),
                ViewActions.typeText(name),
                ViewActions.closeSoftKeyboard()
        );
        return this;
    }

    public EditTaskScreen enterTaskText(String text) {
        onView(withId(R.id.txt)).perform(
                ViewActions.typeText(text),
                ViewActions.closeSoftKeyboard()
        );
        return this;
    }

    public EditTaskScreen saveChanges() {
        onView(withId(R.id.save)).perform(click());
        return this;
    }

    public EditTaskScreen enterDefaultTime() {
        Calendar calendar = Calendar.getInstance();
        onView(withId(R.id.time2)).perform(click());
        onView(isAssignableFrom(TimePicker.class)).perform(
                PickerActions.setTime(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE) + 2)
        );
        onView(withText("OK")).perform(click());
        return this;
    }

    public EditTaskScreen enterDefaultDate() {
        Calendar calendar = Calendar.getInstance();
        onView(withId(R.id.date2)).perform(click());
        onView(isAssignableFrom(DatePicker.class)).perform(
                PickerActions.setDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DATE))
        );
        onView(withText("OK")).perform(click());
        return this;
    }

    public MainScreen deleteTask() {
        onView(withId(R.id.add_btn)).perform(
                click()
        );
        onView(withId(R.id.yes)).perform(
                click()
        );
        return new MainScreen();
    }



}

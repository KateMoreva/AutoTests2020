package com.darkpingouin.todolist.utils;


import androidx.test.espresso.ViewInteraction;

import static com.darkpingouin.todolist.utils.Utils.getText;


public class TaskWrapper {
    private String name;
    private String text;
    private String date;

    public TaskWrapper(ViewInteraction viewInteraction) {


    }

    public static String getName(ViewInteraction viewInteraction) {
        return getText(viewInteraction);
    }

}

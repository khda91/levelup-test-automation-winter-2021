package ru.levelup.qa.at.utils;

import java.util.concurrent.TimeUnit;

public final class SleepUtils {

    private SleepUtils() {

    }

    public static void sleep(long millis) {
        try {
            TimeUnit.MILLISECONDS.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

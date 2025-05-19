package ec.edu.monster.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class AuthHelper {
    private static final String PREFS_NAME = "AuthPrefs";
    private static final String KEY_IS_LOGGED_IN = "isLoggedIn";

    public static void setLoggedIn(Context context, boolean isLoggedIn) {
        SharedPreferences preferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        preferences.edit().putBoolean(KEY_IS_LOGGED_IN, isLoggedIn).apply();
    }

    public static boolean isLoggedIn(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        return preferences.getBoolean(KEY_IS_LOGGED_IN, false);
    }
}
package com.recenturesoft.changeapplanguage.custom;

import android.content.Context;

import com.recenturesoft.changeapplanguage.model.LanguageType;


/**
 * Created by anand
 */

public class PrefUtils {
    public static void setLanguage(LanguageType currentUser, Context ctx){
        ComplexPreferences complexPreferences = ComplexPreferences.getComplexPreferences(ctx, "user_pref", 0);
        complexPreferences.putObject("user_pref_value", currentUser);
        complexPreferences.commit();
    }



    public static LanguageType getLanguage(Context ctx){
        ComplexPreferences complexPreferences = ComplexPreferences.getComplexPreferences(ctx, "user_pref", 0);
        LanguageType currentUser = complexPreferences.getObject("user_pref_value", LanguageType.class);
        return currentUser;
    }
}

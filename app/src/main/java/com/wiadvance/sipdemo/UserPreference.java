package com.wiadvance.sipdemo;

import android.content.Context;
import android.preference.PreferenceManager;

public class UserPreference {

    private static final String PREF_NAME = "name";
    private static final String PREF_EMAIL = "email";
    private static final String PREF_SIP = "sip";
    private static final String PREF_DOMAIN = "domain";
    private static final String PREF_PASSWORD = "password";
    private static final String PREF_REGISTRATION_OK = "registration_ok";


    public static String getName(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context).getString(PREF_NAME, null);
    }

    public static String getEmail(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context).getString(PREF_EMAIL, null);
    }

    public static String getSip(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context).getString(PREF_SIP, null);
    }

    public static String getDomain(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context).getString(PREF_DOMAIN, null);
    }

    public static String getPassword(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context).getString(PREF_PASSWORD, null);
    }

    public static boolean getRegistrationStatus(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(PREF_REGISTRATION_OK, false);
    }

    public static void setName(Context context, String name){
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString(PREF_NAME, name).apply();
    }

    public static void setEmail(Context context, String email){
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString(PREF_EMAIL, email).apply();
    }

    public static void setSip(Context context, String sip){
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString(PREF_SIP, sip).apply();
    }

    public static void setDomain(Context context, String domain){
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString(PREF_DOMAIN, domain).apply();
    }

    public static void setPassword(Context context, String password){
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString(PREF_PASSWORD, password).apply();
    }

    public static void setRegistrationStatus(Context context, boolean isOk){
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean(PREF_REGISTRATION_OK, isOk).apply();
    }
}

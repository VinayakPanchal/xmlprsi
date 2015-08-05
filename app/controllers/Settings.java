package controllers;

import java.util.HashMap;

/**
 * Created by vpanchal on 7/22/2015.
 */
public class Settings
{
    private static HashMap resumeList = new HashMap();

    public static void updateResumeList(String fname, String lname, String email)
    {
        HashMap hm = new HashMap();

        hm.put("fname",fname);
        hm.put("lname",lname);
        hm.put("email",email);

        resumeList.put(email,hm);
    }

    public static void clearAll()
    {
        resumeList.clear();
    }


}

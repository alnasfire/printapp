package com.printapp.util;

import java.io.FileInputStream;
import java.util.Properties;

public class Configuration {

    private static Properties props = null;
    public static final String default_language = "ru";

    public static String getProperty(String name){
        if(props == null){
            props = new Properties();
            try{
                props.load(new FileInputStream("config.cfg"));
        }catch(Exception ex){
                return "";
            }
        }
        String prop = "" + props.get(name);
        return Utils.isNull(prop)?"":prop;
    }

    public static void setProperty(String name, String property){
        if(props == null)
            props = new Properties();
        props.put(name, property);
    }

    public static String getLanguage(){
        String prop = getProperty("language");
        if(prop.trim().length() ==0)
            prop = default_language;
        return prop;
    }

    public static void setLanguage(String lang){
        setProperty("language", lang);
    }
}

package com.printapp.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class i18n {

    private static Properties props = null;


    public static String getString(String key){

        if(props == null)
        try{
            props = new Properties();
            FileInputStream is = new FileInputStream("src/com/printapp/conf/lang.properties");
            InputStreamReader isr = new InputStreamReader(is, "UTF8");
            props.load(isr);
        }catch(Exception ex){
            ex.printStackTrace();
        }

        String prop = (String )props.get(Configuration.getLanguage() + "." + key);
        if(Utils.isNull(prop))
            prop = Configuration.getLanguage() + "." + key;
        return prop;
    }
}

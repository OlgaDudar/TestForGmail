package core;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class DataProperties {

    public static String getDataProperties (String param, String file){
        Properties props;
        props = new Properties();
        try {
            props.load(new InputStreamReader(new FileInputStream(file)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return props.getProperty(param);
    }

    public static void setDataProperties(String param, String file, String value){
        Properties props;
        props = new Properties();
        try {
            props.load(new InputStreamReader(new FileInputStream(file)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        props.setProperty(param, value);
        try {
            props.store(new FileOutputStream(file), null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

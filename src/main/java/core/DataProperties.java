package core;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class DataProperties {
    public static String getDataProperties (String param){
        Properties props;
        props = new Properties();
        try {
            props.load(new InputStreamReader(new FileInputStream("system.properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return props.getProperty(param);
    }
}

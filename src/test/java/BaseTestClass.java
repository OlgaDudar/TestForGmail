import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class BaseTestClass {
    @BeforeClass
    public void setProp(){
        System.setProperty("webdriver.chrome.driver", "\\drivers\\chromedriver.exe");
    }

    public static String getDataProperties (String param) throws Exception {
        Properties props;
        props = new Properties();
        props.load(new InputStreamReader(new FileInputStream("system.properties")));
        return props.getProperty(param);
    }
}

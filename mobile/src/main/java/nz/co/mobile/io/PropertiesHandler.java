package nz.co.mobile.io;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesHandler {
        private Properties properties;
        private InputStream inputStream;

    public PropertiesHandler(String filePath) {
        try {
            inputStream = getClass().getClassLoader().getResourceAsStream(filePath);
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    public Properties getProperties(){
        properties = new Properties();
        try{
            if(inputStream != null){
                properties.load(inputStream);
            }
        }catch(IOException e){
            e.printStackTrace();
            return null;
        }
        return properties;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instagram;

/**
 *
 * @author jorda
 */
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class InstaUtils {

    private static final String CONFIG_PROPERTIES = "/config.properties";

    public static Properties getConfigProperties() {
        InputStream input = null;
        final Properties prop = new Properties();
        try {
            input = InstaUtils.class.getResourceAsStream(CONFIG_PROPERTIES);
            prop.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return prop;

    }


}

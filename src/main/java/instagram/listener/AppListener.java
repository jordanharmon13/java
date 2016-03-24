/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instagram.listener;

/**
 *
 * @author jorda
 */
import instagram.Constants;
import org.jinstagram.auth.InstagramAuthService;
import org.jinstagram.auth.oauth.InstagramService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AppListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {

        String clientId = "8e92bafbcdcc4c849fdca959b0daba81";
        String clientSecret = "024355aaf3d34ba995cdd7dcde5a6bef";
        String callbackUrl = "http://java-jordanharmon.rhcloud.com/instaOperations";


        InstagramService service = new InstagramAuthService()
                .apiKey(clientId)
                .apiSecret(clientSecret)
                .callback(callbackUrl)
                .build();

        sce.getServletContext().setAttribute(Constants.INSTAGRAM_SERVICE, service);

    }

    public void contextDestroyed(ServletContextEvent sce) {

        sce.getServletContext().removeAttribute(Constants.INSTAGRAM_SERVICE);

    }


}

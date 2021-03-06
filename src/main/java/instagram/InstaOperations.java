/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instagram;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.jinstagram.Instagram;
import org.jinstagram.auth.model.Token;
import org.jinstagram.auth.model.Verifier;
import org.jinstagram.auth.oauth.InstagramService;

/**
 *
 * @author jorda
 */
//@WebServlet(name = "InstaOperations", urlPatterns = {"/InstaOperations"})
public class InstaOperations extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String code = request.getParameter("code");


        InstagramService service = (InstagramService) request.getServletContext().getAttribute(Constants.INSTAGRAM_SERVICE);

        Verifier verifier = new Verifier(code);

        Token accessToken = service.getAccessToken(verifier);
        Instagram instagram = new Instagram(accessToken);

        HttpSession session = request.getSession();

        session.setAttribute(Constants.INSTAGRAM_OBJECT, instagram);

        System.out.println(request.getContextPath());
        // Redirect to User Profile page.
        response.sendRedirect(request.getContextPath() + "/profile.jsp");

    }

}

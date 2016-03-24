/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instagram;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jinstagram.Instagram;
import org.jinstagram.auth.InstagramAuthService;
import org.jinstagram.auth.model.Token;
import org.jinstagram.auth.model.Verifier;
import org.jinstagram.auth.oauth.InstagramService;
import org.jinstagram.entity.users.basicinfo.UserInfo;
import org.jinstagram.entity.users.basicinfo.UserInfoData;

/**
 *
 * @author jorda
 */
@WebServlet(name = "instaOperations", urlPatterns = {"/instaOperations"})
public class instaOperations extends HttpServlet {
    
    private static final Token EMPTY_TOKEN = null;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String code = request.getParameter("code");
        InstagramService service = new InstagramAuthService()
            .apiKey("8e92bafbcdcc4c849fdca959b0daba81")
            .apiSecret("024355aaf3d34ba995cdd7dcde5a6bef")
            .callback("http://java-jordanharmon.rhcloud.com/instaOperations")
            .build();

    String authorizationUrl = service.getAuthorizationUrl(EMPTY_TOKEN);
    
    Verifier verifier = new Verifier(code);
    Token accessToken = service.getAccessToken(EMPTY_TOKEN, verifier);

    Instagram instagram = new Instagram(accessToken);
    long userId = 458131440;
    UserInfo userInfo = instagram.getUserInfo(userId);

    UserInfoData userData = userInfo.getData();
        try (PrintWriter out = response.getWriter()) {

            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet instaOperations</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet instaOperations at " + request.getContextPath() + "</h1>");
            out.println("id : " + userData.getId());
            out.println("first_name : " + userData.getFirstName());
            out.println("last_name : " + userData.getLastName());
            out.println("profile_picture : " + userData.getProfilePicture());
            out.println("website : " + userData.getWebsite());
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

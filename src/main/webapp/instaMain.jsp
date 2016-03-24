<%-- 
    Document   : instaMain
    Created on : Mar 24, 2016, 1:37:31 PM
    Author     : Jordan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="org.jinstagram.auth.oauth.InstagramService" %>
<%@ page import="instagram.Constants" %>


<%
    // If we already have an instagram object, then redirect to profile.jsp
    Object objInstagram = session.getAttribute(Constants.INSTAGRAM_OBJECT);
    if (objInstagram != null) {
        response.sendRedirect(request.getContextPath() + "/profile.jsp");
    }

    InstagramService service = (InstagramService) session.getServletContext().getAttribute(Constants.INSTAGRAM_SERVICE);

    String authorizationUrl = service.getAuthorizationUrl();
    //String authorizationUrl = "test";

%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
<div class="container">

    <div class="jumbotron">
        <h1>Demo</h1>
        <p><a href="<%= authorizationUrl%>">Login to Instagram</a></p>
    </div>
    </body>
</html>
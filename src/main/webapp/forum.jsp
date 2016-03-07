 <%@ page import="java.io.*" %>
<html>
    <head>
        <title>Please Sign My Guest Book!</title>
    </head>

    <body>
        <h1>Forum Submission</h1>
        <form action="forum.jsp" method="post">
            Your name:
            <input type="text" name="text1">
            <br>
            <br>
            <br>
            Your comments:
            <br>
            <textarea name="textarea1" rows="5" cols="50"></textarea>
            <br>
            <input type="submit" value="Submit"><input type="reset" value="Reset">
        </form>
    <%
          String name = request.getParameter("text1");
          String text = request.getParameter("textarea1");
          String file = application.getRealPath("/") + "test.txt";
          FileWriter filewriter = new FileWriter(file, true);
          filewriter.write("<B>Name: </B>" + name + "<br>");
          filewriter.write("<B>Comments: </B><br>");
          filewriter.write(text + "<br><br>");
          filewriter.close();
        %>
</BODY>
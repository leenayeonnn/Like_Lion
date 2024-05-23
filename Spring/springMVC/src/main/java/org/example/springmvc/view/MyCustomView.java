package org.example.springmvc.view;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;
import org.springframework.web.servlet.View;

public class MyCustomView implements View {

    @Override
    public String getContentType() {
        return "text/html";
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        response.setContentType(getContentType());
        PrintWriter printWriter = response.getWriter();
        printWriter.print("<html><body>");
        printWriter.print("<h1>My Custom View</h1>");
        printWriter.print("</body></html>");

        printWriter.close();
    }
}

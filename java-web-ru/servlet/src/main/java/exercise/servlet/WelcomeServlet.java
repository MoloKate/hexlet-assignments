package exercise.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/")
public class WelcomeServlet extends HttpServlet {

    @Override
    // С помощью метода doGet() сервлет сможет обрабатывать GET запросы
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {

        PrintWriter out = response.getWriter();
        out.println("Hello, Hexlet!");
    }
}
// END

package exercise.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.stream.Collectors;
import static exercise.Data.getCompanies;

public class CompaniesServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                throws IOException, ServletException {

        // BEGIN
        PrintWriter out = response.getWriter();
        List<String> companies = getCompanies();

        String searchString = request.getParameter("search") == null ? ""
                : request.getParameter("search");
        List<String> sortedCompanies = companies
                .stream()
                .filter(company ->company.contains(searchString))
                .toList();

        if (sortedCompanies.isEmpty()) {
            out.println("Companies not found");
            return;
        }

        sortedCompanies.forEach(out::println);
        // END
    }
}

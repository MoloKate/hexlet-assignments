package exercise.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.Map;

import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.lang3.ArrayUtils;

public class UsersServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                throws IOException, ServletException {

        String pathInfo = request.getPathInfo();

        if (pathInfo == null) {
            showUsers(request, response);
            return;
        }

        String[] pathParts = pathInfo.split("/");
        String id = ArrayUtils.get(pathParts, 1, "");

        showUser(request, response, id);
    }

    private List<Map<String, String>> getUsers() throws JsonProcessingException, IOException {
        // BEGIN
        final String pathUsers = "src/main/resources/users.json";
        Path path = Paths.get(pathUsers);
        String content = Files.readString(path);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(content, new TypeReference<List<Map<String, String>>>() { });
        // END
    }

    private void showUsers(HttpServletRequest request,
                          HttpServletResponse response)
                throws IOException {

        // BEGIN
        response.setContentType("text/html;charset=UTF-8");
        StringBuilder users = new StringBuilder();
        String startBody = """
            <!DOCTYPE html>
            <html lang=\"ru\">
                <head>
                    <meta charset=\"UTF-8\">
                    <title>Users</title>
                    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css\"
                          rel=\"stylesheet\"
                          integrity=\"sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We\"
                          crossorigin=\"anonymous\">
                </head>
                <body>
                <table>
            """;
        String endBody = """
                </table>
                </body>
            </html>
            """;

        users.append(startBody);

        for (Map<String, String> user : getUsers()) {
            users.append("<tr>\n");
            users.append("<td>");
            users.append(user.get("id"));
            users.append("</td>\n");
            users.append("<td>\n");
            users.append("<a href=\"/users/");
            users.append(user.get("id"));
            users.append("\">");
            users.append(user.get("firstName"));
            users.append(" ");
            users.append(user.get("lastName"));
            users.append("</a>\n");
            users.append("</td>");
            users.append("</tr>");
        }
        users.append(endBody);

        PrintWriter out = response.getWriter();
        out.println(users.toString());

        // END
    }

    private void showUser(HttpServletRequest request,
                         HttpServletResponse response,
                         String id)
                 throws IOException {

        // BEGIN
        boolean error = true;
        response.setContentType("text/html;charset=UTF-8");
        StringBuilder selectedUser = new StringBuilder();

        String startBody = """
            <!DOCTYPE html>
            <html lang=\"ru\">
                <head>
                    <meta charset=\"UTF-8\">
                    <title>User</title>
                    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css\"
                          rel=\"stylesheet\"
                          integrity=\"sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We\"
                          crossorigin=\"anonymous\">
                </head>
                <body>
                <table>
            """;

        String endBody = """
                </table>
                </body>
            </html>
            """;

        selectedUser.append(startBody);
        for (Map<String, String> user : getUsers()) {
            if (user.get("id").equals(id)) {
                selectedUser.append("<tr>\n");
                selectedUser.append("<td>&nbsp&nbsp");
                selectedUser.append(user.get("id"));
                selectedUser.append("</td>\n");
                selectedUser.append("</tr>\n");
                selectedUser.append("<tr>");
                selectedUser.append("<td>&nbsp&nbsp");;
                selectedUser.append(user.get("firstName"));
                selectedUser.append("  ");
                selectedUser.append(user.get("lastName"));
                selectedUser.append("</td>");
                selectedUser.append("</tr>\n");
                selectedUser.append("<tr>");
                selectedUser.append("<td>&nbsp&nbsp");
                selectedUser.append(user.get("email"));
                selectedUser.append("</td>\n");
                selectedUser.append("</tr>");
                error = false;
                break;
            }
        }
        selectedUser.append(endBody);
        if (error) {
            response.sendError(404, "Not found");
        }
        PrintWriter out = response.getWriter();
        out.println(selectedUser.toString());
        // END
    }
}

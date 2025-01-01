import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // In-memory user store (username, password) — use same map from RegisterServlet
    private static final Map<String, String> userStore = RegisterServlet.userStore;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Check if the username exists in the store and if the password matches
        String storedPassword = userStore.get(username);

        if (storedPassword != null && storedPassword.equals(password)) {
            // Successful login, set the session or cookies (optional)
            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            // Redirect to welcome page
            response.sendRedirect("welcome.jsp");
        } else {
            // Invalid login, show error message
            request.setAttribute("errorMessage", "Invalid username or password");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // In-memory user store (username, password)
    static final Map<String, String> userStore = new HashMap<>();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        // Check if the username already exists
        if (userStore.containsKey(username)) {
            request.setAttribute("errorMessage", "Username already exists");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        // Check if passwords match
        if (password == null || !password.equals(confirmPassword)) {
            request.setAttribute("errorMessage", "Passwords do not match");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        // Save the user in the "database" (in-memory Map)
        userStore.put(username, password);

        // Redirect to login page after successful registration
        response.sendRedirect("login.jsp");
    }
}

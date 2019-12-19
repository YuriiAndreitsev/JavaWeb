package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import dao.UserControllerDAO;
import model.ErrorObj;
import model.User;

/**
 * Servlet implementation class RegServlet
 */
public class RegServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/reg.jsp");
        rd.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordConfirmation = request.getParameter("passwordConfirmation");
        String location = request.getParameter("location");
        String gender = request.getParameter("gender");
        String comment = request.getParameter("comment");
        DAOFactory factory = DAOFactory.getFactory(1);
        UserControllerDAO userControllerDAO = factory.getUserControllerDAO();
        ErrorObj errors = new ErrorObj();


        if (errors.checkForMistakes(email, password, passwordConfirmation, location, gender)) {
            StringBuilder errorMessage = errors.getErrorText();
            request.setAttribute("errorObj", errorMessage);
            doGet(request, response);
        } else {
            User user = new User(email, password, location, gender, comment);

            userControllerDAO.addUser(user);
            request.setAttribute("regComplete", "Registration Successful");
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/reg.jsp");
            rd.forward(request, response);
        }
    }

}

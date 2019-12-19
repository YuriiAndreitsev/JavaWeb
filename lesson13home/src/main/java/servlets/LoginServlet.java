package servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAOFactory;
import dao.UserControllerDAO;
import model.User;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static int accessCount = 0;
    private long time = 0;

	private long penaltyTime = time + 10000 - (new Date().getTime());

    public boolean showForm() {
		boolean form = true;
		if (penaltyTime <= 0) {
			penaltyTime = 0;
            time = 0;
        } else {
            form = false;
        }

        if (accessCount >= 3) {
            form = false;

            if (time == 0) {
                time = new Date().getTime();
            }


        }
        if (!form) {
            accessCount = 0;
        }
        return form;
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	if(!showForm()) {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
		}

        DAOFactory factory = DAOFactory.getFactory(1);
        UserControllerDAO userControllerDAO = factory.getUserControllerDAO();
//        UserController uc = new UserController();
//        DBWorker dbWorker = new DBWorker();

        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/log.jsp");
        rd.forward(request, response);

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String accessMessage;

        DAOFactory factory = DAOFactory.getFactory(1);
        UserControllerDAO userControllerDAO = factory.getUserControllerDAO();

        if (email != null && password != null) {

			User user = userControllerDAO.getUserByEmail(email);
			if (user!=null) {
				String message = "denied";
				String color = "red";


				if (user.getPassword().equals(userControllerDAO.getHash(password))) {
					message = "granted";
					color = "green";
					//form = false;
					accessMessage = "</br></br><center><font color='" + color + "'>Access " + message + "</font></center>";
					request.setAttribute("access", accessMessage);

					HttpSession session = request.getSession();
					session.setAttribute("user", user);

					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/log.jsp");
					rd.forward(request, response);

				} else {
					accessMessage = "</br></br><center><font color='" + color + "'>Access " + message + "</font></center>";
					request.setAttribute("access", accessMessage);
					accessCount++;
					doGet(request, response);
				}
			}else{
				request.setAttribute("errorMessage", "Wrong Email or Password");
			}
        }

        String logout = request.getParameter("logout");
        if (logout != null) {
            HttpSession session = request.getSession();
            session.invalidate();
            session = request.getSession();
        }
        doGet(request, response);
    }
}



package commons;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllers.AddController;
import controllers.AddFormController;
import controllers.DetailController;
import controllers.ListController;
import controllers.RankController;
import controllers.RoundController;
import controllers.UpdateController;

@SuppressWarnings("serial")
@WebServlet("*.home")
public class FrontController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uri = request.getRequestURI();
		
		String path = null;
		Controller controller = null;
		
		if(uri.endsWith("list.home")) {
			controller = new ListController();
		} else if(uri.endsWith("round.home")) {
			controller = new RoundController();
		} else if(uri.endsWith("addform.home")) {
			controller = new AddFormController();
		} else if(uri.endsWith("add.home")) {
			controller = new AddController();
		} else if(uri.endsWith("detail.home")) {
			controller = new DetailController();
		} else if(uri.endsWith("update.home")) {
			controller = new UpdateController();
		} else if(uri.endsWith("rank.home")) {
			controller = new RankController();
		}
		
		try {
			path = controller.process(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		if(path.startsWith("redirect")) {
			path = path.replace("redirect:", "");
			response.sendRedirect(path);
		} else {
			request.getRequestDispatcher("WEB-INF/views/" + path).forward(request, response);
		}
	}
}

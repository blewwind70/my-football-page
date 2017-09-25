package commons;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.LeagueDao;
import util.StringUtils;
import vo.League;

@SuppressWarnings("serial")
@WebServlet("/nation.find")
public class NationInfoServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int nationNo = StringUtils.stringToNumber(request.getParameter("nation"));
		if(nationNo != 0) {
			try {
				List<League> leagueList = LeagueDao.getInstance().getLeguesByNationNo(nationNo);
				response.setContentType("text/plain;charset=utf-8");
				
				PrintWriter pw = response.getWriter();
				String json = new Gson().toJson(leagueList);
				pw.write(json);				
			} catch (SQLException e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
			

		}
	}
}

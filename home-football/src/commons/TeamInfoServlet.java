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

import dao.TeamDao;
import util.StringUtils;
import vo.Team;

@SuppressWarnings("serial")
@WebServlet("/team.find")
public class TeamInfoServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int leagueNo = StringUtils.stringToNumber(request.getParameter("league"));
		if(leagueNo != 0) {
			try {
				List<Team> teamList = TeamDao.getInstance().getTeamsByLeagueNo(leagueNo);
				response.setContentType("text/plain;charset=utf-8");
				
				PrintWriter pw = response.getWriter();
				String json = new Gson().toJson(teamList);
				pw.write(json);				
			} catch (SQLException e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
			

		}
	}	
}

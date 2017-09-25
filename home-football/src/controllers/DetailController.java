package controllers;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import commons.Controller;
import dao.MatchDao;
import util.StringUtils;
import vo.MatchTeam;

public class DetailController implements Controller {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		int matchTeamNo = StringUtils.stringToNumber(request.getParameter("mno"));
		
		MatchTeam matchTeam = MatchDao.getInstance().getMatchByMatchNo(matchTeamNo);
		request.setAttribute("matchTeam", matchTeam);
		
		return "list/detail.jsp";
	}

}

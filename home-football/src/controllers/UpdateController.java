package controllers;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import commons.Controller;
import dao.MatchDao;
import util.StringUtils;
import vo.Match;

public class UpdateController implements Controller {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws SQLException {

		int matchNo = StringUtils.stringToNumber(request.getParameter("mno"));
		int homeScore = StringUtils.stringToNumber(request.getParameter("homescore"));
		int awayScore = StringUtils.stringToNumber(request.getParameter("awayscore"));
		
		MatchDao matchDao = MatchDao.getInstance();
		
		Match match = matchDao.getMatchByMatchNo(matchNo);
		match.setHomeScore(homeScore);
		match.setAwayScore(awayScore);
		match.setResult("FT");
		
		matchDao.updateMatchByMatchNo(match);
		
		return "redirect:detail.home?mno=" + matchNo;
	}

}

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

		int matchTeamNo = StringUtils.stringToNumber(request.getParameter("mno"));
		int homeScore = StringUtils.stringToNumber(request.getParameter("homescore"));
		int awayScore = StringUtils.stringToNumber(request.getParameter("awayscore"));
		
		MatchDao matchDao = MatchDao.getInstance();
		
		Match matchTeam = matchDao.getMatchByMatchNo(matchTeamNo);
		matchTeam.setHomeScore(homeScore);
		matchTeam.setAwayScore(awayScore);
		matchTeam.setResult("FT");
		
		matchDao.updateMatchTeamByMatchNo(matchTeam);
		
		return "redirect:detail.home?mno=" + matchTeamNo;
	}

}

	package controllers;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import commons.Controller;
import dao.TeamDao;
import util.StringUtils;
import vo.Team;

public class RankController implements Controller {
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		
		int leagueNo = StringUtils.stringToNumber(request.getParameter("lno"), 5);
		
		TeamDao teamDao = TeamDao.getInstance();
		Map<String, BigDecimal> winMap = teamDao.getTotalWinByLeagueNo(leagueNo);
		Map<String, BigDecimal> drawMap = teamDao.getTotalDrawByLeagueNo(leagueNo);
		Map<String, BigDecimal> loseMap = teamDao.getTotalLoseByLeagueNo(leagueNo);
		Map<String, BigDecimal> gfMap = teamDao.getTotalGFByLeagueNo(leagueNo);
		Map<String, BigDecimal> gaMap = teamDao.getTotalGAByLeagueNo(leagueNo);
		
		List<Team> teamList = teamDao.getTeamsByLeagueNo(leagueNo);
		
		List<Team> teamRank = new ArrayList<>();
		for(Team forTeam : teamList) {
			String teamName = forTeam.getName();
			int win = ((BigDecimal) winMap.get(teamName)).intValue();
			int draw = ((BigDecimal) drawMap.get(teamName)).intValue();
			int lose = ((BigDecimal) loseMap.get(teamName)).intValue();
			int gf = ((BigDecimal) gfMap.get(teamName)).intValue();
			int ga = ((BigDecimal) gaMap.get(teamName)).intValue();
			
			forTeam.setWin(win);
			forTeam.setDraw(draw);
			forTeam.setLose(lose);
			forTeam.setGf(gf);
			forTeam.setGa(ga);
			
			teamRank.add(forTeam);
		}
		
		request.setAttribute("cp", "list");
		request.setAttribute("teamRank", teamRank);
		
		return "list/rank.jsp";
	}
}

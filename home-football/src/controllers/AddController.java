package controllers;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import commons.Controller;
import dao.MatchDao;
import dao.TeamDao;
import util.DateUtils;
import util.StringUtils;
import vo.League;
import vo.MatchInfo;
import vo.MatchTeam;
import vo.Team;

public class AddController implements Controller {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		
		try {
			String notTimeDate = request.getParameter("date");
			Date matchDate = DateUtils.changeStrToDate(notTimeDate + request.getParameter("time"));
			int leagueNo = StringUtils.stringToNumber(request.getParameter("league"));
			int round = StringUtils.stringToNumber(request.getParameter("round"));

			League league = new League();
			league.setNo(leagueNo);
			
			MatchInfo matchInfo = new MatchInfo();
			matchInfo.setLeague(league);
			matchInfo.setMatchDate(matchDate);
			matchInfo.setRound(round);
			
			MatchDao matchDao = MatchDao.getInstance();
			MatchInfo searchMatch = matchDao.getMatchInfoByMatch(matchInfo);
			
			if(searchMatch == null) {
				int infoSeq = matchDao.getMatchInfoSequence();
				matchInfo.setNo(infoSeq);
				matchDao.addMatchInfo(matchInfo);
				searchMatch = matchDao.getMatchInfoByMatch(matchInfo);
			}
			
			int hometeamNo = StringUtils.stringToNumber(request.getParameter("hometeam"));
			int awayteamNo = StringUtils.stringToNumber(request.getParameter("awayteam"));
			
			TeamDao teamDao = TeamDao.getInstance();
			Team homeTeam = teamDao.getTeamByTeamNo(hometeamNo);
			Team awayTeam = teamDao.getTeamByTeamNo(awayteamNo);
			
			MatchTeam matchTeam = new MatchTeam();
			matchTeam.setHomeTeam(homeTeam);
			matchTeam.setAwayTeam(awayTeam);
			matchTeam.setMatchInfo(searchMatch);
			
			matchDao.addMatchTeam(matchTeam);
			
			return "redirect:list.home?matchdate=" + notTimeDate;
		} catch (ParseException e) {
			e.printStackTrace();
			throw new SQLException(e);
		}
		
	}
	
}

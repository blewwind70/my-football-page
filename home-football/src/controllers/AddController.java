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
import vo.Match;
import vo.Team;

public class AddController implements Controller {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		
		try {
			String notTimeDate = request.getParameter("date");
			Date matchdate = DateUtils.changeStrToDate(notTimeDate + request.getParameter("time"));
			int leagueNo = StringUtils.stringToNumber(request.getParameter("league"));
			int round = StringUtils.stringToNumber(request.getParameter("round"));

			League league = new League();
			league.setNo(leagueNo);
			
			MatchInfo matchInfo = new MatchInfo();
			matchInfo.setRound(round);
			matchInfo.setMatchdate(matchdate);
			matchInfo.setLeague(league);
			
			MatchDao matchDao = MatchDao.getInstance();
			MatchInfo searchMatchInfo = matchDao.getMatchInfoByMatchInfo(matchInfo);
			if(searchMatchInfo == null) {
				matchDao.addMatchInfo(matchInfo);
				searchMatchInfo  =  matchDao.getMatchInfoByMatchInfo(matchInfo);
			}
			
			String[] hometeamNoList = request.getParameter("hometeam").split(",");
			String[] awayteamNoList = request.getParameter("awayteam").split(",");
			
			TeamDao teamDao = TeamDao.getInstance();
			for(int i=0; i<hometeamNoList.length; i++) {
				int hometeamNo = StringUtils.stringToNumber(hometeamNoList[i]);
				int awayteamNo = StringUtils.stringToNumber(awayteamNoList[i]);
				Team hometeam = teamDao.getTeamByTeamNo(hometeamNo);
				Team awayteam = teamDao.getTeamByTeamNo(awayteamNo);
				
				Match match = new Match();
				match.setMatchInfo(searchMatchInfo);
				match.setHometeam(hometeam);
				match.setAwayteam(awayteam);
				matchDao.addMatch(match);
			}
			
			return "redirect:list.home?matchdate=" + notTimeDate;
		} catch (ParseException e) {
			e.printStackTrace();
			throw new SQLException(e);
		}
		
	}
	
}

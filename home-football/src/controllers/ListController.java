package controllers;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import commons.Controller;
import dao.MatchDao;
import util.DateUtils;
import vo.Match;

public class ListController implements Controller {
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		String matchDate = request.getParameter("matchdate");
		
		Date selectedDate = null; 
		try {
			if(matchDate != null) {
				selectedDate = DateUtils.changeNotTimeStrToDate(matchDate);
			} else {
				selectedDate = DateUtils.changeNotTimeStrToDate(DateUtils.changeNotTimeDateToString(new Date()));
			}			
		} catch (ParseException e) {
			e.getStackTrace();
			throw new SQLException(e);
		}
		
		List<Match> matchList = MatchDao.getInstance().getMatchesByDate(selectedDate);
		request.setAttribute("cp", "list");
		request.setAttribute("matchdate", matchDate);
		request.setAttribute("matchList", matchList);
		
		return "list/list.jsp";
	}

}

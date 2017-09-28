package controllers;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import commons.Controller;
import dao.MatchDao;
import util.StringUtils;
import vo.Match;

public class DetailController implements Controller {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		int matchNo = StringUtils.stringToNumber(request.getParameter("mno"));
		
		Match match = MatchDao.getInstance().getMatchByMatchNo(matchNo);
		request.setAttribute("match", match);
		
		return "list/detail.jsp";
	}

}

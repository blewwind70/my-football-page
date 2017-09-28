package util;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import dao.MatchDao;
import vo.Match;

public class Test {

	public static void main(String[] args) throws SQLException {

		List<Match> matchList = MatchDao.getInstance().getMatchesByDate(new Date());
		for(Match match : matchList) {
			System.out.println(match.getNo());
		}
	}
}

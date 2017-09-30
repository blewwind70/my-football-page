package util;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import dao.MatchDao;
import dao.TeamDao;
import vo.Match;
import vo.Team;

public class Test {

	public static void main(String[] args) throws SQLException {

		Map<String, BigDecimal> matchList = TeamDao.getInstance().getTotalWinByLeagueNo(5);
		System.out.println(matchList.get("Arsenal"));
	}
}

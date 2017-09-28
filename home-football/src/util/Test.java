package util;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import dao.TeamDao;
import vo.Team;

public class Test {

	public static void main(String[] args) throws SQLException {

		Map<String, BigDecimal> total = TeamDao.getInstance().getTotalWinByLeagueNo(1);
		List<Team> teamList = TeamDao.getInstance().getTeamsByLeagueNo(1);
		for(Team team : teamList) {
			int a = ((BigDecimal) total.get(team.getName())).intValue();
			System.out.println(a);
		}
	}
}

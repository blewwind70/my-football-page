package dao;

import java.sql.SQLException;
import java.util.List;

import util.IbatisUtils;
import vo.Team;

public class TeamDao {

	private static TeamDao self = new TeamDao();
	private TeamDao() {}
	public static TeamDao getInstance() {
		return self;
	}
	
	@SuppressWarnings("unchecked")
	public List<Team> getTeamsByLeagueNo(int leagueNo) throws SQLException {
		return IbatisUtils.getSqlMapClient().queryForList("team.getTeamsByLeagueNo", leagueNo);
	}
	
	public Team getTeamByTeamNo(int teamNo) throws SQLException {
		return (Team) IbatisUtils.getSqlMapClient().queryForObject("team.getTeamByTeamNo", teamNo);
	}
}

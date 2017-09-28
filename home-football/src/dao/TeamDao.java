package dao;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

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
	
	@SuppressWarnings("unchecked")
	public Map<String, BigDecimal> getTotalWinByLeagueNo(int leagueNo) throws SQLException {
		return IbatisUtils.getSqlMapClient().queryForMap("team.getTotalWinByLeagueNo", leagueNo, "NAME", "WIN");
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, BigDecimal> getTotalDrawByLeagueNo(int leagueNo) throws SQLException {
		return IbatisUtils.getSqlMapClient().queryForMap("team.getTotalDrawByLeagueNo", leagueNo, "NAME", "DRAW");
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, BigDecimal> getTotalLoseByLeagueNo(int leagueNo) throws SQLException {
		return IbatisUtils.getSqlMapClient().queryForMap("team.getTotalLoseByLeagueNo", leagueNo, "NAME", "LOSE");
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, BigDecimal> getTotalGFByLeagueNo(int leagueNo) throws SQLException {
		return IbatisUtils.getSqlMapClient().queryForMap("team.getTotalGFByLeagueNo",leagueNo, "NAME", "GF");
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, BigDecimal> getTotalGAByLeagueNo(int leagueNo) throws SQLException {
		return IbatisUtils.getSqlMapClient().queryForMap("team.getTotalGAByLeagueNo", leagueNo, "NAME", "GA");
	}
}

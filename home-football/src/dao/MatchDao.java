package dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import util.IbatisUtils;
import vo.MatchInfo;
import vo.MatchTeam;

public class MatchDao {

	private static MatchDao self = new MatchDao();
	private MatchDao() {}
	public static MatchDao getInstance() {
		return self;
	}
	
	public void addMatchInfo(MatchInfo matchInfo) throws SQLException {
		IbatisUtils.getSqlMapClient().insert("match.addMatchInfo", matchInfo);
	}
	
	public void addMatchTeam(MatchTeam matchTeam) throws SQLException {
		IbatisUtils.getSqlMapClient().insert("match.addMatchTeam", matchTeam);
	}
	
	public Integer getMatchInfoSequence() throws SQLException {
		return (Integer) IbatisUtils.getSqlMapClient().queryForObject("match.getMatchInfoSequence");
	}
	
	public MatchTeam getMatchByMatchNo(int matchTeamNo) throws SQLException {
		return (MatchTeam) IbatisUtils.getSqlMapClient().queryForObject("match.getMatchByMatchNo", matchTeamNo);
	}
	
	@SuppressWarnings("unchecked")
	public List<MatchTeam> getMatchesByDate(Date matchDate) throws SQLException {
		return IbatisUtils.getSqlMapClient().queryForList("match.getMatchesByDate", matchDate);
	}
	
	public MatchInfo getMatchInfoByMatch(MatchInfo matchInfo) throws SQLException {
		return (MatchInfo) IbatisUtils.getSqlMapClient().queryForObject("match.getMatchInfoByMatch", matchInfo);
	}
	
	public void updateMatchTeamByMatchNo(MatchTeam matchTeam) throws SQLException {
		IbatisUtils.getSqlMapClient().update("match.updateMatchTeamByMatchNo", matchTeam);
	}
}
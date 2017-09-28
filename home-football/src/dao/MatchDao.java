package dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import util.IbatisUtils;
import vo.MatchInfo;
import vo.Match;

public class MatchDao {

	private static MatchDao self = new MatchDao();
	private MatchDao() {}
	public static MatchDao getInstance() {
		return self;
	}
	
	public void addMatchInfo(MatchInfo matchInfo) throws SQLException {
		IbatisUtils.getSqlMapClient().insert("match.addMatchInfo", matchInfo);
	}
	
	public void addMatch(Match match) throws SQLException {
		IbatisUtils.getSqlMapClient().insert("match.addMatch", match);
	}
	
	public Match getMatchByMatchNo(int matchNo) throws SQLException {
		return (Match) IbatisUtils.getSqlMapClient().queryForObject("match.getMatchByMatchNo", matchNo);
	}
	
	@SuppressWarnings("unchecked")
	public List<Match> getMatchesByDate(Date matchDate) throws SQLException {
		return IbatisUtils.getSqlMapClient().queryForList("match.getMatchesByDate", matchDate);
	}
	
	public MatchInfo getMatchInfoByMatchInfo(MatchInfo matchInfo) throws SQLException {
		return (MatchInfo) IbatisUtils.getSqlMapClient().queryForObject("match.getMatchInfoByMatchInfo", matchInfo);
	}
	
	public void updateMatchByMatchNo(Match match) throws SQLException {
		IbatisUtils.getSqlMapClient().update("match.updateMatchByMatchNo", match);
	}
}

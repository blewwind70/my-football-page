package dao;

import java.sql.SQLException;
import java.util.List;

import util.IbatisUtils;
import vo.League;

public class LeagueDao {

	private static LeagueDao self = new LeagueDao();
	private LeagueDao() {}
	public static LeagueDao getInstance() {
		return self;
	}
	
	@SuppressWarnings("unchecked")
	public List<League> getLeguesByNationNo(int nationNo) throws SQLException {
		return IbatisUtils.getSqlMapClient().queryForList("league.getLeguesByNationNo", nationNo);
	}
}

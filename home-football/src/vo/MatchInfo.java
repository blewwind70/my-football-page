package vo;

import java.util.Date;

public class MatchInfo {

	private int no;
	private int round;
	private Date matchdate;
	private League league;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getRound() {
		return round;
	}
	public void setRound(int round) {
		this.round = round;
	}
	public Date getMatchdate() {
		return matchdate;
	}
	public void setMatchdate(Date matchdate) {
		this.matchdate = matchdate;
	}
	public League getLeague() {
		return league;
	}
	public void setLeague(League league) {
		this.league = league;
	}
	
}

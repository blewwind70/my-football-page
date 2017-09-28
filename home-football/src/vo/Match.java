package vo;

public class Match {

	private int no;
	private String result;
	private int homeScore;
	private int awayScore;
	private MatchInfo matchInfo;
	private Team homeTeam;
	private Team awayTeam;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public int getHomeScore() {
		return homeScore;
	}
	public void setHomeScore(int homeScore) {
		this.homeScore = homeScore;
	}
	public int getAwayScore() {
		return awayScore;
	}
	public void setAwayScore(int awayScore) {
		this.awayScore = awayScore;
	}
	public MatchInfo getMatchInfo() {
		return matchInfo;
	}
	public void setMatchInfo(MatchInfo matchInfo) {
		this.matchInfo = matchInfo;
	}
	public Team getHomeTeam() {
		return homeTeam;
	}
	public void setHomeTeam(Team homeTeam) {
		this.homeTeam = homeTeam;
	}
	public Team getAwayTeam() {
		return awayTeam;
	}
	public void setAwayTeam(Team awayTeam) {
		this.awayTeam = awayTeam;
	}
	
}

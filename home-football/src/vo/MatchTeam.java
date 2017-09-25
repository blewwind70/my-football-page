package vo;

public class MatchTeam {

	private int no;
	private Team homeTeam;
	private Team awayTeam;
	private int homeScore;
	private int awayScore;
	private String result;
	private MatchInfo matchInfo;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
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
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public MatchInfo getMatchInfo() {
		return matchInfo;
	}
	public void setMatchInfo(MatchInfo matchInfo) {
		this.matchInfo = matchInfo;
	}
	
}

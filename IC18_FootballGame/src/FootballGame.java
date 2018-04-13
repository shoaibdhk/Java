
public class FootballGame {
	private int mHomeScore;
	private String mHomeTeam;
	private int mVisitorScore;
	private String mVisitorTeam;
	// Constructor
	public FootballGame(String homeTeam, String visitorTeam) {
		super();
		mHomeScore = 0;
		mHomeTeam = homeTeam;
		mVisitorScore = 0;
		mVisitorTeam = visitorTeam;
	}
	//Getters
	public int getHomeScore() {
		return mHomeScore;
	}
	public int getVisitorScore() {
		return mVisitorScore;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + mHomeScore;
		result = prime * result + ((mHomeTeam == null) ? 0 : mHomeTeam.hashCode());
		result = prime * result + mVisitorScore;
		result = prime * result + ((mVisitorTeam == null) ? 0 : mVisitorTeam.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FootballGame other = (FootballGame) obj;
		if (mHomeScore != other.mHomeScore)
			return false;
		if (mHomeTeam == null) {
			if (other.mHomeTeam != null)
				return false;
		} else if (!mHomeTeam.equals(other.mHomeTeam))
			return false;
		if (mVisitorScore != other.mVisitorScore)
			return false;
		if (mVisitorTeam == null) {
			if (other.mVisitorTeam != null)
				return false;
		} else if (!mVisitorTeam.equals(other.mVisitorTeam))
			return false;
		return true;
	}
	@Override
	public String toString() {
		String message;
		if(mHomeScore> mVisitorScore)
			message = "Home team is winning";
		else if(mHomeScore == mVisitorScore)
			message = "It's a tie";
		else
			message = "Visitor team is winning";
		
		return "FootballGame ["+mHomeTeam + "=" + mHomeScore + ", " + mVisitorTeam + "="
				+ mVisitorScore + " ~~~ "+ message +"]";
	}
	// Miscellaneous
	
	public boolean scoreTouchdown(String teamName) {
		if(teamName.equals(mHomeTeam)) {
			mHomeScore+=6;
			return true;
		}
		else if(teamName.equals(mVisitorTeam)) {
			mVisitorScore+=6;
			return true;
		}
		else 
			return false;
	}
	
	public boolean scoreExtraPoint(String teamName) {
		if(teamName.equals(mHomeTeam)) {
			mHomeScore+=1;
			return true;
		}
		else if(teamName.equals(mVisitorTeam)) {
			mVisitorScore+=1;
			return true;
		}
		else 
			return false;
	}
	public boolean scoreConversion(String teamName) {
		if(teamName.equals(mHomeTeam)) {
			mHomeScore+=2;
			return true;
		}
		else if(teamName.equals(mVisitorTeam)) {
			mVisitorScore+=2;
			return true;
		}
		else 
			return false;
	}
	public boolean scoreFieldGoal(String teamName) {
		if(teamName.equals(mHomeTeam)) {
			mHomeScore+=3;
			return true;
		}
		else if(teamName.equals(mVisitorTeam)) {
			mVisitorScore+=3;
			return true;
		}
		else 
			return false;
	}
	public boolean scoreSafety(String teamName) {
		if(teamName.equals(mHomeTeam)) {
			mHomeScore+=2;
			return true;
		}
		else if(teamName.equals(mVisitorTeam)) {
			mVisitorScore+=2;
			return true;
		}
		else 
			return false;
	}
	
}

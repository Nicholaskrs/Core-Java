package zenoNK;

public class Score implements Comparable {

	
	private int score;
	private String name;
	private int rank;
	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public Score(int score, String name,int rank) {
		super();
		this.score = score;
		this.name = name;
		this.rank=rank;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method 
		int comparescore=((Score)o).getScore();
        return comparescore-this.score;
	}
	
}

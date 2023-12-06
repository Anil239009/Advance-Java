package pojos;
/*
 * id | name    | party    | votes            
 *
 */

import java.sql.Date;

public class Candidate {
	private int userId;
	private String name;
	private String party;
	private int votes;
	public Candidate() {
		// not required in JDBC , but required in Hibernate!
	}
	public Candidate(int userId, String name, String party, int votes) {
		super();
		this.userId = userId;
		this.name = name;
		this.party = party;
		this.votes = votes;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParty() {
		return party;
	}
	public void setParty(String party) {
		this.party = party;
	}
	public int getVotes() {
		return votes;
	}
	public void setVotes(int votes) {
		this.votes = votes;
	}
	@Override
	public String toString() {
		return "Candidate [userId=" + userId + ", name=" + name + ", party=" + party + ", votes=" + votes + "]";
	}
	
	
	
	

	
}

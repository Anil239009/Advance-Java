package dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import pojos.Candidate;

public interface CandidateDao {
	 List<Candidate> getAllCandidate() throws SQLException;
	 String updateVotings(int id) throws SQLException;
	 List<Candidate> topTwoCandidates()throws SQLException;
	 Map<String, Integer> partyWiseEntery()throws SQLException;
}

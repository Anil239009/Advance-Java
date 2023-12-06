package Tester;

import java.sql.SQLException;
import java.util.List;

import dao.CandidateDao;
import dao.CandidateDaoImple;
import pojos.Candidate;

public class CandidateTest {

	public static void main(String[] args) throws SQLException {
		CandidateDao candidate= new CandidateDaoImple();
		List<Candidate> list=candidate.getAllCandidate();
		
		list.forEach(e -> System.out.println(e));
		
	}

}

package Tester;

import java.sql.SQLException;
import java.util.List;

import dao.CandidateDao;
import dao.CandidateDaoImple;
import pojos.Candidate;

public class UpdateVoting {

	public static void main(String[] args) throws SQLException {
		CandidateDao candidate= new CandidateDaoImple();
		String result=candidate.updateVotings(1);
		String result1=candidate.updateVotings(2);
		String result2=candidate.updateVotings(1);
		String result3=candidate.updateVotings(3);
		String result4=candidate.updateVotings(4);
		String result5=candidate.updateVotings(3);
		String result6=candidate.updateVotings(2);
		String result7=candidate.updateVotings(3);
		String result8=candidate.updateVotings(2);
		String result9=candidate.updateVotings(1);

		System.out.println(result);
		
		
	}

}

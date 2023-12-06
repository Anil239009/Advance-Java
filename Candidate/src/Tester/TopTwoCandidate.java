package Tester;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import dao.CandidateDao;
import dao.CandidateDaoImple;
import pojos.Candidate;

public class TopTwoCandidate {

	public static void main(String[] args) throws SQLException {
		
		try(Scanner sc=new Scanner(System.in)) {
			List<Candidate>list=new ArrayList<Candidate>();
			CandidateDaoImple c1=new CandidateDaoImple();
			list=c1.topTwoCandidates();
			list.forEach(e->System.out.println(e));
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}

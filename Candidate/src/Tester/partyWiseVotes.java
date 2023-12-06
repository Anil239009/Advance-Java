package Tester;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

import dao.CandidateDao;
import dao.CandidateDaoImple;
import pojos.Candidate;

public class partyWiseVotes {

	public static void main(String[] args) throws SQLException {
		
		try(Scanner sc=new Scanner(System.in)) {
			CandidateDaoImple c1=new CandidateDaoImple();
			Map<String, Integer> map=c1.partyWiseEntery();
		
			for(Entry<String, Integer> e:map.entrySet()) {
				System.out.println(e.getKey()+" "+e.getValue());
				System.out.println();
			}
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}

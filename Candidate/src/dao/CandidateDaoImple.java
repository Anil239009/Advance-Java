package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static utils.DBUtils.*;
import pojos.Candidate;

public class CandidateDaoImple implements CandidateDao{
	private Connection cn;
	private PreparedStatement ptr1;
	private PreparedStatement pst2,pst3,pst4;
	
	public CandidateDaoImple() throws SQLException {
		super();
		cn=openConnection();
		ptr1=cn.prepareStatement("select * from candidates");
		pst2=cn.prepareStatement("update candidates set votes=votes+1 where id=?");
		pst3=cn.prepareStatement("select * from candidates order by votes desc limit 2");
		pst4=cn.prepareStatement("select party,sum(votes) from candidates group by party");
	}
	
	@Override
	public List<Candidate> getAllCandidate() throws SQLException {
		List<Candidate>list=new ArrayList<Candidate>();
		ResultSet data=ptr1.executeQuery();
		while(data.next()) {
			list.add(new Candidate(data.getInt(1),data.getString(2),data.getString(3),data.getInt(4)));
		}
		return list;
	}
	
	public String updateVotings(int id) throws SQLException {
		pst2.setInt(1, id);
		int rowCount=pst2.executeUpdate();
		if(rowCount==1) {
			return("Result status Updated successfully...!");
		}
		
		return "Voter is not found...!";
	}
	
	public List<Candidate> topTwoCandidates()throws SQLException{
		List<Candidate>list1=new ArrayList<>();
		ResultSet s1=pst3.executeQuery();
		while(s1.next()) {
			list1.add(new Candidate(s1.getInt(1),s1.getString(2),s1.getString(3),s1.getInt(4)));
		}
		return list1;
	}
	
	public Map<String, Integer> partyWiseEntery()throws SQLException{
		Map<String, Integer> map=new LinkedHashMap<String, Integer>();
		try(ResultSet s1=pst4.executeQuery()) {
			while(s1.next()) {
				map.put(s1.getString(1), s1.getInt(2));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
}

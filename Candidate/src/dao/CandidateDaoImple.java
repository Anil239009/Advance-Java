package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import static utils.DBUtils.*;
import pojos.Candidate;

public class CandidateDaoImple implements CandidateDao{
	private Connection cn;
	private PreparedStatement ptr1;
	
	public CandidateDaoImple() throws SQLException {
		super();
		cn=openConnection();
		ptr1=cn.prepareStatement("select * from candidates");
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
	
	
	
	
	
}

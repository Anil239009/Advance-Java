package Code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Student {
//	Driver load
//	connection established
//	statement creation
//	execute query
//	connection close
	public void createDatabase() {
		try {
			String url = "jdbc:mysql://localhost:3306/anil";
//			String db="anil";
			String username = "root";
			String password = "root123";

			Connection conn = DriverManager.getConnection(url, username, password);
			Statement stm = conn.createStatement();
			String query = "create database Anil";
			stm.execute(query);
			System.out.println("Connected Successfully...!");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createTable() {
		try {
			String url = "jdbc:mysql://localhost:3306/anil";
//			String db="anil";
			String username = "root";
			String password = "root123";

			Connection conn = DriverManager.getConnection(url, username, password);
			Statement stm = conn.createStatement();
			String query = "create table Student(rollno int(5), sname varchar(20), semail varchar(50))";
			stm.execute(query);
			System.out.println(" Table Connected Successfully...!");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createData() {
		try {
			String url = "jdbc:mysql://localhost:3306/";
			String db="anil";
			String username = "root";
			String password = "root123";

			Connection conn = DriverManager.getConnection(url+db, username, password);
			String query = "insert into student (?,?,?)";
			PreparedStatement pstm = conn.prepareStatement(query);
			
			pstm.setInt(1,10);
			pstm.execute();
			System.out.println("Data inserted Successfully...!");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

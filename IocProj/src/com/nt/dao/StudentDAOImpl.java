package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Random;

import javax.sql.DataSource;

import com.nt.bo.StudentBO;

public final class StudentDAOImpl implements StudentDAO{
	private static final  String   STUDENT_INSERT_QUERY="INSERT INTO LAYERED_STUDENT VALUES(?,?,?,?,?,?)";
	private DataSource ds;

	public StudentDAOImpl(DataSource ds) {
	   System.out.println("StudentDAOImpl:: 1-param constructor");
		this.ds = ds;
	}

	@Override
	public int insert(StudentBO bo) throws Exception {
		int count=0;
		Connection con=null;
		PreparedStatement ps=null;
		//get pooled jdbc con object
		con=ds.getConnection();
		//create PreparedStatement obj having SQL Query
		ps=con.prepareStatement(STUDENT_INSERT_QUERY);
		//set values to query params
		ps.setInt(1,new Random().nextInt(10000));
		ps.setString(2,bo.getSname());
		ps.setString(3,bo.getSadd());
		ps.setInt(4,bo.getTotal());
		ps.setFloat(5,bo.getAvg());
		ps.setString(6,bo.getResult());
      //execute the SQL Query
		count=ps.executeUpdate();
		
		//close jdbc objs
		ps.close();
		con.close();
		return count;
	}

}

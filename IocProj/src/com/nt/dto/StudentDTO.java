package com.nt.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class StudentDTO implements Serializable {
	private String sname;
	private  String sadd;
	private int m1,m2,m3;
	
	
}

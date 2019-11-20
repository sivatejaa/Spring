package com.nt.bo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/*@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode*/

@Data
public class StudentBO {
	
	private String sname;
	private  String sadd;
	private  int total;
	private float avg;
	private String result;
	
	
}

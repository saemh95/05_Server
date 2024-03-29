package edu.kh.sudoku.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Member {

	private String memberNo;
	private String memberId;
	private String memberPw;
	private String memberName;
	private String enrollDate;
	private String memberDeleteFlag;
	
}

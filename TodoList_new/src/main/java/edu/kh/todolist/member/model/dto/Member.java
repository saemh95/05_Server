package edu.kh.todolist.member.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member {

	private String memberNo;
	private String memberId;
	private String memberPw;
	private String memberNickname;
	private String enrollDate;
	private String memberDeleteFlag;
}

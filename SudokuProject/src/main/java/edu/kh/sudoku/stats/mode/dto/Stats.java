package edu.kh.sudoku.stats.mode.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Stats {

	private String gameId;
	private String gamePlayed;
	private String shortest;
	private String longest;
	
}

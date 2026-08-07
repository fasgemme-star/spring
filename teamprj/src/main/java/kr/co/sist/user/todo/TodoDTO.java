package kr.co.sist.user.todo;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class TodoDTO {
	private String title, content;
	private String[] representUserNo;
	private Timestamp startDate, endDate;
}

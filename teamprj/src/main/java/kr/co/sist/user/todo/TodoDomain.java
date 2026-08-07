package kr.co.sist.user.todo;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class TodoDomain {
	private String title, content, status;
	private String[] representUserNo;
	private Timestamp startDate, endDate;
}

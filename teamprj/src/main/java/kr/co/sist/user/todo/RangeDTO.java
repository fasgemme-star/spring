package kr.co.sist.user.todo;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class RangeDTO {
	private String content, RepresentativeUserNo, requestUserNo, isRepresented, isRequested;
	private Timestamp startDate, endDate;

}

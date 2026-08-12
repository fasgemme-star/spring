package kr.co.sist.user.todo;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("todoRangeDTO")
@Data
public class RangeDTO {
	private String content, RepresentativeUserNo, requestUserNo, isRepresented, isRequested;
	private Timestamp startDate, endDate;

}

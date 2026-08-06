package kr.co.sist.user.address;

import lombok.Data;

@Data
public class RangeDTO {
	private String name, phoneNumber, group, organization;
	private int startNum, endNum, totalCount, activeCount;
	
}

package kr.co.sist.user.address;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("addressRangeDTO")
@Data
public class RangeDTO {
	private String name, phoneNumber, group, organization, bookmarked, companyNo;
}

package kr.co.sist.user.address;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AddressMapper {
	public List<UserDomain> selectAddressList(RangeDTO rDTO);

	public List<GroupsDomain> selectGroup(String userNo);

	public List<OrganizationDomain> selectOrganization(String userNo);
	
	public UserDomain selectAddressDetail(String userNo);
	
	public int insertBookmark(String userNo, String targetNo);
	
	public int deleteBookmark(String userNo, String targetNo);
	
}

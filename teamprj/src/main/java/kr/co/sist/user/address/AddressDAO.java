package kr.co.sist.user.address;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class AddressDAO {

	public List<UserDomain> selectAddressList(RangeDTO rDTO) {
		List<UserDomain> list = new ArrayList<UserDomain>();
		return list;
	}

	public List<GroupsDomain> selectGroup(String companyNo) {
		List<GroupsDomain> list = new ArrayList<GroupsDomain>();
		return list;
	}
	
	public List<OrganizationDomain> selectOrganizaion(String companyNo) {
		List<OrganizationDomain> list = new ArrayList<OrganizationDomain>();
		return list;
	}
	
	public UserDomain selectAddressDetail(String userNo) {
		UserDomain ud = null;
		return ud;
	}
	
	public int selectIsBookmark(String userNo, String targetNo) {
		return 0;
	}
	
	public int insertBookmark(String userNo, String targetNo) {
		return 0;
	}
	
	public int deleteBookmark(String userNo, String targetNo) {
		return 0;
	}

}

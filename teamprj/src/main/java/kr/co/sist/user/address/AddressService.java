package kr.co.sist.user.address;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

	@Autowired(required = false)
	private AddressMapper am;
	 
	public List<UserDomain> getAddressList(RangeDTO rDTO) {
		List<UserDomain> list = null;
		list = am.selectAddressList(rDTO);
		return list;
	}
	
	public OrgGroupDomain getOrgGroup(String companyNo) {
		OrgGroupDomain ogd = null;
		List<OrganizationDomain> oList = new ArrayList<OrganizationDomain>();
		List<GroupsDomain> gList = new ArrayList<GroupsDomain>();
		
		oList = am.selectOrganization(companyNo);
		gList = am.selectGroup(companyNo);
		
		ogd.setOList(oList);
		ogd.setGList(gList);
		
		return ogd;
	}
	
	public UserDomain getAddressDetail(String userNo) {
		UserDomain ud = null;
		ud = am.selectAddressDetail(userNo);
		return ud;
	}
	
//	public boolean changeBookmark(String userNo, String targetNo) {
//		boolean flag = false;
//		if (am.selectIsBookmark(userNo, targetNo) == 1) {
//			am.deleteBookmark(userNo, targetNo);
//			flag = true;
//		} else {
//			am.insertBookmark(userNo, targetNo);
//			flag = true;
//		} // end else
//		return flag;
//	}

	
}

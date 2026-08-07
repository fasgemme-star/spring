package kr.co.sist.user.address;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

	@Autowired
	private AddressDAO aDAO;
	 
	public List<UserDomain> getAddressList(RangeDTO rDTO) {
		List<UserDomain> list = null;
		list = aDAO.selectAddressList(rDTO);
		return list;
	}
	
	public OrgGroupDomain getOrgGroup(String companyNo) {
		OrgGroupDomain ogd = null;
		List<OrganizationDomain> oList = new ArrayList<OrganizationDomain>();
		List<GroupsDomain> gList = new ArrayList<GroupsDomain>();
		
		oList = aDAO.selectOrganizaion(companyNo);
		gList = aDAO.selectGroup(companyNo);
		
		ogd.setOList(oList);
		ogd.setGList(gList);
		
		return ogd;
	}
	
	public UserDomain getAddressDetail(String userNo) {
		UserDomain ud = null;
		ud = aDAO.selectAddressDetail(userNo);
		return ud;
	}
	
	public boolean changeBookmark(String userNo, String targetNo) {
		boolean flag = false;
		if (aDAO.selectIsBookmark(userNo, targetNo) == 1) {
			aDAO.deleteBookmark(userNo, targetNo);
			flag = true;
		} else {
			aDAO.insertBookmark(userNo, targetNo);
			flag = true;
		} // end else
		return flag;
	}

	
}

package kr.co.sist.user.address;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

	@Autowired
	private AddressDAO aDAO;
	 
	public List<UserDomain> getAddressList(RangeDTO rDTO) {
		List<UserDomain> list = null;
		return list;
	}
	
	public List<OrgGroupDomain> getOrgGroup(String companyNo) {
		List<OrgGroupDomain> list = null;
		return list;
	}
	
	public UserDomain getAddressDetail(String userNo) {
		UserDomain ud = null;
		return ud;
	}

	
}

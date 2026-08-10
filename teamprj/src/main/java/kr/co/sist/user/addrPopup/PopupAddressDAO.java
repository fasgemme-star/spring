package kr.co.sist.user.addrPopup;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class PopupAddressDAO {
	List<UserDomain> selectAddressList(RangeDTO rDTO){
		List<UserDomain> list = null;
		return list;
	}
    
    // 그룹 조회
    List<GroupsDomain> selectGroup(String companyNo){
    	List<GroupsDomain> list = null;
    	return list;
    	
    }
    
    // 조직 조회
    List<OrganizationDomain> selectOrganization(String companyNo){
    	List<OrganizationDomain> list = null;
    	return list;
    }
}

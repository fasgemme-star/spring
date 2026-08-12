package kr.co.sist.user.addrPopup;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PopupAddressMapper {
	List<UserDomain> selectAddressList(RangeDTO rDTO);

	List<GroupsDomain> selectGroup(String userNo);

	List<OrganizationDomain> selectOrganization(String userNo);
}

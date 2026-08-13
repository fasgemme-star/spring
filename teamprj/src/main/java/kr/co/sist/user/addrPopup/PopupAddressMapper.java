package kr.co.sist.user.addrPopup;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PopupAddressMapper {
	public List<UserDomain> selectAddressList(RangeDTO rDTO);

	public List<GroupsDomain> selectGroup(String userNo);

	public 	List<OrganizationDomain> selectOrganization(String userNo);
}

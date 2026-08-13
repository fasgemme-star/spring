package kr.co.sist.user.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;

@Controller
public class AddressController {
	
	@Autowired(required = false)
	private AddressService as;

	@GetMapping("addressBook")
	public String showAddressPage(HttpSession session, RangeDTO rDTO, Model model) {
		rDTO.setCompanyNo((String)session.getAttribute("companyNo"));
		model.addAttribute("users", as.getAddressList(rDTO));
		return "user/addressBook";
	}
	
	@GetMapping("addressDetail")
	public String showAddressDetail(HttpSession session, String userNo) {
		return "user/addressBook";
	}
	
	@GetMapping("toggleFavorite")
	public String modifyBookmark(HttpSession session, String userNo) {
		return "user/addressBook";
	}

}

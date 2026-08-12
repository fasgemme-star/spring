package kr.co.sist.user.addrPopup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class PopupAddressController {
	
	@Autowired
	private PopupAddressService pas;

	@GetMapping("popupAddr")
	public String showAddrPopupPage(HttpSession session, Model model, RangeDTO rDTO) {
		rDTO.setCompanyNo("CO000001");
		model.addAttribute("users", pas.getAddressList(rDTO));
		model.addAttribute("groups", pas.getGroup("U000001"));
		model.addAttribute("organizations", pas.getOrganization("U000001"));
		
		return "popup/PopupAddr";
	}

}

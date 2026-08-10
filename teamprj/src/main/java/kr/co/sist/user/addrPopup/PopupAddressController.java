package kr.co.sist.user.addrPopup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class PopupAddressController {

	@GetMapping("popupAddr")
	public String showAddrPopupPage(HttpSession session, Model model) {
		

		
		return "popup/PopupAddr";
	}

}

package kr.co.sist.user.terms;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TermsController {
	
	@GetMapping("term")
	public String showNoticeDetail(Model model, String noticeNo) {
		return "";
	}
	

}

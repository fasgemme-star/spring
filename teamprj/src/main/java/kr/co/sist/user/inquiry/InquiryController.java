package kr.co.sist.user.inquiry;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class InquiryController {
	
	@GetMapping("inquiry")
	public String insertInquiry(MultipartFile mpf , InquiryDTO iDTO, Model model) {
		return "";
	}

}

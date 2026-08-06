package kr.co.sist.user.inquiry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class InquiryController {
	
	@Autowired
	private InquiryService is;
	
	@GetMapping("user/inquiry")
	public String showInquiry() {
		return "user/inquiry";
	}
	
	@GetMapping("inquiry")
	public String addInquiry(MultipartFile mpf , InquiryDTO iDTO, Model model) {
		is.createInquiry(iDTO);
		return "";
	}

}

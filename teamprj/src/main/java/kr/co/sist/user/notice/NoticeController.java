package kr.co.sist.user.notice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NoticeController {
	
	@GetMapping("user/notice")
	public String showNotice(Model model) {
		return "user/notice";
	}
	
	@GetMapping("notice")
	public String showNoticeDetail(Model model, String noticeNo) {
		return "";
	}
	

}

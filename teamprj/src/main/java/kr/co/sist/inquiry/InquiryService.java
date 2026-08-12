package kr.co.sist.inquiry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InquiryService {
	
	@Autowired
	private InquiryMapper im;
	
	public String createInquiry(InquiryDTO iDTO) {
		return im.insertInquiry(iDTO) == 1 ? "성공" : "실패";
	}// createInquiry

}

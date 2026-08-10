package kr.co.sist.inquiry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InquiryService {
	
	@Autowired
	private InquiryDAO iDAO;
	
	public String createInquiry(InquiryDTO iDTO) {
		String resultMsg = "실패";
		try {
			iDAO.insertInquiry(iDTO);
			resultMsg = "성공";
		} catch (Exception e) {
			e.printStackTrace();
		} // end catch
		return resultMsg;
	}// createInquiry

}

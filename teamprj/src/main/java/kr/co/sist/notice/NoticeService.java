package kr.co.sist.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeService {
	
	@Autowired
	private NoticeDAO nDAO;
	
	public List<NoticeDomain> getNoticeList(){
		List<NoticeDomain> list = null;
		list = nDAO.selectNotice();
		return list;
	}
	
	public NoticeDomain getNoticeDetail(String noticeNo) {
		NoticeDomain nd = null;
		nd = nDAO.selectNoticeDetail(noticeNo);
		return nd;
	}

}

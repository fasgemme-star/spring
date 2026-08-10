package kr.co.sist.notice;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class NoticeDAO {

	public List<NoticeDomain> selectNotice(){
		List<NoticeDomain> list = null;
		return list;
	}// selectNotice
	
	public NoticeDomain selectNoticeDetail(String noticeNo) {
		NoticeDomain nd = new NoticeDomain();
		return nd;
	}
	
}

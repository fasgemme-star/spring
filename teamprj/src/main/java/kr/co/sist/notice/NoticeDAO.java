package kr.co.sist.notice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class NoticeDAO {

	public List<NoticeDomain> selectNotice(){
		List<NoticeDomain> list = new ArrayList<NoticeDomain>();
		list.add(new NoticeDomain("N000001", "네이버웍스 접속이 안됩니다.", "내용들", null,""));
		list.add(new NoticeDomain("N000002", "ID 및 비밀번호가 생각나지 않습니다.", "내용들", null,""));
		list.add(new NoticeDomain("N000003", "최고관리자가 비밀번호를 잊어버렸습니다.", "내용들", null,""));
		list.add(new NoticeDomain("N000004", "본인 인증을 위한 인증번호가 오지 않아요.", "내용들", null,""));
		return list;
	}// selectNotice
	
	public NoticeDomain selectNoticeDetail(String noticeNo) {
		NoticeDomain nd = new NoticeDomain("N000001", "네이버웍스 접속이 안됩니다.", "내용들", null,"");
		return nd;
	}
	
}

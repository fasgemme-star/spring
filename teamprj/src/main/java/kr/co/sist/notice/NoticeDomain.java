package kr.co.sist.notice;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NoticeDomain {
	private String noticeNo, noticeTitle, content, files;
	private LocalDateTime createdDate;
	public NoticeDomain(String noticeNo, String noticeTitle, String content, String files, String createdDate) {
		this.noticeNo=noticeNo;
		this.noticeTitle=noticeTitle;
		this.content=content;
		this.files=files;
		
		this.createdDate = LocalDateTime.now();
	}

}

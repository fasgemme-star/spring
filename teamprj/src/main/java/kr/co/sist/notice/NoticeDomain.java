package kr.co.sist.notice;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class NoticeDomain {
	private String noticeNo, noticeTitle, content, files;
	private LocalDateTime createdDate;

}

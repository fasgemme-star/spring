package kr.co.sist.user.notice;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class NoticeDTO {
	private String noticeNo, noticeTitle, content, files;
	private LocalDateTime createdDate;

}

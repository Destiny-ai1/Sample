package com.example.demo.entity;

import java.time.*;
import java.time.format.*;

import com.example.demo.dto.*;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Board {
	private long bno;
	private String title;
	private String content;
	private String nickname;
	@Builder.Default
	private LocalDateTime writeTime = LocalDateTime.now();
	@Builder.Default
	private long readCnt= 0L;
	
	public BoardDto toDto() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String writeTime= dtf.format(this.writeTime);
		return new BoardDto(bno,title,content,nickname,writeTime,readCnt);
	}
}

package com.example.demo.dto;

import lombok.*;

@Getter
@AllArgsConstructor
public class BoardDto {
	private long bno;
	private String title;
	private String content;
	private String nickname;
	private String writeTime;
	private long readCnt;
}

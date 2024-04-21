package com.kdw.eip.workbook.domain.dto.req;

import com.kdw.eip.workbook.domain.entity.Workbook;

import lombok.Data;

@Data
public class WorkbookReqDto {
	private String question;
	private String answer;
	
	public Workbook toEntity() {
		return Workbook.builder()
				.question(this.question)
				.answer(this.answer)
				.build();
	}
}

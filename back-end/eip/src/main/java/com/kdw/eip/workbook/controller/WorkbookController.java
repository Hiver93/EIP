package com.kdw.eip.workbook.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kdw.eip.workbook.domain.dto.req.WorkbookReqDto;
import com.kdw.eip.workbook.domain.dto.resp.WorkbookRespDto;
import com.kdw.eip.workbook.service.WorkbookService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/workbook")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@AllArgsConstructor
public class WorkbookController {
	private WorkbookService workbookService;

	
	@GetMapping("")
	public ResponseEntity<List<WorkbookRespDto>> workbookList(){
		return new ResponseEntity<List<WorkbookRespDto>>(this.workbookService.getWorkbookList(), HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<String> register(@RequestBody WorkbookReqDto workbookReqDto){
		this.workbookService.createWorkbook(workbookReqDto.toEntity());
		return new ResponseEntity<String>("success",HttpStatus.CREATED);
	}
}

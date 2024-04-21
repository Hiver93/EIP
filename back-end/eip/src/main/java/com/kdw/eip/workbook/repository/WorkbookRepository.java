package com.kdw.eip.workbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kdw.eip.workbook.domain.entity.Workbook;

public interface WorkbookRepository extends JpaRepository<Workbook, Long> {
	
}

package com.study.studyspring.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
public class EmployeeeLocationController{
	@GetMapping("/hire/empmap")
	public String empLocation() {
		
		return "/hire/employee";
	}
}
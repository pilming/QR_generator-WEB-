package com.gd.QRGenerator.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gd.QRGenerator.Mapper.QRGeneratorMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class QRGeneratorController {
	@Autowired QRGeneratorMapper qrGeneratorMapper;
	
	@GetMapping({"/", "/homePage", "home"})
	public String homePage(Model model) {
		log.debug("컨트롤러 진입성공");
		List<String> studentName = qrGeneratorMapper.selectStudentName();
		log.debug("▶▶▶▶▶▶ QRGeneratorController.homePage studentName : "+ studentName);
		
		model.addAttribute("StudentName", studentName);
		return "homePage";
	}
}

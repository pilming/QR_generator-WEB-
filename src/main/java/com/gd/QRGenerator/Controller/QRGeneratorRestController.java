package com.gd.QRGenerator.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gd.QRGenerator.Service.QRGeneratorService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class QRGeneratorRestController {
	@Autowired QRGeneratorService qrGeneratorService;
	@GetMapping("/generateQR")
	public String generateQR(@RequestParam(value = "studentName") String studentName,
							HttpServletRequest request) {
		log.debug("▶▶▶▶▶QRGeneratorRestController.generateQR 매개변수 studentName :"+studentName);
		String ip = request.getHeader("X-Forwarded-For");
		 
		log.debug("▶▶▶▶▶QRGeneratorRestController.generateQR X-FORWARDED-FOR : " + ip);
 
        if (ip == null) {
            ip = request.getHeader("Proxy-Client-IP");
            log.debug("▶▶▶▶▶QRGeneratorRestController.generateQR Proxy-Client-IP : " + ip);
        }
        if (ip == null) {
            ip = request.getHeader("WL-Proxy-Client-IP"); // 웹로직
            log.debug("▶▶▶▶▶QRGeneratorRestController.generateQR WL-Proxy-Client-IP : " + ip);
        }
        if (ip == null) {
            ip = request.getHeader("HTTP_CLIENT_IP");
            log.debug("▶▶▶▶▶QRGeneratorRestController.generateQR HTTP_CLIENT_IP : " + ip);
        }
        if (ip == null) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            log.debug("▶▶▶▶▶QRGeneratorRestController.generateQR HTTP_X_FORWARDED_FOR : " + ip);
        }
        if (ip == null) {
            ip = request.getRemoteAddr();
        }
        
        log.debug("▶▶▶▶▶QRGeneratorRestController.generateQR Result : IP Address : "+ip);

		String QRImageFile = qrGeneratorService.generateQR(studentName, ip);
		
		return QRImageFile;
	}
}

package com.gd.QRGenerator.Service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gd.QRGenerator.Mapper.QRGeneratorMapper;
import com.gd.QRGenerator.Vo.Student;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Service
public class QRGeneratorService {
	@Autowired QRGeneratorMapper qrGeneratorMapper;
	public String generateQR(String studentName, String ip) {
		log.debug("▶▶▶▶▶QRGeneratorService. generateQR 매개변수 studentName :"+studentName);
		
		Student studentInfo = qrGeneratorMapper.selectStudentInfoByName(studentName);
		
		StringBuffer contents = new StringBuffer();
		
		contents.append("course : (디지털 컨버전스)자바/스프링 기반 SW개발자 양성과정(3) (21-03-02 ~ 21-08-10)\n");
		contents.append("student id : " + studentInfo.getId()+"\n");
		contents.append("student name : " + studentInfo.getName()+"\n");
		contents.append("student gender : " + studentInfo.getGender()+"\n");
		contents.append("student gitHub address : " + studentInfo.getGitHubAddress()+"\n");
		contents.append("create ip address : " + ip +"\n");
		SimpleDateFormat timeFormat = new SimpleDateFormat ( "yyyy/MM/dd HH시mm분ss초");
		Date time = new Date();
		String createTime = timeFormat.format(time);
		contents.append("QR createTime : " + createTime);
		
        //2.QR생성
        QRCodeWriter qrWriter = new QRCodeWriter();
        
        //qr이미지 관련(모양, 컨테츠)
        //한글 인코딩
        String info = contents.toString();
        log.debug("▶▶▶▶▶QRGeneratorService.generateQR info :"+info);
        try {
        	info = new String(contents.toString().getBytes("UTF-8"), "ISO-8859-1");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
        
        log.debug("▶▶▶▶▶QRGeneratorService.generateQR info :"+info);
        
        BitMatrix matrix = null;
		try {
			matrix = qrWriter.encode(info, BarcodeFormat.QR_CODE, 300, 300);
		} catch (WriterException e) {
			e.printStackTrace();
		}
        //qr설정관련(색상)
        //MatrixToImageConfig config = new MatrixToImageConfig(0xFFFFFFFF, 0xFF000000);
        //두개의 설정 매개변수를 이용하여 이미지 생성
        BufferedImage qrImage = MatrixToImageWriter.toBufferedImage(matrix);
        
        
        //3.QR저장 
        File path = new File("");
        System.out.println(path.getAbsolutePath());
        
        String QRImageFilePath = path+"src/main/webapp/resources/img/"+studentName+"QRImageFile.png";
        String QRImageFile = "resources/img/"+studentName+"QRImageFile.png";
        try {
			ImageIO.write(qrImage, "png", new File(QRImageFilePath));
		} catch (IOException e) {
			e.printStackTrace();
		} //(메모리안의이미지, 확장자, 파일생성)
		
		return QRImageFile;
	}
}

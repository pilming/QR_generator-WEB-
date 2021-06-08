package com.gd.QRGenerator.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gd.QRGenerator.Vo.Student;

@Mapper
public interface QRGeneratorMapper {
	List<String> selectStudentName(); 
	Student selectStudentInfoByName(String studentName);
}

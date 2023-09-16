package egovframework.let.temp.service.impl;

import java.util.List;

import egovframework.let.temp.service.TempVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Mapper("temp2Mapper") //mapper 명이 같으면 안되기 때문에 바꿔줌.
public interface Temp2Mapper {

	TempVO selectTemp(TempVO vo) throws Exception; 
	
	//임시데이터 목록 가져오기
	List<EgovMap> selectTempList(TempVO vo) throws Exception;
	
	//임시데이터 등록
	void insertTemp(TempVO vo) throws Exception; 
	
	//임시데이터 수정하기
	void updateTemp(TempVO vo) throws Exception;
	
	//임시데이터 삭제하기
	void deleteTemp(TempVO vo) throws Exception;
} 
	


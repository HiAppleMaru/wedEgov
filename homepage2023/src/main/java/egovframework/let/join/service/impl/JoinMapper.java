package egovframework.let.join.service.impl;

import java.util.List;

import egovframework.let.board.service.BoardVO;
import egovframework.let.join.service.JoinVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Mapper("joinMapper")
public interface JoinMapper {
	
	//ID 중복체크
	int duplicateCheck(JoinVO vo) throws Exception;

	//회원등록
	void insertJoin(JoinVO vo) throws Exception;
} 
	


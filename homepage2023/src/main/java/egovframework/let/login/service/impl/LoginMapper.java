package egovframework.let.login.service.impl;

import java.util.List;

import egovframework.com.cmm.LoginVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Mapper("loginMapper")
public interface LoginMapper {
	
	//일반 로그인을 처리한다
	public LoginVO actionLogin(LoginVO vo) throws Exception;
} 
	


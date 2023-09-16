package egovframework.let.login.service;

import java.util.List;

import egovframework.com.cmm.LoginVO;
import egovframework.rte.psl.dataaccess.util.EgovMap;

public interface LoginService {
	
	//일반 로그인을 처리
	public LoginVO actionLogin(LoginVO vo) throws Exception;
	
}

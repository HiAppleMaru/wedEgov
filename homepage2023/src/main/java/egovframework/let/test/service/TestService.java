package egovframework.let.test.service;

import java.util.List;


import egovframework.rte.psl.dataaccess.util.EgovMap;

public interface TestService {
	
	//게시물 목록 긁어오자
	public List<EgovMap> selectTestList(TestVO vo) throws Exception;
	
	//게시물 목록 수
	public int selectTestListCnt(TestVO vo) throws Exception;
	
	//게시물 등록하자
	public String insertTest(TestVO vo) throws Exception;
	
	//게시물 들여다보자
	public TestVO selectTest(TestVO vo) throws Exception;
	
	//게시물 고쳐보자
	public void updateTest(TestVO vo) throws Exception;
	
	//게시물 날려보자
	public void deleteTest(TestVO vo) throws Exception;
}

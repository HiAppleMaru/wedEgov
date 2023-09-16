package egovframework.let.test.service.impl;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import egovframework.let.test.service.TestVO;

@Mapper("testMapper")
public interface TestMapper {
	
	//테스트 목록 긁어오기
	List<EgovMap> selectTestList(TestVO vo);
	
	//테스트 목록 수
	int selectTestListCnt(TestVO vo);
	
	//테스트 등록
	void insertTest(TestVO vo);

	//테스트 상세정보
	TestVO selectTest(TestVO vo);

	//테스트 수정하기
	void updateTest(TestVO vo);

	//테스트 삭제하기
	void deleteTest(TestVO vo);

	

	
}

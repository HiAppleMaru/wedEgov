package egovframework.let.test.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import egovframework.let.test.service.TestService;
import egovframework.let.test.service.TestVO;

@Service("testService")
public class TestServiceImpl extends EgovAbstractServiceImpl implements TestService {

	@Resource(name="testMapper")
	private TestMapper testMapper;
	
	@Resource(name= "egovTestIdGnrService")
	private EgovIdGnrService idgenService;

	//테스트 목록 긁어오자
	public List<EgovMap> selectTestList(TestVO vo) throws Exception {
		return testMapper.selectTestList(vo);
	}

	//테스트 목록 수
	public int selectTestListCnt(TestVO vo) throws Exception {
		return testMapper.selectTestListCnt(vo);
	}

	//테스트 등록
	public String insertTest(TestVO vo) throws Exception {
		String id = idgenService.getNextStringId();
		vo.setTestId(id);
		testMapper.insertTest(vo);
		
		return id;
	}

	//테스트 상세정보
	public TestVO selectTest(TestVO vo) throws Exception {
		return testMapper.selectTest(vo);
	}

	//테스트 수정하기
	public void updateTest(TestVO vo) throws Exception {
		testMapper.updateTest(vo);
	}

	//테스트 삭제하기
	public void deleteTest(TestVO vo) throws Exception {
		testMapper.deleteTest(vo);
	}
	
	

}

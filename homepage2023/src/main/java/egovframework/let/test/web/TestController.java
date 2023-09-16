package egovframework.let.test.web;

import java.util.List;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.service.EgovFileMngService;

import egovframework.com.cmm.util.EgovUserDetailsHelper;


import egovframework.let.test.service.TestService;
import egovframework.let.test.service.TestVO;
import egovframework.let.utl.fcc.service.EgovStringUtil;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;


@Controller
public class TestController {

	@Resource(name = "testService")
	private TestService testService;
	
	@Resource(name = "EgovFileMngService")
	private EgovFileMngService fileMngService;
	
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertyService;
	
	//테스트 목록 긁어오기
	@RequestMapping(value = "/test/testSelectList.do")
	public String selectList(@ModelAttribute("searchVO") TestVO searchVO, HttpServletRequest request, ModelMap model) throws Exception{
		PaginationInfo paginationInfo = new PaginationInfo();
		
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());
		
		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
		List<EgovMap> resultList = testService.selectTestList(searchVO);
		model.addAttribute("resultList", resultList);
		
		int totCnt = testService.selectTestListCnt(searchVO);
		
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);
		
		LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
		model.addAttribute("USER_INFO", user);
		
		return "test/TestSelectList";
	}
	
	//게시글 등록/수정
	@RequestMapping(value = "/test/testRegist.do")
	public String testRegist(@ModelAttribute("searchVO") TestVO testVO, HttpServletRequest request, ModelMap model) throws Exception{
		LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
		if(user == null || user.getId() == null) {
			model.addAttribute("message", "로그인 후 사용가능합니다.");
			return "forward:/test/testSelectList.do";
		} else {
			model.addAttribute("USER_INFO", user);
		}
		
		TestVO result = new TestVO();
		if(!EgovStringUtil.isEmpty(testVO.getTestId())) {
			result = testService.selectTest(testVO);
			//본인 및 관리자만 허용
			if(!user.getId().equals(result.getFrstRegisterId()) && !"admin".equals(user.getId())) {
				model.addAttribute("message", "작성자 본인만 확인 가능합니다.");
				return "forward:/test/testSelectList.do";
			}
		}
		model.addAttribute("result", result);
		
		request.getSession().removeAttribute("sessionBoard");
		
		return "test/TestRegist";
	}
	
	//게시물 등록하기
	@RequestMapping(value = "/test/testInsert.do")
	public String insert ( 
	TestVO searchVO, HttpServletRequest request, ModelMap model) throws Exception {
				
		LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
		if(user == null || user.getId() == null) {
			model.addAttribute("message", "로그인 후 사용가능합니다.");
			return "forward:/test/testSelectList.do";
		}
		testService.insertTest(searchVO);
		
		return "forward:/test/testSelectList.do";
	}
	
	//게시물 가져오기
	@RequestMapping(value = "/test/testSelect.do")
	public String select(@ModelAttribute("searchVO") TestVO searchVO, HttpServletRequest request, ModelMap model) throws Exception {
		LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
		model.addAttribute("USER_INFO", user);
		
		TestVO result = testService.selectTest(searchVO);
		
		model.addAttribute("result", result);
		return "test/TestSelect";
	}
	
	//게시물 수정하기
	@RequestMapping(value = "/test/testUpdate.do")
	public String update(final MultipartHttpServletRequest multiRequest, @ModelAttribute("searchVO") TestVO searchVO, HttpServletRequest request, ModelMap model) throws Exception{
		
		LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
		if(user == null || user.getId() == null) {
			model.addAttribute("message", "로그인 후 사용가능합니다.");
			return "forward:/test/testSelectList.do";}


		
		searchVO.setUserNm(user.getId());
		
		testService.updateTest(searchVO);
		
		//이중 서브밋 방지
		request.getSession().setAttribute("sessionBoard", searchVO);
		return "forward:/test/testSelectList.do";
	}
	
	//게시물 삭제하기
	@RequestMapping(value = "/test/testDelete.do")
	public String delete(@ModelAttribute("searchVO") TestVO searchVO, HttpServletRequest request, ModelMap model) throws Exception{
		LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
		if(user == null || user.getId() == null) {
			model.addAttribute("message", "로그인 후 사용가능합니다.");
			return "forward:/test/testSelectList.do";
		}
		searchVO.setUserNm(user.getId());
		
		testService.deleteTest(searchVO);
		
		return "forward:/test/testSelectList.do";
	}
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	


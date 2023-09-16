package egovframework.let.member.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.com.cmm.LoginVO;
import egovframework.let.join.service.JoinService;
import egovframework.let.join.service.JoinVO;
import egovframework.let.login.service.LoginService;
import egovframework.let.member.service.MemberService;
import egovframework.let.member.service.MemberVO;
import egovframework.let.utl.fcc.service.EgovStringUtil;
import egovframework.let.utl.sim.service.EgovFileScrty;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.rte.fdl.property.EgovPropertyService;

import egovframework.rte.psl.dataaccess.util.EgovMap;


@Service("memberService")
public class MemberServiceImpl extends EgovAbstractServiceImpl implements MemberService { 

	@Resource(name="memberMapper")
	private MemberMapper memberMapper;
	
	//회원ID찾기
	public MemberVO findId(MemberVO vo) throws Exception{
		return memberMapper.findId(vo);
	}

	//회원비밀번호찾기
	public MemberVO findPassword(MemberVO vo) throws Exception {
		return memberMapper.findPassword(vo);
	}

	//회원비밀번호업데이트
	public void passwordUpdate(MemberVO vo) throws Exception {
		//입력한 비밀번호를 암호화한다.
		String enpassword = EgovFileScrty.encryptPassword(vo.getPassword(), vo.getEmplyrId());
		vo.setPassword(enpassword);
		
		memberMapper.passwordUpdate(vo);
		
	}	
	
	//회원목록
	public List<EgovMap> selectMberList(MemberVO vo) throws Exception{
		return memberMapper.selectMberList(vo);
	}
	
	//회원목록 수
	public int selectMberListCnt(MemberVO vo) throws Exception{
		return memberMapper.selectMberListCnt(vo);
	}

	//회원상세
	public EgovMap selectMber(MemberVO vo) throws Exception {
		return memberMapper.selectMber(vo);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
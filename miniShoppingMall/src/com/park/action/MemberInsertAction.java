package com.park.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.park.dao.MemberDao;
import com.park.dto.Address;
import com.park.dto.Member;

public class MemberInsertAction implements Action {

	@Override
	public ActionForward action(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//페이지 이동방식과 경로 객체생성
		ActionForward forward = new ActionForward();
		//가입할 회원정보를 담을 객체와 가입처리 메서드 객체 생성
		MemberDao memberDao = new MemberDao();
		Member member = new Member();
		
		//임의 값 셋팅 나중에 jsp에서 넘어온 입력값으로 바꿔야함
		//int id = 1;
		String name = request.getParameter("name");
		String city = request.getParameter("city");		
		String street = request.getParameter("street");		
		String zipcode = request.getParameter("zipcode");
		
		//입력값 멤버 객체에 셋팅
		//member.setId(id);
		member.setName(name);
		member.setAddress(new Address());
		member.getAddress().setCity(city).setStreet(street).setZipcode(zipcode);
		
		//회원가입 Insert메서드 호출
		memberDao.memberInsert(member);
		
		forward.setRedirect(true);
		forward.setPath("/Mini/Main.do");
		
		return forward;
	}

}

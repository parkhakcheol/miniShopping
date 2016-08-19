package com.park.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.park.dao.MemberDao;
import com.park.dto.Address;
import com.park.dto.Member;

public class MemberInsertAction implements Action {

	@Override
	public ActionForward action(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//������ �̵���İ� ��� ��ü����
		ActionForward forward = new ActionForward();
		//������ ȸ�������� ���� ��ü�� ����ó�� �޼��� ��ü ����
		MemberDao memberDao = new MemberDao();
		Member member = new Member();
		
		//���� �� ���� ���߿� jsp���� �Ѿ�� �Է°����� �ٲ����
		//int id = 1;
		String name = request.getParameter("name");
		String city = request.getParameter("city");		
		String street = request.getParameter("street");		
		String zipcode = request.getParameter("zipcode");
		
		//�Է°� ��� ��ü�� ����
		//member.setId(id);
		member.setName(name);
		member.setAddress(new Address());
		member.getAddress().setCity(city).setStreet(street).setZipcode(zipcode);
		
		//ȸ������ Insert�޼��� ȣ��
		memberDao.memberInsert(member);
		
		forward.setRedirect(true);
		forward.setPath("/Mini/Main.do");
		
		return forward;
	}

}

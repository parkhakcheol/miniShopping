package com.park.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.park.dao.ItemDao;
import com.park.dto.Category;

public class ItemInsertForm implements Action{

	@Override
	public ActionForward action(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//������ �̵���İ� ��� ��ü����
		ActionForward forward = new ActionForward();
		//������ ��Ͻ� ������ ī�װ��������� ���� ����Ʈ ����
		ArrayList<Category> categoryList = new ArrayList<Category>();
		ItemDao itemDao = new ItemDao();
		
		categoryList = itemDao.categoryList();
		
		request.setAttribute("categoryList", categoryList);
		
		forward.setRedirect(false);
		forward.setPath("/insert/item_insert_form.jsp");
		
		return forward;
	}

}

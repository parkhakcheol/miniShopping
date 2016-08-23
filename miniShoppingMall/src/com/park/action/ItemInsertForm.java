package com.park.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.park.dao.ItemDao;
import com.park.dto.Category;

public class ItemInsertForm implements Action{

	@Override
	public ActionForward action(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//페이지 이동방식과 경로 객체생성
		ActionForward forward = new ActionForward();
		//아이템 등록시 보여질 카테고리정보들을 담을 리스트 선언
		ArrayList<Category> categoryList = new ArrayList<Category>();
		ItemDao itemDao = new ItemDao();
		
		categoryList = itemDao.categoryList();
		
		request.setAttribute("categoryList", categoryList);
		
		forward.setRedirect(false);
		forward.setPath("/insert/item_insert_form.jsp");
		
		return forward;
	}

}

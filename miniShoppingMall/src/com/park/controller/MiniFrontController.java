package com.park.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.park.action.Action;
import com.park.action.ActionForward;
import com.park.action.MemberInsertAction;


//@WebServlet("/MiniFrontController")
public class MiniFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MiniFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void doPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("��Ʈ�ѷ� �۵�");
    	request.setCharacterEncoding("utf-8");
    	//��û ���� �ּ�
    	String command = request.getServletPath();
    	
    	Action actionInterface = null;
    	ActionForward forward = null;
    	
    	if(command.equals("/Mini/MemberInsertForm.do")){
    		System.out.println("����ȭ������ �̵�");
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath(request.getContextPath() + "/minsert/m_insert_form.jsp");
			
    	} else if(command.equals("/Mini/MemberInsertAction.do")){
    		System.out.println("����ó���� �̵�");
    		actionInterface = new MemberInsertAction();
    		try {
				forward = actionInterface.action(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	
    	
    	if(forward != null){
			if(forward.isRedirect()){
				
				response.sendRedirect(forward.getPath());
			}else{
				
				RequestDispatcher dispatcher=
					request.getRequestDispatcher(forward.getPath());
				System.out.println(forward.getPath() + "<--- forward.getPath()[jsp �̵����]  MiniFrontController.java");
				System.out.println();
				dispatcher.forward(request, response);
				destroy();
			}
		}
    	
    	
    	
    	
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPro(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPro(request, response);
	}

}

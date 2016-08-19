package com.park.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	public ActionForward action(HttpServletRequest request,HttpServletResponse response) throws Exception;
}

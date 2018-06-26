package com.sve.util;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *  接收页面传过来的手机号码
 *  @作者 soft01
 *  2018年6月26日下午4:30:12
 */
@WebServlet("/sendSMS")
public class SendSMS extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String phone = request.getParameter("phone");
		String code = GetMessageCode.getCode(phone);
		System.out.println(code);
		response.getWriter().print(code);
	}

}

package com.sve.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *  验证 输入的验证码和短信验证码
 *  @作者 soft01
 *  2018年6月27日下午3:47:06
 */
@WebServlet("/validateCode")
public class ValidateCode extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		boolean flag = false;
		request.setCharacterEncoding("UTF-8");//POST请求
		response.setContentType("text/html;charset=UTF-8");
		String yzm = request.getParameter("yzm");
		PrintWriter out = response.getWriter();
		String code = (String) session.getAttribute("sms_code");
		System.out.println(yzm+"----"+code);
		if(!(code.equals(yzm))) {
			System.out.println("验证失败");
			out.print(flag);
		}else {
			flag = true;
			out.print(flag);
		}
		
	}

	
	
}

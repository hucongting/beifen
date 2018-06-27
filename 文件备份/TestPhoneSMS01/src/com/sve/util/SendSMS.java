package com.sve.util;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *  接收页面传过来的手机号码
 *  测试根据手机号接收的验证码
 *  @作者 soft01
 *  2018年6月26日下午4:30:12
 */
@WebServlet("/sendSMS")
public class SendSMS extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String phone = request.getParameter("phone");
		//获取验证码
		//String code = GetMessageCode.getCode(phone);
		//测试数据
		String code = "123465";
		session.setAttribute("sms_code", code);
		String str = (String) session.getAttribute("sms_code");
		System.out.println(phone+"----> 验证码："+str);
		

	}

}

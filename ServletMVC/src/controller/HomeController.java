package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Test2Service;

@WebServlet("*.mvc")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 요청한 주소를 가져온다.
		String url = request.getRequestURI();
		// View로 사용할 JSP
		String viewName = null;

		if (url.contains("main.mvc")) {
			viewName = "main.jsp";
		} else if (url.contains("test1.mvc")) {

			// 파라미터 데이터 추출
			String str1 = request.getParameter("data1");
			String str2 = request.getParameter("data2");

			// 파라미터 값을 숫자로 변환
			int number1 = Integer.parseInt(str1);
			int number2 = Integer.parseInt(str2);

			int result = number1 + number2;

			request.setAttribute("result", result);

			viewName = "test1.jsp";
		} else if (url.contains("test2.mvc")) {

			// 모델 요청
			int result = Test2Service.minus(request);

			request.setAttribute("result", result);

			viewName = "test2.jsp";
		}

		RequestDispatcher dis = request.getRequestDispatcher(viewName);
		dis.forward(request, response);

	}

}

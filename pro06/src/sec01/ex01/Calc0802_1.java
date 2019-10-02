package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Calc0802_1
 */
@WebServlet("/Day0802_1")
public class Calc0802_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Calc0802_1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pw = response.getWriter();
		String command = request.getParameter("command");
		String num1 = request.getParameter("num1");
		String num2 = request.getParameter("num2");
		String operator = request.getParameter("operator");

		if(command != null && command.equals("calculate")) {
			String result = calculate(Float.parseFloat(num1), Float.parseFloat(num2), operator);
			pw.print("<html><font size=5>변환 결과</font><br>");
			pw.print("<html><font size=5>" + result + "</font><br>");
			pw.print("<a href= '/pro06/Day0802_1.html'>계산기</a>");
			return;
		}
	}
	
	private static String calculate(float num1, float num2,String operator) {
		String result = null;
		if(operator.equals("+")) {
			result = String.format("%.6f", num1 + num2 );
		}else if(operator.equals("-")) {
			result = String.format("%.6f", num1 - num2);
		}else if(operator.equals("*")) {
			result = String.format("%.6f", num1 * num2);
		}else if(operator.equals("/")) {
			result = String.format("%.6f", num1 / num2 );
		}
		return result;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

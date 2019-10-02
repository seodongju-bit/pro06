package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Calc0802
 */
@WebServlet("/Day0802")
public class Calc0802 extends HttpServlet {
	private static float USD_RATE = 1124.70F;
	private static float JPY_RATE = 10.113F;
	private static float CNY_RATE = 163.30F;
	private static float GBP_RATE = 1444.35F;
	private static float EUR_RATE = 1295.97F;
	private static final long serialVersionUID = 1L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public Calc0802() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("0802실습 호출");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pw = response.getWriter();
		String command = request.getParameter("command");
		String won = request.getParameter("won");
		String operator = request.getParameter("operator");

		if(command != null && command.equals("calculate")) {
			String result = calculate(Float.parseFloat(won), operator);
			pw.print("<html><font size=5>변환 결과</font><br>");
			pw.print("<html><font size=5>" + result + "</font><br>");
			pw.print("<a href= '/pro06/Day0802.html'>환율 계산기</a>");
			return;
		}
	}
	
	private static String calculate(float won, String operator) {
		String result = null;
		if(operator.equals("dollar")) {
			result = String.format("%.6f", won / USD_RATE);
		}else if(operator.equals("en")) {
			result = String.format("%.6f", won / JPY_RATE);
		}else if(operator.equals("wian")) {
			result = String.format("%.6f", won / CNY_RATE);
		}else if(operator.equals("pound")) {
			result = String.format("%.6f", won / GBP_RATE);
		}else if(operator.equals("euro")) {
			result = String.format("%.6f", won / EUR_RATE);
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

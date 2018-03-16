package examples.ejb.client;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import examples.ejb.basic.stateful.EmployeeLocal;

/**
 * Servlet implementation class StatefulEmployeeServlet
 */
@WebServlet("/StatefulEmployeeServlet")
public class StatefulEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	@EJB
	private EmployeeLocal statefulE1;
	@EJB
	private EmployeeLocal statefulE2;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StatefulEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html><html><head>");
		out.println("<title>Lab1</title>");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("</head><body>");
		out.println("<h3>Stateful Employee</h3>"+"<br>");
		out.println("Stateful Employee 1 skapad: ");
		statefulE1.setName("Rolke Af Sturup");
		out.println(statefulE1.getName()+"<br>");
		out.println("Stateful Employee 2 skapad: ");
		statefulE2.setName("Mats Af Lund");
		out.println(statefulE2.getName()+"<br>");
		out.println("Stateful Employee 1 : "+statefulE1.getName()+" - Borde vara <b>Rolke Af Sturup</b><br>");
		out.println("Stateful keeps the state!");
		out.println("</body></html>");
		statefulE1.remove();
		statefulE2.remove();
	}

}

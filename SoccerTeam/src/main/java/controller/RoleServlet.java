package controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import domain.Role;
import exception.DAOException;
import dao.RoleDbDAO;
import dao.ConnectionProperty;
/**
* Servlet implementation class RoleServlet
*/
@WebServlet("/role")
public class RoleServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
ConnectionProperty prop;
/**
* @throws IOException
* @throws FileNotFoundException
* @see HttpServlet#HttpServlet()
*/
public RoleServlet() throws FileNotFoundException, IOException {
	super();
// TODO Auto-generated constructor stub
	prop = new ConnectionProperty();
	}
/**
* @see HttpServlet#doGet(HttpServletRequest request, 
HttpServletResponse
* response)
*/
protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	response.setContentType("text/html");
	String userPath;
	List<Role> roles;
	RoleDbDAO dao = new RoleDbDAO();
	try {
		roles = dao.findAll();
		request.setAttribute("roles", roles);
		} 
	catch (DAOException e) {
// TODO Auto-generated catch block
		e.printStackTrace();
		}
	userPath = request.getServletPath();
	if ("/role".equals(userPath)) {
		request.getRequestDispatcher("/views/role.jsp").forward(request, response);
		}
	}
/**
* @see HttpServlet#doPost(HttpServletRequest request, 
HttpServletResponse
* response)
*/
protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
RoleDbDAO dao = new RoleDbDAO();
String name = request.getParameter("inputRole");
Role newRole = new Role(name);
try {
Long index = dao.insert(newRole);
System.out.println("Adding result: " + index );
} catch (DAOException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
doGet(request, response);
}
}
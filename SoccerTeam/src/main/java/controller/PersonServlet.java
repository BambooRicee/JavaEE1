package controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import dao.ConnectionProperty;
import dao.PersonDbDAO;
import dao.RoleDbDAO;
import domain.Person;
import domain.Role;
import exception.DAOException;
@WebServlet("/person")
public class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ConnectionProperty prop;
public PersonServlet() throws FileNotFoundException, IOException {
	super();
	 prop = new ConnectionProperty();
}
protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
	response.setContentType("text/html");
	String userPath;
	List<Person> persons;
	List<Role> roles;
	RoleDbDAO daoRole = new RoleDbDAO();
	PersonDbDAO dao = new PersonDbDAO();
	try {
		roles = daoRole.findAll();
		request.setAttribute("roles", roles);
	} catch (DAOException e) {
		e.printStackTrace();
}
	try {
		persons = dao.findAll();
		roles = daoRole.findAll();
		for (Person person: persons) {
			person.setRole(daoRole.FindById(person.getIdRole(), roles));
}   request.setAttribute("persons", persons);
} catch (DAOException e) {
e.printStackTrace();
} 
	userPath = request.getServletPath();
	if("/person".equals(userPath)){
		request.getRequestDispatcher("/views/person.jsp").forward(request, response);
}
}
protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
	PersonDbDAO dao = new PersonDbDAO();
	String firstName = request.getParameter("firstname");
	String lastName = request.getParameter("lastname");
	String birthday = request.getParameter("birthday");
	String height = request.getParameter("height");
	String weight = request.getParameter("weight");
	String role = request.getParameter("role");
	int index1 = role.indexOf('='); 
	int index2 = role.indexOf(","); 
	String r1 = role.substring(index1+1, index2);
	Long idRole = Long.parseLong(r1.trim());
	Person newPerson = new Person(idRole, firstName, lastName, height, birthday, weight);
	try {
		Long index = dao.insert(newPerson);
		System.out.println("Adding result: " + index );
	} catch (DAOException e) { 
		e.printStackTrace();
	}    
	doGet(request, response);
	}
}
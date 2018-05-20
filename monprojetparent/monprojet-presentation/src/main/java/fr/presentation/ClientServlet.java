package fr.presentation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.domaine.Client;
import fr.service.ClientService;

/**
 * Servlet implementation class ClientServlet
 */
@WebServlet("/ClientServlet")
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClientServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 1. CREATION VARIABLES POUR RECUPERER LES DONNEES
		String nom = request.getParameter("lenom");
		String prenom = request.getParameter("leprenom");
		String age1 = request.getParameter("age");
		String idConseiller1 = request.getParameter("conseiller");

		Integer entier = 0;
		int age = entier.parseInt(age1);
		int idConseiller = entier.parseInt(idConseiller1);

		Client monClient = new Client(nom, prenom,age,idConseiller);

		// 2. APPEL METHODE INSERER CLIENT DANS LA COUCHE SERVICE
		ClientService service = new ClientService();
		boolean reponse = service.createClient(monClient);

		// 3. RETOUR DE LA REPONSE AVEC LA METHODE DISPATCHER
		
		RequestDispatcher dispatcher;

		if (reponse==true) {
			dispatcher = request.getRequestDispatcher("EnregistrementR�ussi.html");
		} else {
			dispatcher = request.getRequestDispatcher("EnregistrementEchou�.html");
		}

		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

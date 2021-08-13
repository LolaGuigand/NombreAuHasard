package fr.eni.jee;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TraitementAuHasard
 */
@WebServlet("/TraitementAuHasard")
public class TraitementAuHasard extends HttpServlet {
	
	private static int BORNE_MAX = 10;
	private int nbHasard;
	
	
	@Override
	public void init() throws ServletException {
		System.out.println("INIT DE LA SERVLET");
		Random rd = new Random();
		this.nbHasard = rd.nextInt(BORNE_MAX + 1)	;
		System.out.println(nbHasard);
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
//		doGet(request, response);
		String saisie = request.getParameter("numero");
				
		
		if (Integer.parseInt(saisie) == this.nbHasard) {
			init();
			 // rediriger vers page réussite
			response.sendRedirect("./victoire.html");
			//nouveau nombre au hasard pour rejouer ?
//			Random rd = new Random();
//			int nbHasard = rd.nextInt(11)	;
			
		} else {
			 // redirier vers page échec
			response.sendRedirect("./echec.html");
		
		}
		
		//Si on envoye réponse au format html, ajouter métadonnée ContentType
				response.setContentType("text.html");
	}

}



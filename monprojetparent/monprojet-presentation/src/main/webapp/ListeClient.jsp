<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="fr.domaine.Client" %>
   <%@ page import="java.util.List" %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">

      <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item active">
            <a class="nav-link" href="index.html">Acceuil <span class="sr-only">(current)</span></a>
          </li>
          
          <li class="nav-item">
            <a class="nav-link" href="ListeClients">Liste des Clients</a>
          </li>
        </ul>
      </div>
    </nav>
<div class="text-center">
	    <h2></h2>
    
    <% 
    List<Client> listeClient = (List<Client>)session.getAttribute("liste");
    
    for (Client monClient : listeClient) {
    	out.println("<p>"+ monClient + "</p>");
    			}%>
      </p>

      </p>
      </div>
</body>
</html>
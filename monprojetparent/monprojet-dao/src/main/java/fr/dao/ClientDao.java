package fr.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import fr.domaine.Client;

public class ClientDao {

	private Statement connect() {
		try {
			// 1.CHARGEMENT DE DRIVER
			Class.forName("com.mysql.jdbc.Driver");

			// 2.CREATION DE LA CONNEXION
			String url = "jdbc:mysql://localhost:3306/bdd";
			String login = "root";
			String mdp = "";
			Connection connection = DriverManager.getConnection(url, login, mdp);

			// 3.CREATION DE LA REQUETE
			Statement stmt = connection.createStatement();
			return stmt;
		} catch (ClassNotFoundException e) {
			System.out.println("Problème chargement du driver !");
			e.printStackTrace();
			Statement stmt = null;
			return stmt;
		} catch (SQLException e) {
			System.out.println("Problème de connexion à la base de donnee !");
			e.printStackTrace();
			Statement stmt = null;
			return stmt;
		}
	}

	public boolean createClient(Client monClient) {
		
		// 1. CREATION DE LA VARIABLE DE RETOUR
		boolean reponse = false; 
		try {
			
			// 2. CONNECTION ET CREATION DE LA REQUETE
			Statement stmt = this.connect();
			String sql = "INSERT INTO `client`(`nom`, `prenom`, `age`, `idConseiller`) VALUES ('" + monClient.getNom()
					+ "', '" + monClient.getPrenom() + "', " + monClient.getAge() + ", " + monClient.getIdConseiller()
					+ ");";
			
			// 3. EXECUTION DE LA REQUETE
			int result = stmt.executeUpdate(sql); 
			if (result > 0) { 
				reponse = true;
			} else {
				reponse = false;
			}
			return reponse; 
		} catch (SQLException e) {
			System.out.println("Problème lors de la creation du client !");
			e.printStackTrace();
			return reponse;
		}
	}

	public Client getClient(int id) {
		
		// 1. CREATION DE LA VARIABLE DE RETOUR
		Client monClient = new Client();
		try {
			
			// 2. CONNECTION ET CREATION DE LA REQUETE
			Statement stmt = this.connect();
			String sql = "SELECT `idClient`, `nom`, `prenom`, `age`, `idConseiller` FROM `client` WHERE idClient = "
					+ id;
			
			// 3. EXECUTION DE LA REQUETE
			ResultSet result = stmt.executeQuery(sql);

			// RECUPERER LES DONNES DE MA BASE DE DONNEES
			result.next();
			monClient.setIdClient(result.getInt("idClient"));
			monClient.setNom(result.getString("nom"));
			monClient.setPrenom(result.getString("prenom"));
			monClient.setAge(result.getInt("age"));
			monClient.setIdConseiller(result.getInt("idConseiller"));

			return monClient;
		} catch (SQLException e) {
			System.out.println("Problème lors de la recuperation du client !");
			e.printStackTrace();
			return monClient;
		}
	}

	public Client updateClient(Client monClient) {
		try {
			
			// 1. CONNECTION ET CREATION DE LA REQUETE
			Statement stmt = this.connect();
			String sql = "UPDATE `client` SET `nom` = '" + monClient.getNom() + "', `prenom` = '"
					+ monClient.getPrenom() + "', `age` = " + monClient.getAge() + ", `idConseiller` = "
					+ monClient.getIdConseiller() + " WHERE `idClient` = " + monClient.getIdClient();
			
			// 2. EXECUTION DE LA REQUETE
			int result = stmt.executeUpdate(sql);
			if (result > 0) {
				return monClient;
			} else {
				System.out.println("Un problème est survenu lors de la modification du client.");
				return monClient;
			}
		} catch (SQLException e) {
			System.out.println("Problème lors de la modification du client !");
			e.printStackTrace();
			return monClient;
		}
	}

	public boolean deleteClient(Client monClient) {
		// 1. CREATION DE LA VARIABLE DE RETOUR
		boolean reponse = false;
		try {
			
			// 2. CONNECTION ET CREATION DE LA REQUETE
			Statement stmt = this.connect();
			String sql = "DELETE FROM client WHERE `idClient` = " + monClient.getIdClient();
			
			// 3. EXECUTION DE LA REQUETE
			int result = stmt.executeUpdate(sql);

			if (result > 0) {
				reponse = true;
			} else {
				reponse = false;
			}
			return reponse;
		} catch (SQLException e) {
			System.out.println("Problème lors de la suppression du client !");
			e.printStackTrace();
			return reponse;
		}
	}

	public List<Client> getAllClient() {
		List<Client> listClient = new ArrayList<Client>();
		try {
			// 1. CONNECTION ET CREATION DE LA REQUETE
			Statement stmt = this.connect();
			String sql = "SELECT * FROM `client`;";
			
			// 2. EXECUTION DE LA REQUETE
			ResultSet result = stmt.executeQuery(sql);
			
			while (result.next()) {
				
				// 3. CREATION DE LA VARIABLE DE RETOUR
				Client monClient = new Client();
				
				// 4.RECUPERER LES DONNES DE MA BASE DE DONNEES
				monClient.setIdClient(result.getInt("idClient"));
				monClient.setNom(result.getString("nom"));
				monClient.setPrenom(result.getString("prenom"));
				monClient.setAge(result.getInt("age"));
				monClient.setIdConseiller(result.getInt("idConseiller"));
				listClient.add(monClient);
			}
			return listClient;
		} catch (SQLException e) {
			System.out.println("Problème lors de la recuperation des clients !");
			e.printStackTrace();
			return listClient;
		}
	}
}

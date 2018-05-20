package fr.service;

import java.util.List;

import fr.dao.ClientDao;
import fr.domaine.Client;

public class ClientService {

	ClientDao dao = new ClientDao();

	public boolean createClient(Client monClient) {
		boolean reponse = dao.createClient(monClient);
		return reponse; 
	}

	public Client getClient(int id) {
		Client monClient = dao.getClient(id);
		return monClient;
	}

	public Client updateClient(Client monClient) {
		monClient = dao.updateClient(monClient);
		return monClient;
	}

	public boolean deleteClient(Client monClient) {
		boolean reponse = dao.deleteClient(monClient);
		return reponse; 
	}

	public List<Client> getAllClient() {
		List<Client> listClient = dao.getAllClient();
		return listClient;
	}
}



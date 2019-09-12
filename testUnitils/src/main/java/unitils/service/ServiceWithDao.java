package unitils.service;

import unitils.dao.DAO;

public class ServiceWithDao {

	private DAO dao;

	public void callDatabase() {
		dao.callDatabase();
	}

}

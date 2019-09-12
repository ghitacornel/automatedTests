package easymock.service;

import easymock.dao.DAO;
import easymock.model.Model;

public class Service {

	/**
	 * assume this dependency is injected somehow by a container for example
	 */
	private DAO dao;

	/**
	 * in out tests we will manually inject a {@link DAO} using this setter
	 * 
	 * @param dao
	 */
	public void setDao(DAO dao) {
		this.dao = dao;
	}

	/**
	 * a simple finder that throws exception for id<0 from dao
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Model findById(int id) throws Exception {
		return dao.findById(id);
	}

	/**
	 * a stupid business method that uses {@link DAO}
	 * 
	 * @param model
	 * @throws Exception
	 */
	public void business(Model model) throws Exception {

		Model existingModel = dao.findById(model.getId());
		if (existingModel != null) {
			model.setDescription(model.getDescription() + " existing");
			dao.update(model);
		} else {
			model.setDescription(model.getDescription() + " new");
			dao.insert(model);
		}
	}

}
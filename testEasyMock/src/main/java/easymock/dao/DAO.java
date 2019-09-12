package easymock.dao;

import easymock.model.Model;

/**
 * Note that we don't have an implementation for this interface
 * 
 * @author Cornel
 * 
 */
public interface DAO {

	void insert(Model model);

	/**
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 *             if id<0
	 */
	Model findById(int id) throws Exception;

	void update(Model model);

	void delete(Model model);

}

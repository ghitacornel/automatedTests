package dbunit.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dbunit.model.Bean;

/**
 * CRUD service to test over the database<br>
 * this service does not manage the database connection as this is expected to
 * be managed by a container<br>
 * Update service method will only reset model data to current date and time<br>
 *
 * @author Cornel
 */
public class Service {

    final private Connection connection;

    public Service(Connection connection) {
        this.connection = connection;
    }

    public void insert(Bean bean) {
        try {
            PreparedStatement statement = connection.prepareStatement("insert into testtable(id,description) values (?,?)");
            statement.setLong(1, bean.getId());
            statement.setString(2, bean.getDescription());
            statement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Bean findById(Long id) {
        try {
            PreparedStatement statement = connection.prepareStatement("select id,description from testtable where id=?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Bean bean = new Bean();
                bean.setId(id);
                bean.setDescription(resultSet.getString("description"));
                resultSet.close();
                return bean;
            } else {
                resultSet.close();
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(Bean bean) {
        try {
            PreparedStatement statement = connection.prepareStatement("delete from testtable where id=?");
            statement.setLong(1, bean.getId());
            statement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Bean bean) {
        try {
            PreparedStatement statement = connection.prepareStatement("update testtable set description = ? where id = ?");
            statement.setString(1, bean.getDescription());
            statement.setLong(2, bean.getId());
            statement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

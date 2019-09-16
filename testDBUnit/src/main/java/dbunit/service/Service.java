package dbunit.service;

import dbunit.model.Bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * CRUD service to test over the database<br>
 * this service does not manage the database connection<br>
 * database connection is expected to be managed by a container<br>
 * update service method will only reset model data to current date and time<br>
 */
public class Service {

    final private Connection connection;

    public Service(Connection connection) {
        this.connection = connection;
    }

    private static void close(PreparedStatement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void insert(Bean bean) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("insert into testtable(id,description) values (?,?)");
            statement.setLong(1, bean.getId());
            statement.setString(2, bean.getDescription());
            statement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            close(statement);
        }
    }

    public Bean findById(Long id) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("select id,description from testtable where id=?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Bean bean = new Bean();
                bean.setId(id);
                bean.setDescription(resultSet.getString("description"));
                resultSet.close();
                return bean;
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            close(statement);
        }
    }

    public void delete(Bean bean) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("delete from testtable where id=?");
            statement.setLong(1, bean.getId());
            statement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            close(statement);
        }
    }

    public void update(Bean bean) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("update testtable set description = ? where id = ?");
            statement.setString(1, bean.getDescription());
            statement.setLong(2, bean.getId());
            statement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            close(statement);
        }
    }

}

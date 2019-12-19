package dao;

import controllers.DBConnector;
import controllers.ProductController;
import controllers.UserController;

import java.sql.Connection;

import org.springframework.stereotype.Component;
@Component
public class MySQLDAOFactory extends DAOFactory {
    private Connection conn;

    public MySQLDAOFactory() {
        this.conn = new DBConnector().getConnection();
    }

    @Override
    public UserControllerDAO getUserControllerDAO() {
        return new UserController(conn);
    }

    @Override
    public ProductControllerDAO getProductControllerDAO() {
        return new ProductController(conn);
    }
}

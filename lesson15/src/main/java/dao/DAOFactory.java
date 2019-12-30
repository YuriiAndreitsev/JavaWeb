package dao;

import org.springframework.stereotype.Component;

@Component
public abstract class DAOFactory {
    public abstract UserControllerDAO getUserControllerDAO();
    public abstract ProductControllerDAO getProductControllerDAO();

    public static DAOFactory getFactory(int source) {
        switch (source) {
            case 1:
                return new MySQLDAOFactory();
//            case 2:
//                return new XMLDaoFactory();
            default:
                return new MySQLDAOFactory();
        }
    }
}

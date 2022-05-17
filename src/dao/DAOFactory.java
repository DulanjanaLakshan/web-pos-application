package dao;

import dao.custom.impl.customerDAOImpl;
import dao.custom.impl.itemDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {

    }

    public static DAOFactory getDaoFactory() {
        return daoFactory == null ? daoFactory = new DAOFactory() : daoFactory;
    }

    public SuperDAO getDAO(DAOTypes types) {
        switch (types) {
            case ITEM:
                return new itemDAOImpl();
            case ORDER:
                return null;
            case CUSTOMER:
                return new customerDAOImpl();
            default:
                return null;
        }
    }

    public enum DAOTypes {
        ITEM, CUSTOMER, ORDER
    }
}

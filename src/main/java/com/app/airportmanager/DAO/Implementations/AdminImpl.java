package com.app.airportmanager.DAO.Implementations;

import com.app.airportmanager.DAO.AdminDao;
import com.app.airportmanager.Entities.Users.Admin;
import com.app.airportmanager.Entities.Users.Passenger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AdminImpl implements AdminDao {
    private SessionFactory sessionFactory;
    Transaction transaction = null;

    public AdminImpl() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public boolean login(Admin admin) {
        Session session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }
}

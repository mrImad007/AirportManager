package com.app.airportmanager.DAO.Implementations;

import com.app.airportmanager.DAO.PassengerDao;
import com.app.airportmanager.Entities.Users.Passenger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class PassengerImpl implements PassengerDao {
    private SessionFactory sessionFactory;
    Transaction transaction = null;

    public PassengerImpl() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public boolean login(Passenger passenger) {
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

    @Override
    public boolean register(Passenger passenger) {
        Session session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            session.save(passenger);
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

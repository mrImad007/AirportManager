package com.app.airportmanager.DAO.Implementations;

import com.app.airportmanager.DAO.PassengerDao;
import com.app.airportmanager.Entities.Users.Passenger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class PassengerImpl implements PassengerDao {
    private SessionFactory sessionFactory;
    Transaction transaction = null;

    public PassengerImpl() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public boolean login(String email, String password) {
        Session session = sessionFactory.openSession();
        try {
            System.out.println("implementation :" +email);
            System.out.println("implementation :" +password);
            Transaction transaction = session.beginTransaction();
            Query<Passenger> query = session.createQuery("from Passenger where email = :email and password = :password", Passenger.class);
            query.setParameter("email", email);
            query.setParameter("password", password);
            Passenger passenger = query.uniqueResult();

            if (passenger != null) {
                return true;
            }
            transaction.commit();
            return false;
        } catch (Exception e) {
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

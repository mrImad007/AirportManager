package com.app.airportmanager.DAO.Implementations;

import com.app.airportmanager.DAO.FlightDao;
import com.app.airportmanager.Entities.Flight;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class FlightImpl implements FlightDao {
    private SessionFactory sessionFactory;
    Transaction transaction = null;
    public FlightImpl (){
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }
    @Override
    public boolean add_flight(Flight flight) {
        try (Session session = sessionFactory.openSession()) {
            try {
                transaction = session.beginTransaction();
                session.save(flight);
                transaction.commit();
                return true;
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
        }
        return false;
    }
    @Override
    public boolean update_flight(Flight flight) {
        try (Session session = sessionFactory.openSession()) {
            try {
                transaction = session.beginTransaction();
                session.update(flight);
                transaction.commit();
                return true;
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
        }
        return false;
    }
    @Override
    public boolean delete_flight(int id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                session.delete(id);
                transaction.commit();
                return true;
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
        }
        return false;
    }
    @Override
    public Flight getFlightById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Flight.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public List<Flight> getAllFlights() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Flight", Flight.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}

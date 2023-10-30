package com.app.airportmanager.DAO.Implementations;

import com.app.airportmanager.DAO.FlightDao;
import com.app.airportmanager.Entities.Flight;
import com.app.airportmanager.Entities.Users.Admin;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

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
                Flight flight = session.get(Flight.class, id);

                if (flight != null) {
                    session.delete(flight);
                    transaction.commit();
                    return true;
                } else {
                    transaction.rollback();
                    return false;
                }
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
        Session session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            Flight flight = session.get(Flight.class, id);
            transaction.commit();
            return flight;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public List<Flight> getAllFlights() {
        try (Session session = sessionFactory.openSession()) {
            List<Flight> flights = session.createQuery("FROM Flight", Flight.class).list();
            return flights;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Flight> getFlightsBySearch(String departureCity, String arrivalCity,String date,boolean stopover) {
        try (Session session = sessionFactory.openSession()) {
            Query<Flight> query = session.createQuery("FROM Flight WHERE departureCity ILIKE :departureCity AND arrivalCity ILIKE :arrivalCity AND DATE(departureTime) = DATE(:date) AND stopover = :stopover", Flight.class);
            query.setParameter("departureCity", departureCity);
            query.setParameter("arrivalCity", arrivalCity);
            query.setParameter("date",date);
            query.setParameter("stopover",stopover);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}

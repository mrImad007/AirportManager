package com.app.airportmanager.DAO.Implementations;

import com.app.airportmanager.DAO.ReservationDao;
import com.app.airportmanager.Entities.Reservation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Collections;
import java.util.List;

public class ReservationImpl implements ReservationDao {

    private SessionFactory sessionFactory;
    Transaction transaction = null;

    public ReservationImpl(){
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }
    @Override
    public boolean create_reservation(Reservation reservation) {
        try(Session session = sessionFactory.openSession()){
            session.getTransaction();
            session.save(reservation);
            session.getTransaction().commit();
        }catch (Exception e){
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update_reservation(Reservation reservation) {
        try(Session session = sessionFactory.openSession()){
            session.getTransaction();
            session.update(reservation);
            session.getTransaction().commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete_reservation(int id) {
        try(Session session = sessionFactory.openSession()){
            session.getTransaction();
            session.delete(id);
            session.getTransaction().commit();
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
        }
        return false;
    }

    @Override
    public List<Reservation> getAllReservations() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Reservation", Reservation.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

}

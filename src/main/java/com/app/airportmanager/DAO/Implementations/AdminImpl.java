package com.app.airportmanager.DAO.Implementations;

import com.app.airportmanager.DAO.AdminDao;
import com.app.airportmanager.Entities.Users.Admin;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class AdminImpl implements AdminDao {
    private SessionFactory sessionFactory;
    Transaction transaction = null;

    public AdminImpl() {
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
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

    public Admin getAdmin(int adminId) {
        Session session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            Admin admin = session.get(Admin.class, adminId);
            transaction.commit();
            return admin;
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

}

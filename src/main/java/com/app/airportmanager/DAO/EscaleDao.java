package com.app.airportmanager.DAO;

import com.app.airportmanager.Entities.Escale;

public interface EscaleDao {
    boolean create_escale(Escale escale);
    boolean update_escale(Escale escale);
    boolean delete_escale(Escale escale);
}

package com.app.airportmanager.DAO;

import com.app.airportmanager.Entities.Stopover;

public interface StopoverDao {
    boolean create_stopover(Stopover stopover);
    boolean update_stopover(Stopover stopover);
    boolean delete_stopover(Stopover stopover);
}

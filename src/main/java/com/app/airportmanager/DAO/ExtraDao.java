package com.app.airportmanager.DAO;

import com.app.airportmanager.Entities.Extra;

public interface ExtraDao {
    boolean add_extra(Extra extra);
    boolean update_extra(Extra extra);
    boolean delete_extra(Extra extra);
}

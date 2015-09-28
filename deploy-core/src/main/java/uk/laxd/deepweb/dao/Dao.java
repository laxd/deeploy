package uk.laxd.deepweb.dao;

import java.util.List;

/**
 * Created by Lenny on 27/09/2015.
 */
public interface Dao<T> {
    T findById(int id);
    List<T> findByRestrictions(Restrictions restriction);
}

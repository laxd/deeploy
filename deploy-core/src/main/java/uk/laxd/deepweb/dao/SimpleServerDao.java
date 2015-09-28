package uk.laxd.deepweb.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uk.laxd.deepweb.lang.Constants;
import uk.laxd.deepweb.mapper.ServerRowMapper;
import uk.laxd.deepweb.model.Server;

import java.util.List;

/**
 * Created by Lenny on 20/09/2015.
 */
@Repository(Constants.Dao.SERVER_DAO)
public class SimpleServerDao extends ServerDao {

    @Autowired
    public SimpleServerDao(JdbcTemplate template) {
        super(template);
    }

}

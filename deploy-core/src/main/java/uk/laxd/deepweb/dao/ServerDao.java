package uk.laxd.deepweb.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import uk.laxd.deepweb.mapper.ServerRowMapper;
import uk.laxd.deepweb.model.Server;

import java.util.List;

/**
 * Created by Lenny on 20/09/2015.
 */
public abstract class ServerDao extends AbstractDao<Server> {
    public ServerDao(JdbcTemplate template) {
        super(template, new ServerRowMapper(), "SERVER");
    }
}

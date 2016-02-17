package uk.laxd.deepweb.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import uk.laxd.deepweb.lang.Constants;

import java.util.List;

/**
 * Created by Lenny on 27/09/2015.
 */
public abstract class AbstractDao<T> implements Dao {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractDao.class);
    private static final String BUFFER = " ";
    private static final String SELECT_ALL = "SELECT * FROM ";
    private String tableName;
    private JdbcTemplate template;
    private RowMapper<T> rowMapper;

    public AbstractDao(JdbcTemplate template, RowMapper<T> rowMapper, String tableName) {
        this.template = template;
        this.rowMapper = rowMapper;
        this.tableName = BUFFER + tableName + BUFFER;
    }

    public T findById(int id) {
        List<T> output = findByRestrictions(new Restrictions().add(Constants.DB.ID_COLUMN, Symbol.EQUALS, id));

        if(output.size() > 0) {
            return output.get(0);
        }

        return null;
    }

    public List<T> findAll() {
        return findByRestrictions(new Restrictions());
    }

    public List<T> findByRestrictions(Restrictions restriction) {
        String query = SELECT_ALL + tableName + BUFFER + restriction.getWhereClauses();

        LOG.debug("Executing query '{}'", query);

        return template.query(query, rowMapper, restriction.getArguments());
    }
}

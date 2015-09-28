package uk.laxd.deepweb.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import uk.laxd.deepweb.mapper.CredentialsRowMapper;
import uk.laxd.deepweb.model.Credentials;

/**
 * Created by Lenny on 27/09/2015.
 */
public abstract class CredentialsDao extends AbstractDao<Credentials> {
    public CredentialsDao(JdbcTemplate template) {
        super(template, new CredentialsRowMapper(), "CREDENTIALS");
    }
}

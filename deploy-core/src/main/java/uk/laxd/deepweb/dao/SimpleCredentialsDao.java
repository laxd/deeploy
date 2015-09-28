package uk.laxd.deepweb.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uk.laxd.deepweb.lang.Constants;

/**
 * Created by Lenny on 27/09/2015.
 */
@Repository(Constants.Dao.CREDENTIALS_DAO)
public class SimpleCredentialsDao extends CredentialsDao {

    @Autowired
    public SimpleCredentialsDao(JdbcTemplate template) {
        super(template);
    }
}

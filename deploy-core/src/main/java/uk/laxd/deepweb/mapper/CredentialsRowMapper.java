package uk.laxd.deepweb.mapper;

import org.springframework.jdbc.core.RowMapper;
import uk.laxd.deepweb.lang.Constants;
import uk.laxd.deepweb.model.CredentialType;
import uk.laxd.deepweb.model.Credentials;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Lenny on 27/09/2015.
 */
public class CredentialsRowMapper implements RowMapper<Credentials> {
    public Credentials mapRow(ResultSet resultSet, int i) throws SQLException {
        Credentials credentials = new Credentials();
        credentials.setId(resultSet.getInt(Constants.DB.Credentials.ID_COLUMN));
        credentials.setUsername(resultSet.getString(Constants.DB.Credentials.USERNAME_COLUMN));
        credentials.setPassword(resultSet.getString(Constants.DB.Credentials.PASSWORD_COLUMN));
        credentials.setKeyLocation(resultSet.getString(Constants.DB.Credentials.KEY_LOCATION_COLUMN));
        credentials.setType(CredentialType.valueOf(resultSet.getString(Constants.DB.Credentials.CREDENTIALS_TYPE_COLUMN)));

        return credentials;
    }
}

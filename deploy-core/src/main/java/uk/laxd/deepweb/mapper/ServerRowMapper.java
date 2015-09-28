package uk.laxd.deepweb.mapper;

import org.springframework.jdbc.core.RowMapper;
import uk.laxd.deepweb.lang.Constants;
import uk.laxd.deepweb.model.CredentialType;
import uk.laxd.deepweb.model.Credentials;
import uk.laxd.deepweb.model.Server;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Lenny on 20/09/2015.
 */
public class ServerRowMapper implements RowMapper<Server> {
    public Server mapRow(ResultSet resultSet, int i) throws SQLException {
        Server server = new Server();

        server.setId(resultSet.getInt(Constants.DB.Server.ID_COLUMN));
        server.setName(resultSet.getString(Constants.DB.Server.NAME_COLUMN));
        server.setHost(resultSet.getString(Constants.DB.Server.HOST_COLUMN));

//        Credentials credentials = new Credentials();
//        credentials.setId(resultSet.getInt(Constants.DB.Credentials.ID_COLUMN));
//        credentials.setUsername(resultSet.getString(Constants.DB.Credentials.USERNAME_COLUMN));
//        credentials.setPassword(resultSet.getString(Constants.DB.Credentials.PASSWORD_COLUMN));
//        credentials.setKeyLocation(resultSet.getString(Constants.DB.Credentials.KEY_LOCATION_COLUMN));
//        credentials.setType(CredentialType.valueOf(resultSet.getString(Constants.DB.Credentials.CREDENTIALS_TYPE_COLUMN)));
//
//        server.setCredentials(credentials);

        return server;
    }
}

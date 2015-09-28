package uk.laxd.deepweb.lang;

/**
 * Created by Lenny on 20/09/2015.
 */
public class Constants {

    public final class RequestMappings {
        public static final String SERVERS = "/servers";
    }

    public class CRUD {
        public static final String CREATE = "add";
        public static final String READ = "view/{id}";
        public static final String UPDATE = "edit/{id}";
        public static final String DELETE = "remove/{id}";
    }

    public class Service {
        public static final String SERVER_SERVICE = "serverService";
    }

    public class Dao {
        public static final String SERVER_DAO = "serverDao";
        public static final String CREDENTIALS_DAO = "credentialsDao";
    }

    public class DB {
        public class Server {
            public static final String ID_COLUMN = "ID";
            public static final String NAME_COLUMN = "NAME";
            public static final String HOST_COLUMN = "HOST";
        }

        public class Credentials {
            public static final String ID_COLUMN = "ID";
            public static final String USERNAME_COLUMN = "USERNAME";
            public static final String PASSWORD_COLUMN = "PASSWORD";
            public static final String KEY_LOCATION_COLUMN = "KEY_LOC";
            public static final String CREDENTIALS_TYPE_COLUMN = "TYPE";
        }
    }

    public class SQL {

        public static final String SELECT_SERVER = "SELECT SERVER.ID AS SERVER_ID," +
                " SERVER.NAME," +
                " SERVER.HOST," +
                " CREDENTIALS.ID AS CREDENTIALS_ID," +
                " CREDENTIALS.USERNAME," +
                " CREDENTIALS.PASSWORD," +
                " CREDENTIALS.KEY_LOC," +
                " CREDENTIALS.TYPE " +
                " FROM SERVER" +
                " INNER JOIN CREDENTIALS" +
                " ON CREDENTIALS.ID = SERVER.CREDENTIALS_ID";
    }
}
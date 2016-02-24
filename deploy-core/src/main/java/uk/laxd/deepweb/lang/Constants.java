package uk.laxd.deepweb.lang;

/**
 * Created by Lenny on 20/09/2015.
 */
public class Constants {

    public final class RequestMappings {
        public static final String BUILD_FLOW = "/flow";
    }

    public class DB {

        public static final String ID_COLUMN = "ID";

        public class BuildFlow {
            public static final String NAME_COLUMN = "NAME";
        }

        public class BuildFlowStep {
            public static final String BUILD_FLOW_ID_COLUMN = "BUILD_FLOW_ID";
            public static final String TYPE_COLUMN = "TYPE";
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
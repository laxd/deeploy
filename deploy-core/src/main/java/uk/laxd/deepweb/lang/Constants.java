package uk.laxd.deepweb.lang;

/**
 * Created by Lenny on 20/09/2015.
 */
public class Constants {

    private Constants() {
    }

    public final class RequestMappings {
        private RequestMappings() {
        }

        public static final String BUILD_FLOW = "/flow";
    }

    public class DB {

        private DB() {
        }

        public static final String ID_COLUMN = "ID";

        public class BuildFlow {
            private BuildFlow() {
            }

            public static final String TABLE_NAME = "BUILD_FLOW";
            public static final String NAME_COLUMN = "NAME";
        }

        public class BuildFlowStep {
            private BuildFlowStep() {
            }

            public static final String TABLE_NAME = "BUILD_FLOW_STEP";
            public static final String BUILD_FLOW_ID_COLUMN = "BUILD_FLOW_ID";
            public static final String TYPE_COLUMN = "TYPE";
        }

        public class BuildFlowStepArgument {
            private BuildFlowStepArgument() {
            }

            public static final String TABLE_NAME = "BUILD_FLOW_STEP_ARGUMENT";
            public static final String NAME_COLUMN = "NAME";
            public static final String VALUE_COLUMN = "VALUE";
            public static final String BUILD_FLOW_STEP_ID_COLUMN = "BUILD_FLOW_STEP_ID";
        }
    }
}
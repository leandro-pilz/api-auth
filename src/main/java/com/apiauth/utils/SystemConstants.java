package com.apiauth.utils;

import static com.apiauth.utils.SystemConstants.DB.TABLES.COMPANY_TABLE_NAME;

public class SystemConstants {

    public interface API {
        String BASE_URL = "/api/v1/mobiteb2b/auth";
        String REFRESH_ROUTE = BASE_URL + "/refreshToken";
    }

    public interface Prefix {
        String BEARER_PREFIX = "Bearer ";
    }

    public interface DB {

        interface TABLES {
            String COMPANY_TABLE_NAME = "mobite_b2b_empresa";
            String USER_TABLE_NAME = "mobite_b2b_usuario";

        }

        interface COLUMNS {
            String COLUMN_ID = "id";
            String COLUMN_COMPANY_ID = COMPANY_TABLE_NAME + "_" + COLUMN_ID;
            String COLUMN_UUID = "uuid";
            String COLUMN_NAME = "nome";
            String COLUMN_EMAIL = "email";
            String COLUMN_PASSWORD = "senha";
            String COLUMN_STATUS = "situacao";

        }
    }
}

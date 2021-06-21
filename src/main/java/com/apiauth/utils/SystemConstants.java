package com.apiauth.utils;

public class SystemConstants {

    public interface ApiRoutes {
        //Routes
        String BASE_URL = "/api/v1/mobiteb2b/auth";
        String REFRESH_ROUTE = BASE_URL + "/refreshToken";
    }

    public interface Prefix {
        String BEARER_PREFIX = "Bearar ";
    }

    public interface DB {
        //Tables
        String COMPANY_TABLE_NAME = "mobite_b2b_empresa";
        String USER_TABLE_NAME = "mobite_b2b_usuario";
        String PERMISSION_TABLE_NAME = "mobite_b2b_permissao_usuario";
        String PROFILE_TABLE_NAME = "mobite_b2b_perfil";

        //Columns
        String COLUMN_ID = "id";
        String COLUMN_COMPANY_ID = COMPANY_TABLE_NAME + "_" + COLUMN_ID;
        String COLUMN_USER_ID = USER_TABLE_NAME + "_" + COLUMN_ID;
        String COLUMN_PROFILE_ID = PROFILE_TABLE_NAME + "_" + COLUMN_ID;
        String COLUMN_UUID = "uuid";
        String COLUMN_NAME = "nome";
        String COLUMN_EMAIL = "email";
        String COLUMN_PASSWORD = "senha";
        String COLUMN_STATUS = "situacao";
    }
}

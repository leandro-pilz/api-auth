package com.apiauth.utils;

public class ConstantsDb {
    private static final String SEQ = "seq_";
    private static final String GENERATOR = "_generator";

    //Tables
    public static final String COMPANY_TABLE_NAME = "mobite_b2b_empresa";
    public static final String USER_TABLE_NAME = "mobite_b2b_usuario";
    public static final String PERMISSION_TABLE_NAME = "mobite_b2b_permissao_usuario";
    public static final String PROFILE_TABLE_NAME = "mobite_b2b_perfil";
    public static final String TOKEN_TABLE_NAME = "bem_b2b_token";

    //Sequences
    public static final String COMPANY_SEQUENCE = SEQ + COMPANY_TABLE_NAME;
    public static final String USER_SEQUENCE = SEQ + USER_TABLE_NAME;
    public static final String PROFILE_SEQUENCE = SEQ + PROFILE_TABLE_NAME;
    public static final String USER_PERMISSION_SEQUENCE = SEQ + PERMISSION_TABLE_NAME;

    //Columns
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_COMPANY_ID = COMPANY_TABLE_NAME + "_" + COLUMN_ID;
    public static final String COLUMN_USER_ID = USER_TABLE_NAME + "_" + COLUMN_ID;
    public static final String COLUMN_PROFILE_ID = PROFILE_TABLE_NAME + "_" + COLUMN_ID;
    public static final String COLUMN_USER_PERMISSION_ID = PERMISSION_TABLE_NAME + "_" + COLUMN_ID;
    public static final String COLUMN_UUID = "uuid";
    public static final String COLUMN_NAME = "nome";
    public static final String COLUMN_PROFILE = "perfil";
    public static final String COLUMN_CNPJ = "cnpj";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PASSWORD = "senha";
    public static final String COLUMN_STATUS = "situacao";
    public static final String COLUMN_CREATED = "data_criacao";
    public static final String COLUMN_UPDATED = "data_alteracao";
    public static final String COLUMN_ACCESS_TOKEN = "access_token";
    public static final String COLUMN_REFRESH_TOKEN = "refresh_token";

    //Generators
    public static final String USER_GENERATOR = USER_TABLE_NAME + GENERATOR;
    public static final String ROLE_GENERATOR = PERMISSION_TABLE_NAME + GENERATOR;
}

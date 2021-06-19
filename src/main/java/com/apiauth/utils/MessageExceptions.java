package com.apiauth.utils;

public interface MessageExceptions {

    //User
    String USER_ALREADY_EXISTS_WITH_EMAIL = "Usuário já cadastrado com este e-mail.";
    String USER_FIELD_REQUIRED = "Os campos nome e e-mail são obrigatórios.";
    String USER_NOTFOUND = "Usuário não cadastrado.";

    //Profile
    String PROFILE_NOTFOUND = "Perfil não cadastrado.";

    //User Role
    String USER_ROLE_ALREADY_EXISTS = "Permissão já cadastrada para o usuário.";

    String QUERY_PARAM_WITHOUT = "Parâmetro(s) obrigatório(s) não informado(s) na requisição.";
    String PATH_VARIABLE_WITHOUT = "Identificador(Id) não enviado na requisição.";
    String NO_DATA_FOUND = "Nenhum dado encontrado.";
    String USER_LOGGED_NOT_PERMISSION_FOR_THIS_CREATION = "Usuário não possui permissão para esta requisição.";
    String STATUS_FIELD_REQUIRED = "O campo situação é obrigatório.";
    String PASSWORD_FIELD_REQUIRED = "O campo senha é obrigatório.";
}

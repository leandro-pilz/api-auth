package com.apiauth.utils;

public interface MessageExceptions {
    String USER_NOTFOUND = "Usuário não cadastrado.";
    String UNIDENTIFIED_USER = "Usuário ou senha não informado, verifique.";
    String USER_BLOCKED = "Usuário bloqueado, entre em contato com o administrador do sistema.";
    String COMPANY_BLOCKED = "Empresa bloqueada, entre em contato com o administrador do sistema.";
    String QUERY_PARAM_WITHOUT = "Parâmetro(s) obrigatório(s) não informado(s) na requisição.";
    String PATH_VARIABLE_WITHOUT = "Identificador(Id) não enviado na requisição.";
    String USER_LOGGED_NOT_PERMISSION_FOR_THIS_CREATION = "Usuário não possui permissão para esta requisição.";
}

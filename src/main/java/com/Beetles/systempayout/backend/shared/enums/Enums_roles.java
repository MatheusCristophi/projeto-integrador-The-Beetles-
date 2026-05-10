package com.Beetles.systempayout.backend.shared.enums;

public enum Enums_roles {
    ALUNOS("ROLE_ALUNO"),
    ADMIN("ROLE_ADMIN");

    private String role;

    Enums_roles(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}

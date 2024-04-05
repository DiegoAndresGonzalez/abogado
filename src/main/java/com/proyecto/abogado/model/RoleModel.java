package com.proyecto.abogado.model;

import com.proyecto.abogado.utils.Constant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum RoleModel implements GrantedAuthority {

    LAWYER_ROLE(Constant.LAWYER_ROLE),
    CLIENT_ROLE(Constant.CLIENT_ROLE);

    private String role;

    @Override
    public String getAuthority() {
        return "ROLE_" + role;
    }
}

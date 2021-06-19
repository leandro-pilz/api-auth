package com.apiauth.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import static com.apiauth.utils.ConstantsDb.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = PROFILE_TABLE_NAME)
public class ProfileEntity implements GrantedAuthority {

    @Id
    @Column(name = COLUMN_ID)
    private Long id;

    @Column(name = COLUMN_NAME)
    private String name;

    @Override
    public String getAuthority() {
        return name;
    }
}

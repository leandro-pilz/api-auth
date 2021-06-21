package com.apiauth.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import static com.apiauth.utils.SystemConstants.DB.COLUMN.*;
import static com.apiauth.utils.SystemConstants.DB.TABLE.PERMISSION_TABLE_NAME;
import static com.apiauth.utils.SystemConstants.DB.TABLE.USER_TABLE_NAME;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = USER_TABLE_NAME)
public class UserEntity implements UserDetails {

    @Id
    @Column(name = COLUMN_ID)
    private Long id;

    @Column(name = COLUMN_COMPANY_ID)
    private Long companyId;

    @Column(name = COLUMN_UUID)
    private UUID uuid;

    @Column(name = COLUMN_NAME)
    private String name;

    @Column(name = COLUMN_EMAIL)
    private String email;

    @Column(name = COLUMN_PASSWORD)
    private String password;

    @Column(name = COLUMN_STATUS)
    private Boolean status;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = PERMISSION_TABLE_NAME,
            joinColumns = @JoinColumn(name = COLUMN_USER_ID, referencedColumnName = COLUMN_ID),
            inverseJoinColumns = @JoinColumn(name = COLUMN_PROFILE_ID, referencedColumnName = COLUMN_ID))
    private List<ProfileEntity> roles;

    @ManyToOne
    @JoinColumn(name = COLUMN_COMPANY_ID, nullable = false, insertable = false, updatable = false)
    private CompanyEntity company;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getUsername() {
        return uuid.toString();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

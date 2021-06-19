package com.apiauth.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@Table(name = PERMISSION_TABLE_NAME)
public class UserPermissionEntity {

    @Id
    @Column(name = COLUMN_ID)
    private Long id;

    @Column(name = COLUMN_USER_ID)
    private Long userId;

    @Column(name = COLUMN_PROFILE_ID)
    private Long profileId;
}

package com.apiauth.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

import static com.apiauth.utils.SystemConstants.DB.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = COMPANY_TABLE_NAME)
public class CompanyEntity {

    @Id
    @Column(name = COLUMN_ID)
    private Long id;

    @Column(name = COLUMN_STATUS)
    private Boolean status;

    @OneToMany(mappedBy = "company")
    private List<UserEntity> users;
}

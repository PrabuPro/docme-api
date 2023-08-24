package com.docme.docmeapi.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "user_account")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", length = 50)
    private String firstName;

    @Column(name="last_name" ,length = 50)
    private String lastName;

    @Column(name="middle_name", length = 50)
    private String middleName;

    private String email;

    @Column(name="phone_number")
    private String phoneNumber;

    @Column(name = "keycloak_id")
    private String keycloakId;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private List<Role> role = new ArrayList<>();


}

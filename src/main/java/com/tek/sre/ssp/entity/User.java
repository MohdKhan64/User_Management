package com.tek.sre.ssp.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "SRE_SSP_USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_email_id", length = 55, nullable = false, unique = true)
    @NotEmpty
    private String userEmailId;

    @Column(name = "password", nullable = false)
    @NotEmpty
    @Size(min = 4)
    private String password;

    @Column(name = "first_name", length = 55, nullable = false)
    @NotEmpty
    private String firstName;

    @Column(name = "last_name", length = 55, nullable = false)
    @NotEmpty
    private String lastName;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "SRE_SSP_USER_ROLE_MAPPING", joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")})
    private List<Role> roles;




}

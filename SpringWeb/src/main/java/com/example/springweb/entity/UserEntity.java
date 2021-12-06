package com.example.springweb.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column
    private String userName;
    @Column
    private String passWord;
    @Column
    private String fullName;
    @Column
    private String phoneNumber;
    @ManyToMany(fetch=FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<RoleEntity> roleEntities=new HashSet<>();
    @OneToMany(mappedBy = "user")
    private Set<BillEntity>billEntities=new HashSet<>();
    @OneToMany(mappedBy = "userIS")
    private Set<InsuranceEntity>insuranceEntities=new HashSet<>();
    @Column
    private String address;
    @Column
    private String email;
}
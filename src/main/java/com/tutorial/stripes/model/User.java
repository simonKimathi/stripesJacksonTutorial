package com.tutorial.stripes.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class User {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String surname;

    @Column
    private String username;

    @Column
    private String password;


}

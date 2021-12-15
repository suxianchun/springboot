package com.security.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class User implements Serializable {

    @Id
    @Column
    private int id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String role;

}

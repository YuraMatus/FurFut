package com.furniturefuture.entity;

import org.hibernate.annotations.GeneratorType;
import org.springframework.security.core.GrantedAuthority;
import lombok.Setter;
import lombok.Getter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "t_role")
@Getter
@Setter
public class Role implements GrantedAuthority {
    @Id
    private Long id;
    private String name;
    @Transient
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public Role() {
    }

    public Role(Long id) {
        this.id = id;
    }

    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }


    public String getName() {
        return name;
    }


    public Set<User> getUsers() {
        return users;
    }


    @Override
    public String getAuthority() {
        return getName();
    }
}
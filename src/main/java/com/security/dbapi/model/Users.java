package com.security.dbapi.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table (name = "user")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "user_id")
    private int id;

    private String email;
    private String password;
    private String name;
    private String last_name;
    private int active;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)

    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn (name="role_id"))
    private Set<Role> roles;

    public  Users (Users users){
        this.email = users.getEmail();
        this.password = users.getPassword();
        this.name = users.getName();
        this.last_name = users.getLast_name();
        this.active = users.getActive();
        this.roles = users.getRoles();


    }

    public Users(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Users(String email, String password, String name, String last_name, int active, Set<Role> roles) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.last_name = last_name;
        this.active = active;
        this.roles = roles;
    }
}

package dev.naman.splitwise_class.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends Auditable {
    private String name;
    private String email;
    private String passwordHash;
    private String phoneNumber;

    @ManyToMany(mappedBy = "members")
    private List<Group> memberGroups;

    @ManyToMany(mappedBy = "participants")
    private List<Expense> expenses;
}

// user_group ->
// member_of: M:M
// admin: 1:M

// 4 servers
// 1 server - v2 - 1 class
// 3 servers - v3 - 4 classes
// v4 -> 7 classes
// applications have instances: dev, staging, prod
package dev.naman.splitwise_class.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "groups")
public class Group extends Auditable {
    private String name;

    @ManyToMany
    private List<User> members = new ArrayList<>();

    @OneToMany(mappedBy = "group")
    private List<Expense> expenses = new ArrayList<>();

    @ManyToOne
    private User admin;
}

// user    group -> admin
// 1        M
// 1         1
// 1 to M

// group     expense
// 1          M
// 1           1
// 1 to M

// group       members
// 1           M
// M            1
// M    to      M
// hands on lld 1
// lld 13: splitwise
// support@scaler.com -> add all lld classes that were taken in this batch -> Feb 21 Intermediate + April 21 Advanced



// 2 classes
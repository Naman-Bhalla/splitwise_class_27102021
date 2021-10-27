package dev.naman.splitwise_class.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@Setter
@Table (name = "expenses")
public class Expense extends Auditable { // table: expenses
    private String description;
    private Date expenseDate;
    private Double amount;

    @ManyToOne
    private Group group;

    @ManyToMany
    private List<User> participants = new ArrayList<>();

    @ElementCollection
    private Map<User, Double> amountsPaid = new HashMap<>();

    @ElementCollection
    private Map<User, Double> amountsOwed = new HashMap<>();
}

// Todat you might put an expense that happened 3 days ago
// E1: A, B, C
// a-> 120, B -> 200, C -> 10
// totalAmount = 330
// amountsOwed = a-> 100 b -> 100 c -> 130

/// expense                       group
//// 1                               1
//// M                               1
// ManyToOne
/// expense                      user
//        1                       M
//        M                        1
//        M                       M

// users group
// 2 1 to many relationships
// group -> owners
// group _> past members
package com.casino.entity;

import javax.persistence.*;

@Entity
@Table(name = "moves")
public class Move {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer result;

    private Double transaction;

    public Move() {
    }

    public Move(Integer result, Double transaction) {
        this.result = result;
        this.transaction = transaction;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public Double getTransaction() {
        return transaction;
    }

    public void setTransaction(Double transaction) {
        this.transaction = transaction;
    }

    public String toString() {
        return "Transacción id=" + id + ", result=" + result + ", transaction=" + transaction + '}';
    }
}

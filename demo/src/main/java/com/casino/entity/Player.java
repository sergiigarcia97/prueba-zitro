package com.casino.entity;

import javax.persistence.*;

@Entity
@Table(name = "players")
public class Player {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Float balance;

    @OneToOne
    @JoinColumn(name = "provider_id", referencedColumnName = "id")
    private Provider provider;

    @ManyToOne
    @JoinColumn(name="casino_id", referencedColumnName = "id")
    private Casino casino;

    public Player() {
    }

    public Player(Float balance,String name, Provider provider, Casino casino) {
        this.balance = balance;
        this.name = name;
        this.provider = provider;
        this.casino = casino;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Casino getCasino() {
        return casino;
    }

    public void setCasino(Casino casino) {
        this.casino = casino;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", provider=" + provider +
                ", casino=" + casino +
                '}';
    }
}

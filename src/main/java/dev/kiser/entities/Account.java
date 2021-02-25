package dev.kiser.entities;

import dev.kiser.daos.AccountDAO;

// Java Bean
public class Account {

    private int clientId; // The owner's id
    private int accId; // the account id
    private float amount; // the amount in the account
    private String type; // the type of account

    //No args constructor
    public Account() {
    }

    // Constructor
    public Account(int clientId, int accId, float amount, String type) {
        this.clientId = clientId;
        this.accId = accId;
        this.amount = amount;
        this.type = type;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getAccId() {
        return accId;
    }

    public void setAccId(int accId) {
        this.accId = accId;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getType(){
        return this.type;
    }

    public void setType(String type){
        this.type = type;
    }

    @Override
    public String toString() {
        return "Account{" +
                "clientId=" + clientId +
                ", accId=" + accId +
                ", amount=" + amount +
                ", type='" + type + '\'' +
                '}';
    }
}

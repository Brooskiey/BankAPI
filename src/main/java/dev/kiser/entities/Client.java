package dev.kiser.entities;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Java Bean
public class Client {

    private int id;
    private String firstName;
    private String lastName;
    private int maritalStatus; // 0 -> single; 1 -> married; 2 -> divorced; 3 -> widowed
    private boolean gender; // true -> male; false -> female
    private final Map<Integer, Account> clientAccounts = new HashMap<>();
    private int accountNum;

    // No args constructor
    public Client() {
    }

    public Client(int id, String firstName, String lastName, int maritalStatus, boolean gender, int accountNum) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.maritalStatus = maritalStatus;
        this.gender = gender;
        this.accountNum = accountNum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(int accountNum) {
        this.accountNum = accountNum;
    }

    public Set<Account> getClientAccounts() {
        return new HashSet<Account>(clientAccounts.values());
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(int maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public boolean isMale() {
        return gender;
    }

    public void setGender(Boolean gender){
        this.gender = gender;
    }

    public int incAccount(){
        this.accountNum++;
        return this.accountNum;
    }
    public int decAccount(){
        this.accountNum--;
        return this.accountNum;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", maritalStatus=" + maritalStatus +
                ", gender=" + gender +
                ", clientAccounts=" + clientAccounts +
                ", accountNum=" + accountNum +
                '}';
    }
}

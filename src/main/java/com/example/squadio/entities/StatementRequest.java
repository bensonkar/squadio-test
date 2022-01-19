package com.example.squadio.entities;

public class StatementRequest {
    private String accountId;

    public StatementRequest() {
    }

    public StatementRequest(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        return "StatementRequest{" +
                "accountId='" + accountId + '\'' +
                '}';
    }
}

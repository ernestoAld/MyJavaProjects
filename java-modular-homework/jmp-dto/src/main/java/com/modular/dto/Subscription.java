package com.modular.dto;

import java.time.LocalDate;

public class Subscription {
    private BankCard bankcard;
    private LocalDate startDate;

    public Subscription(BankCard bankcard, int year, int month, int day) {
        this.bankcard = bankcard;
        this.startDate = LocalDate.of(year,month,day);
    }

    public Subscription(BankCard bankcard) {
        this.bankcard = bankcard;
        this.startDate = LocalDate.now();
    }

    public BankCard getBankcard() {
        return bankcard;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    @Override
    public String toString() {
        return  "CARD: \t"+getBankcard().getNumber()+
                "\tUSER: \t"+getBankcard().getUser().toString()+
                "\tDATE: \t"+getStartDate();
    }
}

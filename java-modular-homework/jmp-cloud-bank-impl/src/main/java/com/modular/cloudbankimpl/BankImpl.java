package com.modular.cloudbankimpl;

import com.modular.bankapi.IBank;
import com.modular.dto.*;
/*
* Implementation of IBank interface
* */
public class BankImpl implements IBank {
    /*
    * createBankCard: method that creates a new BankCard depending on the passed BankCardType
    * parameters:
        * String number: parameter to generate the number of the new BankCard
        * User user: parameter that specifies who is the owner of the new BankCard
        * BankCardType bankCardType: parameter used to specify the type of the new BankCard, it can only have 2 values due to the enum used.
    * */
    @Override
    public BankCard createBankCard(String number, User user, BankCardType bankCardType) {
        return (bankCardType.equals(BankCardType.CREDIT) ? new CreditBankCard(number,user) : new DebitBankCard(number,user));
    }
}

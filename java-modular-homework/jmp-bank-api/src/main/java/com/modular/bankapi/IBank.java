package com.modular.bankapi;

import com.modular.dto.BankCard;
import com.modular.dto.BankCardType;
import com.modular.dto.User;
/*
* Creationg IBANK interface with method that returns the creation of new BankCard object;
* */
public interface IBank {
    BankCard createBankCard(String number, User user, BankCardType bankCardType);
}

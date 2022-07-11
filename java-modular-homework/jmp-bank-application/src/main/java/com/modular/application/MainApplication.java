package com.modular.application;

import com.modular.bankapi.IBank;
import com.modular.cloudbankimpl.BankImpl;
import com.modular.dto.*;
import com.modular.service.impl.ServiceImpl;
import com.modular.serviceapi.CustomException;
import com.modular.serviceapi.IService;

import java.util.Optional;
import java.util.ServiceLoader;
import java.util.function.Predicate;

public class MainApplication {
    public static void main(String[] args) throws CustomException {

        //Loading the corrresponding modules with ServiceLoader
        ServiceLoader<IService> myServiceLoader = ServiceLoader.load(IService.class);
        ServiceLoader<IBank> myBankLoader = ServiceLoader.load(IBank.class);


        System.out.println("###############################");
        //Instanciating interfaces to work with them
        IService service = new ServiceImpl();
        IBank bank = new BankImpl();

        //Creating BankCards
        BankCard card1 = bank.createBankCard("216453951",
                new User("Ernesto","Aldana",1998,1,20),
                BankCardType.CREDIT);
        BankCard card2 = bank.createBankCard("2165763771",
                new User("Andrea","Rivera",1993,5,22),
                BankCardType.DEBIT);
        BankCard card3 = bank.createBankCard("216843786",
                new User("Carlos","Gutierrez",1998,2,13),
                BankCardType.DEBIT);
        BankCard card4 = bank.createBankCard("216446811",
                new User("Sofia","Vega",2000,9,8),
                BankCardType.CREDIT);

        //Subscribing cards to subscription List from ServiceImpl
        service.subscribe(card1);
        service.subscribe(card2);
        service.subscribe(card3);
        service.subscribe(card4);


        //Getting list of all users using getAllUsers();
        service.getAllUsers().stream().forEach(System.out::println);

        //Getting Subscription by BankCard number using getSubscriptionByBankCardNumber();
        System.out.println(service.getSubscriptionByBankCardNumber("21645395"));

        //Get average age using getAverageUsersAge();
        System.out.println(service.getAverageUsersAge());
        //checking if an user is able to receive a pay using isPayableUser();
        System.out.println(IService.isPayableUser(new User("Ernesto","Aldana",1998,1,20)));

        //Creating the Predicate to be used inside getAllSubscriptionsByCondition() method;
        Predicate<Subscription> predicate = subscription -> subscription.getBankcard() instanceof CreditBankCard == true;
        System.out.println(service.getAllSubscriptionsByCondition(predicate));



    }
}

package com.modular.service.impl;

import com.modular.dto.BankCard;
import com.modular.dto.Subscription;
import com.modular.dto.User;
import com.modular.serviceapi.CustomException;
import com.modular.serviceapi.IService;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ServiceImpl implements IService {
    //List that will help us to store all the subscriptions in the system
    List<Subscription> subscriptions = new ArrayList<>();

    //subscribe method that allow us to add a new subscription to subscriptions List.
    @Override
    public void subscribe(BankCard bankCard) {
        subscriptions.add(new Subscription(bankCard));
    }
    /*
    * getSubscriptionByBankCardNumber method receives a String that containes the card number that we
    * want to find inside our subscriptions List.
    * this will return an Optional<Subscription> that contains the corresponding subscription if it exists or
    * will return an Optional.empty() showing the error message
    * */
    @Override
    public Optional<Subscription> getSubscriptionByBankCardNumber(String number) throws CustomException {
        var subscription = subscriptions.stream()
                .findFirst()
                .filter(s -> s.getBankcard().getNumber().equals(number));
        try{
            return Optional.ofNullable(subscription.orElseThrow(CustomException::new));
        }catch (CustomException ex){
            System.out.println(ex.getMessage());
        }
        return subscription;
    }

    /*
    * getAllUsers returns a list of all the users stored in the subscriptions List.
    * */
    @Override
    public List<User> getAllUsers() {
        return subscriptions.stream()
                .map(Subscription::getBankcard)//Using Method reference
                .map(BankCard::getUser)//Using Method reference
                .distinct()
                .collect(Collectors.toUnmodifiableList()); //Using toUnmodifiableList();
    }

    /*
    * getAverageUsersAge return a double value that represents the average age of the users
    * stored in the subscriptions List, this method only takes the years of every user.
    * */
    @Override
    public double getAverageUsersAge() {
        double ages = getAllUsers()
                .stream()
                .map(User::getBirthday)
                .mapToLong(age -> ChronoUnit.YEARS.between(age,LocalDate.now()))
                .sum();

        return ages/getAllUsers().size();
    }

    /*
    * getAllSubscriptionsByCondition returns a new List that contains all the subscriptions
    * from the subscriptions List that fits with the conditions defined on the Predicate passed as argument.
    * */
    @Override
    public List<Subscription> getAllSubscriptionsByCondition(Predicate<Subscription> predicate) {
        return subscriptions.stream()
                .filter(predicate)
                .collect(Collectors.toUnmodifiableList());
    }


}

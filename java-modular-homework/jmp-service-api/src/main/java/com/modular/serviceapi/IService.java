package com.modular.serviceapi;

import com.modular.dto.BankCard;
import com.modular.dto.Subscription;
import com.modular.dto.User;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

//Interface that defines the services that should be present
public interface IService {

    /*
    * subscribe receives a BankCard to be stored in the system that will let us work with the functionalities.
    * */
    void subscribe(BankCard bankCard);

    /*
    * getSubscriptionByBankCardNumber method receives a card number and should return the correspondent BankCard if it exists
    * */
    Optional<Subscription> getSubscriptionByBankCardNumber(String number) throws CustomException;

    /*
    * getAllUsers method that returns all the users registered in the system.
    * */
    List<User> getAllUsers();//Metodo para optener todos los usuarios subscritos

    /*
    * getAverageUsersAge method that returs the average ages of the registered users.
    * */
    double getAverageUsersAge();

    /*
    * getAllSubscriptionsByCondition receives a Predicate that will determine the condition to return a list with the subscriptions that
    * fits with this.
    * */
    List<Subscription> getAllSubscriptionsByCondition(Predicate<Subscription> predicate);

    /*
    * isPayableUser Static method that determines if a user is over 18 years old
    * */
    //Static Method
    static boolean isPayableUser(User user){
        Long age = ChronoUnit.YEARS.between(user.getBirthday(), LocalDate.now());
        return age > 18 ?true:false;
    }

}

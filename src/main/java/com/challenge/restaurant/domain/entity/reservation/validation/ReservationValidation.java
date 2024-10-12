package com.challenge.restaurant.domain.entity.reservation.validation;

import com.challenge.restaurant.domain.entity.reservation.Reservation;
import com.challenge.restaurant.domain.exception.restaurant.NotNullLocationException;
import com.challenge.restaurant.domain.exception.restaurant.NotNullNameException;

public class ReservationValidation {
    public Reservation reservationValidation(Reservation restaurant) throws Exception {
        if (reservation.getCnpj().isEmpty()){
            return reservation;
        }

        if (restaurant.getName().isEmpty()){
            throw new NotNullNameException("The name of the restaurant can not be null");
        }

        if(restaurant.getLocation().isEmpty()){
            throw new NotNullLocationException("The location of the restaurant can not be null");
        }

        return new Restaurant(null, restaurant.getName(), restaurant.getCnpj(), restaurant.getLocation(), restaurant.getCuisineType(), restaurant.getCapacity(), restaurant.getOpeningHours());
    }
}

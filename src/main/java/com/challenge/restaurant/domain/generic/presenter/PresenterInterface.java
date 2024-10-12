package com.challenge.restaurant.domain.generic.presenter;

import com.challenge.restaurant.domain.generic.OutputInterface;

import java.util.Map;

public interface PresenterInterface {
    Map<String, Object> toArray();

    OutputInterface getOutput();
}

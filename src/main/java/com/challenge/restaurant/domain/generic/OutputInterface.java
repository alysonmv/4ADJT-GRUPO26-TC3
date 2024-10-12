package com.challenge.restaurant.domain.generic;

import com.challenge.restaurant.domain.generic.output.OutputStatus;

public interface OutputInterface {
    Object getBody();
    OutputStatus getOutputStatus();
}

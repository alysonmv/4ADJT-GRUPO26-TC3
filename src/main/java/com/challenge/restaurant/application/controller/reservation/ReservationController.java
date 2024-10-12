package com.challenge.restaurant.application.controller.reservation;

import com.challenge.restaurant.application.controller.reservation.request.ReservationRequest;
import com.challenge.restaurant.application.response.GenericResponse;
import com.challenge.restaurant.application.response.PresenterResponse;
import com.challenge.restaurant.domain.generic.OutputInterface;
import com.challenge.restaurant.domain.input.ReservationInput;
import com.challenge.restaurant.domain.output.reservation.CreateReservationOutput;
import com.challenge.restaurant.domain.present.reservation.create.IndentifyReservationPresenter;
import com.challenge.restaurant.domain.useCase.reservation.CreateReservationUseCase;
import com.challenge.restaurant.infra.adapter.repository.CreateReservationRepository;
import com.challenge.restaurant.infra.repository.ReservationRepository;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reservation/create")
public class ReservationController {

    private final ReservationRepository reservationRepository;

    @PostMapping
    @Operation(tags = {"reservation"})
    public ResponseEntity<Object> createReservation(@RequestBody ReservationRequest reservationRequest) throws Exception {

        ReservationInput reservationInput = new ReservationInput(
                reservationRequest.restaurantId(),
                reservationRequest.customerName(),
                reservationRequest.reservationDate(),
                reservationRequest.reservationTime(),
                reservationRequest.numberOfGuests()
        );

        CreateReservationUseCase useCase = new CreateReservationUseCase(new CreateReservationRepository(reservationRepository));
        useCase.create(reservationInput);

        OutputInterface outputInterface = useCase.getCreateReservationOutputInterface();

        if (outputInterface.getOutputStatus().getCode() != 200) {
            return new GenericResponse().response(outputInterface);
        }

        IndentifyReservationPresenter presenter = new IndentifyReservationPresenter((CreateReservationOutput) outputInterface);

        return new PresenterResponse().response(presenter);
    }
}

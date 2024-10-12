package com.challenge.restaurant.application.controller.restaurant;

import com.challenge.restaurant.application.controller.restaurant.request.RestaurantRequest;
import com.challenge.restaurant.application.response.GenericResponse;
import com.challenge.restaurant.application.response.PresenterResponse;
import com.challenge.restaurant.domain.entity.restaurant.Restaurant;
import com.challenge.restaurant.domain.generic.OutputInterface;
import com.challenge.restaurant.domain.input.RestaurantInput;
import com.challenge.restaurant.domain.output.restaurant.CreateRestaurantOutput;
import com.challenge.restaurant.domain.present.restaurant.create.IndentifyRestaurantPresenter;
import com.challenge.restaurant.domain.useCase.restaurant.CreateRestaurantUseCase;
import com.challenge.restaurant.infra.adapter.repository.CreateRestaurantRepository;
import com.challenge.restaurant.infra.repository.RestaurantRepository;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurant/create")
public class RestaurantController {

    private final RestaurantRepository restaurantRepository;

    @PostMapping
    @Operation(tags = {"restaurant"})
    public ResponseEntity<Object> createRestaurant(@RequestBody RestaurantRequest restaurantRequest) throws Exception{

        RestaurantInput restaurantInput = new RestaurantInput(
                restaurantRequest.name(),
                restaurantRequest.cnpj(),
                restaurantRequest.location(),
                restaurantRequest.cuisineType(),
                restaurantRequest.capacity(),
                restaurantRequest.openingHours()
        );

        CreateRestaurantUseCase useCase = new CreateRestaurantUseCase(new CreateRestaurantRepository(restaurantRepository));
        useCase.create(restaurantInput);

        OutputInterface outputInterface = useCase.getCreateRestaurantOutputInterface();

        if (outputInterface.getOutputStatus().getCode() != 200) {
            return new GenericResponse().response(outputInterface);
        }

        IndentifyRestaurantPresenter presenter = new IndentifyRestaurantPresenter((CreateRestaurantOutput) outputInterface);

        return new PresenterResponse().response(presenter);
    }

}

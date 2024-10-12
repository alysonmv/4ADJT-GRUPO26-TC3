package com.challenge.restaurant.application.controller.restaurant;

import com.challenge.restaurant.application.controller.restaurant.request.SearchRestaurantRequest;
import com.challenge.restaurant.application.response.GenericResponse;
import com.challenge.restaurant.application.response.PresenterResponse;
import com.challenge.restaurant.domain.generic.OutputInterface;
import com.challenge.restaurant.domain.input.RestaurantSearchInput;
import com.challenge.restaurant.domain.output.restaurant.RestaurantSearchOutput;
import com.challenge.restaurant.domain.present.restaurant.search.RestaurantSearchPresenter;
import com.challenge.restaurant.domain.useCase.restaurant.SearchRestaurantUseCase;
import com.challenge.restaurant.infra.adapter.repository.SearchRestaurantRepository;
import com.challenge.restaurant.infra.repository.RestaurantRepository;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurant/search")
public class RestaurantSearchController {

    private final RestaurantRepository restaurantRepository;

    @PostMapping
    @Operation(tags = {"restaurant"})
    public ResponseEntity<Object> searchRestaurant(@RequestBody SearchRestaurantRequest request) throws Exception {

        RestaurantSearchInput searchInput = new RestaurantSearchInput(
                request.getName(),
                request.getLocation(),
                request.getCuisineType()
        );

        SearchRestaurantUseCase useCase = new SearchRestaurantUseCase(new SearchRestaurantRepository(restaurantRepository));
        useCase.search(searchInput);

        OutputInterface outputInterface = useCase.getRestaurantSearchOutput();

        if (outputInterface.getOutputStatus().getCode() != 200) {
            return new GenericResponse().response(outputInterface);
        }

        RestaurantSearchPresenter presenter = new RestaurantSearchPresenter((RestaurantSearchOutput) outputInterface);

        return new PresenterResponse().response(presenter);
    }
}

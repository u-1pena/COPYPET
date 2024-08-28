package com.u_1.copypet.Controller;

import com.u_1.copypet.Controller.Request.FoodCreateRequest;
import com.u_1.copypet.Controller.Response.ApplicationResponse;
import com.u_1.copypet.Entity.Food;
import com.u_1.copypet.Service.FoodService;
import java.net.URI;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class FoodController {

  private final FoodService foodService;

  public FoodController(FoodService foodService) {
    this.foodService = foodService;

  }

  @PostMapping("/foods")
  public ResponseEntity<ApplicationResponse> createFood(
      @RequestBody @Validated FoodCreateRequest foodCreateRequest,
      UriComponentsBuilder uriBuilder) {
    Food food = foodService.createFood(foodCreateRequest.convertToEntity());
    URI location = uriBuilder.path("/foods/{id}").buildAndExpand(food.getFoodId()).toUri();
    ApplicationResponse body = new ApplicationResponse("food created");
    return ResponseEntity.created(location).body(body);
  }

}


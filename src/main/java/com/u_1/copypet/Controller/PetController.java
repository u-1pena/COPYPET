package com.u_1.copypet.Controller;

import com.u_1.copypet.Controller.Request.PetCreateRequest;
import com.u_1.copypet.Controller.Response.ApplicationResponse;
import com.u_1.copypet.Entity.Pet;
import com.u_1.copypet.Entity.User;
import com.u_1.copypet.Service.PetService;
import com.u_1.copypet.Service.UserService;
import java.net.URI;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class PetController {

  private final PetService petService;
  private final UserService userService;

  public PetController(PetService petService, UserService userService) {
    this.petService = petService;
    this.userService = userService;
  }

  @PostMapping("/pets/{userId}")
  public ResponseEntity<ApplicationResponse> createPet(
      @PathVariable int userId,
      @RequestBody @Validated PetCreateRequest petCreateRequest,
      UriComponentsBuilder uriBuilder) {

    User user = userService.findById(userId);

    petService.checkPetAlreadyRegisteredByUserId(userId);
    Pet pet = petCreateRequest.convertToEntity(user, petService);
    petService.createPet(pet);

    URI location = uriBuilder.path("/pets/{id}").buildAndExpand(pet.getUserId()).toUri();
    ApplicationResponse body = new ApplicationResponse(
        "The pet registration has been completed. The owner is " + user.getName());
    return ResponseEntity.created(location).body(body);
  }


}

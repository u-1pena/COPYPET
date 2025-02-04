package com.u_1.copypet.Controller;

import com.u_1.copypet.Controller.Request.BreedingCreateRequest;
import com.u_1.copypet.Controller.Response.ApplicationResponse;
import com.u_1.copypet.Entity.Breeding;
import com.u_1.copypet.Entity.Pet;
import com.u_1.copypet.Service.BreedingService;
import com.u_1.copypet.Service.PetService;
import java.net.URI;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class BreedingController {

  private final BreedingService breedingService;
  private final PetService petService;

  public BreedingController(BreedingService breedingService, PetService petService) {
    this.breedingService = breedingService;
    this.petService = petService;
  }


  @PostMapping("/breeding/{id}")
  public ResponseEntity<ApplicationResponse> createBreeding(
      @PathVariable int id,
      @RequestBody @Validated BreedingCreateRequest breedingCreateRequest,
      UriComponentsBuilder uriBuilder) {
    Pet pet = petService.findPetById(id);
    breedingService.findBreedingById(id);
    Breeding breeding = breedingCreateRequest.convertToEntity(pet);
    breedingService.createBreeding(breeding);
    URI location = uriBuilder.path("/breeding/{id}").buildAndExpand(breeding.getId()).toUri();
    ApplicationResponse body = new ApplicationResponse("breeding created");
    return ResponseEntity.created(location).body(body);
  }
}

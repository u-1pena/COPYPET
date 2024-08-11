package com.u_1.copypet.Service;

import com.u_1.copypet.Controller.Response.PetAlreadyExistsException;
import com.u_1.copypet.Entity.Pet;
import com.u_1.copypet.Mapper.PetMapper;
import org.springframework.stereotype.Service;


@Service
public class PetService {

  private final PetMapper petMapper;

  public PetService(PetMapper petMapper) {
    this.petMapper = petMapper;
  }

  public Pet createPet(Pet pet) {
    petMapper.insertPet(pet);
    return pet;
  }

  public Pet findPetByUserId(int userId) {
    petMapper.findPetByUserId(userId).ifPresent(pet -> {
      throw new PetAlreadyExistsException("Pet already exists with user id: " + userId);
    });
    return null;//petが存在しないければ進行
  }
}



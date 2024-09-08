package com.u_1.copypet.Service;

import com.u_1.copypet.Controller.Response.BreedingAlreadyExistsException;
import com.u_1.copypet.Entity.Breeding;
import com.u_1.copypet.Mapper.BreedingMapper;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class BreedingService {

  private final BreedingMapper breedingMapper;

  public BreedingService(BreedingMapper breedingMapper) {
    this.breedingMapper = breedingMapper;
  }

  public Breeding createBreeding(Breeding breeding) {
    breedingMapper.insertBreeding(breeding);
    return breeding;
  }

  public Optional<Breeding> findBreedingById(int id) {
    return this.breedingMapper.findBreedingById(id)
        .map(breeding -> {
          throw new BreedingAlreadyExistsException(
              "Breeding already exists with pet id: " + id);
        });

  }
}


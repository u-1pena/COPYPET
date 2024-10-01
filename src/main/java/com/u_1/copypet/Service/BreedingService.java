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

  //CREATE処理 breedingを作成するメソッド
  public Breeding createBreeding(Breeding breeding) {
    breedingMapper.insertBreeding(breeding);
    return breeding;
  }

  //READ処理 breedingを取得するメソッド。登録の際、重複登録を防ぐため例外を投げる
  public Optional<Breeding> findBreedingById(int id) {
    return this.breedingMapper.findBreedingById(id)
        .map(breeding -> {
          throw new BreedingAlreadyExistsException(
              "Breeding already exists with id: " + id);
        });

  }

  //UPDATE処理 breedingを更新するメソッド

}


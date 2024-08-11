package com.u_1.copypet.Controller.Response;

public class PetAlreadyExistsException extends RuntimeException {

  public PetAlreadyExistsException(String message) {
    super(message);
  }
}

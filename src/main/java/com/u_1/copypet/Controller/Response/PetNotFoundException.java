package com.u_1.copypet.Controller.Response;

public class PetNotFoundException extends RuntimeException {

  public PetNotFoundException(String message) {
    super(message);
  }

}

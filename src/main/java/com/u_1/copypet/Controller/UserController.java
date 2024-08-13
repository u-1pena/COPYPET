package com.u_1.copypet.Controller;

import com.u_1.copypet.Controller.Request.UserCreateRequest;
import com.u_1.copypet.Controller.Response.ApplicationResponse;
import com.u_1.copypet.Entity.User;
import com.u_1.copypet.Service.UserService;
import java.net.URI;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/users")//ユーザー新規登録
  public ResponseEntity<ApplicationResponse> createUser(
      @RequestBody @Validated UserCreateRequest userCreateRequest,
      UriComponentsBuilder uriBuilder) {
    User user = userService.createUser(userCreateRequest.convertToEntity());
    URI location = uriBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();
    ApplicationResponse body = new ApplicationResponse("user created");
    return ResponseEntity.created(location).body(body);
  }

}

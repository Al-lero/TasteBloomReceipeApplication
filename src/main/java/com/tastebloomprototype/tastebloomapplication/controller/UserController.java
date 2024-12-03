package com.tastebloomprototype.tastebloomapplication.controller;

import com.tastebloomprototype.tastebloomapplication.Data.Repository.UserRepository;
import com.tastebloomprototype.tastebloomapplication.Dto.request.LoginRequest;
//import com.tastebloomprototype.tastebloomapplication.Dto.request.RecipeRequest;
import com.tastebloomprototype.tastebloomapplication.Dto.request.UserRequest;
import com.tastebloomprototype.tastebloomapplication.Dto.response.TasteBloomResponse;
//import com.tastebloomprototype.tastebloomapplication.Service.RecipeService;
import com.tastebloomprototype.tastebloomapplication.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

//    @Autowired
//    RecipeService recipeService;

    @Autowired
    UserRepository userRepository;

//    public UserController(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    @PostMapping("create")
    public TasteBloomResponse createUser(@Valid @RequestBody UserRequest userRequest) {
        return userService.createUser(userRequest);

    }

//    @PostMapping("login")
////    public TasteBloomResponse loginUser(@Valid @RequestBody LoginRequest loginRequest) {
////        Boolean loginsuccessful = userService.loginUser(loginRequest);
////        return TasteBloomResponse.builder()
////                .responseCode("LOGIN_SUCCESSFUL")
////                .responseMessage("Login successful!")
////                .build();
////
////    } else
////
////    {
////        return TasteBloomResponse.builder()
////                .responseCode("Invalid_Credentials")
////                .responseMessage("Invlaid Credentials")
////                .build();
////    }

//    @PostMapping("/createReceipe")
//    public TasteBloomResponse createReceipe(@Valid @RequestBody RecipeRequest recipeRequest){
//        return recipeService.createRecipe(recipeRequest);
//    }


}

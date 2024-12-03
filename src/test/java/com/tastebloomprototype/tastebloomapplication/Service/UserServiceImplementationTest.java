//package com.tastebloomprototype.tastebloomapplication.Service;
//
//import com.tastebloomprototype.tastebloomapplication.Data.Model.User;
//import com.tastebloomprototype.tastebloomapplication.Data.Repository.UserRepository;
//import com.tastebloomprototype.tastebloomapplication.Dto.request.UserRequest;
//import com.tastebloomprototype.tastebloomapplication.Dto.response.TasteBloomResponse;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//class UserServiceImplementationTest {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private UserService userService;
//
//    @Test
//    public void testThatUserCanBeCreated(){
//        UserRequest userRequest = new UserRequest();
//        userRequest.setName("Alero");
//        userRequest.setEmail("utieyionealero@yahoo.com");
//        userRequest.setPassword("123456");
//        userRequest.setPhoneNumber("09123562541");
//        TasteBloomResponse response = userService.createUser(userRequest);
//        User user = userRepository.findByEmail("utieyionealero@yahoo.com");
//        User.sendEmailAlert(emailDetails);
//    }
//
//}
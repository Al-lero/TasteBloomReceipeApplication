package com.tastebloomprototype.tastebloomapplication.Service;

import com.tastebloomprototype.tastebloomapplication.Data.Model.User;
import com.tastebloomprototype.tastebloomapplication.Data.Repository.UserRepository;
import com.tastebloomprototype.tastebloomapplication.Dto.request.LoginRequest;
import com.tastebloomprototype.tastebloomapplication.Dto.request.UserRequest;
import com.tastebloomprototype.tastebloomapplication.Dto.response.TasteBloomResponse;
import com.tastebloomprototype.tastebloomapplication.utils.TasteBloomUtils;
import lombok.Builder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@SpringBootTest
class UserServiceImplementationTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;
    private UserRequest userRequest;

    @BeforeEach
    public void setup(){
        userRequest  = new UserRequest();
        userRequest.setEmail("utieyionealero@yahoo.com");
        userRequest.setName("mofe");
        userRequest.setPassword("900021");
        userRequest.setPhoneNumber("91290234521");

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail("utieyionealero@yahoo.com");
        loginRequest.setPassword("900021");

        userRepository.deleteAll();
    }

    @Test
    public void testCreateUser_UserExists(){
        User existingUser = User.builder()
                .email("utieyionealero@yahoo.com")
                .name("mofe")
                .phoneNumber("91290234521")
                .password("900021")
                .build();
        userRepository.save(existingUser);

        TasteBloomResponse response = userService.createUser(userRequest);

        assertEquals(TasteBloomUtils.User_Exist_code,response.getResponseCode());
        assertEquals(TasteBloomUtils.User_Exists_Message, response.getResponseMessage());


    }

    @Test
    public void testUserWasCreatedSuccesfully(){
        TasteBloomResponse response = userService.createUser(userRequest);
        assertEquals(TasteBloomUtils.User_Created_Successfully,response.getResponseCode());
        assertEquals(TasteBloomUtils.User_Creation_Message,response.getResponseMessage());

        User savedUser = userRepository.findByEmail(userRequest.getEmail());
        assertNotNull(savedUser);
        assertEquals(userRequest.getEmail(), savedUser.getEmail());
        assertEquals(userRequest.getName(), savedUser.getName());
        assertEquals(userRequest.getPhoneNumber(), savedUser.getPhoneNumber());

    }


    @Test
    public void testThatUserCanLogin() {

        TasteBloomResponse response = userService.createUser(userRequest);
        assertEquals(TasteBloomUtils.User_Created_Successfully, response.getResponseCode());

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail("utieyionealero@yahoo.com");
        loginRequest.setPassword("900021");

        boolean loginSuccessful = userService.loginUser(loginRequest);
        assertNotNull(loginSuccessful);
        assertEquals(true, loginSuccessful);
    }




}



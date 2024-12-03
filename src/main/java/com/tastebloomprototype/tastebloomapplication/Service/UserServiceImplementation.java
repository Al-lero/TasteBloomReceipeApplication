package com.tastebloomprototype.tastebloomapplication.Service;

import com.tastebloomprototype.tastebloomapplication.Data.Model.User;
import com.tastebloomprototype.tastebloomapplication.Data.Repository.UserRepository;
import com.tastebloomprototype.tastebloomapplication.Dto.request.EmailDetails;
import com.tastebloomprototype.tastebloomapplication.Dto.request.LoginRequest;
import com.tastebloomprototype.tastebloomapplication.Dto.request.UserRequest;
import com.tastebloomprototype.tastebloomapplication.Dto.response.TasteBloomResponse;
import com.tastebloomprototype.tastebloomapplication.utils.TasteBloomUtils;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    EmailService emailService;


    @Override
    public TasteBloomResponse createUser(UserRequest userRequest) {
        if (userRepository.existsUserByEmail(userRequest.getEmail())){
            return TasteBloomResponse.builder()
                    .responseCode(TasteBloomUtils.User_Exist_code)
                    .responseMessage(TasteBloomUtils.User_Exists_Message)

                    .build();

        }

        User newUser = User.builder()
                .email(userRequest.getEmail())
                .name(userRequest.getName())
                .phoneNumber(userRequest.getPhoneNumber())
                .password(userRequest.getPassword())
                .build();

        User savedUser = userRepository.save(newUser);

        EmailDetails emailDetails = EmailDetails.builder()
                .recipient(savedUser.getEmail())
                .subject("Welcome!!")
                .messageBody("Welcome to Taste Bloom Receipe, where meals are magical" +
                        "\nTasteBloom Name: " + savedUser.getName() + " " + "\nTasteBloom Email:" + savedUser.getEmail() + " " + "\nTasteBloom Password:" + savedUser.getPassword())
                .build();

        emailService.sendEmailALert(emailDetails);

        return TasteBloomResponse.builder()
                .responseCode(TasteBloomUtils.User_Created_Successfully)
                .responseMessage(TasteBloomUtils.User_Creation_Message)

                .build();


    }

    @Override
    public Boolean loginUser(LoginRequest loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getEmail());

        if( user == null) {
            return false;

        }
        return loginRequest.getPassword().equals(user.getPassword());
    }


}

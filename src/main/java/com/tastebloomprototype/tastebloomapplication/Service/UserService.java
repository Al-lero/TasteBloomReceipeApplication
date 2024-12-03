package com.tastebloomprototype.tastebloomapplication.Service;

import com.tastebloomprototype.tastebloomapplication.Dto.request.UserRequest;
import com.tastebloomprototype.tastebloomapplication.Dto.response.TasteBloomResponse;

public interface UserService {
    TasteBloomResponse createUser(UserRequest userRequest);
}

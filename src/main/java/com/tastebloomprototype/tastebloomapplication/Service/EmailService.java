package com.tastebloomprototype.tastebloomapplication.Service;

import com.tastebloomprototype.tastebloomapplication.Dto.request.EmailDetails;

public interface EmailService {

    void sendEmailALert(EmailDetails emailDetails);
}

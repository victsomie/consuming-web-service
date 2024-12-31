package com.example.consumingwebservice.client;

import com.example.consumingwebservice.wsdl.GetUserRequest;
import com.example.consumingwebservice.wsdl.GetUserResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class UserClient extends WebServiceGatewaySupport {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserClient.class);


    public GetUserResponse getUserResponse(String userName){

        GetUserRequest request = new GetUserRequest();
        request.setName(userName);


        GetUserResponse response = (GetUserResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8091/ws/USERS",
                        request,
                        new SoapActionCallback("http://techprimers.com/spring-boot-soap-example")
                );

        return response;

    }
}

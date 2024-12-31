package com.example.consumingwebservice.client;

import com.example.consumingwebservice.wsdl.GetBankResponseType;
import com.example.consumingwebservice.wsdl.GetBankType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class BankClient extends WebServiceGatewaySupport {
    private static final Logger log = LoggerFactory.getLogger(BankClient.class);

    public GetBankResponseType getBankResponseType(String blzCode) {

        // The request object
        GetBankType request = new GetBankType();
        request.setBlz(blzCode);

        log.info("Requesting location for BANK CODE: " + blzCode);

        // The RESPONSE
        GetBankResponseType responseType = (GetBankResponseType) getWebServiceTemplate()
                .marshalSendAndReceive("http://www.thomas-bayer.com/axis2/services/BLZService",
                        request, new SoapActionCallback("http://thomas-bayer.com/blz/BLZService/getBankResponse")
                );
        return responseType;
    }
}

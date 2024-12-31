package com.example.consumingwebservice;

import com.example.consumingwebservice.client.BankClient;
import com.example.consumingwebservice.client.CountryClient;
import com.example.consumingwebservice.client.UserClient;
import com.example.consumingwebservice.client.WeatherClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class CountryConfiguration {

    @Bean
    public Jaxb2Marshaller marshaller(){

        Jaxb2Marshaller marshaller =  new Jaxb2Marshaller();

        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.setContextPath("com.example.consumingwebservice.wsdl");

        return marshaller;
    }


    @Bean
    public CountryClient countryClient(Jaxb2Marshaller marshaller){

        CountryClient client = new CountryClient();

        client.setDefaultUri("http://localhost:8080/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);

        return client;
    }

    @Bean
    public UserClient userClient(Jaxb2Marshaller marshaller){

        UserClient userClient = new UserClient();
        userClient.setDefaultUri("http://localhost:8080/ws");
        userClient.setMarshaller(marshaller);
        userClient.setUnmarshaller(marshaller);

        return userClient;
    }

    @Bean
    public WeatherClient weatherClient(Jaxb2Marshaller marshaller){
        WeatherClient client = new WeatherClient();

         client.setDefaultUri("http://localhost:8080/ws/users");
//        client.setDefaultUri("http://wsf.cdyne.com/WeatherWS");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);

        return client;
    }

    @Bean
    public BankClient bankClient(Jaxb2Marshaller marshaller){
        BankClient bankClient = new BankClient();
        bankClient.setDefaultUri("http://www.thomas-bayer.com/axis2/services/BLZService");
        bankClient.setMarshaller(marshaller);
        bankClient.setUnmarshaller(marshaller);

        return bankClient;
    }
}

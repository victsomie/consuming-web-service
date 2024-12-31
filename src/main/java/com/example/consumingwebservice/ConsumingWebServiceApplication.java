package com.example.consumingwebservice;

import com.example.consumingwebservice.client.BankClient;
import com.example.consumingwebservice.client.CountryClient;
import com.example.consumingwebservice.client.UserClient;
import com.example.consumingwebservice.client.WeatherClient;
import com.example.consumingwebservice.wsdl.GetCityForecastByZIPResponse;
import com.example.consumingwebservice.wsdl.GetCountryResponse;
import com.example.consumingwebservice.wsdl.GetUserResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ConsumingWebServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumingWebServiceApplication.class, args);
    }
//
//
//    @Bean
//    CommandLineRunner lookup(CountryClient quoteClient, UserClient userClient, WeatherClient weatherClient, BankClient bankClient) {
//        return args -> {
//            String country = "Spain";
//            String userPeter = "Peter";
//
//            if (args.length > 0) {
//                country = args[0];
//            }
//            GetCountryResponse response = quoteClient.getCountry(country);
//            System.err.println(response.getCountry().getCurrency());
//
//            GetUserResponse userResponse = userClient.getUserResponse(userPeter);
//            System.err.println("USERS RESPONSE: " +userResponse.getUser().getName());
//
//
//
//            /*
//			GetCityForecastByZIPResponse responseWeather =  weatherClient.getCityForecastByZIP("94304");
//			weatherClient.printResponse(responseWeather);
//
//             */
//
//
//            /*
//            GetBankResponseType bankResponseType = bankClient.getBankResponseType("56062227");
//            System.err.println("================ bankResponseType: " + bankResponseType.getDetails().getBezeichnung());
//
//             */
//        };
//    }
}

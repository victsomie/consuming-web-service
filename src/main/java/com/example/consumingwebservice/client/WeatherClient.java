package com.example.consumingwebservice.client;

import com.example.consumingwebservice.wsdl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import java.text.SimpleDateFormat;


public class WeatherClient extends WebServiceGatewaySupport {

    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherClient.class);

    public GetCityForecastByZIPResponse getCityForecastByZIP(String zipCode) {

        GetCityForecastByZIP request = new GetCityForecastByZIP();
        request.setZIP(zipCode);

        LOGGER.info("Requesting forecast for " + zipCode + "...");

        GetCityForecastByZIPResponse response = (GetCityForecastByZIPResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://wsf.cdyne.com/WeatherWS/Weather.asmx",
                        request,
                        new SoapActionCallback("http://ws.cdyne.com/WeatherWS/GetCityForecastByZIP"));

        return response;
    }

    public void printResponse(GetCityForecastByZIPResponse response) {
        ForecastReturn forecastReturn = response.getGetCityForecastByZIPResult();

        if (forecastReturn.isSuccess()) {
            LOGGER.info("Forecast for " + forecastReturn.getCity() + ", " + forecastReturn.getState());

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

            for (Forecast forecast : forecastReturn.getForecastResult().getForecast()) {

                Temp temperature = forecast.getTemperatures();

                LOGGER.info(String.format("%s %s %s°-%s°", format.format(forecast.getDate().toGregorianCalendar().getTime()), forecast.getDesciption(), temperature.getMorningLow(), temperature.getDaytimeHigh()));

            }
        } else {
            LOGGER.info("No forecast received");
        }
    }
}

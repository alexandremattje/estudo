package com.salsatechnology.integration.controller;

import com.salsatechnology.dto.ProductOrderListDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Map;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ProductOrderControllerTest {

    @Test
    public void requestOrderFilteredOKTest() {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Object> responseEntity = restTemplate.getForEntity(
                "http://localhost:8080/orders/list?productType={productType}&page={page}&offSet={offSet}",
                Object.class,
                Map.of(
                        "productType", "SUNSHADE",
                        "page", "0",
                        "offSet", "3"
                ));

        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void requestOrderFilteredBadRequestMissingPRODUCTTYPETest() {
        RestTemplate restTemplate = new RestTemplate();

        restTemplate.setErrorHandler(this.getAssertionsErrorHandler(HttpStatus.BAD_REQUEST));
        restTemplate.getForEntity(
                "http://localhost:8080/orders/list?page={page}&offSet={offSet}",
                Object.class,
                Map.of(
                        "page", "0",
                        "offSet", "3"
                ));

    }

    @Test
    public void requestOrderFilteredBadRequestMissingPAGETest() {
        RestTemplate restTemplate = new RestTemplate();

        restTemplate.setErrorHandler(this.getAssertionsErrorHandler(HttpStatus.BAD_REQUEST));
        restTemplate.getForEntity(
                "http://localhost:8080/orders/list?productType={productType}&offSet={offSet}",
                Object.class,
                Map.of(
                        "productType", "SUNSHADE",
                        "offSet", "3"
                ));

    }

    @Test
    public void requestOrderFilteredBadRequestMissingOFFSETTest() {
        RestTemplate restTemplate = new RestTemplate();

        restTemplate.setErrorHandler(this.getAssertionsErrorHandler(HttpStatus.BAD_REQUEST));
        restTemplate.getForEntity(
                "http://localhost:8080/orders/list?productType={productType}&page={page}",
                Object.class,
                Map.of(
                        "productType", "SUNSHADE",
                        "page", "0"
                ));

    }

    private ResponseErrorHandler getAssertionsErrorHandler(HttpStatus httpStatus) {
        return new ResponseErrorHandler() {
            @Override
            public boolean hasError(ClientHttpResponse response) throws IOException {
                return true;
            }

            @Override
            public void handleError(ClientHttpResponse response) throws IOException {
                Assertions.assertEquals(httpStatus, response.getStatusCode());
            }
        };
    }

}

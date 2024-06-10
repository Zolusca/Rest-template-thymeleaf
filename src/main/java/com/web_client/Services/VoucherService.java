package com.web_client.Services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.web_client.Entities.Vouchers;
import com.web_client.Exceptions.ClientErrorExceptions;
import com.web_client.HttpResponseApi.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class VoucherService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ObjectMapper objectMapper;

    protected final String PATH_URI = "http://localhost:9090/api/voucher";

    public Vouchers getDetailVoucher() throws JsonProcessingException {
        try{
            ResponseEntity<ApiResponses<Vouchers>> response =
                    restTemplate.exchange(
                            PATH_URI + "/detail/100",
                            HttpMethod.GET,
                            null,
                            new ParameterizedTypeReference<ApiResponses<Vouchers>>() {}
                    );

            return response.getBody().getData();

        }catch (HttpClientErrorException e){
            ApiResponses<String> responseErr = objectMapper.readValue(e.getResponseBodyAsString(), new TypeReference<ApiResponses<String>>() {});
            throw new ClientErrorExceptions("err",responseErr.getError());
        }
    }

}

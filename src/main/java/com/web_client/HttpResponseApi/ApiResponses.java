package com.web_client.HttpResponseApi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @param <T>
 * class ini merepresentasikan response dari server
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponses<T> {
    private Integer code;
    private List<String> error;
    private T data;
}

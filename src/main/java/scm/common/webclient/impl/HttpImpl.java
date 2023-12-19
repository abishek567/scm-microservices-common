package scm.common.webclient.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import scm.common.exception.CustomException;
import scm.common.response.Response;
import scm.common.utils.CommonUtils;
import scm.common.webclient.Http;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class HttpImpl implements Http {

    private final String URL_PREFIX = "http://";
    private final ReactorLoadBalancerExchangeFilterFunction lbFunction;

    @Bean
    @Primary
    public WebClient loadBalancedWebClient() {
        return WebClient
                .builder()
                .filter(lbFunction)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    @Override
    public <T> T get(String url, String path, Map<String, String> params, Class<T> responseType) throws Exception {
        Response<T> response = Objects.requireNonNull(loadBalancedWebClient()
                .get()
                .uri(uriBuilder -> {
                    uriBuilder.path(URL_PREFIX + url + path);
                    params.forEach(uriBuilder::queryParam);
                    return uriBuilder.build();
                })
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Response<T>>() {
                })
                .block());

        if (response.getResponseHeader().getStatus().isError()) {
            throw new CustomException(response.getResponseHeader().getError());
        } else {
            String jsonString = CommonUtils.getJsonObjectStringFromModel((Serializable) response.getResponseBody());
            return CommonUtils.getModelFromJsonObject(jsonString, responseType);
        }
    }

    @Override
    public <T> List<T> getList(String url, String path, Map<String, String> params, Class<T> responseType) throws Exception {
        Response<List<T>> response = Objects.requireNonNull(loadBalancedWebClient()
                .get()
                .uri(uriBuilder -> {
                    uriBuilder.path(URL_PREFIX + url + path);
                    params.forEach(uriBuilder::queryParam);
                    return uriBuilder.build();
                })
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Response<List<T>>>() {
                })
                .block());

        if (response.getResponseHeader().getStatus().isError()) {
            throw new CustomException(response.getResponseHeader().getError());
        } else {
            String jsonString = CommonUtils.getJsonObjectStringFromModel((Serializable) response.getResponseBody());
            return CommonUtils.getListFromJsonArray(jsonString, responseType);
        }
    }

    @Override
    public <T, S> S post(String url, String path, T requestBody, Class<S> responseType) throws Exception {
        Response<S> response = Objects.requireNonNull(loadBalancedWebClient()
                .post()
                .uri(URL_PREFIX + url + path)
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Response<S>>() {
                })
                .block());

        if (response.getResponseHeader().getStatus().isError()) {
            throw new CustomException(response.getResponseHeader().getError());
        } else {
            String jsonString = CommonUtils.getJsonObjectStringFromModel((Serializable) response.getResponseBody());
            return CommonUtils.getModelFromJsonObject(jsonString, responseType);
        }
    }

    @Override
    public <T, S> List<S> postAndReceiveList(String url, String path, T requestBody, Class<S> responseType) throws Exception {
        Response<List<S>> response = Objects.requireNonNull(loadBalancedWebClient()
                .post()
                .uri(URL_PREFIX + url + path)
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Response<List<S>>>() {
                })
                .block());

        if (response.getResponseHeader().getStatus().isError()) {
            throw new CustomException(response.getResponseHeader().getError());
        } else {
            String jsonString = CommonUtils.getJsonObjectStringFromModel((Serializable) response.getResponseBody());
            return CommonUtils.getListFromJsonArray(jsonString, responseType);
        }
    }

}

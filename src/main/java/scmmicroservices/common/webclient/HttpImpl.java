package scmmicroservices.common.webclient;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import scmmicroservices.common.exception.CustomException;
import scmmicroservices.common.response.Response;
import scmmicroservices.common.utils.CommonUtils;

import java.io.Serializable;
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
    public <T> T get(String url, String path, Class<T> responseType) throws Exception {
        Response response = Objects.requireNonNull(loadBalancedWebClient()
                .get()
                .uri(URL_PREFIX + url + path)
                .retrieve()
                .bodyToMono(Response.class)
                .block());

        if (response.getResponseHeader().getStatus().isError()) {
            throw new CustomException(response.getResponseHeader().getError());
        } else {
            String jsonString = CommonUtils.getJsonObjectStringFromModel((Serializable) response.getResponseBody());
            return CommonUtils.getModelFromJsonObject(jsonString, responseType);
        }
    }

    @Override
    public <T, S> S post(String url, String path, T requestBody, Class<S> responseType) throws Exception {
        Response response = Objects.requireNonNull(loadBalancedWebClient()
                .post()
                .uri(URL_PREFIX + url + path)
                .body(BodyInserters.fromValue(requestBody))
                .retrieve()
                .bodyToMono(Response.class)
                .block());

        if (response.getResponseHeader().getStatus().isError()) {
            throw new CustomException(response.getResponseHeader().getError());
        } else {
            String jsonString = CommonUtils.getJsonObjectStringFromModel((Serializable) response.getResponseBody());
            return CommonUtils.getModelFromJsonObject(jsonString, responseType);
        }
    }

}

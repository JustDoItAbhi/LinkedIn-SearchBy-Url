package linkedinprofilesearch.linkedinprofilesearch.interseptorservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Component
public class HeaderRequestInterceptor implements ClientHttpRequestInterceptor {
    private final String headerName;
    private final String headerValue;


    public HeaderRequestInterceptor(@Value("${spring.api.url.key}") String headerName,
                                    @Value("${spring.api.url.host}") String headerValue) {
        this.headerName = headerName;
        this.headerValue = headerValue;
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        try {
            request.getHeaders().set(headerName, headerValue);
            return execution.execute(request, body);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
//List<ClientHttpRequestInterceptor> interceptors = new ArrayList<ClientHttpRequestInterceptor>();
//        interceptors.add(new HeaderRequestInterceptor(new HeaderRequestInterceptor("x-rapidapi-key", apiKey));
//RestTemplate restTemplate=new RestTemplate();
//        restTemplate.setInterceptors(interceptors);

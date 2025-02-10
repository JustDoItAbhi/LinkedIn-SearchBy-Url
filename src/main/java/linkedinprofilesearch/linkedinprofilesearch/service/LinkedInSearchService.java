package linkedinprofilesearch.linkedinprofilesearch.service;

import linkedinprofilesearch.linkedinprofilesearch.dto.LinkedInSearchRequest;
import linkedinprofilesearch.linkedinprofilesearch.dto.LinkedInSearchResult;
import linkedinprofilesearch.linkedinprofilesearch.interseptorservice.HeaderRequestInterceptor;
import linkedinprofilesearch.linkedinprofilesearch.models.LinkedInSearchItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class LinkedInSearchService implements ISearchService{
    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    @Value("${spring.api.url.key}")
    private String apiKey;
    @Value("${spring.api.url.host}")
    private String apiUrl;
    private String URL="https://linkedin-data-api.p.rapidapi.com/search-people-by-url";
    @Override
    public List<LinkedInSearchItem> searchPeople(LinkedInSearchRequest linkedInSearchRequest) {
        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<ClientHttpRequestInterceptor>();
        interceptors.add(new HeaderRequestInterceptor("x-rapidapi-key", apiKey));
        RestTemplate restTemplate=restTemplateBuilder.build();
        restTemplate.setInterceptors(interceptors);
//        RestTemplate restTemplate=restTemplateBuilder.additionalInterceptors(
//                new HeaderRequestInterceptor("x-rapidapi-key", apiKey)).build();

        ResponseEntity<LinkedInSearchResult>response=restTemplate.postForEntity(URL, linkedInSearchRequest,LinkedInSearchResult.class);
       if(response.getBody()==null){
           throw new RuntimeException("RESPONSE IS NULL ");
       }
        return response.getBody().getData().getItems();
    }
}

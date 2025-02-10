package linkedinprofilesearch.linkedinprofilesearch.controller;

import linkedinprofilesearch.linkedinprofilesearch.dto.LinkedInSearchRequest;
import linkedinprofilesearch.linkedinprofilesearch.models.LinkedInSearchItem;
import linkedinprofilesearch.linkedinprofilesearch.service.ISearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/linkedin")
public class LinkedInSearchController {
    @Autowired
    private ISearchService searchService;

    public LinkedInSearchController(ISearchService searchService) {
        this.searchService = searchService;
    }

    @PostMapping("/")
    public ResponseEntity<List<LinkedInSearchItem>> search( @RequestBody LinkedInSearchRequest request){
        List<LinkedInSearchItem> results = searchService.searchPeople(request);

//        if (results == null || results.isEmpty()) {
//            return ResponseEntity.notFound().build(); // Return 404 if no match
//        }
        return ResponseEntity.ok(results); // Return only the first match
    }
}

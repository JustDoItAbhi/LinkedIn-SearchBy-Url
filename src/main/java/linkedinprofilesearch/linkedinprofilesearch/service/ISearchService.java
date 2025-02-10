package linkedinprofilesearch.linkedinprofilesearch.service;

import linkedinprofilesearch.linkedinprofilesearch.dto.LinkedInSearchRequest;
import linkedinprofilesearch.linkedinprofilesearch.models.LinkedInSearchItem;

import java.util.List;

public interface ISearchService {
    List<LinkedInSearchItem> searchPeople(LinkedInSearchRequest linkedInSearchRequest);
}

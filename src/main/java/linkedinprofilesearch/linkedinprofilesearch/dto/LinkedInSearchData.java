package linkedinprofilesearch.linkedinprofilesearch.dto;

import linkedinprofilesearch.linkedinprofilesearch.models.LinkedInSearchItem;
import lombok.Data;

import java.util.List;

@Data
public class LinkedInSearchData {
    private List<LinkedInSearchItem> items;
}

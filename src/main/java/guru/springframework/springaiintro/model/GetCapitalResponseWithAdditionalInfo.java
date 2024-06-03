package guru.springframework.springaiintro.model;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public record GetCapitalResponseWithAdditionalInfo(
        @JsonPropertyDescription("The population of the country") Long population,
        @JsonPropertyDescription("The region of the country") String region,
        @JsonPropertyDescription("The language of the country") String language,
        @JsonPropertyDescription("The currency of the country (emoji preferable)") String currency) {
}

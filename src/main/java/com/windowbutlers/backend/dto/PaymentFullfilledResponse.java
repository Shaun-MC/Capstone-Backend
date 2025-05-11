package com.windowbutlers.backend.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentFullfilledResponse {
    @JsonProperty("isFullfilled")
    private boolean isFullfilled;

    @JsonProperty("unpaidJobs")
    private List<JobSummary> unpaidJobs;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class JobSummary {
        private String id;
        private String title;
        private String dateCompleted;
    }
}

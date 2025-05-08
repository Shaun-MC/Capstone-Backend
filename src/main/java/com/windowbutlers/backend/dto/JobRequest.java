package com.windowbutlers.backend.dto;

import com.windowbutlers.backend.enums.JobTitles;
import com.windowbutlers.backend.enums.JobRatings;
import com.windowbutlers.backend.validation.ValidEnum;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.sql.Date;

@Data
public class JobRequest {
    
    @NotBlank(message = "Job name is required")
    @ValidEnum(enumClass = JobTitles.class)
    private JobTitles title;

    // Idrk
    @NotBlank(message = "Job date is required")
    @Pattern(
        regexp = "^(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])/\\d{4}$",
        message = "Job date must be valid"
    )
    private Date dateStarted;

    // Idrk
    @Pattern(
        regexp = "^(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])/\\\\d{4}$",
        message = "Job time must be valid"
    )
    private Date dateCompleted;

    @Min(value=0, message = "Labor hours must be a positive integer")
    private Integer laborHours;

    @Size(max = 255, message = "Notes must be less then 255 characters")
    private String notes;

    @NotBlank(message = "Job difficulty is required")
    @ValidEnum(enumClass = JobRatings.class)
    private JobRatings difficulty;

    @NotBlank(message = "Home id is required")
    private String homeID;
}

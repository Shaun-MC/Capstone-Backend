package com.windowbutlers.backend.dto;

import com.windowbutlers.backend.enums.JobTitle;
import com.windowbutlers.backend.enums.Rating;
import com.windowbutlers.backend.validation.ValidEnum;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.sql.Date;

@Data
public class JobRequest {
    
    @NotBlank(message = "Job name is required")
    @ValidEnum(enumClass = JobTitle.class)
    private String jobName;

    @NotBlank(message = "Job description is required")
    @Size(min = 2, max = 255, message = "Job description must be between 2 and 255 characters")
    private String jobDescription;

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
    @ValidEnum(enumClass = Rating.class)
    private String jobDifficulty;
}

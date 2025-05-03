package com.windowbutlers.backend.entity;

import com.windowbutlers.backend.enums.StyleLabel;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "style")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Style {

    // Unsure if the ID is necessary for a domain table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // This being unique makes it a domain table
    @Column(name = "label", nullable = false, unique = true)
    private StyleLabel label;
}
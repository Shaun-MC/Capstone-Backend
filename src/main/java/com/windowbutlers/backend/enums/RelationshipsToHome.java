package com.windowbutlers.backend.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonCreator;

public enum RelationshipsToHome {
    FAMILY_MEMBER("Family Member"),
    PROPERTY_MANAGER("Property Manager"),
    RENTER("Renter"),
    HOME_OWNER("Home Owner");

    private final String displayRelationship;

    RelationshipsToHome(String relationship) {
        this.displayRelationship = relationship;
    }

    @JsonValue
    public String getRelationship() {
        return displayRelationship;
    }

    @JsonCreator
    public static RelationshipsToHome fromString(String value) {
        for (RelationshipsToHome relationship : RelationshipsToHome.values()) {
            if (relationship.displayRelationship.equalsIgnoreCase(value) || relationship.name().equalsIgnoreCase(value)) {
                return relationship;
            }
        }
        throw new IllegalArgumentException("Invalid RelationshipToHome: " + value);
    }
}

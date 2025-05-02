package com.windowbutlers.backend.enums;

public enum RelationshipToHome {
    FAMILY_MEMBER("Family Member"),
    PROPERTY_MANAGER("Property Manager"),
    RENTER("Renter"),
    HOME_OWNER("Home Owner");

    private final String relationship;

    RelationshipToHome(String relationship) {
        this.relationship = relationship;
    }

    public String getRelationship() {
        return relationship;
    }
}

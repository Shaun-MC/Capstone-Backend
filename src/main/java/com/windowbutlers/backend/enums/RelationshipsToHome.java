package com.windowbutlers.backend.enums;

public enum RelationshipsToHome {
    FAMILY_MEMBER("Family Member"),
    PROPERTY_MANAGER("Property Manager"),
    RENTER("Renter"),
    HOME_OWNER("Home Owner");

    private final String relationship;

    RelationshipsToHome(String relationship) {
        this.relationship = relationship;
    }

    public String getRelationship() {
        return relationship;
    }
}

package org.vbc4me.awanna.facets;

import java.util.Objects;
import java.util.UUID;

public class EmergencyContact extends Person {

    private final PhoneNumber phoneNumber;

    public static Builder builder() {
        return new Builder();
    }

    private EmergencyContact(Builder builder) {
        super(builder.id, builder.firstName, builder.lastName, builder.type);
        this.phoneNumber = builder.phoneNumber;
    }

    /**
     * Return the {@link PhoneNumber} associated with this {@link EmergencyContact}.
     */
    public PhoneNumber phoneNumber() {
        return phoneNumber;
    }

    public static class Builder {
        private UUID id;
        private String firstName;
        private String lastName;
        private Type type;
        private PhoneNumber phoneNumber;

        public Builder id(UUID id) {
            this.id = id;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder type(Type type) {
            this.type = type;
            return this;
        }

        public Builder phoneNumber(PhoneNumber phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public EmergencyContact create() {
            if (id == null) {
                id = UUID.randomUUID();
            }
            if (type == null) {
                type = Type.CONTACT;
            }
            Objects.requireNonNull(firstName);
            Objects.requireNonNull(lastName);
            Objects.requireNonNull(phoneNumber);
            return new EmergencyContact(this);
        }
    }
}

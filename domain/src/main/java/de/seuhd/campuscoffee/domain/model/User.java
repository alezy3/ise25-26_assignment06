package de.seuhd.campuscoffee.domain.model;

import lombok.Builder;

import java.io.Serial;
import java.io.Serializable;

@Builder(toBuilder = true)
public record User (
        //TODO: Implement user domain object
        public class User (
            private final Long id;
            private final LocalDateTime createdAt;
            private final LocalDateTime updatedAt;
            private final String loginName;
            private final String emailAddress;
            private final String firstName;
            private final String lastName;

        public record User (
            @Nullable Long id,
            @Nullable LocalDateTime creeatedAt,
            @Nullable LocalDateTime updatedAt,
            @NonNull String loginName,
            @NonNull String emailAddress,
            @NonNull String firstName,
            @NonNull String lastName)    
            
        )
) implements Serializable { // serializable to allow cloning (see TestFixtures class).
    @Serial
    private static final long serialVersionUID = 1L;
}

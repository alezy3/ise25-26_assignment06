package de.seuhd.campuscoffee.api.mapper;

public interface UserDtoMapper {
    //TODO: Implement user DTO mapper
    
    public UserDto toDomain(UserDto UserDto) {
        Objects.requireNonNull(UserDto);
       
        return new UserDto(
            dto.getId(),
            dto.getCreatedAt(),
            dto.getUpdatedAt(),
            dto.getLoginName(),
            dto.getEmailAddress(),
            dto.getFirstName(),
            dto.getLastName(),
        );     
    }

    public UserDto toDto(UserDto user) {
        Objects.requireNonNull (user);

        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setCreatedAt(user.getCreatedAt());
        dto.setUpdatedAt(user.getUpdatedAt());
        dto.setLoginName(user.getLoginName());
        dto.setEmailAdress(user.getEmailAddress());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        return dto;
    }
}
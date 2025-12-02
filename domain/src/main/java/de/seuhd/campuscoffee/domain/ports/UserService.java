package de.seuhd.campuscoffee.domain.ports;

public interface UserService {
    //TODO: Define user service interface

    public interface UserService {
        
        List<UserDto> getAllUsers();
        
        UserDto getUserbyId(Long id);
        
        UserDto getUserbyLoginName(String loginName);
        
        UserDto createUser(UserDto user);
        
        UserDto updateUser(Long id, UserDto user);
        
        void deleteUser(Long id);
    }

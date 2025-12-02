package de.seuhd.campuscoffee.domain.impl;

import de.seuhd.campuscoffee.domain.ports.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    // TODO: Implement user service

    private final UserDataService userDataService;

    @Autowired
    public UserServiceImpl(UserDataService userDataService) {
        this.userDataService = userDataService;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userDataService.findAll()
                            .stream()
                            .map(user -> UserDtoMapper.toDto(user))
                            .collect(Collectors.toList());
    }

    @Override
    public UserDto getUserbyId(Long id) {
        User user = userDataService.findbyId(id)
                            .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
                            return UserDtoMapper.toDto(user);
    }

    @Override 
    public UserDto getUserbyLoginName(String loginName) {
        User user = userDataService.findbyloginName(loginName)
                            .orElseThrow(() -> new UserNotFoundException ("User not found with login name:" + loginName));
                            return UserDtoMapper.toDto(user);
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = UserDtoMapper.toDomain(userDto);
        User createdUser = userDataService.save(user);
        return UserDtoMapper.toDto(createdUser);
    }

    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        User existingUser = userDataService.findbyId(id)
                            .orElseThrow(() -> new UserNotFoundException("User not found with id:"+ id));
        User userToUpdate = UserDtoMapper.toDomain(userDto).toBuilder().id(id).build();
        User updatedUser = userDataService.save(userToUpdate);
        return UserDtoMapper.toDto(updatedUser);
   }

   @Override
   public void deletedUser(Long id) {
        User existingUser = userDataService.findbyId(id)
                            .orElseThrow(() -> new UserNotFoundException("User not found with id "+ id));
        return userDataService.deletebyId(id);
   }
}

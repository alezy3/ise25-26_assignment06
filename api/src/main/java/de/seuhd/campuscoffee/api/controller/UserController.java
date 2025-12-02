package de.seuhd.campuscoffee.api.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Users", description = "Operations related to user management.")
@Controller
@RequestMapping("/api/users")
@Slf4j
@RequiredArgsConstructor
public class UserController {
    //TODO: Implement user controller
    private final UserService UserService;
    private final UserDtoMapper UserDtoMapper;

    @Autowired
    public UserController(UserService UserService, UserDtoMapper UserDtoMapper) {
        this.UserService = UserService;
        this.UserDtoMapper = UserDtoMapper;
    }

    @GetMapping
    public List<UserDto> getAllUsers() {
        List<User> users = UserService.getAllUsers();
        return users.stream()
                .map(UserDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public UserDto getUserbyId(@PathVariable Long id) {
        User user = UserService.getUserbyId(id);
        return UserDtoMapper.toDto(user);
    }

    @GetMapping("/filter")
    public UserDto getUserbyLoginName(@RequestParam String loginName) {
        User user = UserService.getUserbyLoginName(loginName);
        return UserDtoMapper.toDto(user);
    }

    @PostMapping
    public UserDto createUser(@Valid @RequestBody UserDto UserDto) {
        User user = UserDtoMapper.toDomain(UserDto);
        User createdUser = UserService.createUser(user);
        return UserDtoMapper.toDto(createUser);
    }

    @PutMapping("/{id}")
    public UserDto updateUser(@PathVariable Long id, @Valid @RequestBody UserDto UserDto) {
        User user = UserDtoMapper.toDomain(UserDto);
        User updatedUser = UserService.updateUser(id, user);
        return UserDtoMapper.toDto(updatedUser);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        UserService.deleteUser(id);
    }
}

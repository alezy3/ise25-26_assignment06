package de.seuhd.campuscoffee.tests.system;

public class UsersSystemTests extends AbstractSysTest {

    //TODO: Uncomment once user endpoint is implemented

    @Test
    void createUser() {
        User userToCreate = TestFixtures.getUserListForInsertion().getFirst();
        User createdUser = userDtoMapper.toDomain(userRequests.create(List.of(userDtoMapper.fromDomain(userToCreate))).getFirst());

        assertEqualsIgnoringIdAndTimestamps(createdUser, userToCreate);
    }

    //TODO: Add at least two additional tests for user operations
    @Test
    void getUserbyId() {
        User existingUser = testFixtures.getUser().get(0);
        User retrievedUser = userDtoMapper.toDomain(userRequests.getById(existingUser.getId()));

        assertEqualsIgnoringIdAndTimestamps(retrievedUser, existingUser);
    }
    
    @Test
    void updateUser() {
        User existingUser = TestFixtures.getUserListForInsertion().get(0);
        User updatedUserData = TestFixtures.getUserListForInsertion().get(1);
        User updatedUser = userDtoMapper.toDomain(userRequests.update(existingUser.getId(), userDtoMapper.toDomain(updatedUserData)))
    }

    @Test
    void deleteUser() {
        User existingUser = testFixtures.getUser().get(0);
        user requests.delete(existingUser.getId());
    }

}
package org.example.services;

import org.example.data.UserEntity;
import org.example.data.UserRepository;
import org.example.mappers.EntityMapper;
import org.example.models.UserModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    private final TimeService timeService;
    private final UserRepository userRepository;
    private final EntityMapper<UserEntity, UserModel> entityMapper;

    public UserServiceImpl(TimeService timeService, UserRepository userRepository, EntityMapper<UserEntity, UserModel> entityMapper) {
        this.timeService = timeService;
        this.userRepository = userRepository;
        this.entityMapper = entityMapper;
    }

    public UserModel getUser(String userName) {
        return entityMapper.map(userRepository.findByFirstName(userName));
    }

    public void addUser(UserModel user) {

        user.setCreationTime(timeService.getCurrentTime("Madrid"));
        userRepository.save(entityMapper.reverseMap(user));
    }

    @Transactional
    public void deleteUser(String userName) {
        userRepository.deleteByFirstName(userName);
    }

}

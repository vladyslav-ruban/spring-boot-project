package org.example.mappers;

import org.example.data.UserEntity;
import org.example.models.UserModel;
import org.springframework.stereotype.Component;

@Component
public class UserEntityMapper implements EntityMapper<UserEntity, UserModel> {
    @Override
    public UserModel map(UserEntity entity) {
        return new UserModel(
                entity.getFirstName(),
                entity.getLastName(),
                entity.getMembershipId(),
                entity.getCreationTime()
        );
    }

    @Override
    public UserEntity reverseMap(UserModel entity) {
        return new UserEntity(
                entity.getFirstName(),
                entity.getLastName(),
                entity.getMembershipId(),
                entity.getCreationTime()
        );
    }
}

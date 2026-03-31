package mapper;

import dao.entity.UserEntity;
import dto.UserRequestDto;

public class UserMapper {
    public static UserEntity mapToEntity(UserRequestDto userRequestDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userRequestDto.getName());
        userEntity.setRole(userRequestDto.getRole());
        return userEntity;
    }
}

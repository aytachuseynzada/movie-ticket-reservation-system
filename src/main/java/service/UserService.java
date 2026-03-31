package service;

import dao.entity.UserEntity;
import dao.repository.UserRepository;
import dto.UserRequestDto;
import exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public void createUser(UserRequestDto userRequestDto) {
        UserEntity user = UserMapper.mapToEntity(userRequestDto);
        userRepository.save(user);
    }
    public void activateUser(Long id){
        var user = userRepository.findById(id);
        if(user.isEmpty()){
            throw new UserNotFoundException("USER NOT FOUND");
        }
        user.get().setActive(true);
    }
    public void deactivateUser(Long id){
        var user = userRepository.findById(id);
        if(user.isEmpty()){
            throw new UserNotFoundException("USER NOT FOUND");
        }
        user.get().setActive(false);
    }
}

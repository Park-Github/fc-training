package fastcampus.memorydb.user.service;

import fastcampus.memorydb.user.db.UserRepository;
import fastcampus.memorydb.user.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserEntity save(UserEntity user) {
       return userRepository.save(user);
    }

    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }
}

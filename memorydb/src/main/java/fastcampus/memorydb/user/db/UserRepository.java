package fastcampus.memorydb.user.db;

import fastcampus.memorydb.db.SimpleDataRepository;
import fastcampus.memorydb.user.model.UserEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class UserRepository extends SimpleDataRepository<UserEntity, Long> {
}

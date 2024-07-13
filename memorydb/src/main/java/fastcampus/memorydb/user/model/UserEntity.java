package fastcampus.memorydb.user.model;

import fastcampus.memorydb.entity.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity extends Entity {
    private String name;
    private int score;
}

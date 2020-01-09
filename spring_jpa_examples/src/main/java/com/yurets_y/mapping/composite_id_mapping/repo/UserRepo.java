package com.yurets_y.mapping.composite_id_mapping.repo;

import com.yurets_y.mapping.composite_id_mapping.entity.User;
import com.yurets_y.mapping.composite_id_mapping.entity.UserId;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepo extends JpaRepository<User,UserId> {

    User findByUserId(UserId userId);
}

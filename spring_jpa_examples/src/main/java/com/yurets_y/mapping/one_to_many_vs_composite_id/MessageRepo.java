package com.yurets_y.mapping.one_to_many_vs_composite_id;

import com.yurets_y.mapping.one_to_many_vs_composite_id.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepo extends JpaRepository<Message,Long> {
}

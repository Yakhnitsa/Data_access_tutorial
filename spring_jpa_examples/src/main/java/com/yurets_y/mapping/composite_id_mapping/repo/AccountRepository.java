package com.yurets_y.mapping.composite_id_mapping.repo;

import com.yurets_y.mapping.composite_id_mapping.entity.Account;
import com.yurets_y.mapping.composite_id_mapping.entity.AccountId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, AccountId> {


}

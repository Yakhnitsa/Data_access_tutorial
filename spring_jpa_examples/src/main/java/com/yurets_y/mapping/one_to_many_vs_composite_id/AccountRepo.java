package com.yurets_y.mapping.one_to_many_vs_composite_id;

import com.yurets_y.mapping.one_to_many_vs_composite_id.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account, Account.AccountId> {

}

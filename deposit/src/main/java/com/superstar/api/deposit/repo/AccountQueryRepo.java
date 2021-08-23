package com.superstar.api.deposit.repo;

import com.superstar.api.deposit.entity.AccountQuery;

import org.springframework.data.jpa.repository.JpaRepository;


public interface AccountQueryRepo extends JpaRepository<AccountQuery,Integer> {
    
}

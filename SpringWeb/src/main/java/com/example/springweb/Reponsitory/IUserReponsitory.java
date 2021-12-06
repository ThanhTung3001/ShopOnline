package com.example.springweb.Reponsitory;

import com.example.springweb.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserReponsitory extends JpaRepository<UserEntity, Long> {

    public UserEntity findAllByUserName(String username);


}

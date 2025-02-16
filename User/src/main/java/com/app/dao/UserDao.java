package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.models.User;

@Repository
public interface UserDao extends JpaRepository<User, Long>
{

}

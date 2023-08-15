package com.task.Majorreltask.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.task.Majorreltask.Model.User;

public interface UserDao extends JpaRepository<User,String> {
	

}


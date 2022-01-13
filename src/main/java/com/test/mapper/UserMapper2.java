package com.test.mapper;

import com.test.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper2 {

    public List<User> getUser();

    public String getName(String name);

    public List<String> getNames();
}

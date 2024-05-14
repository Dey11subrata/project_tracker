package com.project.springboot.project_tracker.configuration;

import com.project.springboot.project_tracker.utility.mapper.UserMapper;
import com.project.springboot.project_tracker.utility.mapper.UserMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public UserMapper userMapper(){
        return new UserMapperImpl();

    }
}

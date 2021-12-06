package com.example.springweb.Service;

import com.example.springweb.dto.UserDto;

public interface IUserService {

    UserDto findUserByName(String userName);
}

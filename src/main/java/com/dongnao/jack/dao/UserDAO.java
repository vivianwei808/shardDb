package com.dongnao.jack.dao;

import java.util.List;

import com.dongnao.jack.vo.UserVO;

public interface UserDAO {
    
    public List<UserVO> findUsers();
    
    public Integer addUser(UserVO userVO);
}

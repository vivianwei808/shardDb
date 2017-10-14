package com.dongnao.jack.service;

import java.util.List;

import com.dongnao.jack.annotation.TargetDataSource;
import com.dongnao.jack.vo.UserVO;

public interface UserService {
    
    /** 
     * @Description 我们在调用这个方法之前就需要对我们的数据源进行动态切换 
     * @param @return 参数 
     * @return List<UserVO> 返回类型  
     * @throws 
     */
    @TargetDataSource("read")
    public List<UserVO> findUser();
    
    /** 
     * @Description 我们在调用这个方法之前就需要对我们的数据源进行动态切换 
     * @param @return 参数 
     * @return List<UserVO> 返回类型  
     * @throws 
     */
    @TargetDataSource("write")
    public void addUser(UserVO userVO);
}

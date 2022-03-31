package com.cugcs.famdoc.service;

import com.cugcs.famdoc.mapper.DoctorMapper;
import com.cugcs.famdoc.mapper.UserMapper;
import com.cugcs.famdoc.model.Doctor;
import com.cugcs.famdoc.model.Patient;
import com.cugcs.famdoc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserMapper doctorMapper;
    @Autowired
    UserMapper patientMapper;
    @Autowired
    DoctorService doctorService;
    @Autowired
    PatientService patientService;
    /**
     * 登录
     * 先通过登录的用户名查询用户，判断用户是否存在，不存在则返回null
     * 或者判断用户输入的密码和查询出的密码是否一致，不一致则返回null
     * 其他情况返回
     *
     * @param username 用户名
     * @param password 密码
     * @param status 身份
     * @return 员工
     */
    public User doLogin(String username, String password, String status) {    //登录服务
        User user = userMapper.loadUserBynName(username);
        if (user == null || !user.getPassword().equals(password)||!user.getStatus().equals(status)) {
            return null;
        }
        return user;
    }

    public Integer doReg(User user) {
        User user1 = userMapper.loadUserBynName(user.getUsername());
        if (user1 != null) {
            return -1;
        }
        return userMapper.doReg(user);
    }

    public User doLogin2(String username, String password) {
        User user = userMapper.loadUserBynName(username);
        if (user == null || !user.getPassword().equals(password)) {
            return null;
        }
        return user;
    }

    public void doChang(String username, String newpassword) {
        userMapper.doChang(username,newpassword);
    }

    public List<User> getAllUser(String username) {
        return userMapper.getAllUser(username);
    }


}

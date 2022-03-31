package com.cugcs.famdoc.mapper;

import com.cugcs.famdoc.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    User loadUserBynName(String username);

    Integer doReg(User user);

    void doChang(@Param("un") String username,@Param("pw") String newpassword);

    List<User> getAllUser(String username);
}

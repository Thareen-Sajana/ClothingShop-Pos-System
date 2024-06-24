package org.icet.demo.bo.custom;

import org.icet.demo.bo.SuperBo;
import org.icet.demo.dto.User;
import org.icet.demo.entity.UserEntity;

import java.util.List;

public interface UserBo extends SuperBo {

    boolean saveUser(User dto);
    boolean delete(User user);

    String generateUserId();

    boolean isAvailable(User user);

    List<UserEntity> getAllUsers();

    boolean updateUser(User user);

    User getUserById(String id);

    boolean isUserExist(String id);

    List<String> getAllUserId();
}

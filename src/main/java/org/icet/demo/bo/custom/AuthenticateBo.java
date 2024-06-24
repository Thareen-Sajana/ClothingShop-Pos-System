package org.icet.demo.bo.custom;

import org.icet.demo.bo.SuperBo;
import org.icet.demo.dto.Authentication;
import org.icet.demo.dto.AuthenticationDetails;
import org.icet.demo.dto.User;
import org.icet.demo.entity.AuthenticationEntity;

import java.util.List;

public interface AuthenticateBo extends SuperBo {

    boolean saveUsercredentials(Authentication authentication);

    boolean delete(Authentication user);

    Authentication findAuthenticationByUserId(String userId);

    List<AuthenticationEntity> getAll();

    List<AuthenticationDetails> getllAllAuthenticationDetails();

    String isAuthorized(String email, String password);

    boolean updatePassword(String email, String newPassword);
}

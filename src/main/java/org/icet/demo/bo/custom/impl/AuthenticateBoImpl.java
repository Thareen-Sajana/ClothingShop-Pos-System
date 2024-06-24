package org.icet.demo.bo.custom.impl;

import org.icet.demo.bo.custom.AuthenticateBo;
import org.icet.demo.bo.custom.UserBo;
import org.icet.demo.dao.DaoFactory;
import org.icet.demo.dao.custom.AuthenticateDao;
import org.icet.demo.dao.custom.UserDao;
import org.icet.demo.dto.Authentication;
import org.icet.demo.dto.AuthenticationDetails;
import org.icet.demo.entity.AuthenticationEntity;
import org.icet.demo.entity.UserEntity;
import org.icet.demo.util.PassBasedEnc;

import java.util.ArrayList;
import java.util.List;

import static org.icet.demo.util.DaoType.AUTHENTICATE;
import static org.icet.demo.util.DaoType.USER;

public class AuthenticateBoImpl implements AuthenticateBo {

    private AuthenticateDao authenticateDao = DaoFactory.getInstance().getDao(AUTHENTICATE);
    private UserDao userDao = DaoFactory.getInstance().getDao(USER);

    @Override
    public boolean saveUsercredentials(Authentication authentication) {

        AuthenticationEntity authenticationEntity = new AuthenticationEntity();

        authenticationEntity.setUserId(authentication.getUserId());
        authenticationEntity.setPassword(authentication.getPassword());
        authenticationEntity.setSaltValue(authentication.getSaltValue());

        return authenticateDao.save(authenticationEntity);
    }

    @Override
    public boolean delete(Authentication user) {
        AuthenticationEntity authenticationEntity = new AuthenticationEntity();
        authenticationEntity.setUserId(user.getUserId());
        authenticationEntity.setAuthenticationId(user.getAuthenticationId());
        return authenticateDao.delete(authenticationEntity);
    }

    @Override
    public Authentication findAuthenticationByUserId(String userId) {

        List<AuthenticationEntity> allData = getAll();
        Authentication authenticationData = new Authentication();

        for(AuthenticationEntity authentication : allData){
            if(authentication.getUserId().equals(userId)){

                authenticationData.setAuthenticationId(authentication.getAuthenticationId());
                authenticationData.setUserId(authentication.getUserId());
                return authenticationData;
            }
        }
        return null;
    }

    @Override
    public List<AuthenticationEntity> getAll() {
        return authenticateDao.retriveAll();
    }

    @Override
    public List<AuthenticationDetails> getllAllAuthenticationDetails() {

        List<AuthenticationEntity> authenticatons = getAll();
        List<UserEntity> users = userDao.retriveAll();

        List <AuthenticationDetails> allAuthentications = new ArrayList<>();

        for (AuthenticationEntity authentication : authenticatons){
            for (UserEntity user : users){

                if(authentication.getUserId().equals(user.getUserId())){
                    AuthenticationDetails authenticationDetails = new AuthenticationDetails();
                    authenticationDetails.setAuthenticationId(authentication.getAuthenticationId());
                    authenticationDetails.setPassword(authentication.getPassword());
                    authenticationDetails.setSaltValue(authentication.getSaltValue());
                    authenticationDetails.setUserId(authentication.getUserId());
                    authenticationDetails.setEmail(user.getEmail());
                    authenticationDetails.setRole(user.getRole());

                    allAuthentications.add(authenticationDetails);
                    break;
                }
            }
        }
        return allAuthentications;
    }

    @Override
    public String isAuthorized(String email, String password) {

        for(AuthenticationDetails authentication : getllAllAuthenticationDetails()){
            if(authentication.getEmail().equals(email)){

                Boolean status = PassBasedEnc.verifyUserPassword(password,
                        authentication.getPassword()
                        ,authentication.getSaltValue());

                if(status==true){
                    return authentication.getRole();
                }
            }
        }
        return null;
    }

    @Override
    public boolean updatePassword(String email ,String newPassword) {

        String saltvalue = PassBasedEnc.getSaltvalue(30);
        String encryptedpassword = PassBasedEnc.generateSecurePassword(newPassword, saltvalue);

        for (AuthenticationDetails details : getllAllAuthenticationDetails()){
            if(details.getEmail().equals(email)){

                AuthenticationEntity authentication = new AuthenticationEntity();
                authentication.setAuthenticationId(details.getAuthenticationId());
                authentication.setPassword(encryptedpassword);
                authentication.setSaltValue(saltvalue);
                authentication.setUserId(details.getUserId());

                return authenticateDao.update(authentication);
            }
        }
        return false;
    }
}

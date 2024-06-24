package org.icet.demo.bo.custom.impl;


import org.icet.demo.bo.custom.UserBo;
import org.icet.demo.dao.DaoFactory;
import org.icet.demo.dao.custom.UserDao;
import org.icet.demo.dto.User;
import org.icet.demo.entity.UserEntity;


import java.util.ArrayList;
import java.util.List;

import static org.icet.demo.util.DaoType.USER;

public class UserBoImpl implements UserBo {

    private UserDao userDao = DaoFactory.getInstance().getDao(USER);

    @Override
    public boolean saveUser(User dto) {

        UserEntity user = new UserEntity();

        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setGender(dto.getGender());
        user.setRole(dto.getRole());
        user.setPosition(dto.getPosition());
        user.setEmail(dto.getEmail());
        user.setContactNo(dto.getContactNo());
        user.setBirthday(dto.getBirthday());
        user.setUserId(dto.getUserId());
        return userDao.save(user);
    }

    @Override
    public boolean delete(User user){

        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(user.getUserId());
        return userDao.delete(userEntity);
    }

    @Override
    public String generateUserId() {
        List<UserEntity> users = getAllUsers();

        String newNumericPart = "00001";
        String prefix = "D";

        int count = 0;
        for (UserEntity user: users){
            System.out.println(user.getUserId());
            String id = user.getUserId();

            prefix = id.substring(0, 1);

            // Extract the numeric part
            String numericPart = id.substring(1);

            // Convert numeric part to integer
            int number = Integer.parseInt(numericPart);

            // Increment the number by 1
            number++;

            // Format the new number back to the same number of digits
            newNumericPart = String.format("%05d", number);

            count++;
        }
        if(count==0){
            return "D00001";
        }else {
            // Return the new ID
            return prefix + newNumericPart;
        }

    }

    @Override
    public boolean isAvailable(User user) {

        String userContactNo = user.getContactNo();
        String userEmail = user.getEmail();

        List<UserEntity> users = getAllUsers();

        for(UserEntity userEntity : users){
            if(userContactNo.equals(userEntity.getContactNo()) || userEmail.equals(userEntity.getEmail())){
                return true;
            }
        }
        return false;
    }

    public List<UserEntity> getAllUsers(){
        return userDao.retriveAll();
    }

    @Override
    public boolean updateUser(User user) {

        UserEntity userEntity = new UserEntity();

        userEntity.setUserId(user.getUserId());
        userEntity.setFirstName(user.getFirstName());
        userEntity.setBirthday(user.getBirthday());
        userEntity.setGender(user.getGender());
        userEntity.setRole(user.getRole());
        userEntity.setPosition(user.getPosition());
        userEntity.setEmail(user.getEmail());
        userEntity.setContactNo(user.getContactNo());
        userEntity.setLastName(user.getLastName());

        return userDao.update(userEntity);
    }

    @Override
    public User getUserById(String id) {

        User userDetails = new User();
        List<UserEntity> users = getAllUsers();

        for(UserEntity user : users){
            if(user.getUserId().equals(id)){

                userDetails.setFirstName(user.getFirstName());
                userDetails.setBirthday(user.getBirthday());
                userDetails.setGender(user.getGender());
                userDetails.setRole(user.getRole());
                userDetails.setPosition(user.getPosition());
                userDetails.setEmail(user.getEmail());
                userDetails.setContactNo(user.getContactNo());

                return userDetails;
            }
        }
        return null;
    }

    @Override
    public boolean isUserExist(String id) {

        List<UserEntity> users = getAllUsers();
        for (UserEntity user : users){
            if(user.getUserId().equals(id)){
                return true;
            }
        }
        return false;
    }

    @Override
    public List<String> getAllUserId() {

        List<String> userIdList = new ArrayList<>();

        for(UserEntity user : getAllUsers()){
            userIdList.add(user.getUserId());
        }
        return userIdList;
    }
}

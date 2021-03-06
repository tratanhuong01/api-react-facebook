package com.facebook.facebook.users;

import com.facebook.facebook.dto.AccountLogin;
import com.facebook.facebook.dto.DataJWT;
import com.facebook.facebook.dto.UserDetail;
import com.facebook.facebook.jwt.TokenJWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class UsersService {

    //
    @Autowired
    UsersRepository usersRepository;
    //

    public Users getUserById(Long id) {
        return usersRepository.getUserById(id);
    }

    public UserDetail getUserByToken(String token) {
        Users users = usersRepository.getUserById(Long.parseLong(TokenJWTUtils.parseTokenJWT(token)));
        return returnUserDetail(users);
    }
    public UserDetail returnUserDetail(Users users) {
        UserDetail userDetail = null;
        if (users != null) {
            userDetail = new UserDetail();
            userDetail.setUsers(users);
            userDetail.setToken(TokenJWTUtils.generateJwt(String.valueOf(users.getId())));
            if (users.getCodeEmail() == null && users.getCodePhone() == null) {
                userDetail.setStatus(1);
            }
        }
        return userDetail;
    }
    public UserDetail searchUserByEmailOrPhone(String keyword) {
        Users users = usersRepository.searchUserByEmailOrPhone(keyword);
        return returnUserDetail(users);
    }

    public List<Users> searchUser(String keyword,Integer offset,Integer limit) {
        return usersRepository.searchUser(keyword,offset,limit);
    }

    public Users addUser(Users users) {
        users.setTimeCreated(new Timestamp(new Date().getTime()));
        return usersRepository.save(users);
    }

    public Users updateUser(Users users) {
        return usersRepository.save(users);
    }

    public void deleteUser(Users users) {
        usersRepository.delete(users);
    }

    public String generateJWT(DataJWT dataJWT) {
        return TokenJWTUtils.generateJwtByTime(dataJWT.getId(),dataJWT.getEmailOrPhone(),
                dataJWT.getType(),dataJWT.getTime(),dataJWT.getCode());
    }

    public Users checkRegister(String emailOrPhone) {
        List<Users> usersList =  usersRepository.checkRegister(emailOrPhone);
        return usersList.size() > 0 ? usersList.get(0) :null;
    }

    public UserDetail generateLoginByIdJWT(Long id) {
        UserDetail userDetail = null;
        Users users = usersRepository.getUserById(id);
        if (users != null) {
            userDetail = new UserDetail();
            userDetail.setUsers(users);
            userDetail.setToken(TokenJWTUtils.generateJwt(String.valueOf(id)));
        }
        return userDetail;
    }

    public UserDetail checkLogin(AccountLogin accountLogin) {
        Users users = usersRepository.checkLogin(accountLogin.getEmailOrPhone(),accountLogin.getPassword());
        UserDetail userDetail = null;
        if (users != null) {
            userDetail = new UserDetail();
            userDetail.setUsers(users);
            userDetail.setToken(TokenJWTUtils.generateJwt(String.valueOf(users.getId())));
            if (users.getCodePhone() == null && users.getCodeEmail() == null) {
                userDetail.setStatus(1);
            }
        }
        return userDetail;
    }

    public List<Users> getUserFriendOnlineByIdUser(Long idUser,Integer offset,Integer limit) {
        return usersRepository.getUserFriendOnlineByIdUser(idUser,offset,limit);
    }

    public List<Users> getTintUserByIdUser(Long idUser,Long idView) {
        return usersRepository.getTintUserByIdUser(idUser,idView);
    }

}

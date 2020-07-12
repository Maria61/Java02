package Maria.service;

import Maria.mapper.UserMapper;
import Maria.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User login(String username, String password) {
//        User user = new User();
//        user.setUsername(username);
//        user.setPassword(password);
//        return userMapper.login(user);
        return userMapper.login(username, password);
    }
}

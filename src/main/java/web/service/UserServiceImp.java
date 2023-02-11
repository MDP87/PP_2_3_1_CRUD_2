package web.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.repository.UserRepository;
import web.model.User;

@Service
public class UserServiceImp implements UserService {
  @Autowired
  UserRepository userRepository;
  @Override
  public void add(User user) {
  userRepository.add(user);
  }
  @Override
  public void deleteUser(long id) {
  userRepository.deleteUserById(id);
  }
  @Override
  public void updateUser(User user, long id) {
  userRepository.updateUser(user, id);
  }
  @Override
  public User getUserById(long id) {
    return userRepository.getUserById(id);
  }
  @Override
  public List<User> getListUsers() {
    return userRepository.getListUsers();
  }
}

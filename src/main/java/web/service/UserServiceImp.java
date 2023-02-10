package web.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.repository.UserRepository;
import web.model.User;

@Service
public class UserServiceImp implements UserService {
  @Autowired
  UserRepository userRepository;

  @Transactional
  @Override
  public void add(User user) {
  userRepository.add(user);
  }

  @Transactional
  @Override
  public void deleteUser(User user) {
  userRepository.deleteUser(user);
  }
  @Transactional
  @Override
  public void updateUser(User user) {
  userRepository.updateUser(user);
  }
  @Transactional
  @Override
  public User getUserById(long id) {
    return userRepository.getUserById(id);
  }
  @Transactional
  @Override
  public List<User> getListUsers() {
    return userRepository.getListUsers();
  }
}

package web.service;

import java.util.List;
import web.model.User;

public interface UserService {

  void add(User user);
  void deleteUser(User user);

  void updateUser(User user);
  User getUserById(long id);

  List<User> getListUsers();


}

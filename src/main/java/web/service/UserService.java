package web.service;

import java.util.List;
import web.model.User;

public interface UserService {
  void add(User user);
  void deleteUser(long id);
  void updateUser(User user, long id);
  User getUserById(long id);
  List<User> getListUsers();


}

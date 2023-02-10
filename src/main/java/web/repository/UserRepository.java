package web.repository;

import java.util.List;
import web.model.User;
public interface UserRepository {

  void add(User user);
  void deleteUser(User user);

  void updateUser(User user);
  User getUserById(Long id);

  List<User> getListUsers();

}

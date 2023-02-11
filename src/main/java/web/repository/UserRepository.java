package web.repository;

import java.util.List;
import web.model.User;
public interface UserRepository {
  void add(User user);
  void deleteUserById(long id);
  void updateUser(User user, long id);
  User getUserById(Long id);
  List<User> getListUsers();

}

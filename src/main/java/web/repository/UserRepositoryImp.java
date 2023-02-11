package web.repository;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import web.model.User;
@Repository
@Transactional
public class UserRepositoryImp implements UserRepository {
  @PersistenceContext
  private EntityManager entityManager;
  @Override
  public void add(User user) {
      entityManager.persist(user);
      entityManager.flush();
  }
  @Override
  public void deleteUserById(long id) {
     entityManager.remove(getUserById(id));
  }
  @Override
  public void updateUser(User user, long id) {
    User updatingUser =  getUserById(id);
    updatingUser.setEmail(user.getEmail());
    updatingUser.setFirstName(user.getFirstName());
    updatingUser.setLastName(user.getLastName());
    entityManager.merge(updatingUser);
    entityManager.flush();
  }
  @Override
  public User getUserById(Long id) {
    return entityManager.find(User.class, id);
  }
  @Override
  public List<User> getListUsers(){
      List<User> list = new ArrayList<User>();
    TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u", User.class);
    list = query.getResultList();
    return list;
  }
}

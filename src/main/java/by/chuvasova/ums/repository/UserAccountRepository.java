package by.chuvasova.ums.repository;

import by.chuvasova.ums.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

    UserAccount findByUsername(String username);

//    @Query(value = "update user_account set is_locked = 'true' where status = 'INACTIVE'",
//            nativeQuery = true)
//    UserAccount updateUser(UserAccount userAccount);
//    List<UserAccount> findAllByUsername(String username, Pageable pageable);
//    List<UserAccount> findAllByRole(String role, Pageable pageable);
}

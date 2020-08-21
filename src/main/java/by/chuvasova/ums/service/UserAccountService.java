package by.chuvasova.ums.service;

import by.chuvasova.ums.model.UserAccount;
import by.chuvasova.ums.model.UserAccountDetails;
import by.chuvasova.ums.repository.UserAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserAccountService implements UserDetailsService {

    private final UserAccountRepository userAccountRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccount user = userAccountRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new UserAccountDetails(user);
    }

    public void signUp(UserAccount userAccount) {
        final String encryptedPassword = bCryptPasswordEncoder.encode(userAccount.getPassword());
        userAccount.setPassword(encryptedPassword);
        userAccountRepository.save(userAccount);
    }

    public void updateAccount(UserAccount userAccount) {
        userAccountRepository.save(userAccount);
    }
}

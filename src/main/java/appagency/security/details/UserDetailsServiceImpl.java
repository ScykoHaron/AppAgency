package appagency.security.details;

import appagency.dao.ProfileDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    ProfileDao profileDAO;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        if (profileDAO.getUserByLogin(s) == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new UserDetailsImpl(profileDAO.getUserByLogin(s));
    }
}

package com.furniturefuture.service;

import com.furniturefuture.entity.Role;
import com.furniturefuture.entity.User;
import com.furniturefuture.repository.RoleRepository;
import com.furniturefuture.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @PersistenceContext
    private EntityManager em;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }

    public User findUserById(Long userId) {
        Optional<User> userFromDb = userRepository.findById(userId);
        return userFromDb.orElse(new User());
    }

    public List<User> allUsers() {
        return userRepository.findAll();
    }

    public boolean saveUser(User user) {
        User userFromDB = userRepository.findByUsername(user.getUsername());

        if (userFromDB != null) {
            return false;
        }

        Role role = roleRepository.findByName("ROLE_USER");
        user.setRoles(Collections.singleton(role));

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }
    public boolean saveAdmin(User user) {
        User userFromDB = userRepository.findByUsername(user.getUsername());

        if (userFromDB != null) {
            return false;
        }
        Role role = roleRepository.findByName("ROLE_ADMIN");

        user.setRoles(Collections.singleton(role));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }
    public boolean saveSuperAdmin(User user) {
        User userFromDB = userRepository.findByUsername(user.getUsername());

        if (userFromDB != null) {
            return false;
        }
        Role role = roleRepository.findByName("ROLE_SUPERADMIN");

        user.setRoles(Collections.singleton(role));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }

    public boolean deleteUser(Long userId) {
        if (userRepository.findById(userId).isPresent()) {
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }

    public List<User> usergtList(Long idMin) {
        return em.createQuery("SELECT u FROM User u WHERE u.id > :paramId", User.class)
                .setParameter("paramId", idMin).getResultList();
    }
}
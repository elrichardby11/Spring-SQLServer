package cl.cft.conexionDB.service;

import cl.cft.conexionDB.entities.Users;
import cl.cft.conexionDB.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<Users> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    public Users saveUser(Users user) {
        return userRepository.save(user);
    }

    public void deleteUser(Integer id) { userRepository.deleteById(id); }

    public boolean existUser(Integer id) {
        return this.userRepository.existsById(id);
    }

}

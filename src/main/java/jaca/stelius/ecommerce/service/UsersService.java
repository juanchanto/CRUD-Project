package jaca.stelius.ecommerce.service;

import jaca.stelius.ecommerce.model.Users;
import jaca.stelius.ecommerce.repository.UsersRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;
    private static final int BCRYPT_ROUNDS = 10; // Número de rondas de encriptación (cost factor)

    public List<Users> getAllUsers(){
        return usersRepository.findAll();
    }

    public Users getUsersById(Long usersId){
        return usersRepository.findById(usersId)
                .orElseThrow(()-> new RuntimeException("User not found: " + usersId));
    }

    public Users createUser(Users users){
        // Agrega aquí cualquier lógica adicional antes de guardar el usuario
        //Encripta contraseña
        users.setPassword(hashPassword(users.getPassword()));
        return usersRepository.save(users);
    }

    public Users updateUser(Long userId, Users updateUsers){
        Users existingUser = usersRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
        // Actualiza los campos del usuario con los datos proporcionados
        existingUser.setFirstname(updateUsers.getFirstname());
        existingUser.setLastname(updateUsers.getLastname());
        existingUser.setUsername(updateUsers.getUsername());
        existingUser.setEmail(updateUsers.getEmail());
        existingUser.setPassword(updateUsers.getPassword());
        existingUser.setAddress(updateUsers.getAddress());
        existingUser.setDob(updateUsers.getDob());
        existingUser.setContactno(updateUsers.getContactno());
        existingUser.setUrl(updateUsers.getUrl());
        existingUser.setVerificationcode(updateUsers.getVerificationcode());
        existingUser.setCreateddate(updateUsers.getCreateddate());
        existingUser.setModifieddate(updateUsers.getModifieddate());
        existingUser.setStatus(updateUsers.getStatus());
        existingUser.setTipadmin(updateUsers.getTipadmin());

        return usersRepository.save(existingUser);
    }

    public void deleteUsers(Long userId){
        Users usersToDelete = usersRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
        usersRepository.delete(usersToDelete);
    }

    //Encriptacion de password
    public String hashPassword(String password){
        return BCrypt.hashpw(password, BCrypt.gensalt(BCRYPT_ROUNDS));
    }
}

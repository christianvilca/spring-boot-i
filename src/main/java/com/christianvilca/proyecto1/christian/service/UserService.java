package com.christianvilca.proyecto1.christian.service;

import com.christianvilca.proyecto1.christian.entity.User;
import com.christianvilca.proyecto1.christian.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {
    private final Log LOG = LogFactory.getLog(UserService.class);

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /*
    * Si exite algun error a nivel de, en este caso, insert
    * @Transactional nos permite hacer un rollback de todas las transacciones que se han ido registrando en la base de datos
    * Ej si haces un registro y luego haces otro registro y validas todos los usuarios que se han registrado y
    * si ocurre algun error ningun usuario se habra registrado
    * */
    @Transactional
    public void saveTransactional(List<User> users){
        users.stream()
                .peek(user -> LOG.info("Usuario insertado: " +  user))
                //.forEach(user -> userRepository.save(user)); // Tambien es valido hacerlo de esta forma

                // Otra forma
                // En java 8 tambien podemos hacer referencia a los metodos a partir de referencias
                // Por medio de la referencia del save se obtiene una entidad (::)
                .forEach(userRepository::save);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
}

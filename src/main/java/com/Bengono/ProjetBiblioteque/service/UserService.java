package com.Bengono.ProjetBiblioteque.service;


import com.Bengono.ProjetBiblioteque.model.Book;
import com.Bengono.ProjetBiblioteque.model.Borrowing;
import com.Bengono.ProjetBiblioteque.model.User;
import com.Bengono.ProjetBiblioteque.repository.BookRepository;
import com.Bengono.ProjetBiblioteque.repository.BorrowingRepository;
import com.Bengono.ProjetBiblioteque.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class UserService {


     @Autowired
    private UserRepository userRepository;

     @Autowired
     private BorrowingRepository borrowing;
     @Autowired
     private BookRepository bookRepository;

public User save(User user) {
return userRepository.save(user);
}

     public List<User> findAll() {
         return userRepository.findAll();


     }
     public User findById(Long id) {
         return userRepository.findById(id).orElse(null);
     }

    public User update(Long id, User user) {
        User userToUpdate = userRepository.findById(id).orElse(null);
        if (userToUpdate != null) {
            userToUpdate.setName(user.getName());
            userToUpdate.setFirstName(user.getFirstName());
            userToUpdate.setEmail(user.getEmail());
            return userRepository.save(userToUpdate);
        }
        return null;


     }
     @DeleteMapping("/{id}")
     public void delete(Long id) {

    userRepository.deleteById(id);
     }
}

package br.com.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.springboot.model.User;
import br.com.springboot.repository.UserRepository;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//Permite acesso do Front na porta do AngularJS
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/users")
public class UserController implements WebMvcConfigurer {

  // GET
  // POST
  // PUT
  // DELETE
  // PATCH

  @Autowired
  private UserRepository userRepository;

  @GetMapping("/{id}")
  public User GetById(@PathVariable("id") Long id) {
    Optional<User> userFind = this.userRepository.findById(id);
    return userFind.orElse(null);
  }

  @PutMapping("/{id}")
  public ResponseEntity<User> Put(@PathVariable("id") Long id, @RequestBody User newUser){
    Optional<User> oldUser = userRepository.findById(id);
    if(oldUser.isPresent()){
      User user = oldUser.get();
      user.setName(newUser.getName());
      user.setUsername(newUser.getUsername());
      userRepository.save(user);
      return new ResponseEntity<>(user, HttpStatus.OK);
    }
    else
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> Delete(@PathVariable(value = "id") Long id){
    Optional<User> user = userRepository.findById(id);
    if(user.isPresent()){
      userRepository.delete(user.get());
      return new ResponseEntity<>(HttpStatus.OK);
    }
    else
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @PostMapping("/")
  public User Post(@RequestBody User user) {
    return this.userRepository.save(user);
  }

  @GetMapping("/list")
  public List<User> list() {
    return this.userRepository.findAll();
  }

  @GetMapping("/list/{id}")
  public List<User> listMoreThan(@PathVariable("id") Long id) {
    return this.userRepository.findByIdGreaterThan(id);
  }

  @GetMapping("/findByName/{name}")
  public List<User> findByName(@PathVariable("name") String name) {
    return this.userRepository.findByNameIgnoreCase(name);
  }

}

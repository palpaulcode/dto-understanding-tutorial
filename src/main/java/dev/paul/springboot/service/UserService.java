package dev.paul.springboot.service;

import dev.paul.springboot.dto.UserLocationDTO;
import dev.paul.springboot.mapper.Mapper;
import dev.paul.springboot.model.User;
import dev.paul.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final Mapper mapper;

    public UserService(UserRepository userRepository, Mapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    public List<UserLocationDTO> getAllUsersLocation(){
        return userRepository.findAll()
                .stream()
                //.map(this::convertEntityToDto)
                .map(mapper::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public UserLocationDTO getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        return mapper.convertEntityToDto(user);
    }
}

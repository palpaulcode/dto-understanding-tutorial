package dev.paul.springboot.mapper;

import dev.paul.springboot.dto.UserLocationDTO;
import dev.paul.springboot.model.User;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public UserLocationDTO convertEntityToDto(User user) {
        UserLocationDTO userLocationDTO = new UserLocationDTO();
        userLocationDTO.setUserId(user.getId());
        userLocationDTO.setEmail(user.getEmail());
        userLocationDTO.setPlace(user.getLocation().getPlace());
        userLocationDTO.setLongitude(user.getLocation().getLongitude());
        userLocationDTO.setLatitude(user.getLocation().getLatitude());

        return userLocationDTO;
    }
}


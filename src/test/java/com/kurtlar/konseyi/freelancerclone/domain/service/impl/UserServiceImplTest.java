package com.kurtlar.konseyi.freelancerclone.domain.service.impl;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.kurtlar.konseyi.freelancerclone.domain.dto.UserDto;
import com.kurtlar.konseyi.freelancerclone.domain.entity.User;
import com.kurtlar.konseyi.freelancerclone.domain.repository.UserRepository;
import com.kurtlar.konseyi.freelancerclone.domain.service.UserService;
import com.kurtlar.konseyi.freelancerclone.domain.service.mapper.UserMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

class UserServiceImplTest {
    private UserService userService;
    private UserRepository userRepository; // Mocked

//    @BeforeEach
//    void setUp() {
//        userRepository = mock(UserRepository.class);
//        userService = new UserServiceImpl(userRepository);
//    }



    @Test
    void saveUserTest() {
        UserDto userDto = new UserDto();
        User user = new User();

        when(userRepository.save(any(User.class))).thenReturn(user);

        UserDto savedUser = userService.save(userDto);
        assertNotNull(savedUser);
    }

    @Test
    void testGetAllUsers() {
        List<User> userList = List.of(new User(), new User());

        when(userRepository.findAll()).thenReturn(userList);

        List<UserDto> allUsers = userService.getAll();

        assertNotNull(allUsers);
        assertEquals(userList.size(), allUsers.size());
    }


    @Test
    void testGetUserById() {
        UserDto userDto = new UserDto();
        userDto.setId("1");
        userDto.setName("TestName");

        userRepository.save(UserMapper.toEntity(new User(),userDto));

        when(userRepository.findById("1")).thenReturn(Optional.of(UserMapper.toEntity(new User(), userDto)));

        UserDto retrievedUser = userService.getById("1");

        assertNotNull(retrievedUser);
        assertEquals(userDto.getId(), retrievedUser.getId());
        assertEquals(userDto.getName(), retrievedUser.getName());
    }

    @Test
    void testGetAllUsers2() {
        // Sahte kullanıcılar oluştur
        UserDto userDto1 = new UserDto();
        userDto1.setId("1");
        userDto1.setName("TestName1");

        UserDto userDto2 = new UserDto();
        userDto2.setId("2");
        userDto2.setName("TestName2");

        // Kullanıcıları kaydet
        userService.save(userDto1);
        userService.save(userDto2);

        // UserRepository.findAll() çağrısında beklenen sonuçları oluştur
        List<User> userList = List.of(UserMapper.toEntity(new User(), userDto1), UserMapper.toEntity(new User(), userDto2));

        // Mock UserRepository.findAll() metodu çağrısında oluşturulan sonuçları ayarla
        when(userRepository.findAll()).thenReturn(userList);

        // Tüm kullanıcıları getir
        List<UserDto> allUsers = userService.getAll();

        // Tüm kullanıcıları getirdiğimizde null olmadığını kontrol et
        assertNotNull(allUsers);

        // Tüm kullanıcılar listesinin beklenen boyutta olup olmadığını kontrol et
        assertEquals(userList.size(), allUsers.size());

        // Her iki liste arasındaki kullanıcıların ID ve isim özelliklerini kontrol et
        for (int i = 0; i < userList.size(); i++) {
            assertEquals(userList.get(i).getId(), allUsers.get(i).getId());
            assertEquals(userList.get(i).getName(), allUsers.get(i).getName());
        }
    }


}

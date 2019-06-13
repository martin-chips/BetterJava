package com.dimple;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * @className: OptionalTest
 * @description: Test Java8 Optional
 * @auther: Dimple
 * @date: 06/13/19
 * @version: 1.0
 */
@Slf4j
public class OptionalTest {

    @Test(expected = NoSuchElementException.class)
    public void whenCreateEmptyOptional_thenNull() {
        Optional<String> emptyOpt = Optional.empty();
        emptyOpt.get();
    }

    @Test(expected = NullPointerException.class)
    public void whenCreateOfEmptyOptional_thenNullPointException() {
        String s = null;
        Optional<String> optionalS = Optional.of(s);
    }

    @Test
    public void whenCreateOfNullableOptional_thenOk() {
        String name = "Dimple";
        Optional<String> optionalS = Optional.ofNullable(name);
        Assert.assertEquals("Dimple", optionalS.get());
    }

    @Test
    public void whenCheckIfPresent_thenOk() {
        User user = new User("Dimple", "bianxiaofeng@sohu.com");
        Optional<User> optionalUser = Optional.ofNullable(user);
        Assert.assertTrue(optionalUser.isPresent());
        Assert.assertEquals("Dimple", optionalUser.get().getName());

        optionalUser.ifPresent(u -> Assert.assertEquals(u.getName(), user.getName()));
    }

    @Test
    public void givenEmptyValue_thenCompare_thenOk() {
        User user = null;
        log.info("use orElse");
        User result = Optional.ofNullable(user).orElse(createNewUser());
        log.info("use orElseGet");
        User result2 = Optional.ofNullable(user).orElseGet(() -> createNewUser());
    }

    @Test
    public void givenNotEmptyValue_thenCompare_thenOk() {
        User user = new User("dimple", "bianxiaofeng@sohu.com");
        log.info("use orElse");
        User result = Optional.ofNullable(user).orElse(createNewUser());
        log.info("use orElseGet");
        User result2 = Optional.ofNullable(user).orElseGet(() -> createNewUser());
    }

    private User createNewUser() {
        log.debug("Creating New User");
        return new User("extra@gmail.com", "1234");
    }

    @Test
    public void whenMap_thenOk() {
        User user = new User("dimple", "bianxiaofeng@sohu.com");
        //map对值引用作为参数的函数，然后将返回值包装在Optional中
        String s = Optional.ofNullable(user).map(User::getEmail).orElse("default@sohu.com");
        Assert.assertEquals(user.getEmail(), s);
    }

    @Test
    public void whenFilter_thenOk() {
        User user = new User("dimple", "bianxiaofeng@sohu.com");
        Optional<User> optionalUser = Optional.ofNullable(user).filter(u -> u.getName() != null && u.getEmail().contains("@"));
        Assert.assertTrue(optionalUser.isPresent());
    }

    @Test
    public void whenChaining_thenOk() {
        User user = new User("dimple", "bianxiaofeng@sohu.com");
        String result = Optional.ofNullable(user)
                .flatMap(User::getAddress)
                .flatMap(Address::getCountry)
                .map(Country::getCode)
                .orElse("default");
        Assert.assertEquals("default", result);
    }
}

@Data
class User {
    private String name;
    private String email;
    private Address address;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Optional<Address> getAddress() {
        return Optional.ofNullable(address);
    }
}

@Data
class Address {
    private Country country;

    public Optional<Country> getCountry() {
        return Optional.ofNullable(country);
    }
}

@Data
class Country {
    private String code;
}

package ru.ismailova.messenger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ismailova.messenger.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String name);
}

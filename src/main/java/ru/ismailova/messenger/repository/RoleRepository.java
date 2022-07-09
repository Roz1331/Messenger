package ru.ismailova.messenger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ismailova.messenger.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}

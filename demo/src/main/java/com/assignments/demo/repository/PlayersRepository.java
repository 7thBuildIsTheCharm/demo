package com.assignments.demo.repository;

import com.assignments.demo.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayersRepository extends JpaRepository<Player, String> {
}

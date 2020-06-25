package com.github.alexrossi.states.repositories;

import com.github.alexrossi.states.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
}

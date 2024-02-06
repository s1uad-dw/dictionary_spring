package ru.s1uad_dw.dictionary_spring.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.s1uad_dw.dictionary_spring.dao.Dictionary;

import java.util.Optional;
import java.util.UUID;

public interface DictionaryRepository extends JpaRepository<Dictionary, UUID> {
    void deleteById(UUID id);

    Optional<Dictionary> findById(UUID id);
}

package hello.hello.Spring.repository;

import hello.hello.Spring.domain.member;

import java.util.List;
import java.util.Optional;

public interface memberRepository {
    member save(member member1);
    Optional<member> findById(Long id);
    Optional<member> findByName(String name);
    List<member> findAll();
}

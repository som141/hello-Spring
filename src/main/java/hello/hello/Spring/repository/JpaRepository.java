package hello.hello.Spring.repository;

import hello.hello.Spring.domain.member;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class JpaRepository implements memberRepository{
    private final EntityManager em;

    public JpaRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public member save(member member1) {
        em.persist(member1);
        return member1;
    }

    @Override
    public Optional<member> findById(Long id) {
        member member= em.find(member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<member> findByName(String name) {
        List<member> resultList = em.createQuery("select m from member m", member.class)
                .getResultList();
        return resultList.stream().findAny();
    }

    @Override
    public List<member> findAll() {
        return em.createQuery("select m from member m", member.class)
                .getResultList();
    }
}

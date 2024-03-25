package hello.hello.Spring;

import hello.hello.Spring.repository.JTRepository;
import hello.hello.Spring.repository.JpaRepository;
import hello.hello.Spring.repository.memberRepository;
import hello.hello.Spring.repository.memoryMemberRepository;
import hello.hello.Spring.service.service;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    EntityManager entityManager;
    @Autowired
    public SpringConfig(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Bean
    public service service(){
        return new service(memberRepository());
    }
    @Bean
    public memberRepository memberRepository(){
//        return new memoryMemberRepository();
//        return new JTRepository(dataSource);
        return new JpaRepository(entityManager);
    }
}

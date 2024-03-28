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
//        다형성 구현에서   SOLID원칙을 지키기 위해 SPRING 에서 고안한 방법.
//        서비스에서 인터페이스 자체만 의존시키고 그 구현체의 연결은 spring에서 처리!
    }
}

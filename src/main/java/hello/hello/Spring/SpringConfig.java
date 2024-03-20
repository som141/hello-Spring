package hello.hello.Spring;

import hello.hello.Spring.repository.memberRepository;
import hello.hello.Spring.repository.memoryMemberRepository;
import hello.hello.Spring.service.service;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public service service(){
        return new service(memberRepository());
    }
    @Bean
    public memoryMemberRepository memberRepository(){
        return new memoryMemberRepository();
    }
}

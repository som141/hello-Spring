package hello.hello.Spring.repository;

import hello.hello.Spring.domain.member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MemoryMemberRepositoryTest {
    memoryMemberRepository repository=new memoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        member member1= new member();
        member1.setName("윤영주");
        repository.save(member1);
      member r  =repository.findById(member1.getId()).get();
        System.out.println("r = "+(member1==r));
        Assertions.assertEquals(member1,r);
        org.assertj.core.api.Assertions.assertThat(member1).isEqualTo(r);
    }
    @Test
    public void findByName(){
        member member1 = new member();
        member member2 = new member();
        member1.setName("spring");
        member2.setName("boots");
        repository.save(member1);
        repository.save(member2);
        member mR=repository.findByName("spring").get();
        org.assertj.core.api.Assertions.assertThat(mR).isEqualTo(member1);

    }
    @Test
    public void findById(){
        member member1 = new member();
        member member2 = new member();
        member1.setName("spring");
        member2.setName("boots");
        repository.save(member1);
        repository.save(member2);
        member IR=repository.findById(1L).get();
        Assertions.assertEquals(IR,member1);
    }
    @Test
    public void findAll(){
        member member1 = new member();
        member member2 = new member();
        member1.setName("일");
        member2.setName("이");
        repository.save(member1);
        repository.save(member2);
        List<member> AR =repository.findAll();
        org.assertj.core.api.Assertions.assertThat(AR.get(0)).isEqualTo(member1);

    }


}

package hello.hello.Spring.service;

import hello.hello.Spring.domain.member;
import hello.hello.Spring.repository.memoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class serviceTest {
    service service= new service();
    memoryMemberRepository memberRepository= new memoryMemberRepository();
    @BeforeEach
    public void beforeEach(){


    }

    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void join() {
        //given(주어진것)
        //when(이걸 실행할때)
        //then(이런 결과가 나와야함)
        member m1= new member();
        m1.setName("1");
        Long saveId=service.join(m1);
        member result=service.findOne(saveId).get();
        Assertions.assertEquals(result,m1);

    }
    @Test
    public void 중복제거(){
        member m1= new member();
        m1.setName("1");
        member m2= new member();
        m2.setName("1");
        service.join(m1);
//       try {
//           service.join(m2);
//           fail();
//       } catch (IllegalStateException e){
//           System.out.println("중복 계정");
//           Assertions.assertEquals(e.getMessage(),"이미 존재하는 회원입니다.");
//       }  이게 방법 1
        IllegalStateException result = assertThrows(IllegalStateException.class, ()->{service.join(m2);});
        Assertions.assertEquals(result.getMessage(),"이미 존재하는 회원입니다.");




    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}
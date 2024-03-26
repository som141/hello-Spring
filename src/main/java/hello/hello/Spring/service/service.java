package hello.hello.Spring.service;

import hello.hello.Spring.domain.member;
import hello.hello.Spring.repository.memberRepository;
import hello.hello.Spring.repository.memoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Transactional
public class service {
    private final memberRepository memberRepository;


    public service(memberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }//DI :의존성 주입

    //    회원 가입
    public Long join(member m1) {
//        중복방지 로직
        vaidDateDuplicateMemvber(m1);
        memberRepository.save(m1);
        return m1.getId();
    }

    //    전체 회원 조회
    public List<member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

    private void vaidDateDuplicateMemvber(member m1) {
        Optional<member> result = memberRepository.findByName(m1.getName());
//        result.ifPresent(x -> {
////                throw new IllegalStateException("이미 존재하는 회원입니다!.");});
////        함수형 인터페이스 람다식 사용
////        근데 result 안만들고 리포지토리 자체가 optional반환이라 바로. 붙여서 써도 됨.
//    }
    }
}

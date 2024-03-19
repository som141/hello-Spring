package hello.hello.Spring.repository;

import hello.hello.Spring.domain.member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class memoryMemberRepository implements memberRepository{

    private static Map<Long,member>store=new HashMap<>();
    private static long sequence = 0L;

    public void clearStore(){
        store.clear();
    }

    @Override
    public member save(member member1) {
         member1.setId(++sequence);//전위 연산자 1증가시키고 저당, 후위사용하면 저장하고 증가시킴;;
        return store.put(member1.getId(),member1);
    }

    @Override
    public Optional<member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<member> findByName(String name) {
       return store.values().stream().filter(member -> member.getName().equals(name)).findAny();
//       여기서 findAny 메소드는 자동으로 Optional로 반환해줌..

    }

    @Override
    public List<member> findAll() {
        return new ArrayList<>(store.values());//ArrayList<>(),()에 객체 넣으면 그걸로 리스트 만들어줌..
    }
}

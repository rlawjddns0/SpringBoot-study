package repository;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public class MemoruMemeberRepositoryTest {
    MemoryMemberRepository repository=new MemoryMemberRepository();

    //순서는 의존성 없게 해야함
    @AfterEach  //각각의 함수가 끝나고 호출됨 save()-> afterEaxh() , findAll()-> afterEach() 이런식
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        Assertions.assertThat(member).isEqualTo(result);
    }

    @Test
    public  void findByName(){
        Member member1=new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 =new Member();
        member2.setName("spring2");
        repository.save(member2);


        Member result=repository.findByName("spring1").get();
        Assertions.assertThat(result).isEqualTo(result);




    }


    @Test
    public void findAll(){
        Member member1=new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 =new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result=repository.findAll();

        Assertions.assertThat(result.size()).isEqualTo(2);//test로 findAll 이 제대로 작동되는지 확인
    }
}

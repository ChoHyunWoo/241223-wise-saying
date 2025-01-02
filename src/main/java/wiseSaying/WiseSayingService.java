package wiseSaying;

import java.util.ArrayList;

//홀 담당역할
public class WiseSayingService {
   private final WiseSayingMemRepository wiseSayingRepository;



    public WiseSayingService(WiseSayingMemRepository wiseSayingMemRepository) {
        this.wiseSayingRepository = wiseSayingMemRepository;
    }

    public WiseSaying findById(int targetId) {

        return wiseSayingRepository.findById(targetId);
    }
    public void update(WiseSaying wiseSaying,String newContent , String newAuthor){

       //비즈니스 로직(객체를 조립하거나 조작하는 것 - 비즈니스 로직)
        wiseSaying.setContent(newContent);
        wiseSaying.setAuthor(newAuthor);

        wiseSayingRepository.update(wiseSaying);
    }
//뭔가를 저장하는 함수 (메서드) 저장된 것을 다시 리턴하는 것이 관례
    public WiseSaying add(String content , String author){

        return wiseSayingRepository.add(content,author);
    }

    public ArrayList<WiseSaying> findAll() {
        return wiseSayingRepository.findAll();
    }
    public void remove(WiseSaying wiseSaying){
        wiseSayingRepository.remove(wiseSaying);
    }
}

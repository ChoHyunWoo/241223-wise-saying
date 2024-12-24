package org.example;

import java.util.Scanner;
import java.util.ArrayList;
//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {
        App app = new App();
        app.run();
    }
}

class App{
    private int lastID =0;
    private int wiseSayingSize =0;
    private final WiseSaying[] wiseSayingList = new WiseSaying[3];

    public void run(){ //클래스에서 함수들이 공유해야 하는 변수 -> 인스턴스 변수

        Scanner scanner = new Scanner(System.in);
        add("꿈을 지녀라. 그러면 어려운 현실을 이길 수 있다.","월드 디즈니");


        System.out.println("== 명언 앱==");
        while(true){
            System.out.print("명령) ");
             String command = scanner.nextLine();
            if(command.equals("종료")){
                System.out.println("명언 앱을 종료합니다.");
                break;
            }else if(command.equals("등록")) {
                System.out.print("명언 : ");

                String content = scanner.nextLine(); //입력값 가져옴, 입력값이 없으면 기다린다. 엔터를 쳐야 입력이 완료됨. 그래야 넘어간다.

                System.out.print("작가 : ");
                String author = scanner.nextLine();

                add(content,author);//1. 함수로 분리 -> 코드가 줄어든다. 가독성이 올라간다. 2. 재활용성(중복 제거)

                System.out.println("%d번 명언이 등록되었습니다.".formatted(lastID));

            }else if(command.equals("목록")){
                System.out.println("번호 / 작가 / 명언");
                System.out.println("---------------------");

                for(int i =0; i < wiseSayingSize; i++) {
                    WiseSaying wiseSayig = wiseSayingList[i];
                    System.out.println(" %d / %s / %s".formatted(wiseSayig.getId(),wiseSayig.getAuthor(),wiseSayig.getContent()));
                }

            }
        }
    }
    public void add(String content, String author){

        WiseSaying wisesaying = new WiseSaying(++lastID,content,author);
        wiseSayingList[wiseSayingSize++] = wisesaying;

    }
}
class WiseSaying {
   private int id;
    private String content;
    private String author;

    WiseSaying(int id,String content, String author){
        this.id = id;
        this.content = content;
        this.author=author;
    }
    public int getId(){
        return id;
    }
    public String getContent(){
        return content;
    }
    public String getAuthor(){
        return author;
    }
}

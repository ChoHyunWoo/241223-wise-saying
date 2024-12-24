package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private int lastID =0;
   private final ArrayList<WiseSaying> wiseSayingList = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    public void run(){ //클래스에서 함수들이 공유해야 하는 변수 -> 인스턴스 변수


        add("꿈을 지녀라. 그러면 어려운 현실을 이길 수 있다.","월드 디즈니");
        add("현재를 사랑하라","작자 미상");

        System.out.println("== 명언 앱==");
        while(true){
            System.out.print("명령) ");
            String command = scanner.nextLine();

            if(command.equals("종료")){
                System.out.println("명언 앱을 종료합니다.");
                break;

            }else if(command.equals("등록")) {
               writeWiseSaying();

            }else if(command.equals("목록")){
                printWiseSayingList();

            }
        }
    }

    private void printWiseSayingList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("---------------------");


        for( WiseSaying wiseSaying: wiseSayingList.reversed()){
            System.out.println(" %d / %s / %s".formatted(wiseSaying.getId(),wiseSaying.getAuthor(),wiseSaying.getContent()));

        }
    }

    private void writeWiseSaying() {
        System.out.print("명언 : ");
        String content = scanner.nextLine(); //입력값 가져옴, 입력값이 없으면 기다린다. 엔터를 쳐야 입력이 완료됨. 그래야 넘어간다.

        System.out.print("작가 : ");
        String author = scanner.nextLine();

        add(content,author);//1. 함수로 분리 -> 코드가 줄어든다. 가독성이 올라간다. 2. 재활용성(중복 제거)
        System.out.println("%d번 명언이 등록되었습니다.".formatted(lastID));

    }

    public void add(String content, String author){

        WiseSaying wisesaying = new WiseSaying(++lastID,content,author);
        wiseSayingList.add(wisesaying);

    }
}

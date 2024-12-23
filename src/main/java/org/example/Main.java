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
    public void run(){

        Scanner scanner = new Scanner(System.in);
        ArrayList<String> speaks = new ArrayList<>();
        ArrayList<String> authors = new ArrayList<>();

        System.out.println("== 명언 앱==");
        int lastNo =1;
        while(true){
            System.out.print("명령) ");
             String command = scanner.nextLine();
            if(command.equals("종료")){
                System.out.println("명언 앱을 종료합니다.");
                break;
            }else if(command.equals("등록")) {
                System.out.print("명언 : ");
                String speak = scanner.nextLine(); //입력값 가져옴, 입력값이 없으면 기다린다. 엔터를 쳐야 입력이 완료됨. 그래야 넘어간다.

                speaks.add(speak);

                System.out.print("작가 : ");
                String author = scanner.nextLine();

                authors.add(author);

                System.out.println( lastNo + "번 명언이 등록되었습니다.");
            lastNo++;
            }else if(command.equals("목록")){
                System.out.println("번호 / 작가 / 명언");
                System.out.println("---------------------");
            for(int i = speaks.size()-1; i>=0; i--){
                System.out.println((i+1) +" / " + authors.get(i) + " / " + speaks.get(i));
            }
            }
        }
    }
}

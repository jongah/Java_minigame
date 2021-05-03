import java.util.Scanner;
import java.util.Random;

public class Rock_paper_scissors {
    public static void main(String args []) {
        Random random = new Random();
        Scanner scan = new Scanner(System.in);
        char com[] = {'묵', '찌', '빠'};
        char user[] = {'빠', '묵', '찌'};
        int com_index = 0, user_index = 0, com_score = 0, user_score = 0;
        char user_resault = ' ';
        String blank, answer = "";

        System.out.println("\n※ 가위 바위 보를 할 때에는 묵, 찌, 빠로 입력 해야 합니다.(가위, 바위, 보 입력 불가)\n");

        while(true){
            int winner = 0;
            System.out.println("::        게임을 시작 하시겠습니까(Yes or No)        ::");
            System.out.print("\n: ");
            answer = scan.next();
            if(answer.equals("yes") || answer.equals("Yes")){
                while (true) {
                    if(winner == 0)
                        System.out.println("\n가위 바위 보!!\n");
                    else if(winner == 1)
                        System.out.println("User : " + user[user_index] + user[user_index] + "~!");
                    else
                        System.out.println("Com : " + com[com_index] + com[com_index] + "~!");
                    int input = 0;
                    while(input == 0){ //입력 및 확인
                        System.out.print("\tUser : ");
                        blank = scan.next();
                        user_resault = blank.charAt(0);
                        switch(user_resault) {
                            case '묵' : case '찌' : case '빠' :
                                input = 1;
                        }
                        if(input == 0)
                            System.out.println("\t*묵, 찌, 빠를 제대로 입력해 주십시오\n");
                    }

                    com_index = random.nextInt(3); //random com_index생성
                    System.out.println("\tCom  : " + com[com_index]);
                    for (int i = 0; i < 3; i++) {
                        if (user[i] == user_resault) {
                            user_index = i; //user_inex 생성
                        }
                    }

                    if (user[user_index] == com[com_index]) {
                        if (winner == 0){
                            System.out.println("\n*비겼습니다.");
                        }else if (winner == 1) {
                            System.out.println("\n::     이겼습니다!!     ::\n");
                            user_score += 1;
                            break;
                        }else {
                            System.out.println("\n??     졌습니다!!     ??\n");
                            com_score += 1;
                            break;
                        }
                    } else {
                        if (user_index == com_index) {
                            winner = 1;
                            System.out.println("\n*이겼습니다.\n");
                        }else {
                            winner = 2;
                            System.out.println("\n*졌습니다.\n");
                        }
                    }
                }
                System.out.println(user_score + "승" + com_score + "패\n");
            }
            else if(answer.equals("no") || answer.equals("No")){
                System.out.print("          *게임이 종료되었습니다*");
                break;
            }
            else
                System.out.println("* yes 아니면 no 로만 대답해 주십시오.\n");
        }
    }
}
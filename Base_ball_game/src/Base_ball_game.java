import java.util.Random;
import java.util.Scanner;
public class Base_ball_game {
    public static void main(String [] args){
        int bot_num[]= new int[4], user_num[]=new int[4], user_all_num, user_string_count;
        String answer_start, user_string;
        Random random= new Random();
        Scanner sc = new Scanner(System.in);
        System.out.println(":: Welcome to Baseball game ::");

        while(true){        // 대답이 no||No break;
            System.out.print("\n*게임을 시작하시겠습니까?* (Yes or No)\n: ");
            answer_start = sc.next();
            if(answer_start.equals("yes") || answer_start.equals("Yes")){

                for (int i = 0; i < 4; i++)
                    bot_num[i] = random.nextInt(9);
                while (bot_num[0] == bot_num[1])
                    bot_num[1] = random.nextInt(9);
                while (bot_num[2] == bot_num[1] || bot_num[2] == bot_num[0])
                    bot_num[2] = random.nextInt(9);
                while (bot_num[3] == bot_num[0] || bot_num[3] == bot_num[1] || bot_num[3] == bot_num[2])
                    bot_num[3] = random.nextInt(9);

                while (true) {      //홈런시 break;
                    int strike = 0, ball = 0;
                    while (true){        // 숫자 입력
                        int same_count = 0, x = 1;
                        System.out.print("\n"+"숫자 입력 : ");
                        user_string = sc.next();
                        user_string_count = user_string.length();
                        user_all_num = Integer.parseInt(user_string);
                        for (int i = 0; i < 4; i++){
                            user_num[i] = user_all_num % (10 * x) / x;
                            x *= 10;
                        }
                        for(int i = 0; i < 3; i++) {
                            if (same_count != 0)
                                break;
                            for (int j = 1; j < 4; j++)
                            	if (i < j && user_num[i] == user_num[j])
                                    same_count++;
                        }
                        if(same_count == 0 && user_string_count == 4)
                            break;
                        else System.out.println("**숫자는 4자리이고 중복 사용이 불가 합니다**");
                    }       //user_all_num 생성

                    for (int i = 0; i < 4; i++) {
                        if (bot_num[i] == user_num[i])
                            strike += 1;      //strike 생성
                        for (int j = 0; j < 4; j++)
                            if (i != j && (bot_num[i] == user_num[j]))
                                ball += 1;     //ball 생성
                    }
                    if (strike==4) {
                        System.out.println("\n!!Homrun!!!");
                        break;
                    }

                    System.out.println("!!" + strike + "스트라이크 " + ball + "볼!!");
                }
            }
            else if(answer_start.equals("no") || answer_start.equals("No"))
                break;
            else
                System.out.println("\n*정확히 입력하시기 바랍니다*");
        }
        System.out.println("\n"+"게임이 종료되었습니다...");
    }       //end main
}
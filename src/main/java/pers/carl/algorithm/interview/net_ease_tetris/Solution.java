package pers.carl.algorithm.interview.net_ease_tetris;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 小易有一个古老的游戏机，上面有着经典的游戏俄罗斯方块。因为它比较古老，所以规则和一般的俄罗斯方块不同。
 * 荧幕上一共有 n 列，每次都会有一个 1 x 1 的方块随机落下，在同一列中，后落下的方块会叠在先前的方块之上，当一整行方块都被占满时，这一行会被消去，并得到1分。
 * 有一天，小易又开了一局游戏，当玩到第 m 个方块落下时他觉得太无聊就关掉了，小易希望你告诉他这局游戏他获得的分数。
 *
 *
 * 输入描述
 *  第一行两个数 n, m
 *  第二行 m 个数，c1, c2, … , cm ， ci 表示第 i 个方块落在第几列
 *  其中 1 <= n, m <= 1000, 1 <= ci <= n
 *
 * 输出描述
 *  小易这局游戏获得的分数
 *
 *  示例：
 *
 *     输入
 *      第一行： 3 9
 *      第二行： 1 1 2 2 2 3 1 2 3
 *
 *     输出
 *       2
 */
public class Solution {



    private static String separator = " ";



    private int solution(int n, int m, List<Integer> blockColumnIndex){
        if(n < 1 || m < 0){
            return 0;
        }

        //只有一列，有多少块方块就有多少分
        if(n == 1){
            return m;
        }

        //因为是1*1的方块，所以只要有落在每一列的方块就会得一分
        List<Integer> standardList = new ArrayList<>();
        for (int i = 1; i <= n; i++){
            //满足这样的组合就加一分
            standardList.add(i);
        }

       /* blockColumnIndex.stream().peek(columnIndex ->{


        })*/
        return 0;
    }


    public static void main(String[] args) {

        int n = 0, m = 0;
        List<Integer> blockColumnIndex = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        for (;true;){
            System.out.println("请输入n,m用空格隔开：");
            String nMread = scanner.nextLine();
            if(!StringUtils.isEmpty(nMread)){
              String[] paraArray = nMread.split(separator);
              try{
                  n = Integer.parseInt(paraArray[0]);
                  m = Integer.parseInt(paraArray[1]);
                  if(m > 1000){
                      System.out.println("m 必须小于1000");
                      continue;
                  }
              }catch (IndexOutOfBoundsException | ClassCastException e){
                  System.out.println("请输入合法的参数！");
                  continue;
              }
            }
            System.out.println("请输入Ci-Cm用空格隔开：");
            String cIcMread = scanner.nextLine();
            if(!StringUtils.isEmpty(nMread)){
                String[] cIcMarray = cIcMread.split(separator);
                if(cIcMarray.length != m){
                    System.out.println("请输入正确的参数!");
                    continue;
                }

                for (int i = 0; i < cIcMarray.length; i++){
                    int ci = 0;
                    try{
                        ci = Integer.parseInt(cIcMarray[i]);
                    }catch (ClassCastException e){
                        System.out.println("请输入正确的ci!");
                        continue;
                    }
                    if(ci < 1 || ci > n){
                        System.out.println("请输入正确的ci!");
                        continue;
                    }
                    blockColumnIndex.add(ci);
                }
                break;

            }

        }

        Solution solution = new Solution();
        System.out.println(solution.solution(n, m, blockColumnIndex));


    }

}

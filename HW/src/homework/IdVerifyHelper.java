package homework;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Scanner;

public class IdVerifyHelper {

    public boolean checkId(int[] idArray){
        int num1 = idArray[0]*1;
        int num2 = idArray[1]*9;
        int num3 = idArray[2]*8;
        int num4 = idArray[3]*7;
        int num5 = idArray[4]*6;
        int num6 = idArray[5]*5;
        int num7 = idArray[6]*4;
        int num8 = idArray[7]*3;
        int num9 = idArray[8]*2;
        int num10 = idArray[9]*1;

        int sum = num1+num2+num3+num4+num5+num6+num7+num8+num9+num10;
        int mod = sum % 10;
        if(mod != 0 ){
            int lastNum= 10-mod;
            if(idArray[10]==lastNum) return true;
            else return false;
        }else{
            if(idArray[10]==0) return true;
            else return false;
        }

    }



    public static void main(String[] args) throws IOException {
        String filePath = "D:\\workspace\\workspace3\\practice\\HW\\idList.txt";
        File idlist = new File(filePath);
        BufferedReader br = new BufferedReader(new FileReader(idlist));
        String eachID;
        while ((eachID=br.readLine())!=null){
            System.out.println("eachID:"+eachID);
            //先驗證身分證格式
            System.out.println("aaa:"+eachID.matches("/^[A-Z][0-9]{9}$/"));
            if(!(eachID.matches("/^[A-Z][0-9]{9}$/"))){
                System.out.println("====您輸入的身分證字號"+eachID+"====");
                System.out.println("====驗證失敗====");
                break;
            }


            char cc =eachID.charAt(0);
            Character c = (Character)cc;
            String firstEng= c.toString(); //取得第一個英文字母
            EnglishPositon ep = new EnglishPositon();
            String id11Digit = ep.idNum11digit(eachID,ep.engToNum(firstEng));

            //取得一個陣列存放 11純數字身分證
            int[] idArray = new int[11];
            for(int i = 0;i<id11Digit.length();i++){
                char c1 = id11Digit.charAt(i);
                idArray[i] = Character.getNumericValue(c1);
            }
            //開始處理計算公式
            IdVerifyHelper helper =new IdVerifyHelper();
            boolean bo= helper.checkId(idArray);
            System.out.println("結果:"+bo);




////            Integer id11Digit_Integer = Integer.valueOf(id11Digit);
//            //取得一個陣列存放 11純數字身分證
//            IdVerifyHelper helper =new IdVerifyHelper();
//            int[] idArray =helper.id11DigitArray(id11Digit_Integer);

        }

    }
}

package homework;

import homework.model.VerifyResult;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class IdVerifyHelper {

    public boolean checkId(int[] idArray) {
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

    public  IdVerifyHelper(String filename) {
    }

    public List<VerifyResult> validate(String filename) throws IOException {
//        String filePath = "D:\\workspace\\workspace3\\practice\\HW\\idList.txt";
        List<VerifyResult> resultList = new ArrayList<>();
        File idlist = new File(filename);
        BufferedReader br = new BufferedReader(new FileReader(idlist));
        String eachID;

        while ((eachID=br.readLine())!=null){
//            System.out.println("eachID:"+eachID);

            //取得第一個英文字母後，將英文字轉成數字
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
            IdVerifyHelper helper =new IdVerifyHelper(filename);
            boolean bo= helper.checkId(idArray);
//            System.out.println("結果:"+bo);
            VerifyResult result= new VerifyResult();
            if (bo && (eachID.matches(".*[A-Z][0-9]{9}.*"))){
                result.setId(eachID);
                result.setVerifySuccess(true);
                result.setMessage("驗證成功");
                resultList.add(result);
            }else{
                result.setId(eachID);
                result.setVerifySuccess(false);
                result.setMessage("驗證失敗");
                resultList.add(result);
            }

        }

        return resultList;
    }

    public static void main(String[] args) throws IOException {
        String filePath = "D:\\workspace\\workspace3\\practice\\HW\\idList.txt";
        File idlist = new File(filePath);
        BufferedReader br = new BufferedReader(new FileReader(idlist));
        String eachID;

        while ((eachID=br.readLine())!=null){

//            System.out.println("eachID:"+eachID)
            VerifyResult result= new VerifyResult();
            //先處理商業規則後，再進行內政部身分證規則檢查，因須將英文字母轉乘數字才有辦法驗證
            boolean b1 = eachID.matches("[A-Z|a-z]{1,}[0-9]{0,}");
            if(!eachID.matches("[A-Z|a-z]{1,}[0-9]{0,}")){
                result.setId(eachID);
                result.setVerifySuccess(false);
                result.setMessage("證號格式錯誤*");
            }else{
                //開始驗證內政部規則，取得第一個英文字母後，將英文字轉成數字
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
                IdVerifyHelper helper =new IdVerifyHelper(filePath);
                boolean bo= helper.checkId(idArray);
//            System.out.println("結果:"+bo);
                if(bo){
                    result.setId(eachID);
                    result.setVerifySuccess(true);
                    result.setMessage("驗證成功");

                }else{
                    result.setId(eachID);
                    result.setVerifySuccess(false);
                    result.setMessage("驗證失敗，內政部格式錯誤");
                }
            }

        }
    }

}

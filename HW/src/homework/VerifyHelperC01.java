package homework;

import homework.model.VerifyResult;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VerifyHelperC01 extends IdVerifyHelper{

    public VerifyHelperC01(String filename) {
        super(filename);
    }

    @Override
    public List<VerifyResult> validate(String filename) throws IOException {

        List<VerifyResult> resultList = new ArrayList<>();
        File idlist = new File(filename);
        BufferedReader br = new BufferedReader(new FileReader(idlist));
        String eachID;

        while ((eachID=br.readLine())!=null){
//            System.out.println("eachID:"+eachID)
            VerifyResult result= new VerifyResult();
            //先處理商業規則後，再進行內政部身分證規則檢查，因須將英文字母轉乘數字才有辦法驗證
            if(!eachID.matches("\\w{10}")){
                result.setId(eachID);
                result.setVerifySuccess(false);
                result.setMessage("驗證失敗，證號長度不為10");
                resultList.add(result);
            }else if(!eachID.matches(".*[A-Z][0-9]{9}.*")){
                result.setId(eachID);
                result.setVerifySuccess(false);
                result.setMessage("驗證失敗，證號格式錯誤");
                resultList.add(result);
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
                IdVerifyHelper helper =new IdVerifyHelper(filename);
                boolean bo= helper.checkId(idArray);
//            System.out.println("結果:"+bo);
                if(bo){
                    result.setId(eachID);
                    result.setVerifySuccess(true);
                    result.setMessage("驗證成功");
                    resultList.add(result);
                }else{
                    result.setId(eachID);
                    result.setVerifySuccess(false);
                    result.setMessage("驗證失敗，內政部格式錯誤");
                    resultList.add(result);
                }
            }
        }

        return resultList;
    }
}

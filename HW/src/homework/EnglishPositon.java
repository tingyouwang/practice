package homework;

import java.util.HashMap;

public class EnglishPositon {
    public String engToNum(String key){
        HashMap<String, String> hm = new HashMap<String, String>();
        hm.put("A", "10");
        hm.put("B", "11");
        hm.put("C", "12");
        hm.put("D", "13");
        hm.put("E", "14");
        hm.put("F", "15");
        hm.put("G", "16");
        hm.put("H", "17");
        hm.put("I", "34");
        hm.put("J", "18");
        hm.put("K", "19");
        hm.put("L", "20");
        hm.put("M", "21");
        hm.put("N", "22");
        hm.put("O", "35");
        hm.put("P", "23");
        hm.put("Q", "24");
        hm.put("R", "25");
        hm.put("S", "26");
        hm.put("T", "27");
        hm.put("U", "28");
        hm.put("V", "29");
        hm.put("W", "32");
        hm.put("X", "30");
        hm.put("Y", "31");
        hm.put("Z", "33");
        hm.put("a", "10");
        hm.put("b", "11");
        hm.put("c", "12");
        hm.put("d", "13");
        hm.put("e", "14");
        hm.put("f", "15");
        hm.put("g", "16");
        hm.put("h", "17");
        hm.put("i", "34");
        hm.put("j", "18");
        hm.put("k", "19");
        hm.put("l", "20");
        hm.put("m", "21");
        hm.put("n", "22");
        hm.put("o", "35");
        hm.put("p", "23");
        hm.put("q", "24");
        hm.put("r", "25");
        hm.put("s", "26");
        hm.put("t", "27");
        hm.put("u", "28");
        hm.put("v", "29");
        hm.put("w", "32");
        hm.put("x", "30");
        hm.put("y", "31");
        hm.put("z", "33");
        return hm.get(key);
    }

    public String idNum11digit(String id, String firstAndSecond){

        StringBuilder sb = new StringBuilder();
        sb.append(firstAndSecond); //前兩碼是英文轉純數字
//        System.out.println("qqqqq:"+sb.toString());
        for(int i =1;i<id.length();i++){
            char eachNum = id.charAt(i);
            Character eachNumC = (Character)eachNum;
//            eachNumC.toString()
            sb.append(eachNumC.toString());
        }
//        System.out.println("純數字身分證id"+sb.toString());
        return sb.toString();
    }

}

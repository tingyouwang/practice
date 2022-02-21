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

//    public String stringId(String firstAndSecond, String last9Num){
//
//    }
//    public static void main(String[] args) {
//        HashMap<String, Integer> hm = new HashMap<String, Integer>();
//        hm.put("A", 1);
//        hm.put("B", 2);
//        hm.put("C", 3);
//        hm.put("D", 4);
//        hm.put("E", 5);
//        hm.put("F", 6);
//        hm.put("G", 7);
//        hm.put("H", 8);
//        hm.put("I", 9);
//        hm.put("J", 10);
//        hm.put("K", 11);
//        hm.put("L", 12);
//        hm.put("M", 13);
//        hm.put("N", 14);
//        hm.put("O", 15);
//        hm.put("P", 16);
//        hm.put("Q", 17);
//        hm.put("R", 18);
//        hm.put("S", 19);
//        hm.put("T", 20);
//        hm.put("U", 21);
//        hm.put("V", 22);
//        hm.put("W", 23);
//        hm.put("X", 24);
//        hm.put("Y", 25);
//        hm.put("Z", 26);
//
//        String input="values";
//        input = input.toUpperCase();
//
//        if(hm.get(input)==null) {
//            System.out.println(0);
//        }else {
//            System.out.println(input+":"+hm.get(input));
//        }
//
//        Integer sum=0;
//        for(int i =0;i<input.length();i++) {
//            char charAt = input.charAt(i);
//            Character c = (Character)charAt;
//            String s1 = c.toString();
//            sum+=hm.get(s1);
//        }
//        System.out.println(input+":sum:"+sum);
//
//
//    }
}

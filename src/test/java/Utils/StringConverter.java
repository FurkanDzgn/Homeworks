package Utils;

public class StringConverter {

    public static double converter(String str){

        StringBuilder stb=new StringBuilder(str.substring(1).trim());

        double dob=Double.parseDouble(stb.toString().trim());

//        for(int i=0; i<stb.length();i++){
//            if(!Character.isDigit(stb.charAt(i))){
//                stb.deleteCharAt(i);
//                break;
//            }
//        }
        return dob;
    }

    public static double converter2(String str){
        StringBuilder stb=new StringBuilder(str.substring(str.indexOf('$')+1,str.length()-1).trim());
        double dob=Double.parseDouble(stb.toString().trim());
//        for(int i=0; i<stb.length();i++){
//            if(!Character.isDigit(stb.charAt(i))){
//                stb.deleteCharAt(i);
//
//            }
//        }
        return dob;
    }

}

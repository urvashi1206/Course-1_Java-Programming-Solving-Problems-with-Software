
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    public void findAbc(String input){
       System.out.println(input.length());
       int index = input.indexOf("abc");
       while (true){
           if (index == -1 || index >= input.length() - 3){
               System.out.println("index before breaking " + index);
               break;
           }
           System.out.println("index " + index);
           //code
           index=index-1;
           System.out.println("index after updating " + index);
           String found = input.substring(index+2, index+5);
           System.out.println(found);
           index = input.indexOf("abc",index+4);
           System.out.println("new index " + index);
       }
   }

   public void test(){
       //findAbc("abcd");
       findAbc("abcdkfjsksioehgjfhsdjfhksdfhuwabcabcajfieowj");
   }
}

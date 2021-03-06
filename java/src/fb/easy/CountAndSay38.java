package fb.easy;
//The count-and-say sequence is the sequence of integers with the first five terms as following:
//
//        1.     1
//        2.     11
//        3.     21
//        4.     1211
//        5.     111221
//        1 is read off as "one 1" or 11.
//        11 is read off as "two 1s" or 21.
//        21 is read off as "one 2, then one 1" or 1211.
//        Given an integer n, generate the nth term of the count-and-say sequence.
//
//        Note: Each term of the sequence of integers will be represented as a string.
//
//        Example 1:
//
//        Input: 1
//        Output: "1"
//        Example 2:
//
//        Input: 4
//        Output: "1211"



public class CountAndSay38 {
    public String countAndSay(int n) {
        if(n==0){return "";}
        if(n==1){return "1";}
        StringBuilder ans=new StringBuilder();
        ans.append('1');
        int i =1;
        while(i<n){
            StringBuilder nextAns=new StringBuilder();
            char pre=ans.charAt(0);
            int count=1;
            for(int j=1 ; j<ans.length() ; j++){
                char c=ans.charAt(j);
                if(c!=pre){
                    nextAns.append(String.valueOf(count));
                    nextAns.append(pre);
                    count=1;
                }else{
                    count+=1;
                }
                pre=c;

            }
            nextAns.append(String.valueOf(count));
            nextAns.append(pre);
            ans=nextAns;
            i++;
        }
        return ans.toString();
    }
}

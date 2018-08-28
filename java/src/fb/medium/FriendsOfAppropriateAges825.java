package fb.medium;
//Some people will make friend requests. The list of their ages is given and ages[i] is the age of the ith person.
//
//        Person A will NOT friend request person B (B != A) if any of the following conditions are true:
//
//        age[B] <= 0.5 * age[A] + 7
//        age[B] > age[A]
//        age[B] > 100 && age[A] < 100
//        Otherwise, A will friend request B.
//
//        Note that if A requests B, B does not necessarily request A.  Also, people will not friend request themselves.
//
//        How many total friend requests are made?
//
//        Example 1:
//
//        Input: [16,16]
//        Output: 2
//        Explanation: 2 people friend request each other.
//        Example 2:
//
//        Input: [16,17,18]
//        Output: 2
//        Explanation: Friend requests are made 17 -> 16, 18 -> 17.
//        Example 3:
//
//        Input: [20,30,100,110,120]
//        Output:
//        Explanation: Friend requests are made 110 -> 100, 120 -> 110, 120 -> 100.


import java.util.HashMap;

public class FriendsOfAppropriateAges825 {
//    public int numFriendRequests(int[] ages) {
//        int l=ages.length;
//        int ans=0;
//        HashMap<Integer ,Integer> alreadyRequest=new HashMap<>();
//        for(int i=0 ; i<l;i++){
//            for(int j=0 ; j<l;j++){
//                if(i!=j && willRequest(ages[i] , ages[j])){
//                    ans++;
//                }
//            }
//        }
//        return ans;
//
//    }
//    private boolean willRequest(int a , int b){
//        return !((b<=(0.5*a+7)) || ( b>a ) || (b>100 && a<100));
//    }

//    上面会超时



//    1 <= ages.length <= 20000.
//            1 <= ages[i] <= 120.
//
    public int numFriendRequests(int[] ages) {

        int[] ageBracket = new int[121];
        for (int a : ages) {
            ageBracket[a]++;
        }
        int ans=0;
        for (int i = 1; i < 121; i++) {
            for (int j = 1; j < 121; j++) {
                if(willRequest(i , j)){
                    if(i==j){
                        ans+=ageBracket[i]*(ageBracket[i]-1);
                    }else{
                        ans+=ageBracket[i]*ageBracket[j];
                    }
                }
            }
        }

        return ans;
    }

    private boolean willRequest(int a, int b) {
        return !((b <= (0.5 * a + 7)) || (b > a) || (b > 100 && a < 100));
    }
}

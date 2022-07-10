package com.Test;

/**
 * @author 吴喜华
 * @version 1.0
 * @date 2022/4/18 9:16
 */
import java.util.*;

public class Solution {

//    public boolean IsPopOrder(int[] pushA, int[] popA){
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        Collections.
//        List popAList = Arrays.asList(popA);
//        int[] popACopy = Arrays.copyOf(popA, popA.length);
//
//
//        Arrays.sort(pushA);
//
//
//        for(int i=0 ; i<popA.length;i++){
//            if( i!=0 ){
//                int al = i-1;
//                arrayList.add(popA[al]);
//            }
//            int pushIndex = Arrays.binarySearch(pushA, popA[i]);
//            int[] pushCopy = Arrays.copyOf(pushA, pushIndex);
//
//            for (int j=pushCopy.length-1;j>0;j--){
//
//                if(arrayList.size()!=0){
//                    for(int a = 0;a<arrayList.size();a++){
//                         if(arrayList.get(a) == pushCopy[j]){
//
//                         }
//
//
//                    }
//                }
//
//
//
//                if (Arrays.binarySearch(popACopy, pushCopy[j]) > Arrays.binarySearch(popACopy,pushCopy[j--])) {
//                    return false;
//                }
//            }
//
//
//
//        }
//
//
//    }

    //1,2,3,4,5,6,7,8
    //4,3,5,6,8,7,2,1

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = new int[]{1,2,3,4,5,6,7};
        int[] a1 = new int[]{3,5,4,2,6,1,7};
        int[] a2 = Arrays.copyOf(a1,a1.length);
           Arrays.sort(a2);
        System.out.println(Arrays.binarySearch(a2, 4));
        System.out.println(Arrays.toString(a1));


//        System.out.println(Arrays.toString(Arrays.copyOf(a, 2)));

        }








    //    public boolean IsPopOrder(int[] pushA, int[] popA) {
//        Stack<Integer> stack = new Stack<>();
//        int p = 0;
//        for (int i = 0; i < pushA.length; i++) {
//            stack.push(pushA[i]);
//
//            while (!stack.empty() && stack.peek() == popA[p]) {
//                stack.pop();
//                p++;
//            }
//        }
//
//        return p == popA.length;
//    }

}

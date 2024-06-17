package maths;

public class Calculation {
        public static boolean checkPrime(int num){
        if(num==0 || num==1){
            return false;
        }
        for(int divisor=2;divisor<=(num/2);divisor++){
            if(num%divisor==0)
                return false;
        }
            return true;
        }

        public static long calculateFactorial(long num){
            long answer=1;
            for(long iterator=1;iterator<=num;iterator++)
                answer*=iterator;
            return answer;
        }

}

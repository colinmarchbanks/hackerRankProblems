public class working {
    static void kaprekarNumbers(int p, int q) {
        if(p == q - 1){
            System.out.print("Invalid Range");
        }else{
            for(int i = p+1;i<q;i++){
                int n = i;
                int originalN = n;
                n = n * n;
                String nAsString = String.valueOf(n);
                if(nAsString.length() > 1){
                    if(nAsString.length()-originalN > 0){
                        String right = nAsString.substring(nAsString.length()-originalN);
                        String left = nAsString.substring(0,nAsString.length()-originalN);
                        if(Integer.parseInt(right) + Integer.parseInt(left) == originalN){
                            System.out.print(originalN);
                        }
                    }else{
                        String right = nAsString;
                        if(Integer.parseInt(right) + 0 == originalN){
                            System.out.print(originalN);
                        }
                    }
                }else if(nAsString == "1"){
                    System.out.print(1);
                }

            }
        }
}

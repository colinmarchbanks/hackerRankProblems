public class kaprekarNumbers {
    boolean flag = false;

        if(p == 1)
    {
        System.out.print(p+" ");
        flag = true;
    }


        for(long i = p; i <= q; i++)
    {
        long squareLong = i * i;
        String squareStr = String.valueOf(squareLong);

        if(squareStr.length() > 1)
        {
            long left = Long.parseLong(squareStr.substring(0,(int)Math.ceil       (squareStr.length()/2)));
            long right = Long.parseLong(squareStr.substring((int)Math.ceil(squareStr.length()/2), squareStr.length()));
            if(left+right == i)
            {
                System.out.print(i+" ");
                flag = true;
            }
        }
    }
        if(!flag)
    {
        System.out.println("INVALID RANGE");
    }
}

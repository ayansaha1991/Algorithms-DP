// Java program to print a given matrix in spiral form
 
class Test 
{
    // Function print matrix in spiral form
    static void spiralPrint(int R, int C, int a[][])
    {
        int i, rs = 0, cs = 0;
        /*  k - starting row index
        m - ending row index
        l - starting column index
        n - ending column index
        i - iterator
        */
          
        while (rs < R && cs < C)
        {
            // Print the first row from the remaining rows
            for (i = cs; i < C; ++i)
            {
                System.out.print(a[rs][i]+" ");
            }
            rs++;
  
            // Print the last column from the remaining columns 
            for (i = rs; i < R; ++i)
            {
                System.out.print(a[i][C-1]+" ");
            }
            C--;
  
            // Print the last row from the remaining rows */
            if ( rs < R)
            {
                for (i = C-1; i >= cs; --i)
                {
                    System.out.print(a[R-1][i]+" ");
                }
                R--;
            }
  
            // Print the first column from the remaining columns */
            if (cs < C)
            {
                for (i = R-1; i >= rs; --i)
                {
                    System.out.print(a[i][cs]+" ");
                }
                cs++;    
            }        
        }
    }
     
    // driver program
    public static void main (String[] args) 
    {
        int R = 3;
        int C = 6;
        int a[][] = { {1,  2,  3,  4,  5,  6},
                      {7,  8,  9,  10, 11, 12},
                      {13, 14, 15, 16, 17, 18}
                    };
        spiralPrint(R,C,a);
    }
}
 
// Contributed by Pramod Kumar
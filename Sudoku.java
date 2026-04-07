public class Sudoku
{
    public static void main(String[] args)
    {
        int[][][][] array = new int[3][3][3][3];
        print(array);
        fill(array, 0, 0, 0, -1);
        System.out.println();
        print(array);
    }

    public static boolean fill(int[][][][] a, int x, int y, int r, int c){
        c++;
        if (c == 3){
            c = 0; 
            r++;
        }
        if (r == 3){
            r = 0; 
            y++;
        }
        if (y == 3){
            y = 0; 
            x++;
        }
        if (x == 3) return true;
        
        //test loop
        int n = (int) (Math.random()*9) + 1;
        for (int k = 0; k < 9; k++){
            n = n % 9 + 1;
            if (checkSpace(a, x, y, r, c, n)){
                a[x][y][r][c] = n;
            
                if (fill(a, x, y, r, c))
                    return true;
                
                a[x][y][r][c] = 0;
            
            }

        }
        
        return false;
    }
    
    public static void print(int[][][][] a){
        for (int i = 0; i < a.length; i++){
            System.out.print("+-------+-------+-------+");
            System.out.println();
           
            for (int r = 0; r < a[0][0].length; r++){
                
                for (int j = 0; j < a[0].length; j++){
                    System.out.print("| ");
                
                    for (int c = 0; c < a[0][0][0].length; c++){
                        System.out.print(a[i][j][r][c] + " ");
                        
                    }
                }
                System.out.print("|");
                System.out.println();
            }
        }
        System.out.print("+-------+-------+-------+");
    }
    
    public static boolean checkSpace(int[][][][] a, int i, int j, int r, int c, int n){
        for (int x = 0; x < a.length; x++){
            for (int y = 0; y < a[0].length; y++){
                if (a[i][x][r][y] == n)
                    return false;
            }
        }
        for (int x = 0; x < a.length; x++){
            for (int y = 0; y < a[0].length; y++){
                if (a[x][j][y][c] == n)
                    return false;
            }
        }
        for (int x = 0; x < a.length; x++){
            for (int y = 0; y < a[0].length; y++){
                if (a[i][j][x][y] == n)
                    return false;
            }
        }
        return true;
    }
}

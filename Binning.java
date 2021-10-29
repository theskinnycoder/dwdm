import java.util.Scanner;

class Main {

    static void printAllBins(int[][] arr) {
        System.out.println("\nThe final elements are : ");
        System.out.println();
        for (int i = 0; i < arr.length; ++i) {
            for (int j = 0; j < arr[0].length; ++j)
                System.out.print(arr[i][j] + "\t");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int i, j;
        Scanner scan = new Scanner(System.in);
        
        System.out.print("\nEnter the total no. of elements : ");
        int size = scan.nextInt();

        System.out.print("\nEnter the no. of bins : ");
        int m = scan.nextInt();

        int r = size / m;

        int[][] a = new int[m][r];
        int[][] b = new int[m][r];
        
        System.out.print("\nEnter the elements into the array :\n");
        for (i = 0; i < m; ++i) {
            for (j = 0; j < r; ++j) {   
                a[i][j] = scan.nextInt();
            }
        }
        
        System.out.println("\n1. Binning by frequency\n2. Binning by mean\n3. Binning by median\n4. Binning by boundaries");
        
        System.out.print("\nEnter the key : ");
        
        int key = scan.nextInt();
        scan.close();

        switch (key) {

            case 1: {
                b = a;
                break;
            }

            case 2: {
                for (i = 0; i < m; ++i) {
                    int sum = 0;

                    // To find out sum
                    for (j = 0; j < r; ++j)
                        sum += a[i][j];

                    // To replace with mean
                    for (j = 0; j < r; ++j)
                        b[i][j] = sum / r;
                }
                break;
            }

            case 3: {
                int middle = r / 2;
                for (i = 0; i < m; ++i) {
                    // To replace with median
                    for (j = 0; j < r; ++j)
                        b[i][j] = a[i][middle];
                }
                break;
            }

            case 4: {                
                for (i = 0; i < m; ++i) {
                    for (j = 0; j < r; ++j) {
                        if (j == 0 || j == r - 1)
                            b[i][j] = a[i][j];
                        else {
                            if (a[i][j] - a[i][0] <= a[i][r - 1] - a[i][j])
                                b[i][j] = a[i][0];
                            else
                                b[i][j] = a[i][r - 1];
                        }
                    }
                }
                break;
            }
        }

        // Print all bins
        Main.printAllBins(b);
    }
}
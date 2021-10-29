import java.util.Scanner;

class Main {
    static final int glob = 10;

    public static void main(String[] args) {
        int i, j;
        Scanner scan = new Scanner(System.in);

        // No. of elements
        System.out.print("Enter the size of the array : ");
        int n = scan.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];

        // Get 'n' elements & compute 'mean'
        int mean = 0;
        System.out.print("Enter the elements into the array :\n");
        for (i = 0; i < n; ++i) {
            a[i] = scan.nextInt();
            mean += a[i];
        }
        mean /= n;

        // Compute 'mode'
        int max = -1, mode = 0;
        for (i = 0; i < n; ++i) {
            if (a[i] == 0)
                continue;
            int count = 0;
            for (j = i + 1; j < n; ++j) {
                if (a[i] == a[j])
                    count++;
            }
            if (count > max) {
                max = count;
                mode = a[i];
            }
        }

        System.out.println("1. Replace by mean\n2. Replace by glob\n3. Replace by most probable\n");
        
        System.out.print("Enter the key : ");
        int key = scan.nextInt();
        scan.close();
        
        switch (key) {
            case 1: {
                for (i = 0; i < n; ++i) {
                    if (a[i] == 0)
                        b[i] = mean;
                    else
                        b[i] = a[i];
                }
                break;
            }
            case 2: {
                for (i = 0; i < n; i++) {
                    if (a[i] == 0)
                        b[i] = Main.glob;
                    else
                        b[i] = a[i];
                }
                break;
            }
            case 3: {
                for (i = 0; i < n; ++i) {
                    if (a[i] == 0)
                        b[i] = mode;
                    else
                        b[i] = a[i];
                }
                break;
            }
        }
        for (i = 0; i < n; ++i) {
            System.out.println(b[i]);
        }
    }
}
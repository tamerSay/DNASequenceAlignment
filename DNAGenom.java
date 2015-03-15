package dnagenom;

/**
 *
 * @author tamerSay
 */
public class DNAGenom {

    public static void main(String[] args) {
        double gap = -2;
        double match = 5;
        double mMatch = -5;

//        char dnaSeq1[] = {'A', 'A', 'T', 'C', 'G', 'A'};
//        char dnaSeq2[] = {'A', 'T', 'G', 'C', 'G', 'A'};

        char dnaSeq1[] = {'T', 'G', 'C', 'T', 'C', 'G', 'T', 'A'};
        char dnaSeq2[] = {'T', 'T', 'C', 'A', 'T', 'A', 'A', 'G'};
        int n = dnaSeq1.length;
        System.out.println("Length of the DNA Sequence: " + n);

        double a[][] = new double[n + 1][n + 1];

        for (int i = 0; i < n + 1; i++) {
            a[i][0] = i * gap;
            a[0][i] = i * gap;
        }

        double deger1, deger2, deger3;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dnaSeq1[j] == dnaSeq2[i]) {
                    deger1 = a[i][j] + match;
                    deger2 = a[i][j + 1] + gap;
                    deger3 = a[i + 1][j] + gap;
                    a[i + 1][j + 1] = compare(deger1, deger2, deger3);
                } else {
                    deger1 = a[i][j] + mMatch;
                    deger2 = a[i][j + 1] + gap;
                    deger3 = a[i + 1][j] + gap;
                    a[i + 1][j + 1] = compare(deger1, deger2, deger3);
                }
            }
        }

        String seq1 = String.copyValueOf(dnaSeq1);
        String seq2 = String.copyValueOf(dnaSeq2);
        System.out.println("DNA Sequence 1: " + seq1 + "\nDNA Sequence 2: " + seq2);
        System.out.println();
        printOut(a);
        seqControl(a);
        System.out.println();

    }

    public static void printOut(double para[][]) {
        for (int i = 0; i < para.length; i++) {
            for (int j = 0; j < para.length; j++) {
                System.out.print("\t" + para[i][j]);
            }
            System.out.println();
        }
    }

    public static double compare(double a, double b, double c) {
        double max = a;
        if (max <= b) {
            if (c <= b) {
                max = b;
            }
        }
        if (max <= c) {
            if (b <= c) {
                max = c;
            }
        }
        return max;
    }

    public static void seqControl(double para[][]) {
        int i = para.length - 1, j = para.length - 1;

        while (i != 0) {

            if (para[i - 1][j - 1] >= para[i][j - 1] && para[i - 1][j - 1] >= para[i - 1][j]) {
                System.out.printf("a[%d][%d]\n", j, i);
                i--;
                j--;
            }
            if (para[i - 1][j - 1] <= para[i][j - 1] && para[i][j - 1] <= para[i - 1][j]) {
                System.out.printf("a[%d][%d]\n", j, i);
                j--;
            } else {
                System.out.printf("a[%d][%d]\n", j, i);
                i--;
            }

            if (i == 0 && j != 0) {
                while (j != 0) {
                    j--;
                    System.out.printf("a[%d][%d]\n", j, i);

                }
            }
        }
    }
}

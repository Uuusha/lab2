import java.io.PrintStream;
import java.util.Scanner;

public class Main {
    public static Scanner in = new Scanner(System.in);
    public static PrintStream out = System.out;
    public static void main(String[] args) {
        int n = in.nextInt();
        int m = in.nextInt();
        String [][] s = new String[n][m];

        s[0][0] = in.nextLine();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                s[i][j] = in.nextLine();
            }
        }

        double k = in.nextDouble();
        double o;
        char a = s[0][0].charAt(0);
        char b = s[0][0].charAt(3);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a = s[i][j].charAt(0);
                b = s[i][j].charAt(3);
                if (s[i][j].charAt(2) == '+') {
                    o = ((int)a - '0') * k + ((int)b-'0');
                    out.print(o + " ");
                }
                else {
                    if (s[i][j].charAt(2) == '-') {
                        o = ((int)a - '0') * k - ((int)b-'0');
                        out.print(o + " ");
                    }
                    else {
                        if (s[i][j].charAt(2) == '*') {
                            o = ((int)a - '0') * k * ((int)b-'0');
                            out.print(o + " ");
                        }
                        else {
                            o = (((int) a - '0') * k) / ((int) b - '0');
                            out.print(o + " ");
                        }
                    }
                }

            }
            out.println();
        }


        k = k *k;
        double maxO = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a = s[i][j].charAt(0);
                b = s[i][j].charAt(3);
                if (s[i][j].charAt(2) == '+') {
                    o = ((int)a - '0') * k + ((int)b-'0');
                    maxO = o;
                    out.print(a);
                    out.print("*");
                    out.print(k);
                    out.print(s[i][j].charAt(2));
                    out.print(b + " ");
                    out.print(o + " ");
                }
                else {
                    if (s[i][j].charAt(2) == '-') {
                        o = ((int)a - '0') * k - ((int)b-'0');
                        maxO = o;
                        out.print(a);
                        out.print("*");
                        out.print(k);
                        out.print(s[i][j].charAt(2));
                        out.print(b + " ");
                        out.print(o + " ");
                    }
                    else {
                        if (s[i][j].charAt(2) == '*') {
                            o = ((int)a - '0') * k * ((int)b-'0');
                            maxO = 0;
                            out.print(a);
                            out.print("*");
                            out.print(k);
                            out.print(s[i][j].charAt(2));
                            out.print(b + " ");
                            out.print(o + " ");
                        }
                        else {
                            o = (((int) a - '0') * k) / ((int) b - '0');
                            maxO = o;
                            out.print(a);
                            out.print("*");
                            out.print(k);
                            out.print(s[i][j].charAt(2));
                            out.print(b + " ");
                            out.print(o + " ");
                        }
                    }
                }

            }
            out.println();
        }

        String max = "";

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a = s[i][j].charAt(0);
                b = s[i][j].charAt(3);
                if (s[i][j].charAt(2) == '+') {
                    o = ((int)a - '0') * k + ((int)b-'0');
                    if (o >= maxO) {
                        max = s[i][j];
                        maxO = o;
                    }
                }
                else {
                    if (s[i][j].charAt(2) == '-') {
                        o = ((int)a - '0') * k - ((int)b-'0');
                        if (o >= maxO) {
                            max = s[i][j];
                            maxO = o;
                        }
                    }
                    else {
                        if (s[i][j].charAt(2) == '*') {
                            o = ((int)a - '0') * k * ((int)b-'0');
                            if (o >= maxO) {
                                max = s[i][j];
                                maxO = o;
                            }
                        }
                        else {
                            o = (((int) a - '0') * k) / ((int) b - '0');
                            if (o >= maxO) {
                                max = s[i][j];
                                maxO = o;
                            }
                        }
                    }
                }

            }

        }
        out.print(max);
    }
}

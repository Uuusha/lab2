import java.io.PrintStream;
import java.util.Scanner;

public class Main {
    public static Scanner in = new Scanner(System.in);
    public static PrintStream out = System.out;
    public static void main(String[] args) {
        //Считывает с консоли размеры массива 𝑁 и M
        int n = in.nextInt();
        int m = in.nextInt();
        String [][] s = new String[n][m];

        //затем элементы массива размером 𝑁 × M
        s[0][0] = in.nextLine();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                s[i][j] = in.nextLine();
            }
        }

        // Затем считывает число 𝐾.
        double k = in.nextDouble();

        // Для заданного значения 𝑥 = 𝐾 вычисляет и выводит
        //результат каждого выражения в массиве.
        double o;
        char a = s[0][0].charAt(0);
        char b = s[0][0].charAt(3);
        double [] os = new double[n]; //Сумма выражений в каждой строке

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
                            if (b == '0'){
                                out.print("нельзя делить на ноль ");
                                o = 0;
                            }
                            else {
                                o = (((int) a - '0') * k) / ((int) b - '0');
                                out.print(o + " ");
                            }
                        }
                    }
                }
                os[i] = os[i] + o;

            }
            out.println();
        }


        //Сортирует строки массива по возрастанию результата
        //выражения при данном 𝑥.
        double x;
        String [] y;

        for (int j = 0; j < n - 1; j++){
            for (int i = 0; i < n - 1; i++) {
                if(os[i] > os[i + 1]) {
                    x = os[i];
                    os[i] = os[i+1];
                    os[i+1] = x;

                    y = s[i];
                    s[i] = s[i+1];
                    s[i+1] = y;

                }
            }

        }


        //Выводит элементы массива, заменяя переменную 𝑥 на
        //её квадрат и выводит новые результаты выражений при
        //данном 𝑥. 
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
                            if (b == '0'){
                                o = 0;
                                maxO = o;
                                out.print(a);
                                out.print("*");
                                out.print(k);
                                out.print(s[i][j].charAt(2));
                                out.print(b + " ");
                                out.print("нельзя делить на ноль ");
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

            }
            out.println();
        }

        //Находит и выводит выражение с максимальным
        //результатом при данном x
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
                            if (b == '0'){
                                o = 0;
                            }
                            else {
                                o = (((int) a - '0') * k) / ((int) b - '0');
                            }
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

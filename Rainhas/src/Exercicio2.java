import java.util.*;
 
class Exercicio2
{
    public static int N = 7;

    private static void mostraTabuleiro(char tabuleiro[][])
    {
        for (int i = 0; i < N; i++) {
            String s = Arrays.toString(tabuleiro[i]).replaceAll(",", "");
            s = s.replace("[", "");
            s = s.replace("]", "");
            System.out.println(s);
        }
        System.out.print("\n");
    }
 
    private static void resolver(char tabuleiro[][], int row)
    {
        if (row == N)
        {
            mostraTabuleiro(tabuleiro);
            return;
        }

        for (int i = 0; i < N; i++)
        {

            if (semAtaque(tabuleiro, row, i))
            {

                tabuleiro[row][i] = 'Q';
 
                resolver(tabuleiro, row + 1);

                tabuleiro[row][i] = '–';
            }
        }
    }

    private static boolean semAtaque(char tabuleiro[][], int row, int column)
    {
        for (int i = 0; i < row; i++)
        {
            if (tabuleiro[i][column] == 'Q') {
                return false;
            }
        }
 
        for (int i = row, j = column; i >= 0 && j >= 0; i--, j--)
        {
            if (tabuleiro[i][j] == 'Q') {
                return false;
            }
        }
 
        for (int i = row, j = column; i >= 0 && j < N; i--, j++)
        {
            if (tabuleiro[i][j] == 'Q') {
                return false;
            }
        }
 
        return true;
    }
    
    static void entrada(int n) {
        N = n;
        char[][] tabuleiro = new char[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(tabuleiro[i], '–');
        }
 
        resolver(tabuleiro, 0);
    }

    public static void main(String[] args)
    {
        //Insira aqui a quantidade de rainhas
        entrada(4);
    }
}
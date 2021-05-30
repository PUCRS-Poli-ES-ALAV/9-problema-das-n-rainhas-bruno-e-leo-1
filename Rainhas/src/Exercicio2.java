import java.util.*;
 
class Exercicio2
{
    static int instrucoesRainha = 0;
    static int iteracoesRainha = 0;


    public static int N = 7;

    private static void mostraTabuleiro(char tabuleiro[][]){
        instrucoesRainha+=2;
        for (int i = 0; i < N; i++) {
            iteracoesRainha++;
            instrucoesRainha+=8;
            String s = Arrays.toString(tabuleiro[i]).replaceAll(",", "");
            s = s.replace("[", "");
            s = s.replace("]", "");
            System.out.println(s);
        }
        System.out.print("\n");
    }
 
    private static void resolver(char tabuleiro[][], int row){
        instrucoesRainha+=3;
        if (row == N){
            mostraTabuleiro(tabuleiro);
            return;
        }

        for (int i = 0; i < N; i++){
            iteracoesRainha++;
            instrucoesRainha+=4;
            if (semAtaque(tabuleiro, row, i)) {
                instrucoesRainha+=7;
                tabuleiro[row][i] = 'Q';
                resolver(tabuleiro, row + 1);
                tabuleiro[row][i] = '–';
            }
        }
    }

    private static boolean semAtaque(char tabuleiro[][], int row, int column){
        instrucoesRainha+=3;
        for (int i = 0; i < row; i++){
            iteracoesRainha++;
            instrucoesRainha+=4;
            if (tabuleiro[i][column] == 'Q') {
                instrucoesRainha+=4;
                return false;
            }
        }
 
        for (int i = row, j = column; i >= 0 && j >= 0; i--, j--){
            iteracoesRainha++;
            instrucoesRainha+=11;
            if (tabuleiro[i][j] == 'Q') {
                instrucoesRainha+=4;
                return false;
            }
        }
 
        for (int i = row, j = column; i >= 0 && j < N; i--, j++){
            iteracoesRainha++;
            instrucoesRainha+=10;
            if (tabuleiro[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    static void entrada(int n) {
        N = n;
        char[][] tabuleiro = new char[N][N];
        instrucoesRainha+=6;
        for (int i = 0; i < N; i++) {
            iteracoesRainha++;
            instrucoesRainha+=5;
            Arrays.fill(tabuleiro[i], '–');
        }
        resolver(tabuleiro, 0);
    }

    public static void main(String[] args){
        System.out.println("\n>>>>>> Rainha <<<<<< ");
        //Insira aqui a quantidade de rainhas
        entrada(4);
        System.out.println("\n------ Contabilização ------ ");
        System.out.println("-- Escalamento >> Instruções: " + instrucoesRainha);
        System.out.println("-- Escalamento >> Iterações: " + iteracoesRainha);
    }
}
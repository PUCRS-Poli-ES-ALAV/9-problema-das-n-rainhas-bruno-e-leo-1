public class Exercicio1 {

    static int instrucoesRainha = 1;
    static int iteracoesRainha = 0;

    static int N = 7;

    static void mostraTabuleiro (int tabuleiro[][]) {
        instrucoesRainha+=2;
        for (int i = 0; i < N; i++) {
            iteracoesRainha++;
            instrucoesRainha+=4;
            for (int j = 0; j < N; j++){
                iteracoesRainha++;
                instrucoesRainha+=4;
                if(tabuleiro[i][j] == 0) {
                    System.out.print(" - ");
                    instrucoesRainha+=3;
                } else {
                    System.out.print(" Q ");
                }
            }  
        }
    }
    
    static boolean semAtaque(int tabuleiro[][], int linha, int coluna){
        int i, j;
        instrucoesRainha+=2;
        for (i = 0; i < coluna; i++){
            iteracoesRainha++;
            instrucoesRainha+=4;
            if (tabuleiro[linha][i] == 1){
                instrucoesRainha+=3;
                return false;
            }
        }
        for (i = linha, j = coluna; i >= 0 && j >= 0; i--, j--){
            iteracoesRainha++;
            instrucoesRainha+=11;
            if (tabuleiro[i][j] == 1){
                instrucoesRainha+=3;
                return false;  
            }
        }
        for (i = linha, j = coluna; j >= 0 && i < N; i++, j--){
            iteracoesRainha++;
            instrucoesRainha+=10;
            if (tabuleiro[i][j] == 1){
                instrucoesRainha+=3;
                return false;
            }
        }
        return true;
    }
    
    static boolean resolver(int tabuleiro[][], int coluna) {
        instrucoesRainha+=2;
        if (coluna >= N) {
            instrucoesRainha+=2;
            return true;
        }
        for (int i = 0; i < N; i++) {
            iteracoesRainha++;
            instrucoesRainha+=4;
            if (semAtaque(tabuleiro, i, coluna)) {
                instrucoesRainha+=6;
                tabuleiro[i][coluna] = 1;
                if (resolver(tabuleiro, coluna + 1) == true){
                    instrucoesRainha+=2;
                    return true;
                }
                tabuleiro[i][coluna] = 0;
            }
        }
        return false;
    }

    static boolean executar() {
        instrucoesRainha+=6;
        int[][] tabuleiro = new int[N][N];
        for (int i = 0; i < N; i++) {
            iteracoesRainha++;
            instrucoesRainha+=4;
            for (int j = 0; j < N; j++) {
                instrucoesRainha+=7;
                tabuleiro[i][j] = 0;
            }
        }
        if (resolver(tabuleiro, 0) == false) {
            instrucoesRainha+=1;
            System.out.print("Solution does not exist");
            return false;
        }
        mostraTabuleiro(tabuleiro);
        return true;
    }

    static void entrada(int n) {
        if(n <= 3) {
            instrucoesRainha+=3;
            System.out.println("Não é possivel criar um tabuleiro para o numero digitado numero!");
        } else {
            instrucoesRainha+=2;
            N = n;
            executar();
        }
    }
    
    public static void main(String args[])
    {
        System.out.println("\n>>>>>> Rainha <<<<<< ");
        //Insira aqui a quantidade de rainhas
        entrada(7);
        System.out.println("\n------ Contabilização ------ ");
        System.out.println("-- Escalamento >> Instruções: " + instrucoesRainha);
        System.out.println("-- Escalamento >> Iterações: " + iteracoesRainha);
    }
}
    


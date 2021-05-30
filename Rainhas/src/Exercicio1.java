

//Primeira Solução 
public class Exercicio1 {
    static int N = 7;

    
    static void mostraTabuleiro (int tabuleiro[][])
    {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                if(tabuleiro[i][j] == 0) {
                    System.out.print(" - ");
                } else {
                    System.out.print(" Q ");
                }
            System.out.println();
        }
    }
    
    static boolean semAtaque(int tabuleiro[][], int linha, int coluna)
    {
        int i, j;
    
        for (i = 0; i < coluna; i++)
            if (tabuleiro[linha][i] == 1)
                return false;
    
        for (i = linha, j = coluna; i >= 0 && j >= 0; i--, j--)
            if (tabuleiro[i][j] == 1)
                return false;

        for (i = linha, j = coluna; j >= 0 && i < N; i++, j--)
            if (tabuleiro[i][j] == 1)
                return false;
    
        return true;
    }
    
    static boolean resolver(int tabuleiro[][], int coluna)
    {

        if (coluna >= N) {
            return true;
        }
    
        for (int i = 0; i < N; i++) {

            if (semAtaque(tabuleiro, i, coluna)) {

                tabuleiro[i][coluna] = 1;
    
                if (resolver(tabuleiro, coluna + 1) == true){
                    return true;
                }
                
                tabuleiro[i][coluna] = 0;
            }
        }
    
        return false;
    }

    static boolean executar()
    {
        int[][] tabuleiro = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tabuleiro[i][j] = 0;
            }
        }
        
        if (resolver(tabuleiro, 0) == false) {
            System.out.print("Solution does not exist");
            return false;
        }
    
        mostraTabuleiro(tabuleiro);

        return true;
    }

    static void entrada(int n) {
        if(n <= 3) {
            System.out.println("Não é possivel criar um tabuleiro para o numero digitado numero!");
        } else {
            N = n;
            executar();
        }
    }
    
    public static void main(String args[])
    {
        //Insira aqui a quantidade de rainhas
        entrada(7);
    }
    
}

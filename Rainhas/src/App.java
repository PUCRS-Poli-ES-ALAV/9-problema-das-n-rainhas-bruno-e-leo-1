public class App {
    final int N = 7;
    static int flag = 0;
    
    void mostraTabuleiro (int tabuleiro[][])
    {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + tabuleiro[i][j] + " ");
            System.out.println();
        }
    }
    
    boolean ehSeguro(int tabuleiro[][], int linha, int coluna)
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
    
    boolean resolver(int tabuleiro[][], int coluna)
    {

        if (coluna >= flag) {
            return true;
        }
    
        for (int i = 0; i < N; i++) {

            if (ehSeguro(tabuleiro, i, coluna)) {

                tabuleiro[i][coluna] = 1;
    
                if (resolver(tabuleiro, coluna + 1) == true){
                    return true;
                }
                
                tabuleiro[i][coluna] = 0;
            }
        }
    
        return false;
    }
    
    boolean executar()
    {
        int tabuleiro[][] = {   { 0, 0, 0, 0, 0, 0, 0 },
                            { 0, 0, 0, 0, 0, 0, 0 },
                            { 0, 0, 0, 0, 0, 0, 0 },
                            { 0, 0, 0, 0, 0, 0, 0 },
                            { 0, 0, 0, 0, 0, 0, 0 },
                            { 0, 0, 0, 0, 0, 0, 0 },
                            { 0, 0, 0, 0, 0, 0, 0 }};
    
        if (resolver(tabuleiro, 0) == false) {
            System.out.print("Solution does not exist");
            return false;
        }
    
        mostraTabuleiro(tabuleiro);
        return true;
    }

    static void entrada(int n) {
        App Queen = new App();
        if(n >= 2) {
            flag = n;
            Queen.executar();
        } else {
            System.out.println("Numero de rainhas inválido!");
        }
    }
    
    // driver program to test above function
    public static void main(String args[])
    {
        //Insira aqui a quantidade de rainhas
        entrada(7);
    }
    
}

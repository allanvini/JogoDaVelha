/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo_da_velha;

/**
 *
 * @author allan
 */
public class Jogo_da_velha {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Methods function = new Methods();
        
        int tabuleiro [][] = new int [3][3];
        int player = 1, vitoria = -1;
        boolean endGame = false;
        
        function.iniciaTabuleiro(tabuleiro);
        
        System.out.println("O jogo começará com o jogador 1 [X]");
        System.out.println("Automaticamente o jogador 2 será [O]");
        
        if (endGame == false){
            while (endGame == false){
                function.imprimeTabuleiro(tabuleiro);
                if (player == 1){
                    function.capturaJogada(player, tabuleiro);
                    player = 2;
                }
                else if (player == 2){
                    function.capturaJogada(player, tabuleiro);
                    player = 1;
                }
                function.clear();
                endGame = function.verificaFinal(tabuleiro, player, endGame, vitoria);
            }
        }

        function.imprimeTabuleiro(tabuleiro);
        function.apresentaFinal(player);
        
        
    }
    
}

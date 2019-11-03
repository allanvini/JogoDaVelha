/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo_da_velha;
import java.util.Scanner;

/**
 *
 * @author allan
 */
public class Methods {
    
    Scanner in = new Scanner (System.in);
    
    public static void clear(){
        for (int linhas = 0; linhas <99; linhas++){
            System.out.println("");
        }
    }
    
    public static void iniciaTabuleiro (int tabuleiro[][]){
        for (int linhas = 0; linhas < tabuleiro.length; linhas ++){
            for (int colunas = 0; colunas < tabuleiro.length; colunas++){
                tabuleiro[linhas][colunas] = 0;
            }
        }
    }
    
    public static void imprimeTabuleiro (int tabuleiro[][]){
        System.out.println("      1     2     3 ");
        System.out.println("      |     |     | ");
        for (int linhas = 0; linhas < tabuleiro.length; linhas ++){
            System.out.print((linhas+1)+" = ");
            for (int colunas = 0; colunas < tabuleiro.length; colunas++){
                if(tabuleiro[linhas][colunas] == 1){
                    System.out.print("  X   ");
                }
                else if(tabuleiro[linhas][colunas] == 2){
                    System.out.print("  O   ");
                }
                else{
                    System.out.print("  -   ");
                }
                
            }
            System.out.println("");
        }
    }
    
    public void capturaJogada (int jogador, int tabuleiro[][]){
        
            System.out.println("---------Vez do jogador "+jogador+"---------");
            System.out.print("Informe a linha que deseja colocar: ");
            int linha = in.nextInt();
            if (linha > 3 || linha < 1){
                while (linha > 3 || linha < 1){
                    System.out.print("Informe uma linha válida: ");
                    linha = in.nextInt();
                }
            }
            System.out.print("Informe a coluna que deseja colocar: ");
            int coluna = in.nextInt();
            if (coluna > 3 || coluna < 1){
                while (coluna > 3 || coluna < 1){
                    System.out.println("Informe uma coluna válida: ");
                    coluna = in.nextInt();
                }
            }
            
            if (tabuleiro[linha-1][coluna-1] == 0){
                tabuleiro[linha-1][coluna-1] = jogador;
            }
            else{
                System.out.println("Esta jogada ja foi feita!! por favor");
                System.out.println("Faça uma jogada válida!!");
                System.out.println("");
                capturaJogada(jogador, tabuleiro);
            }
        
    }
    
    public static boolean verificaFinal (int tabuleiro[][], int jogador, boolean endGame, int vitoria){
        
        int contadorvaga = 0;
        
        for(int linha = 0; linha<3; linha++){
            for (int coluna = 0; coluna<3; coluna++){
                if (tabuleiro [linha][coluna] == 0){
                    contadorvaga ++;
                }
            }
        }
            
        if(contadorvaga == 0){
            jogador = 0;
            return true;
        }
        
        if ((tabuleiro[0][0] == 1 && tabuleiro [0][1] == 1 && tabuleiro [0][2] == 1) ||
            (tabuleiro[1][0] == 1 && tabuleiro [1][1] == 1 && tabuleiro [1][2] == 1) ||
            (tabuleiro[2][0] == 1 && tabuleiro [2][1] == 1 && tabuleiro [2][2] == 1) ||
            (tabuleiro[0][0] == 1 && tabuleiro [1][1] == 1 && tabuleiro [2][2] == 1) ||
            (tabuleiro[0][2] == 1 && tabuleiro [1][1] == 1 && tabuleiro [2][0] == 1) ||
            (tabuleiro[0][0] == 1 && tabuleiro [1][0] == 1 && tabuleiro [2][0] == 1) ||
            (tabuleiro[0][1] == 1 && tabuleiro [1][1] == 1 && tabuleiro [2][1] == 1) ||
            (tabuleiro[0][2] == 1 && tabuleiro [1][2] == 1 && tabuleiro [2][2] == 1)){

            //jogador = 1;
            return true;
        }
        
   else if ((tabuleiro[0][0] == 2 && tabuleiro [0][1] == 2 && tabuleiro [0][2] == 2) ||
            (tabuleiro[1][0] == 2 && tabuleiro [1][1] == 2 && tabuleiro [1][2] == 2) ||
            (tabuleiro[2][0] == 2 && tabuleiro [2][1] == 2 && tabuleiro [2][2] == 2) ||
            (tabuleiro[0][0] == 2 && tabuleiro [1][1] == 2 && tabuleiro [2][2] == 2) ||
            (tabuleiro[0][2] == 2 && tabuleiro [1][1] == 2 && tabuleiro [2][0] == 2) ||
            (tabuleiro[0][0] == 2 && tabuleiro [1][0] == 2 && tabuleiro [2][0] == 2) ||
            (tabuleiro[0][1] == 2 && tabuleiro [1][1] == 2 && tabuleiro [2][1] == 2) ||
            (tabuleiro[0][2] == 2 && tabuleiro [1][2] == 2 && tabuleiro [2][2] == 2)){

            //jogador = 2;
            return true;
        }
        
        else {

        }
        return false;
    }
    
    public void apresentaFinal (int jogador){
        if (jogador != 1 && jogador != 2){
            System.out.println("Deu empate!!");
        }
        
        if (jogador == 2){
            System.out.println("Parabéns jogador 1!! você venceu!!");
        }
        if (jogador == 1){
            System.out.println("Parabéns jogador 2!! você venceu!!");
        }
    }
}
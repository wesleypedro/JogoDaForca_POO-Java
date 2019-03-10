/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.*;
import Model.MValidadores;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Equipe Forca
 */

public class CController{
    private String NameController = null;
    
    VGame vG = new VGame();
    VMain vM = new VMain();
    MValidadores mV = new MValidadores();
    
    
    public CController(String Name){
        super();
        this.NameController = Name;
    }
    
    
    public void Enter(String Name){
        mV.setPlayerName(Name);
        mV.setPoints(0);
        mV.setLife(3);
        mV.setLevel("Fácil");
        
        vM.setDefaultCloseOperation(VMain.DISPOSE_ON_CLOSE );
        vM.setVisible(false);
        vM.dispose();
        
        Initializes();
        vG.setIconImage(new ImageIcon(getClass().getResource("/Image/icon.png")).getImage());
        vG.setVisible(true);
        vG.setLocationRelativeTo(null);
        mV.setDefineVictory(0);
    }
    
    public void Initializes(){
        String FileName = null;
        
        switch (mV.getLevel()) {
            case "Fácil":
                FileName = System.getProperty("user.dir") + "/src/Files/NivelFacil.txt";
                break;
            case "Médio":
                FileName = System.getProperty("user.dir") + "/src/Files/NivelMedio.txt";
                break;
            case "Difícil":
                FileName = System.getProperty("user.dir") + "/src/Files/NivelDificil.txt";
                break;
            case "HardCore":
                FileName = System.getProperty("user.dir") + "/src/Files/NivelFDP.txt";
                break;
            case "Fim":
                vG.FinalizeGame(mV.getPoints(), mV.getPlayerName(), mV.getLife(),
                        "Vencedor!!!", "Parabéns, você ganhou " + String.valueOf(mV.getPoints()) + " pontos", "/Image/Victory.png");
                FileName = System.getProperty("user.dir") + "/src/Files/NivelFacil.txt";
                mV.setPoints(0);
                mV.setLife(3);
                mV.setLevel("Fácil");
                
                break;
            default:
                break;
        }
        
        String thisLine;
        
        mV.setQtd(50);
        
        Random Rand = new Random();
        
        int  Sort = Rand.nextInt(mV.getQtd());
        
        if(mV.getSorteados(Sort)){
            while(mV.getSorteados(Sort)){
                Sort = Rand.nextInt(mV.getQtd());
            }
        }
        mV.setSorteados(Sort);
        
        
        File arquivo = new File(FileName);
        try{
            FileReader fr = new FileReader(arquivo);
            BufferedReader br = new BufferedReader(fr);   
            Random gerador;
            int var = 0;
            boolean stop = true;
            while(br.ready() && stop){
                thisLine = br.readLine();
                if(var == Sort){
                    stop = false;
                }
                var ++;
            }  
            thisLine = (br.readLine()).trim();
            String []vetor = thisLine.split(";");
            mV.setCheckWord(vetor[0]);
            mV.setFinalWord(vetor[1]);
            mV.setDescription("<html><meta charset = 'uft-8'>" + vetor[3] + "</html>");
            mV.setOutput(DefineOutput(vetor[0].toLowerCase()));
            mV.setClearListTyped();
            mV.setDefineCount(0);
            //System.out.println("Palavra exibida: "+vetor[0]+ "\nPalavra formatada: "+vetor[1]+ "\nNumero de letras: "+vetor[2]+"\nDescrição: "+vetor[3]);            
        }catch(IOException ex){
                System.out.println("Problema ao acessar "+arquivo.getAbsolutePath());  
        }
        
        int QtdLetras = 0;
        
        for (int i = 0; i < mV.getCheckWord().length(); i ++) {
            if(String.valueOf(mV.getOutput().charAt(i)).equals(String.valueOf('_'))){
                QtdLetras += 1;
            }
        }
        
        mV.setSizeWord(QtdLetras);
        
        
        vG.DefineInitial(mV.getPlayerName(), mV.getSizeWord(), mV.getDescription(), mV.getOutput(), 
                        String.valueOf(mV.getListTyped()), mV.getLevel(), mV.getPoints(), mV.getLife());
        
    }
    
    
    public String DefineOutput(String Wordp){
        String Chars[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
                        "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        String Word = Wordp.toLowerCase();
        //System.out.println(Word);
        char [] Output = Word.toCharArray();
        String C = "__";
        for (int i = 0; i < Word.length(); i ++) {
            for(int j = 0; j < 52; j ++){
                if(String.valueOf(Word.charAt(i)).equals(Chars[j].toLowerCase())){
                    Output[i] = C.charAt(0);
            }            }
        }
        return (String.valueOf(Output));
    }
    
    
    public String Valida(String le){
        String l = null, Chars[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
                        "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        
        if(le.length() > 0){
            for(int i = 0; i < 52; i ++){
                if(le.substring(le.length() - 1).equals(Chars[i])){
                    mV.setAcess(true);
                    mV.setTyped(Chars[i].toLowerCase());
                    return Chars[i].toLowerCase();
                }
            }
        }
        mV.setTyped("");
        mV.setAcess(false);
        return "";
    }
    
    public void addCharacter(){
        if(mV.isAcess()){
            String Typed = mV.getTyped();
            String CheckWord = mV.getCheckWord();
            char [] Output = mV.getOutput().toCharArray();
            boolean Entrou = false;

            
            if(!mV.getListTyped(mV.getTyped())){
                mV.setListTyped(Typed);
                for (int i = 0; i < CheckWord.length(); i ++) {
                    if(Typed.equals(String.valueOf(CheckWord.charAt(i)).toLowerCase())){
                        Output[i] = Typed.charAt(0);
                        Entrou = true;
                    }
                }
                mV.setOutput(String.valueOf(Output));

                if(mV.getOutput().equals(CheckWord.toLowerCase())){
                    mV.setChangePoints(60 - 10 * mV.getCount());
                    AddVictory();
                    vG.Victory(mV.getFinalWord(), mV.getPoints(), mV.getLevel());
                }

                else if(!Entrou){
                    mV.setCount(1);
                    vG.DefineGame(mV.getOutput(), String.valueOf(mV.getListTyped()), mV.getImage(mV.getCount()), mV.getLife());
                    if(mV.getCount() > 5){
                        mV.setChangeLife(1);
                        if(mV.getLife() == -1){
                            mV.setLevel("Fácil");
                            vG.FinalizeGame(mV.getPoints(), mV.getPlayerName(), mV.getLife(), 
                                    "Perdedor!!!", "Que pena, você ganhou apenas " + String.valueOf(mV.getPoints()) + " pontos", "/Image/GameOver.png");
                            mV.setPoints(0);
                            mV.setLife(3);
                            mV.setLevel("Fácil");
                        }
                        else{
                            vG.GameOver(mV.getLife());
                        }
                    }
                }
                else{
                    vG.DefineGame(mV.getOutput(), String.valueOf(mV.getListTyped()), mV.getImage(mV.getCount()), mV.getLife());
                }
            }
            else{
                vG.DefineGame(mV.getOutput(), String.valueOf(mV.getListTyped()), mV.getImage(mV.getCount()), mV.getLife());
            }
        }
    }
    
    public void AddVictory(){
        mV.setVictory(1);
        //System.out.println("Entrou");
        if(mV.getVictory() == 6){
            mV.setDefineVictory(0);
            String Level = mV.getLevel();
            switch (Level) {
                case "Fácil":
                    mV.setLevel("Médio");
                    break;
                case "Médio":
                    mV.setLevel("Difícil");
                    break;
                case "Difícil":
                    mV.setLevel("HardCore");
                    break;
                case "HardCore":
                    mV.setLevel("Fim");
                    break;
                default:
                    break;
            }
            JOptionPane.showMessageDialog(null, "Parabéns, você consegui \nalcançar o nível " + mV.getLevel());
        }
    }
    
    public void Exit(){
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?", "Sair?", JOptionPane.YES_NO_OPTION);

        if (resposta == JOptionPane.YES_OPTION) {
           System.exit(0);
        } else if (resposta == JOptionPane.NO_OPTION) {
           //Usuário clicou em não. Executar o código correspondente.
        }
    }
}

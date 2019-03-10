/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Equipe Forca
 */
public class MValidadores {

    private ArrayList<Integer> Sorteados = new ArrayList();
    private int Qtd;
    
    public void setDefineSorteados(){
        this.Sorteados.clear();
    }
    
    public void setSorteados(int Sorteados){
        this.Sorteados.add(Sorteados);
    }
    
    public void setQtd(int Qtd){
        this.Qtd = Qtd;
    }
    
    public boolean getSorteados(int Number){
        return this.Sorteados.contains(Number);
    }
    
    public int getQtd(){
        return this.Qtd;
    }
    
    
    
    
    
    private String PlayerName = "";
    private boolean Acess = false;
    private String CheckWord = "";
    private String FinalWord = "";
    private int SizeWord = 11;
    private String Description = "";
    private int Count = 0;
    private int Victory;
    private String Level;
    private int Points;
    private final String [] Image = {"/Image/vazia.png", "/Image/cabeca.png", "/Image/corpo.png", "/Image/braco1.png",
                                    "/Image/braco2.png", "/Image/perna1.png", "/Image/perna2.png", "/Image/GameOver.png"};
    private int Life;
    private String OutputWord = "";
    private String Typed;
    private ArrayList<String> ListTyped = new ArrayList();
    
    
    
    public void setPlayerName(String PlayerName){
        this.PlayerName = PlayerName;
    }
    
    public void setAcess(boolean Acess){
        this.Acess = Acess;
    }
    
    public void setCheckWord(String CheckWord) {
        this.CheckWord = CheckWord;
    }
    
    public void setFinalWord(String FinalWord) {
        this.FinalWord = FinalWord;
    }
    
    public void setSizeWord(int SizeWord) {
        this.SizeWord = SizeWord;
    }
    
    public void setDescription(String Description) {
        this.Description = Description;
    }
    
    public void setCount(int Count){
        this.Count += Count;
    }
    
    public void setDefineCount(int Count){
        this.Count = Count;
    }
    
    public void setDefineVictory(int Victory){
        this.Victory = Victory;
    }
    
    public void setVictory(int Victory){
        this.Victory += Victory;
        //System.out.println(this.Victory);
    }
    
    public void setLevel(String Level){
        this.Level = Level;
    }
    
    public void setPoints(int Points){
        this.Points = Points;
    }
    
    public void setChangePoints(int Points){
        this.Points += Points;
    }
    
    public void setLife(int Life){
        this.Life = Life;
    }
    
    public void setChangeLife(int Life){
        this.Life -= Life;
    }
    
    public void setOutput(String OutputWord){
        this.OutputWord = OutputWord;
    }
    
    public void setTyped(String Typed){
        this.Typed = Typed;
    }
    
    public void setListTyped(String ListTyped){
        this.ListTyped.add(ListTyped);
    }
    
    public void setClearListTyped(){
        this.ListTyped.clear();
    }
    
    
    
    // Pega os valores dos atributos
    
    public String getPlayerName(){
        return this.PlayerName;
    }
    
    public boolean isAcess(){
        return Acess;
    }
    
    public String getCheckWord() {
        return CheckWord;
    }

    public String getFinalWord() {
        return FinalWord;
    }
    
    public int getSizeWord() {
        return SizeWord;
    }
    
    public String getDescription() {
        return Description;
    }
    
    public int getCount(){
        return this.Count;
    }
    
    public int getVictory(){
        return this.Victory;
    }
    
    public String getLevel(){
        return this.Level;
    }
    
    public int getPoints(){
        return this.Points;
    }
    
    public String getImage(int Position){
        return this.Image[Position];
    }
    
    public int getLife(){
        return this.Life;
    }
    
    public String getOutput(){
        return this.OutputWord;
    }
    
    public String getTyped(){
        return this.Typed;
    }
    
    public boolean getListTyped(String ListTyped){
        return this.ListTyped.contains(ListTyped);
    }
    
    public ArrayList<String> getListTyped(){
        return this.ListTyped;
    }
}

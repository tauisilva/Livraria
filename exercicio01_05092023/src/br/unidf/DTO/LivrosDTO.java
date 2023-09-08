/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unidf.DTO;

/**
 *
 * @author carla braga && taui silva && joao victor
 */
public class LivrosDTO {
    
    private int livID; 
    private String livTitulo;
    private int livISBN;
    
    public int getLivID(){
        return livID;
    }
              
    public void setLivID(int livID){
        this.livID = livID;
    }
    
    public String getLivTitulo(){
        return livTitulo;
    }
    
    public void setLivTitulo(String livTitulo){
        this.livTitulo = livTitulo;
    }
    
    public int getLivISBN(){
        return livISBN;
    }
    
    public void setLivISBN(int livISBN){
        this.livISBN = livISBN;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package graphconnectivity;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author CrackMayo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    private int[] parent, size;
    private int components;
    public Main(int n){
        components=n;
        parent=new int[n];
        size=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }
    }
    private  int root(int p){
        while(p!=parent[p]){
            parent[p]=parent[parent[p]];
            p=parent[p];
        }
        return p;
    }
    //Une los nodos p, q
    public void union(int p, int q){
        int rootP=root(p);
        int rootQ=root(q);
        if (rootP !=rootQ){
            if (size[rootP]<size[rootQ]){
                parent[rootP]=rootQ;
                size[rootQ]=size[rootQ]+size[rootP];
            }else{
                parent[rootQ]=rootP;
                size[rootP]=size[rootP]+ size[rootQ];
            }
           components--;
        }
    }
    //Retorna true si p, q estÃ¡n conectados
    public boolean connected(int p, int q){
        return root(p)==root(q);
    }
    //Retorna el numero de componentes conexas
    public int getComponents(){
        return components;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Map<String, Integer> diccionario;
        diccionario = new HashMap<String, Integer>();
        
        diccionario.put("A",0);
        diccionario.put("B",1);
        diccionario.put("C",2);    
        diccionario.put("D",3);
        diccionario.put("E",4);    
        diccionario.put("F",5);    
        diccionario.put("G",6);    
        diccionario.put("H",7);    
        diccionario.put("I",8);    
        diccionario.put("J",9);    
        diccionario.put("K",10);    
        diccionario.put("L",11);    
        diccionario.put("M",12);    
        diccionario.put("N",13);    
        diccionario.put("O",14);    
        diccionario.put("P",15);    
        diccionario.put("Q",16);    
        diccionario.put("R",17);    
        diccionario.put("S",18);    
        diccionario.put("T",19);    
        diccionario.put("U",20);    
        diccionario.put("V",21);    
        diccionario.put("W",22);    
        diccionario.put("X",23);    
        diccionario.put("Y",24);    
        diccionario.put("Z",25);    

        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        sc.nextLine();
        sc.nextLine();
        for (int i = 0; i < cases; i++) {
            
            String maxLetter = sc.nextLine();
            int components = diccionario.get(maxLetter)+1;
            Main uf = new Main(components);
          
            while(sc.hasNextLine()){
                String[] cadena = sc.nextLine().split("");
                if(!cadena[0].equals("")){
                    for (int j = 0; j < cadena.length-1; j++) {
                        if(!uf.connected(diccionario.get(cadena[j]),diccionario.get(cadena[j+1]))){
                                uf.union(diccionario.get(cadena[j]), diccionario.get(cadena[j+1]));
                        }
                    }
                }else{
                    break;
                }
                
            }
             int comp=uf.getComponents();
             
             System.out.println(comp);
             if(i < cases-1){
                 System.out.println("");
             }
           
        }
    }
    
}

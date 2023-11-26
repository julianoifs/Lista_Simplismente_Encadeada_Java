package com.dominio;

public class Main {
    public static void main(String[] args) {

        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        lista.addInicio(3);
        lista.addInicio(2);
        lista.addInicio(1);
        lista.addFinal(4);
        lista.addFinal(5);
        lista.addFinal(6);

        System.out.println("Tamanho: " + lista.getTamanho());
        System.out.println(lista.exibir());

        lista.removerInicio();
        lista.removerInicio();
       
        System.out.println("Tamanho: " + lista.getTamanho());
        System.out.println(lista.exibir());

        lista.removerFinal();
        lista.removerFinal();

        System.out.println("Tamanho: " + lista.getTamanho());
        System.out.println(lista.exibir());

        System.out.println(lista.getElemento(0));
        
        /*System.out.println("\nLimpando toda a lista");
        lista.limpaLista();
        System.out.println("\nTamanho: " + lista.getTamanho());
        System.out.println(lista.exibir());*/

    }
}

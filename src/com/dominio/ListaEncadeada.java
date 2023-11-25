package com.dominio;

public class ListaEncadeada<T> {

    private No<T> inicio;
    private No<T> ultimo;
    private int tamanho;

    public ListaEncadeada() {
        this.inicio = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    public void addInicio(T elemento) {
        No<T> no = new No<T>(elemento);

        if (this.tamanho == 0) {
            // this.inicio = no;
            this.ultimo = no;
        } else {
            no.setProximo(this.inicio);
        }
        this.inicio = no;
        this.tamanho++;
    }

    public void addFinal(T elemento) {
        No<T> no = new No<T>(elemento);

        if (this.tamanho == 0) {
            this.inicio = no;
        } else {
            this.ultimo.setProximo(no);
        }
        this.ultimo = no;
        this.tamanho = 0;
    }

}

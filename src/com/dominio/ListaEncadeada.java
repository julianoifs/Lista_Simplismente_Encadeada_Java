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
        this.tamanho++;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void limpar() {
        for (No<T> atual = this.inicio; atual != null; ) {
            No<T> novoProximo = atual.getProximo();
            atual.setValor(null);
            atual.setProximo(null);
            atual = novoProximo;
        }

        this.inicio = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    public T Exibir() {
        if (this.tamanho == 0) {
            return (T) ("[Vazia!!]");
        }

        StringBuilder sb = new StringBuilder();
        No<T> atual = this.inicio;

        sb.append("[");
        for (int i = 0; i < this.tamanho - 1; i++) {
            sb.append(atual.getValor()).append(", ");
            atual = atual.getProximo();
        }
        sb.append(atual.getValor()).append("]");

        return (T) sb.toString();
    }

}

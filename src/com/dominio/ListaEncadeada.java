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

    public void removerInicio() {
        No<T> atual = this.inicio;

        if (this.tamanho == 1) {
            this.inicio = null;
            this.ultimo = null;
        } else {
            this.inicio = this.inicio.getProximo();
            atual.setProximo(null);
            this.tamanho--;
        }
    }

    public void removerFinal() {
        No<T> anterior = null;
        No<T> atual = this.inicio;

        if (this.tamanho == 1) {
            this.inicio = null;
            this.ultimo = null;
        } else {
            for (int i = 0; i < this.getTamanho(); i++) {
                if (atual.getValor().equals(this.ultimo.getValor())) {
                    this.ultimo = anterior;
                    anterior.setProximo(null);
                }
                anterior = atual;
                atual = atual.getProximo();
            }
        }
        this.tamanho--;
    }

    public void limpaLista() {
        for (No<T> atual = this.inicio; atual != null;) {
            No<T> novoProximo = atual.getProximo();
            atual.setValor(null);
            atual.setProximo(null);
            atual = novoProximo;
        }
        this.inicio = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    public T getElemento(int posicao) {
        No<T> atual = this.inicio;

        for (int i = 0; i < posicao; i++) {
            if (atual.getProximo() != null) {
                atual = atual.getProximo();
            }
        }
        return atual.getValor();
    }

    public T exibir() {
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

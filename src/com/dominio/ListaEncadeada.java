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

    // adiciona no início
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

    // adiciona no meio
    public void addMeio(int posicao, T elemento) {
        No<T> no = new No<T>(elemento);
        No<T> atual = this.inicio;

        if (posicao <= 0) {
            this.addInicio(elemento);
        } else if (posicao >= this.tamanho) {
            this.addFinal(elemento);
        } else {
            for (int i = 0; i < posicao - 1; i++) {
                atual = atual.getProximo();
            }
            no.setProximo(atual.getProximo());
            atual.setProximo(no);
            this.tamanho++;
        }
    }

    // adiciona no final
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

    // retorna o tamanho/quantidade de elemento
    public int getTamanho() {
        return tamanho;
    }

    // retorna true se a lista possui elemento
    public boolean contem() {
        if (this.tamanho == 0) {
            return true;
        }
        return false;
    }

    // remove do início
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

    // remove do meio
    public void removeMeio(T elemento) {
        No<T> anterior = null;
        No<T> atual = this.inicio;

        for (int i = 0; i < this.tamanho; i++) {
            if (atual.getValor().equals(elemento)) {
                if (this.tamanho == 1) {
                    this.inicio = null;
                    this.ultimo = null;
                } else if (elemento.equals(this.inicio.getValor())) {
                    throw new IllegalArgumentException("Elemento não pode ser removido!");
                } else if (elemento.equals(this.ultimo.getValor())) {
                    throw new IllegalArgumentException("Elemento não pode ser removido!");
                } else {
                    anterior.setProximo(atual.getProximo());
                    atual = null;
                }
                break;
            }
            anterior = atual;
            atual = atual.getProximo();
        }
        this.tamanho--;
    }

    // remove do final
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

    // limpa toda a lista
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

    // retorna um elemento de acordo com a posição passada
    public T getElemento(int posicao) {
        No<T> atual = this.inicio;

        for (int i = 0; i < posicao; i++) {
            if (atual.getProximo() != null) {
                atual = atual.getProximo();
            }
        }
        return atual.getValor();
    }

    // exixbir os elemento da lista
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

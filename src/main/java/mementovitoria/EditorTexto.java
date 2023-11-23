package mementovitoria;

import java.util.ArrayList;
import java.util.List;

public class EditorTexto {

    private String texto;
    private List<String> historico = new ArrayList<>();

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
        historico.add(texto);
    }

    public void restaurarEstado(int indice) {
        if (indice < 0 || indice >= historico.size()) {
            throw new IllegalArgumentException("Índice inválido");
        }
        texto = historico.get(indice);
    }

    public List<String> getHistorico() {
        return new ArrayList<>(historico);
    }
}

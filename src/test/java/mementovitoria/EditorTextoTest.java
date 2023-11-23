package mementovitoria;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EditorTextoTest {

    @Test
    void deveArmazenarEstadosTexto() {
        EditorTexto editor = new EditorTexto();
        editor.setTexto("Primeiro texto");
        editor.setTexto("Segundo texto");
        assertEquals(2, editor.getHistorico().size());
    }

    @Test
    void deveRetornarTextoInicial() {
        EditorTexto editor = new EditorTexto();
        editor.setTexto("Primeiro texto");
        editor.setTexto("Segundo texto");
        editor.restaurarEstado(0);
        assertEquals("Primeiro texto", editor.getTexto());
    }

    @Test
    void deveRetornarTextoAnterior() {
        EditorTexto editor = new EditorTexto();
        editor.setTexto("Primeiro texto");
        editor.setTexto("Segundo texto");
        editor.setTexto("Terceiro texto");
        editor.restaurarEstado(1);
        assertEquals("Segundo texto", editor.getTexto());
    }

    @Test
    void deveRetornarExcecaoIndiceInvalido() {
        try {
            EditorTexto editor = new EditorTexto();
            editor.restaurarEstado(0);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Índice inválido", e.getMessage());
        }
    }
}

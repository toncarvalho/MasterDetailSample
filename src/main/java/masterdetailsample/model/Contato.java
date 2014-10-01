package masterdetailsample.model;

import java.io.Serializable;

/**
 * Created by ton on 10/1/14.
 */
public class Contato implements Serializable {

    private Long id;
    private String nome;
    private String fone;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(final String fone) {
        this.fone = fone;
    }

    @Override
    public String toString() {
        return "Contato{" +
               "id=" + id +
               ", nome='" + nome + '\'' +
               ", fone='" + fone + '\'' +
               '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Contato)) {
            return false;
        }

        final Contato contato = (Contato) o;

        if (!fone.equals(contato.fone)) {
            return false;
        }
        if (!id.equals(contato.id)) {
            return false;
        }
        if (!nome.equals(contato.nome)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + nome.hashCode();
        result = 31 * result + fone.hashCode();
        return result;
    }

    public Contato(final Long id, final String nome, final String fone) {
        this.id = id;
        this.nome = nome;
        this.fone = fone;
    }

    public Contato() {
    }
}

package masterdetailsample.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ton on 9/30/14.
 */
public class Pessoa implements Serializable {

    private Long id;

    private String nome;
    private String fone;
    private String email;

    private List<Contato> contatosList = new ArrayList<>();

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

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public List<Contato> getContatosList() {
        return contatosList;
    }

    public void setContatosList(final List<Contato> contatosList) {
        this.contatosList = contatosList;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final Pessoa pessoa = (Pessoa) o;

        if (email != null ? !email.equals(pessoa.email) : pessoa.email != null) {
            return false;
        }
        if (fone != null ? !fone.equals(pessoa.fone) : pessoa.fone != null) {
            return false;
        }
        if (id != null ? !id.equals(pessoa.id) : pessoa.id != null) {
            return false;
        }
        if (nome != null ? !nome.equals(pessoa.nome) : pessoa.nome != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (fone != null ? fone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
               "id=" + id +
               ", nome='" + nome + '\'' +
               ", fone='" + fone + '\'' +
               ", email='" + email + '\'' +
               '}';
    }

    public Pessoa(final Long id, final String nome, final String fone, final String email) {
        this.id = id;
        this.nome = nome;
        this.fone = fone;
        this.email = email;
    }

    public Pessoa() {
    }
}

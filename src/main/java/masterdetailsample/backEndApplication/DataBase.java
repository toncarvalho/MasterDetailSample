package masterdetailsample.backEndApplication;

import java.util.ArrayList;
import java.util.List;
import masterdetailsample.model.Contato;
import masterdetailsample.model.Pessoa;

/**
 * Created by ton on 9/30/14.
 */
public class DataBase {

    private static DataBase base;
    public List<Pessoa> tbPessoas;

    private DataBase() {
        populatePessoas();
    }

    private void populatePessoas() {
        tbPessoas = new ArrayList<Pessoa>();

        Pessoa joselito = new Pessoa(1l, "joselito", "44-88888888", "joselito@gmail.com");
        joselito.getContatosList().add(new Contato(0l, "berinbay", "44-89999999"));
        joselito.getContatosList().add(new Contato(1l, "tra", "44-45665456"));
        joselito.getContatosList().add(new Contato(2l, "vixi", "44-123213"));
        tbPessoas.add(joselito);

        Pessoa peterPan = new Pessoa(2l, "P.Pan", "44-99999999", "peterpan@gmail.com");
        peterPan.getContatosList().add(new Contato(0l, "Sininho", "44-89988899"));
        peterPan.getContatosList().add(new Contato(1l, "Jacaré", "44-789879"));
        tbPessoas.add(peterPan);
    }

    public static DataBase getInstance() {
        if (base == null) {
            base = new DataBase();
        }
        return base;
    }

    public DataBase getBase() {
        return base;
    }

    public void setBase(final DataBase base) {
        this.base = base;
    }
}

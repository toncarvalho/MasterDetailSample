package masterdetailsample.model;

import java.util.ArrayList;
import java.util.List;

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
        tbPessoas.add(new Pessoa(0l, "Ton", "44-98060607", "toncarvalho@gmail.com"));
        tbPessoas.add(new Pessoa(1l, "joselito", "44-88888888", "joselito@gmail.com"));
        tbPessoas.add(new Pessoa(2l, "peterpan", "44-99999999", "peterpan@gmail.com"));
        tbPessoas.add(new Pessoa(2l, "gancho", "44-000000000", "gancho@gmail.com"));
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

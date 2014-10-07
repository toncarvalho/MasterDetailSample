package masterdetailsample.services;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import javafx.application.Platform;
import masterdetailsample.eventos.masterdetail.DetailEventListener;
import masterdetailsample.eventos.masterdetail.MasterDetailEvent;
import masterdetailsample.eventos.masterdetail.MasterDetailEventSource;
import masterdetailsample.eventos.masterdetail.MasterEventListener;
import masterdetailsample.model.Contato;
import masterdetailsample.model.DataBase;
import masterdetailsample.model.Pessoa;
import masterdetailsample.types.FormState;

/**
 * Created by ton on 10/1/14.
 */
public class BackEndService implements MasterEventListener, DetailEventListener {

    private static BackEndService service;

    private FormState estadoInterno = FormState.INICIAL;

    private MasterDetailEventSource eventSource;

    public List<Pessoa> getPessoas() {
        try {
            Thread.sleep(1);
            return DataBase.getInstance().tbPessoas;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void startFormListener(final MasterDetailEvent event) {
        try {
            Thread.sleep(1000);
            estadoInterno = FormState.INICIAL;
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void persistListener(final MasterDetailEvent e) {

        Pessoa novo = (Pessoa) e.getSource();
        if (novo.getId() == null) {
            novo.setId(DataBase.getInstance().tbPessoas.stream().count() + 1);
            DataBase.getInstance().tbPessoas.sort(Comparator.comparingLong(obj -> obj.getId()));

            Long novoId = (DataBase.getInstance().tbPessoas.get(DataBase.getInstance().tbPessoas.size() - 1).getId() + 1);
            novo.setId(novoId);
            DataBase.getInstance().tbPessoas.add(novo);
            eventSource.pesquisaRegistro();
        } else {
            List<Pessoa> pessoas = DataBase.getInstance().tbPessoas;
            Pessoa antigo = pessoas.stream().filter(Predicate.isEqual(novo)).findFirst().get();
            antigo.setId(novo.getId());
            antigo.setNome(novo.getNome());
            antigo.setFone(novo.getFone());
            antigo.setEmail(novo.getEmail());
            eventSource.pesquisaRegistro();
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    eventSource.selecaoDeIten(antigo);
                }
            });
        }

        System.out.println(" Lista completa de registros ");

        DataBase.getInstance().tbPessoas.forEach(pessoa -> {
            System.out.println(pessoa);
        });

        estadoInterno = FormState.INICIAL;
    }

    @Override
    public void cancelListener(final MasterDetailEvent e) {
        try {
            Thread.sleep(500);
            System.out.println(this.getClass().getName() + " Efetuando Cancelamento!!!");
            eventSource.pesquisaRegistro();
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    eventSource.selecaoDeIten();
                }
            });
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void insertListener(final MasterDetailEvent e) {

        System.out.println(this.getClass().getName()
                           + "Inicicizando inserção de novo registro, carregando caixas  de seleção e valores default de componentes!!!");
    }

    @Override
    public void changeItemListener(final MasterDetailEvent e) {
        try {
            Thread.sleep(1);
            estadoInterno = FormState.EDITANDO;
            System.out.println(this.getClass().getName() + " Efetuando Alteração do registro!!!");
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteListener(final MasterDetailEvent e) {
        try {
            Thread.sleep(1000);
            Pessoa objeto = (Pessoa) e.getSource();

            DataBase.getInstance().tbPessoas.remove(objeto);

            System.out.println(this.getClass().getName() + " Efetuando EXCLUSÃO do registro!!!");
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void searchListener(final MasterDetailEvent e) {

        try {
            Thread.sleep(500);

            System.out.println(this.getClass().getName() + "Pesquisando registros!!!");
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void selectDetailListener(final MasterDetailEvent event) {

    }

    @Override
    public void restartSearchInDetails(final MasterDetailEvent event) {

    }

    @Override
    public void insertDetailListener(final MasterDetailEvent e) {

    }

    @Override
    public void changeDetailListener(final MasterDetailEvent e) {

    }

    @Override
    public void deleteDetailListener(final MasterDetailEvent e) {

    }

    @Override
    public void searchDetailListener(final MasterDetailEvent e) {

    }

    @Override
    public void persistDetailListener(final MasterDetailEvent e) {
        System.out.println("ouviu o evento persistDetailListener em: " + this.getClass().getName());

        Map<String, Serializable> map = (Map<String, Serializable>) e.getSource();
        Pessoa pessoa = (Pessoa) map.get("pessoa");
        Contato contato = (Contato) map.get("contato");
        /**
         * Quando o id do contato é nulo, então o contato é novo, caso contrário esta ocorrendo uma atualização.
         */

        if (contato.getId() == null) {
            Pessoa persistente = DataBase.getInstance().tbPessoas.stream().filter(Predicate.isEqual(pessoa)).findFirst().get();
            persistente.getContatosList().sort(Comparator.comparingLong(obj -> obj.getId()));
            Contato ultimo = persistente.getContatosList().get(persistente.getContatosList().size() - 1);
            Long novoId = ultimo.getId() + 1;
            contato.setId(novoId);

            pessoa.getContatosList().add(contato);
            persistente = pessoa;
        } else {
            Pessoa persistente = DataBase.getInstance().tbPessoas.stream().filter(Predicate.isEqual(pessoa)).findFirst().get();
            persistente.getContatosList().sort(Comparator.comparingLong(obj -> obj.getId()));
            Contato contatoAntigo = persistente.getContatosList().stream().filter(Predicate.isEqual(contato)).findFirst().get();
            contatoAntigo.setId(contato.getId());
            contatoAntigo.setNome(contato.getNome());
            contatoAntigo.setFone(contato.getFone());
            persistente = pessoa;
        }
        System.out.println(" gravou!!!");
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                eventSource.selecaoDeItenDetalhe(contato);

                System.out.println(" disparou o evento selectMasterItemListener em: " + this.getClass().getName());
            }
        });
    }

    @Override
    public void cancelDetailListener(final MasterDetailEvent e) {

    }

    @Override
    public void selectListener(final MasterDetailEvent event) {

    }

    @Override
    public void restartSearchListener(final MasterDetailEvent event) {

    }

    @Override
    public void selectMasterItemListener(final MasterDetailEvent event) {

    }

    @Override
    public void startNewDetailListener(final MasterDetailEvent event) {

    }

    private BackEndService() {
        this.eventSource = eventSource;
    }

    public static BackEndService getInstance() {
        if (service == null) {
            service = new BackEndService();
        }

        return service;
    }

    public void setEventSource(final MasterDetailEventSource masterDetailSource) {
        this.eventSource = masterDetailSource;
    }
}

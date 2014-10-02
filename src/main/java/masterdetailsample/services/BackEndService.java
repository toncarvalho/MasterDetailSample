package masterdetailsample.services;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import javafx.application.Platform;
import masterdetailsample.eventos.masterdetail.DetailEventListener;
import masterdetailsample.eventos.masterdetail.MasterDetailEvent;
import masterdetailsample.eventos.masterdetail.MasterDetailEventSource;
import masterdetailsample.eventos.masterdetail.MasterEventListener;
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
    public void inicioCadastro(final MasterDetailEvent event) {
        try {
            Thread.sleep(1000);
            estadoInterno = FormState.INICIAL;
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void gravacaoRegistro(final MasterDetailEvent e) {

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
    public void cancelamentoRegistro(final MasterDetailEvent e) {
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
    public void insercaoRegistro(final MasterDetailEvent e) {

        System.out.println(this.getClass().getName()
                           + "Inicicizando inserção de novo registro, carregando caixas  de seleção e valores default de componentes!!!");
    }

    @Override
    public void alteracaoRegistro(final MasterDetailEvent e) {
        try {
            Thread.sleep(1);
            estadoInterno = FormState.EDITANDO;
            System.out.println(this.getClass().getName() + " Efetuando Alteração do registro!!!");
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void exclusaoRegistro(final MasterDetailEvent e) {
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
    public void pesquisaRegistro(final MasterDetailEvent e) {

        try {
            Thread.sleep(500);

            System.out.println(this.getClass().getName() + "Pesquisando registros!!!");
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void insercaoRegistroDetalhe(final MasterDetailEvent e) {

    }

    @Override
    public void alteracaoRegistroDetalhe(final MasterDetailEvent e) {

    }

    @Override
    public void exclusaoRegistroDetalhe(final MasterDetailEvent e) {

    }

    @Override
    public void pesquisaRegistroDetalhe(final MasterDetailEvent e) {

    }

    @Override
    public void gravacaoRegistroDetalhe(final MasterDetailEvent e) {

    }

    @Override
    public void cancelamentoRegistroDetalhe(final MasterDetailEvent e) {

    }

    @Override
    public void selecaoDeIten(final MasterDetailEvent event) {

    }

    @Override
    public void reiniciaPesquisa(final MasterDetailEvent event) {

    }

    @Override
    public void selecaoDeItenDetalhe(final MasterDetailEvent event) {

    }

    @Override
    public void inicioCadastroDetalhe(final MasterDetailEvent event) {

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

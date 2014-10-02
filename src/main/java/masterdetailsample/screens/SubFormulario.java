package masterdetailsample.screens;

import java.util.ArrayList;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import masterdetailsample.components.BarraDeFerramentasInicial;
import masterdetailsample.components.BarraDeStatus;
import masterdetailsample.components.GridSubFormulario;
import masterdetailsample.eventos.masterdetail.DetailEventListener;
import masterdetailsample.eventos.masterdetail.MasterDetailEvent;
import masterdetailsample.eventos.masterdetail.MasterDetailEventSource;
import masterdetailsample.eventos.masterdetail.MasterEventListener;
import masterdetailsample.model.Contato;
import masterdetailsample.model.Pessoa;
import masterdetailsample.types.FormState;

/**
 * Created by ton on 9/29/14.
 */
public class SubFormulario implements MasterEventListener, DetailEventListener {

    private final TableView<Contato> tableContato;

    private MasterDetailEventSource masterDetailSource;
    private VBox vBox = new VBox();
    private FormState estado;

    private Contato entidadeDetalhe;

    private ObservableList<Contato> contatoObservableList = FXCollections.observableArrayList();

    public SubFormulario(final MasterDetailEventSource masterDetailSource) {
        this.estado = FormState.INICIAL;
        this.masterDetailSource = masterDetailSource;
        GridSubFormulario grid = new GridSubFormulario();
      //  this.masterDetailSource.addDetailListener(grid);
        tableContato = grid.getTable();

        //se adicionando à cadeia de ouvintes
        this.masterDetailSource.addMasterListener(this);
        this.masterDetailSource.addDetailListener(this);

        BarraDeFerramentasInicial ferramentasInicialDetalhe = new BarraDeFerramentasInicial(masterDetailSource);
        ferramentasInicialDetalhe.novo.setOnAction(event -> {
            masterDetailSource.insercaoRegistroDetalhe(ferramentasInicialDetalhe);
        });

        ferramentasInicialDetalhe.alterar.setOnAction(event -> {

            if (entidadeDetalhe != null) {
                masterDetailSource.alteracaoRegistroDetalhe(entidadeDetalhe);
            } else {
                System.out.println(" entidadeDetalhe nula, nenhum item selecionado");
            }
        });

        ferramentasInicialDetalhe.excluir.setOnAction(event -> {
            masterDetailSource.exclusaoRegistroDetalhe(ferramentasInicialDetalhe);
        });

        this.masterDetailSource.addMasterListener(ferramentasInicialDetalhe);
        VBox boxDetalhe = new VBox();
        boxDetalhe.getChildren().add(new Label("SUBFORMULÁRIO CONTATOS"));

        tableContato.setFocusTraversable(false);
        tableContato.getSelectionModel().getSelectedItems().addListener(new ListChangeListener() {
            @Override
            public void onChanged(final Change c) {
                entidadeDetalhe = (Contato) c.getList().get(0);
                masterDetailSource.selecaoDeItenDetalhe(entidadeDetalhe);
            }
        });

        boxDetalhe.getChildren().add(tableContato);
        boxDetalhe.getChildren().add(ferramentasInicialDetalhe.createBarraInicializacao());

        BarraDeStatus status = new BarraDeStatus();
        boxDetalhe.getChildren().add(status);
        this.masterDetailSource.addMasterListener(status);
        vBox.getChildren().add(boxDetalhe);
        vBox.setPrefSize(300, 200);
    }

    public VBox getScreen() {
        return this.vBox;
    }

    public TableView<Contato> getTableContato() {
        return tableContato;
    }

    @Override
    public void inicioCadastro(final MasterDetailEvent e) {

    }

    @Override
    public void gravacaoRegistro(final MasterDetailEvent e) {

    }

    @Override
    public void cancelamentoRegistro(final MasterDetailEvent e) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                masterDetailSource.pesquisaRegistro();
            }
        });
    }

    @Override
    public void insercaoRegistro(final MasterDetailEvent e) {

    }

    @Override
    public void alteracaoRegistro(final MasterDetailEvent e) {

    }

    @Override
    public void exclusaoRegistro(final MasterDetailEvent e) {

    }

    @Override
    public void pesquisaRegistro(final MasterDetailEvent e) {

        System.out.println("ouviu o evento pesquisaRegistro em: " + this.getClass().getName());
        //this.contatoObservableList = FXCollections.observableList( new ArrayList<Contato>());
        contatoObservableList.clear();
    }

    @Override
    public void insercaoRegistroDetalhe(final MasterDetailEvent e) {
        System.out.println("ouviu o evento insercaoRegistroDetalhe em: " + this.getClass().getName());
    }

    @Override
    public void alteracaoRegistroDetalhe(final MasterDetailEvent e) {
        System.out.println("ouviu o evento alteracaoRegistroDetalhe em: " + this.getClass().getName());
    }

    @Override
    public void exclusaoRegistroDetalhe(final MasterDetailEvent e) {
        System.out.println("ouviu o evento exclusaoRegistroDetalhe em: " + this.getClass().getName());
    }

    @Override
    public void pesquisaRegistroDetalhe(final MasterDetailEvent e) {
        System.out.println("ouviu o evento pesquisaRegistroDetalhe em: " + this.getClass().getName());
    }

    @Override
    public void gravacaoRegistroDetalhe(final MasterDetailEvent e) {
        System.out.println("ouviu o evento gravacaoRegistroDetalhe em: " + this.getClass().getName());
    }

    @Override
    public void cancelamentoRegistroDetalhe(final MasterDetailEvent e) {
        System.out.println("ouviu o evento cancelamentoRegistroDetalhe em: " + this.getClass().getName());
    }

    @Override
    public void selecaoDeIten(final MasterDetailEvent event) {

        System.out.println("ouviu o evento selecaoDeIten em: " + this.getClass().getName());
        tableContato.itemsProperty().setValue(contatoObservableList);

        if (event.getSource() != null && event.getSource() instanceof TableView) {
            TableView<Pessoa> tablePessoas = (TableView<Pessoa>) event.getSource();
            if (tablePessoas.getSelectionModel().getSelectedItem() != null) {
                Pessoa pessoa = tablePessoas.getSelectionModel().getSelectedItems().get(0);
                System.out.println(" contatos da pessoa: " + pessoa.getNome());
                pessoa.getContatosList().stream().forEach(obj -> {
                    System.out.println(obj);
                });

                if (!pessoa.getContatosList().isEmpty()) {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            contatoObservableList.clear();
                            contatoObservableList.addAll(pessoa.getContatosList());
                        }
                    });
                } else {
                    this.tableContato.itemsProperty().setValue(FXCollections.observableList(new ArrayList<>()));
                }
            }
        } else if (event.getSource() != null && event.getSource() instanceof Pessoa) {
            Pessoa pessoa = (Pessoa) event.getSource();
            System.out.println(" contatos da pessoa: " + pessoa.getNome());
            pessoa.getContatosList().stream().forEach(obj -> {
                System.out.println(obj);
            });

            if (!pessoa.getContatosList().isEmpty()) {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {

                        contatoObservableList.clear();
                        contatoObservableList.addAll(pessoa.getContatosList());
                    }
                });
            } else {
                this.tableContato.itemsProperty().setValue(FXCollections.observableList(new ArrayList<>()));
            }
        }
    }

    @Override
    public void reiniciaPesquisa(final MasterDetailEvent event) {
        contatoObservableList.clear();
        System.out.println("ouviu o evento reiniciaPesquisa em: " + this.getClass().getName());
    }

    @Override
    public void selecaoDeItenDetalhe(final MasterDetailEvent event) {
        System.out.println(" ouvinte do evento selecaoDeItenDetalhe em:" + this.getClass().getName());
        System.out.println(" detalhe selecionado: " + event.getSource());
    }
}

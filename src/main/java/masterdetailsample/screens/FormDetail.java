package masterdetailsample.screens;

import java.util.ArrayList;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import masterdetailsample.components.DetailStatusBar;
import masterdetailsample.components.StartDetailEventsToolBar;
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
public class FormDetail implements MasterEventListener, DetailEventListener {

    private final TableView<Contato> tableContato;

    private MasterDetailEventSource masterDetailSource;
    private VBox vBox = new VBox();
    private FormState estado;

    private Contato entidadeDetalhe;

    private ObservableList<Contato> contatoObservableList = FXCollections.observableArrayList();
    private Pessoa pessoa;

    public FormDetail(final MasterDetailEventSource masterDetailSource) {
        this.estado = FormState.INICIAL;
        this.masterDetailSource = masterDetailSource;
        GridSubFormulario grid = new GridSubFormulario();
        //  this.masterDetailSource.addDetailListener(grid);
        tableContato = grid.getTable();

        //se adicionando à cadeia de ouvintes
        this.masterDetailSource.addMasterListener(this);
        this.masterDetailSource.addDetailListener(this);

        StartDetailEventsToolBar ferramentasInicialDetalhe = new StartDetailEventsToolBar(masterDetailSource);
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

        this.masterDetailSource.addDetailListener(ferramentasInicialDetalhe);
        VBox boxDetalhe = new VBox();
        boxDetalhe.getChildren().add(new Label("SUBFORMULÁRIO CONTATOS"));

        tableContato.setFocusTraversable(false);
        tableContato.getSelectionModel().getSelectedItems().addListener(new ListChangeListener() {
            @Override
            public void onChanged(final Change c) {
                entidadeDetalhe = (Contato) c.getList().get(0);
                if (entidadeDetalhe != null) {
                    masterDetailSource.selecaoDeItenDetalhe(entidadeDetalhe);
                }
            }
        });

        boxDetalhe.getChildren().add(tableContato);
        boxDetalhe.getChildren().add(ferramentasInicialDetalhe.createBarraInicializacao());

        DetailStatusBar status = new DetailStatusBar();
        boxDetalhe.getChildren().add(status);
        this.masterDetailSource.addDetailListener(status);
        vBox.getChildren().add(boxDetalhe);
        vBox.setPrefSize(300, 400);

        //adicionando subformulario de cadastro.
        InterfaceCadastroDetail cadastroDetail = new InterfaceCadastroDetail(masterDetailSource);
        vBox.getChildren().add(new Separator());
        vBox.getChildren().add(cadastroDetail.getScreen());
    }

    public VBox getScreen() {
        return this.vBox;
    }

    public TableView<Contato> getTableContato() {
        return tableContato;
    }

    @Override
    public void startFormListener(final MasterDetailEvent e) {
        this.masterDetailSource.inicioCadastroDetalhe();
    }

    @Override
    public void persistListener(final MasterDetailEvent e) {

    }

    @Override
    public void cancelListener(final MasterDetailEvent e) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                masterDetailSource.pesquisaRegistro();
            }
        });
    }

    @Override
    public void insertListener(final MasterDetailEvent e) {

    }

    @Override
    public void changeItemListener(final MasterDetailEvent e) {

    }

    @Override
    public void deleteListener(final MasterDetailEvent e) {

    }

    @Override
    public void searchListener(final MasterDetailEvent e) {

        System.out.println("ouviu o evento searchListener em: " + this.getClass().getName());
        //this.contatoObservableList = FXCollections.observableList( new ArrayList<Contato>());
        contatoObservableList.clear();
    }

    @Override
    public void restartSearchListener(final MasterDetailEvent event) {
        contatoObservableList.clear();
        System.out.println("ouviu o evento restartSearchListener em: " + this.getClass().getName());
    }

    @Override
    public void selectListener(final MasterDetailEvent event) {

        System.out.println("ouviu o evento selectListener em: " + this.getClass().getName());
        tableContato.itemsProperty().setValue(contatoObservableList);

        if (event.getSource() != null && event.getSource() instanceof TableView) {
            TableView<Pessoa> tablePessoas = (TableView<Pessoa>) event.getSource();
            if (tablePessoas.getSelectionModel().getSelectedItem() != null) {
                pessoa = tablePessoas.getSelectionModel().getSelectedItems().get(0);
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
            pessoa = (Pessoa) event.getSource();
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
    public void selectDetailListener(final MasterDetailEvent event) {

    }

    @Override
    public void restartSearchInDetails(final MasterDetailEvent event) {

    }

    @Override
    public void insertDetailListener(final MasterDetailEvent e) {
        System.out.println("ouviu o evento insertDetailListener em: " + this.getClass().getName());
    }

    @Override
    public void changeDetailListener(final MasterDetailEvent e) {
        System.out.println("ouviu o evento changeDetailListener em: " + this.getClass().getName());
    }

    @Override
    public void deleteDetailListener(final MasterDetailEvent e) {
        System.out.println("ouviu o evento deleteDetailListener em: " + this.getClass().getName());
    }

    @Override
    public void searchDetailListener(final MasterDetailEvent e) {
        System.out.println("ouviu o evento searchDetailListener em: " + this.getClass().getName());
    }

    @Override
    public void persistDetailListener(final MasterDetailEvent e) {
        System.out.println("ouviu o evento persistDetailListener em: " + this.getClass().getName());
        tableContato.getItems().clear();

        contatoObservableList.addAll(pessoa.getContatosList());

    }

    @Override
    public void cancelDetailListener(final MasterDetailEvent e) {
        System.out.println("ouviu o evento cancelDetailListener em: " + this.getClass().getName());
    }

    @Override
    public void selectMasterItemListener(final MasterDetailEvent event) {
        System.out.println(" ouvinte do evento selectMasterItemListener em:" + this.getClass().getName());
        System.out.println(" detalhe selecionado: " + event.getSource());
        entidadeDetalhe = (Contato) event.getSource();
    }

    /**
     * acoes, modificou o estado da barra, modificou o estado da barra de status, e deve zerar a lista de detalhes.
     *
     * @param event
     */
    @Override
    public void startNewDetailListener(final MasterDetailEvent event) {
        System.out.println(" ouvinte do evento startNewDetailListener em:" + this.getClass().getName());
        contatoObservableList.clear();
    }
}

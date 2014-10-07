package masterdetailsample.screens;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.VBox;
import masterdetailsample.components.StartMasterEventsToolBar;
import masterdetailsample.components.MasterStatusBar;
import masterdetailsample.components.Grid;
import masterdetailsample.eventos.masterdetail.MasterDetailEvent;
import masterdetailsample.eventos.masterdetail.MasterDetailEventSource;
import masterdetailsample.eventos.masterdetail.MasterEventListener;
import masterdetailsample.model.Pessoa;
import masterdetailsample.services.BackEndService;
import masterdetailsample.types.FormState;

/**
 * Created by ton on 9/29/14.
 */
public class InterfacePesquisaMaster implements MasterEventListener {

    private final TableView<Pessoa> table;

    private MasterDetailEventSource masterDetailSource;
    private VBox vBox = new VBox();
    private FormState estado;

    private Button btnPesquisa = new Button("Pesquisa");
    private Button btnLimpaGrid = new Button("Limpra Grid");
    private Button btnReinicia = new Button("Reinicia");

    private Pessoa entidade;

    private ObservableList<Pessoa> pessoaObservableList = FXCollections.observableArrayList();

    public InterfacePesquisaMaster(final MasterDetailEventSource masterDetailSource) {
        this.estado = FormState.INICIAL;
        this.masterDetailSource = masterDetailSource;
        Grid grid = new Grid();
        this.masterDetailSource.addMasterListener(grid);

        table = grid.getTable();

        StartMasterEventsToolBar ferramentasJanelaPesquisa = new StartMasterEventsToolBar(masterDetailSource);
        ferramentasJanelaPesquisa.novo.setOnAction(event -> {
            masterDetailSource.insercaoRegistro(ferramentasJanelaPesquisa);
        });

        ferramentasJanelaPesquisa.alterar.setOnAction(event -> {

            //masterDetailSource.changeItemListener(table.getSelectionModel().selectedItemProperty().get());
            if (entidade != null) {
                masterDetailSource.alteracaoRegistro(entidade);
            } else {
                System.out.println(" entidade nula, nenhum item selecionado");
            }
        });

        ferramentasJanelaPesquisa.excluir.setOnAction(event -> {
            masterDetailSource.exclusaoRegistro(ferramentasJanelaPesquisa);
        });

        this.masterDetailSource.addMasterListener(ferramentasJanelaPesquisa);
        VBox interfacePesquisa = new VBox();
        interfacePesquisa.getChildren().add(new Label("Pesquisa"));
        interfacePesquisa.getChildren().add(new ToolBar(btnPesquisa, btnLimpaGrid, btnReinicia));

        table.setFocusTraversable(false);
        table.getSelectionModel().getSelectedItems().addListener(new ListChangeListener() {
            @Override
            public void onChanged(final Change c) {

                masterDetailSource.selecaoDeIten(table);
            }
        });

        interfacePesquisa.getChildren().add(table);
        interfacePesquisa.getChildren().add(ferramentasJanelaPesquisa.createBarraInicializacao());

        MasterStatusBar status = new MasterStatusBar();
        interfacePesquisa.getChildren().add(status);
        this.masterDetailSource.addMasterListener(status);
        interfacePesquisa.setPrefSize(350, 200);
        vBox.getChildren().add(interfacePesquisa);

        btnPesquisa.setOnAction(event -> {

            masterDetailSource.pesquisaRegistro();
        });

        btnLimpaGrid.setOnAction(event -> {

            masterDetailSource.reiniciaPesquisa();
        });

        btnReinicia.setOnAction(event -> {
            masterDetailSource.inicioCadastro();
        });
    }

    public VBox getScreen() {
        return this.vBox;
    }

    public TableView<Pessoa> getTable() {
        return table;
    }

    @Override
    public void startFormListener(final MasterDetailEvent e) {

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

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                table.itemsProperty().setValue(pessoaObservableList);
                pessoaObservableList.removeAll(FXCollections.observableList(BackEndService.getInstance().getPessoas()));
                pessoaObservableList.addAll(FXCollections.observableList(BackEndService.getInstance().getPessoas()));
            }
        });
    }

    @Override
    public void selectListener(final MasterDetailEvent event) {
        System.out.println(this.getClass().getName() + " selecionando item");
        if (event.getSource() != null && event.getSource() instanceof TableView) {
            TableView<Pessoa> table = (TableView<Pessoa>) event.getSource();
            if (table.getSelectionModel().getSelectedItem() != null) {
                entidade = table.getSelectionModel().getSelectedItems().get(0);
            }
        } else if (event.getSource() != null && event.getSource() instanceof Pessoa) {
            entidade = (Pessoa) event.getSource();
        }
    }

    @Override
    public void restartSearchListener(final MasterDetailEvent event) {

    }
}

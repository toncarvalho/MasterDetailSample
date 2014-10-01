package masterdetailsample.screens;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.VBox;
import masterdetailsample.components.BarraDeFerramentasInicial;
import masterdetailsample.components.BarraDeStatus;
import masterdetailsample.components.Grid;
import masterdetailsample.eventos.masterdetail.MasterDetailEventSource;
import masterdetailsample.model.DataBase;
import masterdetailsample.model.Pessoa;
import masterdetailsample.types.FormState;

/**
 * Created by ton on 9/29/14.
 */
public class InterfacePesquisa {

    private final TableView<Pessoa> table;

    private MasterDetailEventSource masterDetailSource;
    private VBox vBox = new VBox();
    private FormState estado;

    private Button btnPesquisa = new Button("Pesquisa");
    private Button btnLimpaGrid = new Button("Limpra Grid");
    private Button btnReinicia = new Button("Reinicia");

    public InterfacePesquisa(final MasterDetailEventSource masterDetailSource) {
        this.estado = FormState.INICIAL;
        this.masterDetailSource = masterDetailSource;

        BarraDeFerramentasInicial ferramentasJanelaPesquisa = new BarraDeFerramentasInicial(masterDetailSource);
        this.masterDetailSource.addMasterDetailListener(ferramentasJanelaPesquisa);
        VBox interfacePesquisa = new VBox();
        interfacePesquisa.getChildren().add(new Label("Pesquisa"));
        interfacePesquisa.getChildren().add(new ToolBar(btnPesquisa, btnLimpaGrid,btnReinicia));

        Grid grid = new Grid();
        this.masterDetailSource.addMasterDetailListener(grid);

        table = grid.getTable();
        table.setFocusTraversable(false);
        table.getSelectionModel().getSelectedItems().addListener(new ListChangeListener() {
            @Override
            public void onChanged(final Change c) {
                masterDetailSource.selecaoDeIten(table);
            }
        });

        interfacePesquisa.getChildren().add(table);
        interfacePesquisa.getChildren().add(ferramentasJanelaPesquisa.createBarraInicializacao());

        BarraDeStatus status = new BarraDeStatus();
        interfacePesquisa.getChildren().add(status);
        this.masterDetailSource.addMasterDetailListener(status);
        interfacePesquisa.setPrefSize(400, 200);
        vBox.getChildren().add(interfacePesquisa);

        btnPesquisa.setOnAction(event -> {
            masterDetailSource.pesquisaRegistro(FXCollections.observableList(DataBase.getInstance().tbPessoas));
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
}

package masterdetailsample.screens;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import masterdetailsample.components.DetailStatusBar;
import masterdetailsample.components.ConfirmDetailEventslToolBar;
import masterdetailsample.eventos.masterdetail.DetailEventListener;
import masterdetailsample.eventos.masterdetail.MasterDetailEvent;
import masterdetailsample.eventos.masterdetail.MasterDetailEventSource;
import masterdetailsample.eventos.masterdetail.MasterEventListener;
import masterdetailsample.model.Contato;
import masterdetailsample.model.Pessoa;

/**
 * Interface de cadastro de subformulário.
 */
public class InterfaceCadastroDetail implements MasterEventListener, DetailEventListener {

    private VBox boxSubformularioCadastro = new VBox();
    private MasterDetailEventSource masterDetailSource;
    private Label lblNome = new Label("None:");
    private TextField edtNome = new TextField();
    private Label lblFone = new Label("Fone:");
    private TextField edtFone = new TextField();

    private DetailStatusBar status = new DetailStatusBar();

    private Contato entidade;
    private Pessoa pessoaSelecionada;

    public InterfaceCadastroDetail(final MasterDetailEventSource masterDetailSource) {
        this.masterDetailSource = masterDetailSource;
        this.masterDetailSource.addDetailListener(this);
        this.masterDetailSource.addMasterListener(this);

        ConfirmDetailEventslToolBar confirmDetailEventslToolBar = new ConfirmDetailEventslToolBar(masterDetailSource);

        confirmDetailEventslToolBar.cancelar.setOnAction(event -> {
            this.masterDetailSource.cancelamentoRegistro(entidade);
        });

        this.masterDetailSource.addDetailListener(confirmDetailEventslToolBar);
        boxSubformularioCadastro.getChildren().add(new Label("SUBFORMULÁRIO DE CADASTRO"));

        boxSubformularioCadastro.getChildren().add(new VBox(lblNome, edtNome));

        boxSubformularioCadastro.getChildren().add(new VBox(lblFone, edtFone));

        boxSubformularioCadastro.getChildren().add(confirmDetailEventslToolBar.createBarraFinalizacao());

        DetailStatusBar status = new DetailStatusBar();
        boxSubformularioCadastro.getChildren().add(status);
        this.masterDetailSource.addDetailListener(status);

        boxSubformularioCadastro.setPrefSize(400, 200);

        confirmDetailEventslToolBar.salvar.setOnAction(event -> {

            Map<String, Serializable> map = new TreeMap<String, Serializable>();
            map.put("pessoa", this.pessoaSelecionada);

            if (entidade == null) {
                entidade = new Contato();
                entidade.setNome(edtNome.textProperty().getValue());
                entidade.setFone(edtFone.textProperty().getValue());
                map.put("contato", this.entidade);
                this.masterDetailSource.gravacaoRegistroDetalhe(map);
            } else {
                entidade.setNome(edtNome.textProperty().getValue());
                entidade.setFone(edtFone.textProperty().getValue());
                map.put("contato", this.entidade);
                this.masterDetailSource.gravacaoRegistroDetalhe(map);
            }
        });
    }

    public VBox getScreen() {

        return this.boxSubformularioCadastro;
    }

    @Override
    public void startFormListener(final MasterDetailEvent e) {

    }

    @Override
    public void persistListener(final MasterDetailEvent e) {

    }

    @Override
    public void cancelListener(final MasterDetailEvent e) {

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

    }

    @Override
    public void selectListener(final MasterDetailEvent event) {

        if (event.getSource() != null && event.getSource() instanceof Pessoa) {
            this.pessoaSelecionada = (Pessoa) event.getSource();
        } else if (event.getSource() != null && event.getSource() instanceof TableView) {
            TableView<Pessoa> tablePessoas = (TableView<Pessoa>) event.getSource();
            if (tablePessoas.getSelectionModel().getSelectedItem() != null) {
                pessoaSelecionada = tablePessoas.getSelectionModel().getSelectedItems().get(0);
            }
        }
        System.out.println(" ouviu selectListener em:" + this.getClass().getName());
    }

    @Override
    public void restartSearchListener(final MasterDetailEvent event) {

    }

    @Override
    public void selectDetailListener(final MasterDetailEvent event) {

    }

    @Override
    public void restartSearchInDetails(final MasterDetailEvent event) {

    }

    @Override
    public void insertDetailListener(final MasterDetailEvent e) {
        entidade = new Contato();
        edtNome.disableProperty().set(false);
        edtFone.disableProperty().set(false);

        edtNome.textProperty().set("");
        edtNome.setPromptText("nome");
        edtFone.textProperty().set("");
        edtFone.setPromptText("telefone");
    }

    @Override
    public void changeDetailListener(final MasterDetailEvent e) {
        edtNome.disableProperty().set(false);
        edtFone.disableProperty().set(false);
    }

    @Override
    public void deleteDetailListener(final MasterDetailEvent e) {

    }

    @Override
    public void searchDetailListener(final MasterDetailEvent e) {

        edtNome.textProperty().set("");
        edtNome.setPromptText("nome");
        edtFone.textProperty().set("");
        edtFone.setPromptText("telefone");
    }

    @Override
    public void persistDetailListener(final MasterDetailEvent e) {

    }

    @Override
    public void cancelDetailListener(final MasterDetailEvent e) {
        edtNome.disableProperty().set(true);
        edtFone.disableProperty().set(true);
    }

    @Override
    public void selectMasterItemListener(final MasterDetailEvent event) {

        if (event.getSource() != null && event.getSource() instanceof Contato) {
            entidade = (Contato) event.getSource();
            edtNome.disableProperty().set(true);
            edtFone.disableProperty().set(true);
            edtNome.textProperty().setValue(entidade.getNome());
            edtFone.textProperty().setValue(entidade.getFone());
        } else {
            edtNome.disableProperty().set(true);
            edtFone.disableProperty().set(true);
        }
    }

    @Override
    public void startNewDetailListener(final MasterDetailEvent event) {

        edtNome.disableProperty().set(true);
        edtFone.disableProperty().set(true);

        edtNome.textProperty().set("");
        edtNome.setPromptText("nome");
        edtFone.textProperty().set("");
        edtFone.setPromptText("telefone");
    }
}

package masterdetailsample.screens;

import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import masterdetailsample.components.BarraDeFerramentasFinal;
import masterdetailsample.components.BarraDeStatus;
import masterdetailsample.eventos.masterdetail.MasterDetailEvent;
import masterdetailsample.eventos.masterdetail.MasterDetailEventListener;
import masterdetailsample.eventos.masterdetail.MasterDetailEventSource;
import masterdetailsample.model.Pessoa;

/**
 * Created by ton on 9/29/14.
 */
public class FormMaster implements MasterDetailEventListener {
    private VBox formMaster = new VBox();
    private MasterDetailEventSource masterDetailSource;
    private Label lblNome = new Label("None:");
    private TextField edtNome = new TextField();
    private Label lblFone = new Label("Fone:");
    private TextField edtFone = new TextField();
    private Label lblEmail = new Label("Email:");
    private TextField edtEmail = new TextField();

    public FormMaster(final MasterDetailEventSource masterDetailSource) {
        this.masterDetailSource = masterDetailSource;

        BarraDeFerramentasFinal ferramentasFormularioMaster = new BarraDeFerramentasFinal(masterDetailSource);
        this.masterDetailSource.addMasterDetailListener(ferramentasFormularioMaster);
        formMaster.getChildren().add(new Label("FORMULÁRIO MASTER"));

        formMaster.getChildren().add(new VBox(lblNome, edtNome));

        formMaster.getChildren().add(new VBox(lblFone, edtFone));

        formMaster.getChildren().add(new VBox(lblEmail, edtEmail));

        formMaster.getChildren().add(ferramentasFormularioMaster.createBarraFinalizacao());

        BarraDeStatus status = new BarraDeStatus();
        formMaster.getChildren().add(status);
        this.masterDetailSource.addMasterDetailListener(status);

        formMaster.setPrefSize(400, 200);
    }

    public VBox getScreen() {

        return this.formMaster;
    }

    @Override
    public void inicioCadastro(final MasterDetailEvent e) {
        edtNome.disableProperty().set(true);
        edtFone.disableProperty().set(true);
        edtEmail.disableProperty().set(true);
        edtNome.textProperty().set("");
        edtNome.setPromptText("nome");
        edtFone.textProperty().set("");
        edtFone.setPromptText("telefone");
        edtEmail.textProperty().set("");
        edtEmail.setPromptText("email");
    }

    @Override
    public void gravacaoRegistro(final MasterDetailEvent e) {

    }

    @Override
    public void cancelamentoRegistro(final MasterDetailEvent e) {

    }

    @Override
    public void insercaoRegistro(final MasterDetailEvent e) {

    }

    @Override
    public void alteracaoRegistro(final MasterDetailEvent e) {
        edtNome.disableProperty().set(false);
        edtFone.disableProperty().set(false);
        edtEmail.disableProperty().set(false);
    }

    @Override
    public void exclusaoRegistro(final MasterDetailEvent e) {

    }

    @Override
    public void pesquisaRegistro(final MasterDetailEvent e) {

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
        TableView<Pessoa> table = (TableView<Pessoa>) event.getSource();
        if (table.getSelectionModel().getSelectedItem() != null) {
            Pessoa pessoa = table.getSelectionModel().getSelectedItems().get(0);
            edtNome.textProperty().setValue(pessoa.getNome());
            edtFone.textProperty().setValue(pessoa.getFone());
            edtEmail.textProperty().setValue(pessoa.getEmail());

            edtNome.disableProperty().set(true);
            edtFone.disableProperty().set(true);
            edtEmail.disableProperty().set(true);
        }
    }

    @Override
    public void reiniciaPesquisa(final MasterDetailEvent event) {

    }
}

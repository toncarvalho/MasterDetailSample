package masterdetailsample.screens;

import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import masterdetailsample.components.BarraDeStatusDetalhe;
import masterdetailsample.components.ToolBarFinalDetalhe;
import masterdetailsample.eventos.masterdetail.DetailEventListener;
import masterdetailsample.eventos.masterdetail.MasterDetailEvent;
import masterdetailsample.eventos.masterdetail.MasterDetailEventSource;
import masterdetailsample.model.Contato;

/**
 * Interface de cadastro de subformulário.
 */
public class InterfaceCadastroDetail implements DetailEventListener {

    private VBox boxSubformularioCadastro = new VBox();
    private MasterDetailEventSource masterDetailSource;
    private Label lblNome = new Label("None:");
    private TextField edtNome = new TextField();
    private Label lblFone = new Label("Fone:");
    private TextField edtFone = new TextField();

    private BarraDeStatusDetalhe status = new BarraDeStatusDetalhe();

    private Contato entidade;

    public InterfaceCadastroDetail(final MasterDetailEventSource masterDetailSource) {
        this.masterDetailSource = masterDetailSource;

        ToolBarFinalDetalhe toolBarFinalDetalhe = new ToolBarFinalDetalhe(masterDetailSource);

        toolBarFinalDetalhe.salvar.setOnAction(event -> {
            entidade.setNome(edtNome.textProperty().getValue());
            entidade.setFone(edtFone.textProperty().getValue());
            //implementar gravacao registro detalhe
            this.masterDetailSource.gravacaoRegistro(entidade);
        });
        toolBarFinalDetalhe.cancelar.setOnAction(event -> {
            this.masterDetailSource.cancelamentoRegistro(entidade);
        });

        this.masterDetailSource.addDetailListener(toolBarFinalDetalhe);
        boxSubformularioCadastro.getChildren().add(new Label("SUBFORMULÁRIO DE CADASTRO"));

        boxSubformularioCadastro.getChildren().add(new VBox(lblNome, edtNome));

        boxSubformularioCadastro.getChildren().add(new VBox(lblFone, edtFone));

        boxSubformularioCadastro.getChildren().add(toolBarFinalDetalhe.createBarraFinalizacao());

        BarraDeStatusDetalhe status = new BarraDeStatusDetalhe();
        boxSubformularioCadastro.getChildren().add(status);
        this.masterDetailSource.addDetailListener(status);

        boxSubformularioCadastro.setPrefSize(400, 200);
    }

    public VBox getScreen() {

        return this.boxSubformularioCadastro;
    }

    @Override
    public void selecaoDeIten(final MasterDetailEvent event) {

    }

    @Override
    public void reiniciaPesquisa(final MasterDetailEvent event) {

    }

    @Override
    public void insercaoRegistroDetalhe(final MasterDetailEvent e) {
        entidade = new Contato();
        edtNome.disableProperty().set(false);
        edtFone.disableProperty().set(false);

        edtNome.textProperty().set("");
        edtNome.setPromptText("nome");
        edtFone.textProperty().set("");
        edtFone.setPromptText("telefone");
    }

    @Override
    public void alteracaoRegistroDetalhe(final MasterDetailEvent e) {
        edtNome.disableProperty().set(false);
        edtFone.disableProperty().set(false);
    }

    @Override
    public void exclusaoRegistroDetalhe(final MasterDetailEvent e) {

    }

    @Override
    public void pesquisaRegistroDetalhe(final MasterDetailEvent e) {

        edtNome.textProperty().set("");
        edtNome.setPromptText("nome");
        edtFone.textProperty().set("");
        edtFone.setPromptText("telefone");
    }

    @Override
    public void gravacaoRegistroDetalhe(final MasterDetailEvent e) {

    }

    @Override
    public void cancelamentoRegistroDetalhe(final MasterDetailEvent e) {
        edtNome.disableProperty().set(true);
        edtFone.disableProperty().set(true);
    }

    @Override
    public void selecaoDeItenDetalhe(final MasterDetailEvent event) {

        System.out.println(this.getClass().getName() + " selecionando item");
        if (event.getSource() != null && event.getSource() instanceof TableView) {
            TableView<Contato> table = (TableView<Contato>) event.getSource();
            if (table.getSelectionModel().getSelectedItem() != null) {
                entidade = table.getSelectionModel().getSelectedItems().get(0);
                edtNome.textProperty().setValue(entidade.getNome());
                edtFone.textProperty().setValue(entidade.getFone());

                edtNome.disableProperty().set(true);
                edtFone.disableProperty().set(true);
            }
        } else if (event.getSource() != null && event.getSource() instanceof Contato) {
            entidade = (Contato) event.getSource();
            edtNome.textProperty().setValue(entidade.getNome());
            edtFone.textProperty().setValue(entidade.getFone());

            edtNome.disableProperty().set(true);
            edtFone.disableProperty().set(true);
        } else {
            edtNome.disableProperty().set(true);
            edtFone.disableProperty().set(true);
        }
    }

    @Override
    public void inicioCadastroDetalhe(final MasterDetailEvent event) {

        edtNome.disableProperty().set(true);
        edtFone.disableProperty().set(true);

        edtNome.textProperty().set("");
        edtNome.setPromptText("nome");
        edtFone.textProperty().set("");
        edtFone.setPromptText("telefone");
    }
}
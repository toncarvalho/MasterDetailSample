package masterdetailsample.screens;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import masterdetailsample.components.BarraDeStatusDetalhe;
import masterdetailsample.components.ToolBarFinalDetalhe;
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

    private BarraDeStatusDetalhe status = new BarraDeStatusDetalhe();

    private Contato entidade;
    private Pessoa pessoaSelecionada;

    public InterfaceCadastroDetail(final MasterDetailEventSource masterDetailSource) {
        this.masterDetailSource = masterDetailSource;
        this.masterDetailSource.addDetailListener(this);
        this.masterDetailSource.addMasterListener(this);

        ToolBarFinalDetalhe toolBarFinalDetalhe = new ToolBarFinalDetalhe(masterDetailSource);

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

        toolBarFinalDetalhe.salvar.setOnAction(event -> {

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
    public void inicioCadastro(final MasterDetailEvent e) {

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

    }

    @Override
    public void exclusaoRegistro(final MasterDetailEvent e) {

    }

    @Override
    public void pesquisaRegistro(final MasterDetailEvent e) {

    }

    @Override
    public void selecaoDeIten(final MasterDetailEvent event) {

        if (event.getSource() != null && event.getSource() instanceof Pessoa) {
            this.pessoaSelecionada = (Pessoa) event.getSource();
        } else if (event.getSource() != null && event.getSource() instanceof TableView) {
            TableView<Pessoa> tablePessoas = (TableView<Pessoa>) event.getSource();
            if (tablePessoas.getSelectionModel().getSelectedItem() != null) {
                pessoaSelecionada = tablePessoas.getSelectionModel().getSelectedItems().get(0);
            }
        }
        System.out.println(" ouviu selecaoDeIten em:" + this.getClass().getName());
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
    public void inicioCadastroDetalhe(final MasterDetailEvent event) {

        edtNome.disableProperty().set(true);
        edtFone.disableProperty().set(true);

        edtNome.textProperty().set("");
        edtNome.setPromptText("nome");
        edtFone.textProperty().set("");
        edtFone.setPromptText("telefone");
    }
}

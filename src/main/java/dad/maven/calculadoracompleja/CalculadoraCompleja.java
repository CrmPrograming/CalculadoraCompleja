package dad.maven.calculadoracompleja;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CalculadoraCompleja extends Application {
	
	private ComboBox<String> cbOperador;
	private TextField tfNumeradorA;
	private TextField tfNumeradorB;
	private TextField tfDenominadorA;
	private TextField tfDenominadorB;
	private TextField tfResultadoA;
	private TextField tfResultadoB;
	
	private String[] _operador = {"+", "-", "*", "/"};

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		cbOperador = new ComboBox<String>();
		cbOperador.getItems().addAll(_operador);
		cbOperador.getSelectionModel().selectFirst();
		
		VBox vbOperacion = new VBox();
		vbOperacion.getChildren().add(cbOperador);
		
		tfNumeradorA = new TextField();
		tfNumeradorA.setPrefColumnCount(2);
		tfNumeradorA.setMaxWidth(100);
		tfNumeradorA.setAlignment(Pos.CENTER);
		
		tfNumeradorB = new TextField();
		tfNumeradorB.setPrefColumnCount(2);
		tfNumeradorB.setMaxWidth(100);
		tfNumeradorB.setAlignment(Pos.CENTER);
		
		HBox hbNumerador = new HBox();
		hbNumerador.setSpacing(5);
		hbNumerador.getChildren().addAll(tfNumeradorA, new Label("+"), tfNumeradorB, new Label("i"));
		
		tfDenominadorA = new TextField();
		tfDenominadorA.setPrefColumnCount(2);
		tfDenominadorA.setMaxWidth(100);
		tfDenominadorA.setAlignment(Pos.CENTER);
		
		tfDenominadorB = new TextField();
		tfDenominadorB.setPrefColumnCount(2);
		tfDenominadorB.setMaxWidth(100);
		tfDenominadorB.setAlignment(Pos.CENTER);
		
		HBox hbDenominador = new HBox();
		hbDenominador.setSpacing(5);
		hbDenominador.getChildren().addAll(tfDenominadorA, new Label("+"), tfDenominadorB, new Label("i"));
		
		tfResultadoA = new TextField();
		tfResultadoA.setPrefColumnCount(2);
		tfResultadoA.setMaxWidth(100);
		tfResultadoA.setAlignment(Pos.CENTER);
		tfResultadoA.setEditable(false);
		
		tfResultadoB = new TextField();
		tfResultadoB.setPrefColumnCount(2);
		tfResultadoB.setMaxWidth(100);
		tfResultadoB.setAlignment(Pos.CENTER);
		tfResultadoB.setEditable(false);
		
		HBox hbResultado = new HBox();
		hbResultado.setSpacing(5);
		hbResultado.getChildren().addAll(tfResultadoA, new Label("+"), tfResultadoB, new Label("i"));
		
		VBox vbNumeros = new VBox();
		vbNumeros.getChildren().addAll(hbNumerador, hbDenominador, new Separator(), hbResultado);
		
		HBox root = new HBox();
		root.setSpacing(5);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(vbOperacion, vbNumeros);
		
		Scene escena = new Scene(root, 320, 200);
		
		primaryStage.setScene(escena);
		primaryStage.setTitle("IMC");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}

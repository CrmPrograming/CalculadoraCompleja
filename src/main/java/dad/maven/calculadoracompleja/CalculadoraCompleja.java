package dad.maven.calculadoracompleja;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class CalculadoraCompleja extends Application {
	
	private ComboBox<String> cbOperador;
	private TextField tfNumeradorA;
	private TextField tfNumeradorB;
	private TextField tfDenominadorA;
	private TextField tfDenominadorB;
	private TextField tfResultadoA;
	private TextField tfResultadoB;
	
	private Complejo complejoA;
	private Complejo complejoB;
	private Complejo resultado;
	
	private String[] _operador = {"+", "-", "*", "/"};
	
	private void onCambiarAction(ActionEvent e) {
		String operacion = cbOperador.getSelectionModel().getSelectedItem();
		Complejo aux = new Complejo();
		
		switch (operacion) {
			case "+":
				aux = complejoA.add(complejoB);
			break;
			case "-":
				aux = complejoA.substract(complejoB);
			break;
			case "*":
				aux = complejoA.multiply(complejoB);
			break;
			case "/":
				aux = complejoA.divide(complejoB);
			break;
		}
		resultado.setReal(aux.getReal());
		resultado.setImaginario(aux.getImaginario());
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		// Selector de operación
		
		cbOperador = new ComboBox<String>();
		cbOperador.getItems().addAll(_operador);
		cbOperador.getSelectionModel().selectFirst();
		cbOperador.setOnAction(e -> onCambiarAction(e));
		
		VBox vbOperacion = new VBox();
		vbOperacion.getChildren().add(cbOperador);
		vbOperacion.setAlignment(Pos.CENTER);
		
		// Campos para números complejos
		
		// Primer número
		
		tfNumeradorA = new TextField("0");
		tfNumeradorA.setPrefColumnCount(4);
		tfNumeradorA.setMaxWidth(100);
		tfNumeradorA.setAlignment(Pos.CENTER);
		
		tfNumeradorB = new TextField("0");
		tfNumeradorB.setPrefColumnCount(4);
		tfNumeradorB.setMaxWidth(100);
		tfNumeradorB.setAlignment(Pos.CENTER);
		
		HBox hbNumerador = new HBox();
		hbNumerador.setSpacing(5);
		hbNumerador.getChildren().addAll(tfNumeradorA, new Label("+"), tfNumeradorB, new Label("i"));
		
		complejoA = new Complejo();
		
		Bindings.bindBidirectional(tfNumeradorA.textProperty(), complejoA.realProperty(), new NumberStringConverter());
		Bindings.bindBidirectional(tfNumeradorB.textProperty(), complejoA.imaginarioProperty(), new NumberStringConverter());
		
		// Segundo número
		
		tfDenominadorA = new TextField("0");
		tfDenominadorA.setPrefColumnCount(4);
		tfDenominadorA.setMaxWidth(100);
		tfDenominadorA.setAlignment(Pos.CENTER);
		
		tfDenominadorB = new TextField("0");
		tfDenominadorB.setPrefColumnCount(4);
		tfDenominadorB.setMaxWidth(100);
		tfDenominadorB.setAlignment(Pos.CENTER);
		
		HBox hbDenominador = new HBox();
		hbDenominador.setSpacing(5);
		hbDenominador.getChildren().addAll(tfDenominadorA, new Label("+"), tfDenominadorB, new Label("i"));
		
		complejoB = new Complejo();
		
		Bindings.bindBidirectional(tfDenominadorA.textProperty(), complejoB.realProperty(), new NumberStringConverter());
		Bindings.bindBidirectional(tfDenominadorB.textProperty(), complejoB.imaginarioProperty(), new NumberStringConverter());
		
		// Número resultante
		
		tfResultadoA = new TextField("0");
		tfResultadoA.setPrefColumnCount(4);
		tfResultadoA.setMaxWidth(100);
		tfResultadoA.setAlignment(Pos.CENTER);
		tfResultadoA.setDisable(true);
		
		tfResultadoB = new TextField("0");
		tfResultadoB.setPrefColumnCount(4);
		tfResultadoB.setMaxWidth(100);
		tfResultadoB.setAlignment(Pos.CENTER);
		tfResultadoB.setDisable(true);
		
		resultado = new Complejo();
		
		Bindings.bindBidirectional(tfResultadoA.textProperty(), resultado.realProperty(), new NumberStringConverter());
		Bindings.bindBidirectional(tfResultadoB.textProperty(), resultado.imaginarioProperty(), new NumberStringConverter());
		
		HBox hbResultado = new HBox();
		hbResultado.setSpacing(5);
		hbResultado.getChildren().addAll(tfResultadoA, new Label("+"), tfResultadoB, new Label("i"));
		
		VBox vbNumeros = new VBox();
		vbNumeros.setAlignment(Pos.CENTER);
		vbNumeros.getChildren().addAll(hbNumerador, hbDenominador, new Separator(), hbResultado);
		
		// Root
		
		HBox root = new HBox();
		root.setSpacing(5);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(vbOperacion, vbNumeros);
		
		Scene escena = new Scene(root, 320, 200);
		
		primaryStage.setScene(escena);
		primaryStage.setTitle("CalculadoraCompleja");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}

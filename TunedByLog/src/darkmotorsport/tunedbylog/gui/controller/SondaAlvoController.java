package darkmotorsport.tunedbylog.gui.controller;

import java.util.ArrayList;
import java.util.List;

import darkmotorsport.tunedbylog.gui.model.AlvoSondaLambda;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class SondaAlvoController {

	@FXML
	TextField mapPos1;
	@FXML
	TextField mapPos2;
	@FXML
	TextField mapPos3;
	@FXML
	TextField mapPos4;
	@FXML
	TextField mapPos5;
	@FXML
	TextField lambdaPos5;
	@FXML
	TextField lambdaPos4;
	@FXML
	TextField lambdaPos3;
	@FXML
	TextField lambdaPos2;
	@FXML
	TextField lambdaPos1;

	@FXML
	private void initialize() {
	}

	public List<AlvoSondaLambda> alvos = new ArrayList<>();

	@FXML
	public void gravar() {
		alvos.clear();
		alvos.add(new AlvoSondaLambda(getValorFloatTextField(mapPos1), getValorFloatTextField(lambdaPos1)));
		alvos.add(new AlvoSondaLambda(getValorFloatTextField(mapPos2), getValorFloatTextField(lambdaPos2)));
		alvos.add(new AlvoSondaLambda(getValorFloatTextField(mapPos3), getValorFloatTextField(lambdaPos3)));
		alvos.add(new AlvoSondaLambda(getValorFloatTextField(mapPos4), getValorFloatTextField(lambdaPos4)));
		alvos.add(new AlvoSondaLambda(getValorFloatTextField(mapPos5), getValorFloatTextField(lambdaPos5)));
		
		mapPos1.getScene().getWindow().hide();
	}

	private float getValorFloatTextField(TextField tf) {
		String replace = tf.getText().replace(',', '.');
		float parseFloat = 0f;
		if (!replace.isEmpty()) {
			parseFloat = Float.parseFloat(replace);
		}
		return parseFloat;
	}

}

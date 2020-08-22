package darkmotorsport.tunedbylog.gui.model;

import java.util.ArrayList;
import java.util.List;

import darkmotorsport.tunedbylog.gui.Mainapp;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class CellEditavel extends TableCell<DadoTabelaMap, String> {

	private TextField textField;

	public CellEditavel() {
	}

	@Override
	public void startEdit() {

		if (!(getTableRow().getIndex() == 0 || getTableRow().getIndex() == 2 || getTableRow().getIndex() == 4)) {
			return;
		}

		if (!isEmpty()) {
			super.startEdit();
			if (textField == null) {
				createTextField();
			}

			setGraphic(textField);
			setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
			// textField.selectAll();
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					textField.requestFocus();
					textField.selectAll();
				}
			});
		}
	}

	@Override
	public void cancelEdit() {
		super.cancelEdit();

		setText((String) getItem());
		setGraphic(null);
	}

	@Override
	public void updateItem(String item, boolean empty) {
		super.updateItem(item, empty);

		this.setStyle("");

		if (empty) {
			setText(null);
			setGraphic(null);
		} else {
			if (isEditing()) {
				if (textField != null) {
					textField.setText(getString());
				}
				setGraphic(textField);
				setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
			} else {
				setText(getString());
				setContentDisplay(ContentDisplay.TEXT_ONLY);
			}

			if ((getTableRow().getIndex() == 2 || getTableRow().getIndex() == 4)) {
				getTableRow().setStyle("-fx-background-color:lightgreen");
			} else if (getTableRow().getIndex() == 0) {
				getTableRow().setStyle("-fx-background-color:lightskyblue;-fx-font-weight:bold");

			} else if (getTableRow().getIndex() == 7) {

				if (getString() == "-") {
					this.setStyle("");
					return;
				}

				if (Float.parseFloat(getString()) < 100f) {
					this.setStyle("-fx-background-color:crimson");
				} else if (Float.parseFloat(getString()) >= 100 && Integer.parseInt(getString()) < 250f) {
					this.setStyle("-fx-background-color:sandybrown ");
				} else {
					this.setStyle("-fx-background-color:lightblue");
				}

			} else {
				getTableRow().setStyle("");
			}

		}

	}

	private void createTextField() {
		textField = new TextField(getString());
		textField.setMinWidth(this.getWidth() - this.getGraphicTextGap() * 2);

		textField.focusedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2) {
				if (!arg2) {
					commitEdit(textField.getText());
					setText((String) getItem());
				}
			}
		});

		textField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				newValue = newValue.replace(',', '.');
//				if (!newValue.matches("-?\\d*(\\.\\d{0,2})?")) {
				if (!newValue.matches("-?\\d{0,2}(\\.\\d{0,3})?")) {
					textField.setText(oldValue);
				} else {
					textField.setText(newValue);
				}
			}
		});

		textField.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@SuppressWarnings({ "rawtypes", "unchecked" })
			@Override
			public void handle(KeyEvent t) {
				if (t.getCode() == KeyCode.ENTER) {
					comitar();
				} else if (t.getCode() == KeyCode.ESCAPE) {
					cancelEdit();
				} else if (t.getCode() == KeyCode.TAB) {
					comitar();
					TableColumn nextColumn = getNextColumn(!t.isShiftDown());
					if (nextColumn != null) {
						getTableView().edit(getTableRow().getIndex(), nextColumn);
					}

				}
			}

			private void comitar() {
				commitEdit(textField.getText());
				if (getTableRow().getIndex() == 2 || getTableRow().getIndex() == 0) {
					Mainapp.tabelaContr.configurarGrafico();
				}
			}

		});

	}

	private String getString() {
		return getItem() == null ? "" : getItem().toString();
	}

	private TableColumn<DadoTabelaMap, ?> getNextColumn(boolean forward) {
		List<TableColumn<DadoTabelaMap, ?>> columns = new ArrayList<>();
		for (TableColumn<DadoTabelaMap, ?> column : getTableView().getColumns()) {
			columns.addAll(getLeaves(column));
		}
		// There is no other column that supports editing.
		if (columns.size() < 2) {
			return null;
		}
		int currentIndex = columns.indexOf(getTableColumn());
		int nextIndex = currentIndex;
		if (forward) {
			nextIndex++;
			if (nextIndex > columns.size() - 1) {
				nextIndex = 0;
			}
		} else {
			nextIndex--;
			if (nextIndex < 0) {
				nextIndex = columns.size() - 1;
			}
		}
		return columns.get(nextIndex);
	}

	private List<TableColumn<DadoTabelaMap, ?>> getLeaves(TableColumn<DadoTabelaMap, ?> root) {
		List<TableColumn<DadoTabelaMap, ?>> columns = new ArrayList<>();
		if (root.getColumns().isEmpty()) {
			// We only want the leaves that are editable.
			if (root.isEditable()) {
				columns.add(root);
			}
			return columns;
		} else {
			for (TableColumn<DadoTabelaMap, ?> column : root.getColumns()) {
				columns.addAll(getLeaves(column));
			}
			return columns;
		}
	}
}
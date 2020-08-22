package darkmotorsport.tunedbylog.gui.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import darkmotorsport.tunedbylog.gui.controller.PaginaInicialAbaRPM;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumnBase;
import javafx.scene.control.TableRow;
import javafx.scene.control.Tooltip;

public class CellMapRpm extends TableCell<LinhaMapRpm, String> {

	public CellMapRpm() {
	}

	@SuppressWarnings("rawtypes")
	@Override
	protected void updateItem(String item, boolean empty) {
		super.updateItem(item, empty);
		if (item == null)
			return;
		this.setText(item);

		TableRow tableRow = this.getTableRow();

		if (tableRow != null) {

			LinhaMapRpm rowDataItem = (LinhaMapRpm) tableRow.getItem();

			if (rowDataItem != null) {

				List<TableColumn<LinhaMapRpm, ?>> columns = new ArrayList<>();
				for (TableColumn<LinhaMapRpm, ?> column : getTableView().getColumns()) {
					columns.add(column);
				}
				TableColumn<LinhaMapRpm, String> tableColumn = getTableColumn();

				TableColumnBase<LinhaMapRpm, ?> parentColumn = tableColumn.getParentColumn();

				int currentIndex = columns.indexOf(parentColumn);

				CelulaMapRpm celulaMapRpm = rowDataItem.getListaCelulas().get(currentIndex);
				Tooltip tooltip = new Tooltip();
				BigDecimal rpm = celulaMapRpm.getRpm();
				BigDecimal correcao = celulaMapRpm.getCorrecao();
				BigDecimal autoCorrecao = celulaMapRpm.getAutoCorrecao();
				int qtdAmostras = celulaMapRpm.getValoresSonda().size();

				BigDecimal valorTempAr = celulaMapRpm.getValorTempAr();
				BigDecimal valorPressaoComb = celulaMapRpm.getValorPressaoComb();
				BigDecimal valorPressaoOleo = celulaMapRpm.getValorPressaoOleo();
				BigDecimal valorBateriaTensao = celulaMapRpm.getValorBateriaTensao();
				BigDecimal valorTemperaturaMotor = celulaMapRpm.getValorTemperaturaMotor();

				StringBuffer sb = new StringBuffer();
				sb.append("RPM: ");
				sb.append(rpm);

				if (celulaMapRpm.getMap() != null) {
					sb.append("\n");
					sb.append("Map: ");
					sb.append(celulaMapRpm.getMap());
				}

				if (valorTempAr != null) {
					sb.append("\n");
					sb.append("IAT: ");
					sb.append(valorTempAr);
				}
				if (valorTemperaturaMotor != null) {
					sb.append("\n");
					sb.append("CLT: ");
					sb.append(valorTemperaturaMotor);
				}
				
				if (valorPressaoComb != null) {
					sb.append("\n");
					sb.append("Pressão Comb.: ");
					sb.append(valorPressaoComb);
				}
				if (valorPressaoOleo != null) {
					sb.append("\n");
					sb.append("Pressão óleo: ");
					sb.append(valorPressaoOleo);
				}
				if (valorBateriaTensao != null) {
					sb.append("\n");
					sb.append("Tensão Bat.: ");
					sb.append(valorBateriaTensao);
				}

				if (celulaMapRpm.getSondaAlvo() != null) {
					sb.append("\n");
					sb.append("Lamba Alvo: ");
					sb.append(celulaMapRpm.getSondaAlvo());
				}

				if (celulaMapRpm.getSondaMedia() != null) {
					sb.append("\n");
					sb.append("Lamda Média: ");
					sb.append(celulaMapRpm.getSondaMedia());
				}

				if (celulaMapRpm.getAutoCorrecao() != null) {
					sb.append("\n");
					sb.append("Auto Correção Sonda: ");
					sb.append(celulaMapRpm.getAutoCorrecao() + "%");
				}

				if (correcao != null) {
					sb.append("\n");
					sb.append("Correção: ");
					sb.append(correcao + "%");
				}

				if (celulaMapRpm.getTempoInjecaoMedia() != null) {
					sb.append("\n");
					sb.append("mS Média: ");
					sb.append(celulaMapRpm.getTempoInjecaoMedia());
				}

				if (celulaMapRpm.getTempoInjecaoMediaCorrigida() != null) {
					sb.append("\n");
					sb.append("mS Corrigido: ");
					sb.append(celulaMapRpm.getTempoInjecaoMediaCorrigida());
				}

				sb.append("\n");
				sb.append("Qtd amostras: ");
				sb.append(qtdAmostras);

				tooltip.textProperty().setValue(sb.toString());
				this.setTooltip(tooltip);

				this.setStyle("");
				String text = this.getText();

				if (text.equals("") || correcao == null) {
					this.setStyle("");
				} else {

					switch (PaginaInicialAbaRPM.selecaoTabelaCor) {
					case CORRECAO:
						if (correcao.compareTo(new BigDecimal(-1)) >= 0 && correcao.compareTo(new BigDecimal(1)) <= 0) {
							this.setStyle("-fx-background-color:lightslategray");
						}

						if (correcao.compareTo(new BigDecimal(1)) > 0) {
							this.setStyle("-fx-background-color:limegreen ");
						}

						if (correcao.compareTo(new BigDecimal(5)) >= 0) {
							this.setStyle("-fx-background-color:greenyellow ");
						}

						if (correcao.compareTo(new BigDecimal(10)) >= 0) {
							this.setStyle("-fx-background-color:cyan ");
						}

						if (correcao.compareTo(new BigDecimal(-1)) < 0) {
							this.setStyle("-fx-background-color:sandybrown ");
						}

						if (correcao.compareTo(new BigDecimal(-5)) <= 0) {
							this.setStyle("-fx-background-color:orangered ");
						}

						if (correcao.compareTo(new BigDecimal(-10)) <= 0) {
							this.setStyle("-fx-background-color:crimson ");
						}

						break;
					case QTD_AMOSTRAS:

						if (qtdAmostras >= 0 && qtdAmostras <= 5) {
							this.setStyle("-fx-background-color:crimson");
						}
						if (qtdAmostras > 5 && qtdAmostras <= 50) {
							this.setStyle("-fx-background-color:sandybrown ");
						}
						if (qtdAmostras > 50 && qtdAmostras <= 100) {
							this.setStyle("-fx-background-color:lightblue ");
						}
						if (qtdAmostras > 100) {
							this.setStyle("-fx-background-color:royalblue ");
						}

						break;

					case AUTO_CORRECAO:
						if (autoCorrecao.compareTo(new BigDecimal(-1)) >= 0 && autoCorrecao.compareTo(new BigDecimal(1)) <= 0) {
							this.setStyle("-fx-background-color:lightslategray");
						}

						if (autoCorrecao.compareTo(new BigDecimal(1)) > 0) {
							this.setStyle("-fx-background-color:limegreen ");
						}

						if (autoCorrecao.compareTo(new BigDecimal(5)) >= 0) {
							this.setStyle("-fx-background-color:greenyellow ");
						}

						if (autoCorrecao.compareTo(new BigDecimal(10)) >= 0) {
							this.setStyle("-fx-background-color:cyan ");
						}

						if (autoCorrecao.compareTo(new BigDecimal(-1)) < 0) {
							this.setStyle("-fx-background-color:sandybrown ");
						}

						if (autoCorrecao.compareTo(new BigDecimal(-5)) <= 0) {
							this.setStyle("-fx-background-color:orangered ");
						}

						if (autoCorrecao.compareTo(new BigDecimal(-10)) <= 0) {
							this.setStyle("-fx-background-color:crimson ");
						}

						break;

					default:
						break;
					}

//
//					BigDecimal valorCelula = new BigDecimal(text).setScale(2, RoundingMode.HALF_EVEN);
//					
//					
//
//					switch (PaginaInicialAbaRPM.selecaoTabela) {
//					case CORRECAO:
//
//						if (correcao.compareTo(BigDecimal.ZERO) == 0) {
//							this.setStyle("-fx-background-color:lightslategray ");
//						}
//
//						if (valorCelula.compareTo(BigDecimal.ZERO) > 0) {
//							this.setStyle("-fx-background-color:limegreen ");
//						}
//
//						if (valorCelula.compareTo(new BigDecimal(5).setScale(2, RoundingMode.HALF_EVEN)) >= 0) {
//							this.setStyle("-fx-background-color:royalblue ");
//						}
//
//						if (valorCelula.compareTo(BigDecimal.ZERO) < 0) {
//							this.setStyle("-fx-background-color:orangered ");
//						}
//
//						if (valorCelula.compareTo(new BigDecimal(-5).setScale(2, RoundingMode.HALF_EVEN)) <= 0) {
//							this.setStyle("-fx-background-color:crimson");
//						}
//
//						this.setText(this.getText() + "%");
//
//						break;
//					case LAMBDA_ALVO:
//						this.setStyle("");
//						break;
//					case LAMBDA_MEDIA:
//
//						if (valorCelula.compareTo(new BigDecimal(0.98)) >= 0 && valorCelula.compareTo(new BigDecimal(1.02)) < 0) {
//							this.setStyle("-fx-background-color:lightblue");
//						}
//
//						if (valorCelula.compareTo(new BigDecimal(1.03).setScale(2, RoundingMode.HALF_EVEN)) >= 0) {
//							this.setStyle("-fx-background-color:crimson ");
//						}
//
//						if (valorCelula.compareTo(new BigDecimal(0.98).setScale(2, RoundingMode.HALF_EVEN)) < 0) {
//							this.setStyle("-fx-background-color:sandybrown ");
//						}
//
//						if (valorCelula.compareTo(new BigDecimal(0.90).setScale(2, RoundingMode.HALF_EVEN)) <= 0) {
//							this.setStyle("-fx-background-color:limegreen");
//						}
//
//						if (valorCelula.compareTo(new BigDecimal(0.82).setScale(2, RoundingMode.HALF_EVEN)) <= 0) {
//							this.setStyle("-fx-background-color:greenyellow ");
//						}
//
//						if (valorCelula.compareTo(new BigDecimal(0.78).setScale(2, RoundingMode.HALF_EVEN)) <= 0) {
//							this.setStyle("-fx-background-color:cyan");
//						}
//
//						break;
//
//					default:
//						break;
//					}
				}

			}
		}
	}
}

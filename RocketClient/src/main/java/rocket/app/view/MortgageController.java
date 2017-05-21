package rocket.app.view;

import eNums.eAction;
import exceptions.LoanRequestException;
import exceptions.RateException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import rocket.app.MainApp;
import rocketCode.Action;
import rocketData.LoanRequest;

public class MortgageController {

	@FXML private TextField txtCreditScore;
	@FXML private Label lblMortgagePayment;
	@FXML private TextField txtIncome;
	@FXML private TextField txtHouseCost;
	@FXML private ComboBox cmbTerm;
	@FXML private TextField txtExpenses;
	@FXML private TextField txtDownPayment;
	@FXML private Button btnCalculate;
	
	private TextField txtNew;
	
	private MainApp mainApp;
	

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	
	@FXML
	public void btnCalculatePayment(ActionEvent event)
	{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Message Here...");
		alert.setHeaderText("Look, an Information Dialog");
		alert.setContentText(txtNew.getText());
		alert.showAndWait().ifPresent(rs -> {
		    if (rs == ButtonType.OK) {
		        System.out.println("Pressed OK.");
		    }
		});
	}

	
	public void HandleLoanRequestDetails(LoanRequest lRequest)
	{
		lblMortgagePayment.setText(String.format("%.2f", Math.abs(lRequest.getdPayment())));
		
}
	public void HandleExceptions (Exception e)
	{
		if (e instanceof LoanRequestException){
			
		}
		else if (e instanceof RateException){
			
		}
	}
}

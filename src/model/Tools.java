package model;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;

public class Tools {
private static Label actionStatus = new Label("");

	public static String requestID() {
		actionStatus.setText("");
		Dialog dialog = new TextInputDialog("Enter an ID");
		dialog.setTitle("ID");
		dialog.setHeaderText("Enter ID to search...");

		Optional<String> result = dialog.showAndWait();
		String entered = "none.";

		if (result.isPresent()) {
			entered = result.get();
		}
		actionStatus.setText("ID found!");
		return entered;
		// actionStatus.setText("Text entered: " + entered);
	}
	
	public static void SuccessAlert() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Alert!");
		alert.setHeaderText("Information Alert");
		String s ="The ID entered cannot be found!";
		alert.setContentText(s);
		alert.showAndWait();
	}

	public static void failureAlert(String message) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Alert!");
		alert.setHeaderText("Information Alert");
		String s = message;
		alert.setContentText(s);
		alert.showAndWait();
	}
	public static boolean inputCheck(TextField textField) {
		actionStatus.setText("");
		String txt = textField.getText().trim();
		String msg = "Text saved: ";

		if (txt.isEmpty()) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Alert");
			String s = "The field cannot be empty";
			alert.setContentText(s);
			alert.showAndWait();
				textField.requestFocus();
			actionStatus.setText("Failed to add the item!");
			return false;
		} else {
			actionStatus.setText("Succeed");
			return true;
		}

	}
	
	public static void confirm(String s) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Success!");
		alert.setContentText(s);
		actionStatus.setText("Succeed");
		Optional<ButtonType> result = alert.showAndWait();
	}
	
	public static Label getActionStatus() {
		return actionStatus;
	}
	
	

}
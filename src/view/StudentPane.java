package view;
import java.util.Arrays;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import model.College;
import model.Person;
import model.Tools;

public class StudentPane {
	private GridPane gridPane;
	private Button addBtn;
	private Button findBtn;
	private Button removeBtn;
	private Button updateBtn;
	private Button displayBtn;
	
	private TextField nameField;
	private TextField phoneField;

	public StudentPane(College college) {
		
		final int BUTTON_WIDTH = 110;
		final int TEXTFIELD_WIDTH = 250;
		
		gridPane = new GridPane();
		gridPane.setPadding(new Insets(30));
		gridPane.setHgap(20);
		gridPane.setVgap(30);
		HBox lblOut = new HBox(20);
		lblOut.setAlignment(Pos.CENTER);
	
		Label out = new Label(":-)");
		lblOut.getChildren().add(out);
		
		nameField = new TextField();
		nameField.setPromptText("Name");
		nameField.setPrefWidth(TEXTFIELD_WIDTH);
		
		phoneField = new TextField();
		phoneField.setPromptText("Phone");
		phoneField.setPrefWidth(TEXTFIELD_WIDTH);
		
		addBtn = new Button("ADD");
		addBtn.setPrefWidth(BUTTON_WIDTH);
		addBtn.setOnAction(e -> {
			Person person = new Person(nameField.getText(), phoneField.getText());
			college.getPersonBag().insert(person);
			nameField.clear();
			phoneField.clear();
		});
		
		// button used to search through the students by 
		// a given ID number
		findBtn = new Button("FIND BY ID");
		findBtn.setPrefWidth(BUTTON_WIDTH);
		findBtn.setOnAction(e -> {
			String id = Tools.requestID(); 
			try {
				out.setText(college.getPersonBag().findStudentById(id).getName().toString());				
			} catch (NullPointerException e1) {
				Tools.failureAlert("Could not find Student with the id: " + id);
				e1.printStackTrace();
			}
			
		});
		
		// button used to remove a student by a given
		// ID number
		removeBtn = new Button("Remove");
		removeBtn.setPrefWidth(BUTTON_WIDTH);
		updateBtn = new Button("Update");
		updateBtn.setPrefWidth(BUTTON_WIDTH);
		
		// displays the students in the college
		displayBtn = new Button("Display Students");
		displayBtn.setPrefWidth(BUTTON_WIDTH);
		displayBtn.setOnAction(e -> {
			out.setText(college.getPersonBag().StudentArrayToString());
		});
		HBox btnBox = new HBox(20);

		btnBox.setAlignment(Pos.CENTER);
		btnBox.getChildren().addAll(addBtn, findBtn, removeBtn, updateBtn, displayBtn);
	
		gridPane.add(nameField, 0, 0, 2, 1);
		gridPane.add(phoneField, 2, 0, 2, 1);
		gridPane.add(btnBox, 0, 2, 4, 1);
		gridPane.add(lblOut, 1, 3, 1, 1);
	}
	
	public GridPane getGridPane() {
		return gridPane;
	}
}
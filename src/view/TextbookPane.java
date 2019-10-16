package view;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import model.College;
import model.Name;
import model.Textbook;
import model.Tools;

public class TextbookPane {
	private GridPane gridPane;
	private Button addBtn;
	private Button findBtn;
	private Button removeBtn;
	private Button updateBtn;

	private TextField titleField;
	private TextField priceField;
	private TextField isbnField;
	private TextField authorField;
	private TextField publisherField;
	
	private Label actionStatus = new Label("HI");

	public TextbookPane(College college) {
		final int BUTTON_WIDTH = 110;
		final int TEXTFIELD_WIDTH = 250;
		gridPane = new GridPane();
		gridPane.setPadding(new Insets(30));
		gridPane.setHgap(20);
		gridPane.setVgap(30);
		
		titleField = new TextField();
		titleField.setPromptText("Name");
		titleField.setPrefWidth(TEXTFIELD_WIDTH);
		
		authorField = new TextField();
		authorField.setPromptText("Author");
		authorField.setPrefWidth(TEXTFIELD_WIDTH);
		
		publisherField = new TextField();
		publisherField.setPromptText("Publisher");
		publisherField.setPrefWidth(TEXTFIELD_WIDTH);
		
		isbnField = new TextField();
		isbnField.setPromptText("ISBN");
		isbnField.setPrefWidth(TEXTFIELD_WIDTH);

		priceField = new TextField();
		priceField.setPromptText("Price");
		priceField.setPrefWidth(TEXTFIELD_WIDTH);
	
		addBtn = new Button("ADD");
		addBtn.setPrefWidth(BUTTON_WIDTH);
		addBtn.setOnAction(e -> {
			actionStatus.setText("");
			if (Tools.inputCheck(titleField)) {
				String name = authorField.getText();
				String[] nameTokens;
				nameTokens=name.split(" ");
				Name authorName = new Name(nameTokens[1], nameTokens[2], " ");
				Textbook textbook = new Textbook(titleField.getText(), authorName, isbnField.getText(),
						publisherField.getText(), Double.parseDouble(priceField.getText()));
				college.getTextbookBag().add(textbook);
				titleField.clear();
				isbnField.clear();
				priceField.clear();
				actionStatus = Tools.getActionStatus();
			}
		});

		findBtn = new Button("FIND");
		findBtn.setPrefWidth(BUTTON_WIDTH);
		findBtn.setOnAction(e -> {
			String isbn = Tools.requestID();
			Textbook textbook = college.getTextbookBag().findByISBN(isbn);
			try {
				titleField.setText(textbook.getTitle());
				isbnField.setText(textbook.getIsbn());
				priceField.setText(String.valueOf(textbook.getPrice()));
			} catch (NullPointerException el) {
				Tools.failureAlert("Item not found");
			}
			
		});

		removeBtn = new Button("REMOVE");
		removeBtn.setPrefWidth(BUTTON_WIDTH);
		removeBtn.setOnAction(e -> {
			actionStatus.setText("");
			String isbn = Tools.requestID();
			Textbook textbook = college.getTextbookBag().removeByISBN(isbn);
			if(textbook != null) {
			titleField.setText(textbook.getTitle());
			isbnField.setText(textbook.getIsbn());
			priceField.setText(String.valueOf(textbook.getPrice()));
			Tools.confirm("Item removed.");
			titleField.clear();
			isbnField.clear();
			priceField.clear();
//			actionStatus = Util.getActionStatus();
			actionStatus.setText("Item removed");
			} else {
				Tools.failureAlert("Item cannot be found");
			}
		});
		
		
		updateBtn = new Button("UPDATE");
		updateBtn.setPrefWidth(BUTTON_WIDTH);

		HBox btnBox = new HBox(20);

		btnBox.setAlignment(Pos.CENTER);
		btnBox.getChildren().addAll(addBtn, findBtn, removeBtn, updateBtn);

		gridPane.add(titleField, 0, 0, 2, 1);
		gridPane.add(isbnField, 2, 0, 2, 1);
		gridPane.add(priceField, 4, 0, 2, 1);
		
		gridPane.add(btnBox, 0, 2, 6, 1);
		
		gridPane.add(actionStatus, 1,3,4,1);
	}

	public GridPane getGridPane() {
		return gridPane;
	}
	
	public Label getActionStatus() {
		return actionStatus;
	}
	
	
	
}


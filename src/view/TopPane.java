package view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Address;
import model.College;
import model.CourseBag;
import model.Faculty;
import model.Name;
import model.Person;
import model.PersonBag;
import model.Student;
import model.TextbookBag;
import model.Tools;

public class TopPane {
	// menubar object
	private MenuBar menuBar;
	// menu objects
	private Menu fileMenu;
	private Menu importMenu;
	private Menu exportMenu;
	private Menu operationMenu;
	// menuitem objects
	private MenuItem saveMenuItem;
	private MenuItem loadMenuItem;
	private MenuItem studentMenuItemImport;
	private MenuItem facultyMenuItemImport;
	private MenuItem courseMenuItemImport;
	private MenuItem textbookMenuItemImport;
	private MenuItem studentMenuItemExport;
	private MenuItem facultyMenuItemExport;
	private MenuItem courseMenuItemExport;
	private MenuItem textbookMenuItemExport;
	private MenuItem exitMenuItem;
	private MenuItem studentMenuItem;
	private MenuItem facultyMenuItem;
	private MenuItem textbookMenuItem;
	private MenuItem courseMenuItem;
	// bag objects
	private PersonBag personBag;
	private TextbookBag textbookBag;
	private CourseBag courseBag;

	public TopPane(College college) {
		buildFileMenu();
		buildOperationMenu();
		buildMenuBar();
		personBag = college.getPersonBag();
		textbookBag = college.getTextbookBag();
		courseBag = college.getCourseBag();
	}

	public void buildMenuBar() {
		menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu, operationMenu);
	}

	private void buildFileMenu() {
		final FileChooser fileChooser = new FileChooser();
		Stage stage = new Stage();

		fileMenu = new Menu("File");
		saveMenuItem = new MenuItem("Save");
		saveMenuItem.setOnAction(e -> {
			saveAll();
		});
		loadMenuItem = new MenuItem("Load");
		loadMenuItem.setOnAction(e -> {
			loadAll();
		});

		// import menu interface
		importMenu = new Menu("Import...");
		studentMenuItemImport = new MenuItem("Student");
		studentMenuItemImport.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				File file = fileChooser.showOpenDialog(stage);
				if (file != null) {
					try {
						Scanner scanner = new Scanner(file);
						while (scanner.hasNextLine()) {

							String line = scanner.nextLine();
							String[] nameTokens = line.split("[ ]+");
							Name name = new Name(nameTokens[0], nameTokens[2], nameTokens[1]);

							String phone = scanner.nextLine();

							String tempAddress = scanner.nextLine();
							String[] addressTokens = tempAddress.split("[,]+");
							String streetNumber = tempAddress.substring(0, tempAddress.indexOf(" "));
							Address address = new Address(streetNumber, addressTokens[0], addressTokens[1],
									addressTokens[2], addressTokens[3].trim());

							String major = scanner.nextLine();

							Student s = new Student(name, phone, address, major);
							personBag.insert(s);
						}
						Tools.confirm("Students successfully imported!");
					} catch (FileNotFoundException e1) {
						Tools.failureAlert("Failed to import file...");
					}
				}
			}
		});
		facultyMenuItemImport = new MenuItem("Faculty");
		facultyMenuItemImport.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(final ActionEvent e) {
				File file = fileChooser.showOpenDialog(stage);
				if (file != null) {
					try {
						Scanner scanner = new Scanner(file);
						while (scanner.hasNextLine()) {

							String line = scanner.nextLine();
							String[] nameTokens = line.split("[ ]+");
							Name name = new Name(nameTokens[0], nameTokens[2], nameTokens[1]);

							String phone = scanner.nextLine();

							String tempAddress = scanner.nextLine();
							String[] addressTokens = tempAddress.split("[,]+");
							String streetNumber = tempAddress.substring(0, tempAddress.indexOf(" "));
							Address address = new Address(streetNumber, addressTokens[0], addressTokens[1],
									addressTokens[2], addressTokens[3].trim());

							tempAddress = scanner.nextLine();
							String[] officeAddressTokens = tempAddress.split("[,]+");
							streetNumber = tempAddress.substring(0, tempAddress.indexOf(" "));
							Address officeAddress = new Address(streetNumber, officeAddressTokens[0],
									officeAddressTokens[1], officeAddressTokens[2], officeAddressTokens[3].trim());

							Double salary = scanner.nextDouble();
							scanner.nextLine();
							String title = scanner.nextLine();
							Faculty f = new Faculty(name, phone, address, officeAddress, salary, title);
							personBag.insert(f);
						}
						Tools.confirm("Faculty successfuly imported!");
					} catch (FileNotFoundException e1) {
						Tools.failureAlert("Failed to import file...");
					} catch (ArrayIndexOutOfBoundsException e1) {
						Tools.failureAlert("Failed to import file...");
					}
				}
			}
		});
		courseMenuItemImport = new MenuItem("Courses");
		courseMenuItemImport.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(final ActionEvent e) {
				File file = fileChooser.showOpenDialog(stage);
				if (file != null) {
					try {
						Scanner scanner = new Scanner(file);
					} catch (FileNotFoundException e1) {
					}
				}
			}
		});
		textbookMenuItemImport = new MenuItem("Textbook");
		textbookMenuItemImport.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(final ActionEvent e) {
				File file = fileChooser.showOpenDialog(stage);
				if (file != null) {
					try {
						Scanner scanner = new Scanner(file);
					} catch (FileNotFoundException e1) {
						Tools.failureAlert("Error occurred while importing textbooks.txt file");
					}
				}
			}
		});
		importMenu.getItems().addAll(studentMenuItemImport, facultyMenuItemImport, // courseMenuItemImport,
				courseMenuItemImport, textbookMenuItemImport);

		// export menu interface
		exportMenu = new Menu("Export...");
		studentMenuItemExport = new MenuItem("Student");
		studentMenuItemExport.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				FileChooser fileChooser = new FileChooser();

				// set extension filter
				FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
				fileChooser.getExtensionFilters().add(extFilter);

				// show save file dialog
				File file = fileChooser.showSaveDialog(stage);

				if (file != null) {
					try {
						PrintWriter pw = new PrintWriter(file);
						for (int i = 0; i < personBag.getPersonArray().length; i++) {
							pw.println(personBag.getPersonArray()[i].getName() + ": "
									+ personBag.getPersonArray()[i].getId());
						}
						pw.close();
					} catch (FileNotFoundException e) {
						Tools.failureAlert("Failure exporting persons.txt file");
					}
				}
			}
		});
		facultyMenuItemExport = new MenuItem("Faculty");
		courseMenuItemExport = new MenuItem("Courses");
		textbookMenuItemExport = new MenuItem("Textbook");
		exportMenu.getItems().addAll(studentMenuItemExport, facultyMenuItemExport, courseMenuItemExport,
				textbookMenuItemExport);
		exitMenuItem = new MenuItem("Exit");
		exitMenuItem.setOnAction(e -> {
			saveAll();
			Platform.exit();
		});

		fileMenu.getItems().addAll(saveMenuItem, loadMenuItem, new SeparatorMenuItem(), importMenu, exportMenu,
				new SeparatorMenuItem(), exitMenuItem);
	}

	private void buildOperationMenu() {
		operationMenu = new Menu("Operation");
		studentMenuItem = new MenuItem("Student");
		facultyMenuItem = new MenuItem("Faculty");
		courseMenuItem = new MenuItem("Course");
		textbookMenuItem = new MenuItem("Textbook");

		operationMenu.getItems().addAll(studentMenuItem, facultyMenuItem, new SeparatorMenuItem(), textbookMenuItem);
	}

	public void saveAll() {
		personBag.save();
		textbookBag.save();
		courseBag.save();
	}

	public void loadAll() {
		personBag.load();
		textbookBag.load();
		courseBag.load();
	}

	public MenuBar getMenuBar() {
		return menuBar;
	}

	public void setMenuBar(MenuBar menuBar) {
		this.menuBar = menuBar;
	}

	public MenuItem getSaveMenuItem() {
		return saveMenuItem;
	}

	public void setSaveMenuItem(MenuItem saveMenuItem) {
		this.saveMenuItem = saveMenuItem;
	}

	public MenuItem getLoadMenuItem() {
		return loadMenuItem;
	}

	public void setLoadMenuItem(MenuItem loadMenuItem) {
		this.loadMenuItem = loadMenuItem;
	}

	public MenuItem getImportMenu() {
		return importMenu;
	}

	public void setImportMenuItem(Menu importMenu) {
		this.importMenu = importMenu;
	}

	public MenuItem getExportMenu() {
		return exportMenu;
	}

	public void setExportMenuItem(Menu exportMenu) {
		this.exportMenu = exportMenu;
	}

	public MenuItem getExitMenuItem() {
		return exitMenuItem;
	}

	public void setExitMenuItem(MenuItem exitMenuItem) {
		this.exitMenuItem = exitMenuItem;
	}

	public MenuItem getStudentMenuItem() {
		return studentMenuItem;
	}

	public void setStudentMenuItem(MenuItem studentMenuItem) {
		this.studentMenuItem = studentMenuItem;
	}

	public MenuItem getFacultyMenuItem() {
		return facultyMenuItem;
	}

	public void setFacultyMenuItem(MenuItem facultyMenuItem) {
		this.facultyMenuItem = facultyMenuItem;
	}

	public MenuItem getTextbookMenuItem() {
		return textbookMenuItem;
	}

	public void setTextbookMenuItem(MenuItem textbookMenuItem) {
		this.textbookMenuItem = textbookMenuItem;
	}

	public MenuItem getCourseMenuItem() {
		return courseMenuItem;
	}

	public void setCourseMenuItem(MenuItem courseMenuItem) {
		this.courseMenuItem = courseMenuItem;
	}

}

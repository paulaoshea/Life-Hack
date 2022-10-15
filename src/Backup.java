
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.control.Tab;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Backup extends Application {


	private GridPane addcontactGridPane;
	private GridPane editContactGridPane;
	private GridPane homePageGridPane;

	private Label addfirstNameLabel;
	private Label addsecondNameLabel;
	private Label addnumberLabel;
	private Label addstreet1Label;
	private Label addstreet2Label;
	private Label addcityLabel;
	private Label addstateLabel;
	private Label addzipLabel;
	private Label addcountryLabel;
	private Label addbirthdayLabel;
	private Label addphoneLabel;
	private Label addemailLabel;

	private Label editfirstNameLabel;
	private Label editnumberLabel;
	private Label editstreet1Label;
	private Label editstreet2Label;
	private Label editcityLabel;
	private Label editstateLabel;
	private Label editzipLabel;
	private Label editcountryLabel;
	private Label editbirthdayLabel;
	private Label editphoneLabel;
	private Label editemailLabel;
	private Label homePageLabel1;
	private Label homePageLabel2;

	private Label addErrorLabel;
	private Label editErrorLabel;

	private Label paulaLabel;
	private Label maggieLabel;
	private Label elizabethLabel;

	private Label taskDetailLabel;
	private Label whoForLabel;
	private Label addTaskLabel;

	private Label congratsLabel;
	
	private Label day1MenuLabel;
	private Label day2MenuLabel;
	private Label day3MenuLabel;
	private Label day4MenuLabel;
	private Label day5MenuLabel;
	private Label day6MenuLabel;
	private Label day7MenuLabel;
	
	private Label expiryListMainLabel;
	private Label itemLabel;
	private Label expDateLabel;
	
	private Label menuTitleLabel;

	private ComboBox<String> nameComboBox;
	private ComboBox<String> whoForComboBox;

	private TextField addfirstNameText;
	private TextField addsecondNameText;
	private TextField addnumberText;
	private TextField addstreet1Text;
	private TextField addstreet2Text;
	private TextField addcityText;
	private TextField addstateText;
	private TextField addzipText;
	private TextField addcountryText;
	private TextField addbirthdayText;
	private TextField addphoneText;
	private TextField addemailText;

	private TextField editnumberText;
	private TextField editstreet1Text;
	private TextField editstreet2Text;
	private TextField editcityText;
	private TextField editstateText;
	private TextField editzipText;
	private TextField editcountryText;
	private TextField editbirthdayText;
	private TextField editphoneText;
	private TextField editemailText;
	
	private TextField day1MenuText;
	private TextField day2MenuText;
	private TextField day3MenuText;
	private TextField day4MenuText;
	private TextField day5MenuText;
	private TextField day6MenuText;
	private TextField day7MenuText;

	private TextField taskDetailTextField;
	
	private TextField itemText;
	private TextField expDateText;

	private Text homePageText;
	private Text expiryListText;

	private Button addContactButton;
	private Button clearContactButton;

	private Button addTaskButton;
	private Button cancelTaskButton;

	private Button editContactButton;

	private Button btnClose;
	
	private Button audioButton;
	
	private Button addExpItemButton;

	private VBox paulaVBox;
	private VBox maggieVBox;
	private VBox elizabethVBox;

	private VBox addTaskVBox;
	private VBox taskVBox;
	
	private VBox expiryListVBox;

	private HBox buttonTaskHBox;
	private HBox nameHBox;
	private HBox addTaskHBox;
	private HBox whoTaskLabelHBox;
	private HBox taskInputHBox;
	
	private HBox itemHBox;
	private HBox expDateHBox;

	private TilePane taskPane;

	private PrintWriter out;

	private Scanner fileScan;

	private Map<String, Contact> contactMap;
	private Map<String, List<Task>> personMap;
	private Map<CheckBox, Task> checkBoxMap;
	private Map<LocalDate, String> menuMap;

	Contact currentContact;
	private Set<String> nameSet;
	private List<Contact> contactList;
	private List<ExpiringItem> expiringItemList;

	private Font font1;
	private Font font2;
	private Font font3;
	private Font font4;
	
	private final String PATH = "Ba-Bum.mp3";
	
	private String expiryListString;

	private Tab toDoTab;
	
	private Stage stage;
	
	private LocalDate[] thisWeekArr;

	// ****************************************************************************************************
	public static void main(String[] args) {
		launch(args);
	}

	// ****************************************************************************************************
	public void start(Stage primaryStage) {
	
		stage = primaryStage;
		
		contactMap = new TreeMap<>();
		nameSet = new TreeSet<>();
		menuMap = new TreeMap<>();
		contactList = new ArrayList<>();
		expiringItemList = new ArrayList<>();

		btnClose = new Button();
		btnClose.setText("Close");
		btnClose.setOnAction(e -> btnClose_Click());
		
		
		/* Work out the next seven days - to be used in the Menu Planner page */
		/**********************************************************************/
		LocalDate today = LocalDate.now();
		thisWeekArr = new LocalDate[7];
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE MMM dd");
		
		for (int i=0 ; i<7 ; i++) {
			thisWeekArr[i] = today.plusDays(i);
		}
		
		for (LocalDate d : thisWeekArr) {
			System.out.println(d.format(formatter));
		}
		/**********************************************************************/
		// Read in the Menu Items from the input file and load into a Map ...
		Scanner lineScan;

		try {
			fileScan = new Scanner(new FileInputStream("MenuDetails.txt"));

			while (fileScan.hasNext()) { // outer loop reads one file line
				String oneLine = fileScan.nextLine();

				lineScan = new Scanner(oneLine);
				lineScan.useDelimiter(",");

				LocalDate theKey = LocalDate.parse(lineScan.next());
				String menuDescription = lineScan.next();

				menuMap.put(theKey, menuDescription);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File MenuDetails.txt cannot be found");
		} finally {
			fileScan.close();
		}
		
		System.out.println("And the map isssss!!!!!!!!! : " + menuMap);
		
	
		// Read in the Contacts from the input file and load into a Map ...
	//	Scanner lineScan;

		try {
			fileScan = new Scanner(new FileInputStream("lifeHack.txt"));

			while (fileScan.hasNext()) { // outer loop reads one file line
				String oneLine = fileScan.nextLine();

				lineScan = new Scanner(oneLine);
				lineScan.useDelimiter(",");

				String firstNameIn = lineScan.next();
				String secondNameIn = lineScan.next();
				String numberIn = lineScan.next();
				String street1In = lineScan.next();
				String street2In = lineScan.next();
				String cityIn = lineScan.next();
				String stateIn = lineScan.next();
				String zipIn = lineScan.next();
				String countryIn = lineScan.next();
				String birthdayIn = lineScan.next();
				String phoneIn = lineScan.next();
				String emailIn = lineScan.next();
				/* IMPORTANT NOTE! see above- this only works with perfectly formed data */

				Address theAddress = new Address.AddressBuilder(numberIn, street1In, zipIn).street2(street2In)
						.city(cityIn).state(stateIn).country(countryIn).build();

				System.out.println("address is : " + theAddress);

				String month = birthdayIn.substring(0, 2);
				String day = birthdayIn.substring(3);

				System.out.println("name1 " + firstNameIn);
				System.out.println("name2 " + secondNameIn);
				System.out.println("number " + numberIn);
				System.out.println("street1 " + street1In);
				System.out.println("street2 " + street2In);
				System.out.println("city " + cityIn);
				System.out.println("state " + stateIn);
				System.out.println("zip " + zipIn);
				System.out.println("country " + countryIn);
				System.out.println("birthday  " + birthdayIn);
				System.out.println("phone " + phoneIn);
				System.out.println("email " + emailIn);

				System.out.println("month / day " + month + " " + day);

				int intMonth = Integer.parseInt(month);
				int intDay = Integer.parseInt(day);
				MonthDay monthDay = MonthDay.of(intMonth, intDay);

				Contact contact = new Contact(firstNameIn, secondNameIn, theAddress, monthDay, phoneIn, emailIn);

				System.out.println(contact);

				String theKey = firstNameIn + " " + secondNameIn;

				contactMap.put(theKey, contact);

				contactList.add(contact);

				nameSet.add(theKey);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File lifeHack.txt cannot be found");
		} catch (NumberFormatException e) {
			System.out.println("dodgey input to parseInt method");
		} finally {
			fileScan.close();
		}

		// Sort the contactList by birthday
//		Collections.sort(contactList,
//						(	(contact1, contact2) -> 
//			contact1.getbirthday().compareTo(contact2.getbirthday()) ));

		// Sort the contactList by birthday but referencing today
		Collections.sort(contactList, (contact1, contact2) -> {
			if (contact1.getbirthday().isAfter(MonthDay.now()) && contact2.getbirthday().isAfter(MonthDay.now())) {
				return contact1.getbirthday().compareTo(contact2.getbirthday());
			} else if (contact1.getbirthday().isBefore(MonthDay.now())
					&& contact2.getbirthday().isBefore(MonthDay.now())) {
				return contact1.getbirthday().compareTo(contact2.getbirthday());
			} else if (contact1.getbirthday().isAfter(MonthDay.now())) {
				return -1;
			} else {
				return 1;
			}
		});

		String birthdayString = "";
		for (Contact c : contactList) {
			birthdayString = birthdayString + c.getFirstName() + " " + c.getsecondName() + " on: " + c.getbirthday()
					+ "\n";
			System.out.println(c);
		}

		Font font1 = Font.font("Copperplate", 18);
		Font font2 = Font.font("Times", 18);
		Font font3 = Font.font("Snell Roundhand", 36);
		Font font4 = Font.font("Copperplate", 36);

		TabPane tabPane = new TabPane();
		// tabPane.setStyle("-fx-background-color: Teal");

		Tab homePageTab = new Tab("Home Page");
		// Tab toDoTab = new Tab("Lets think about a to do list");
		toDoTab = new Tab("Lets think about a to do list");

		// Tab addContactTab = new Tab("Add Contact" , new Label("Let's add a
		// contact"));
		Tab menuTab = new Tab("Menu Planner");
		Tab addContactTab = new Tab("Add Contact");
		Tab editContactTab = new Tab("Edit Contact");
		Tab expiringItemTab = new Tab("Expiring Items");

		homePageTab.setClosable(false);
		toDoTab.setClosable(false);
		menuTab.setClosable(false);
		addContactTab.setClosable(false);
		editContactTab.setClosable(false);
		expiringItemTab.setClosable(false);

		homePageTab.setStyle("-fx-background-color: SlateBlue");
		toDoTab.setStyle("-fx-background-color: Plum");
		menuTab.setStyle("-fx-background-color: SteelBlue");
		addContactTab.setStyle("-fx-background-color: Thistle");
		editContactTab.setStyle("-fx-background-color: Thistle");
		expiringItemTab.setStyle("-fx-background-color: SlateBlue");


		tabPane.getTabs().add(homePageTab);
		tabPane.getTabs().add(toDoTab);
		tabPane.getTabs().add(menuTab);
		tabPane.getTabs().add(addContactTab);
		tabPane.getTabs().add(editContactTab);
		tabPane.getTabs().add(expiringItemTab);

		VBox vBox = new VBox(tabPane);
		vBox.setStyle("-fx-background-color: Gray");
		Scene scene = new Scene(vBox, 1100, 800);

		// ********************************************************************************************************************
		// Set up the "Home Page" Nodes
		// ********************************************************************************************************************

	
		audioButton = new Button("Play Audio");
		audioButton.setOnAction(e -> playMedia());
		
		audioButton.setMinSize(200, 100);
		audioButton.setFont(font3);
		audioButton.setStyle("-fx-background-color: SlateBlue");

		
		homePageGridPane = new GridPane();
		homePageGridPane.setHgap(40);
		homePageGridPane.setVgap(20);
		homePageGridPane.setPadding(new Insets(0, 0, 0, 0));
		homePageGridPane.setAlignment(Pos.CENTER);

		//homePageGridPane.setGridLinesVisible(true);
	
		homePageText = new Text("");
		homePageText.setText(birthdayString);
		homePageText.setFont(font1);
		
	    ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(homePageText);

	   // homePageText.wrappingWidthProperty().bind(scene.widthProperty());	        
	   // scrollPane.setFitToWidth(true);
					
		
		homePageLabel1 = new Label("Today's Date is " + LocalDate.now());
		homePageLabel1.setFont(font3);
		// homePageLabel1.setStyle("-fx-text-fill: #8B008B;");
		homePageLabel1.setStyle("-fx-text-fill: White");
		homePageLabel1.setAlignment(Pos.CENTER);

		homePageLabel2 = new Label("Upcoming Birthdays");
		homePageLabel2.setFont(font2);
		homePageLabel2.setStyle("font-weight: bold");
		
		GridPane.setConstraints(homePageLabel1, 0, 0);
		GridPane.setConstraints(homePageLabel2, 0, 1);
	//	GridPane.setConstraints(homePageText, 0, 3);
		GridPane.setConstraints(scrollPane, 0, 2);
		GridPane.setConstraints(audioButton, 0, 3);
		
		GridPane.setHalignment(homePageLabel2, HPos.CENTER);
		GridPane.setHalignment(audioButton, HPos.CENTER);

		homePageGridPane.getChildren().addAll(homePageLabel1);
		homePageGridPane.getChildren().addAll(homePageLabel2);
	//	homePageGridPane.getChildren().addAll(homePageText);
		homePageGridPane.getChildren().addAll(scrollPane);
		homePageGridPane.getChildren().addAll(audioButton);

		
		homePageTab.setContent(homePageGridPane);

		// ********************************************************************************************************************
		// Set the Scene and Show
		// ********************************************************************************************************************

	//	primaryStage.setScene(scene);
	//	primaryStage.setTitle("Life Hack App");
	//	primaryStage.setOnCloseRequest(e -> {
	//		e.consume();
	//		btnClose_Click();
	//	});
	//	primaryStage.show();
		
		// ********************************************************************************************************************
		// Set up the "To Do List" Nodes
		// ********************************************************************************************************************

		paulaLabel = new Label("Paula");
		paulaLabel.setFont(font3);
		paulaLabel.setStyle("-fx-text-fill: White");

		maggieLabel = new Label("Maggie");
		maggieLabel.setFont(font3);
		maggieLabel.setStyle("-fx-text-fill: White");

		elizabethLabel = new Label("Elizabeth");
		elizabethLabel.setFont(font3);
		elizabethLabel.setStyle("-fx-text-fill: White");

		taskDetailLabel = new Label("Add a Task");
		whoForLabel = new Label("Who for");
		addTaskLabel = new Label("Task Details");

		congratsLabel = new Label();
		congratsLabel.setFont(font3);
		congratsLabel.setStyle("-fx-text-fill: Pink");

		taskDetailTextField = new TextField();
		taskDetailTextField.setPrefWidth(200);
	//	taskDetailTextField.requestFocus();

		addTaskButton = new Button("Add Task");
		addTaskButton.setOnAction(this::processAddTask);
		cancelTaskButton = new Button("Cancel");
		cancelTaskButton.setOnAction(this::processClearTasks);

		addTaskVBox = new VBox();
		addTaskVBox.setAlignment(Pos.BOTTOM_CENTER);

		addTaskHBox = new HBox();
		addTaskHBox.setAlignment(Pos.CENTER);

		whoTaskLabelHBox = new HBox();
		whoTaskLabelHBox.setPadding(new Insets(20, 20, 20, 20));
		whoTaskLabelHBox.setSpacing(20);
		whoTaskLabelHBox.setAlignment(Pos.CENTER);

		taskInputHBox = new HBox();
		taskInputHBox.setPadding(new Insets(20, 20, 20, 20));
		taskInputHBox.setSpacing(20);
		taskInputHBox.setAlignment(Pos.CENTER);

		buttonTaskHBox = new HBox();
		buttonTaskHBox.setPadding(new Insets(20, 20, 20, 20));
		buttonTaskHBox.setSpacing(20);
		buttonTaskHBox.setAlignment(Pos.CENTER);

		taskVBox = new VBox();
		// taskVBox.setAlignment(Pos.CENTER);
		taskVBox.setAlignment(Pos.TOP_CENTER);

		taskPane = new TilePane();
		taskPane.setAlignment(Pos.CENTER);

		whoForComboBox = new ComboBox<>();
		whoForComboBox.setEditable(false);
		whoForComboBox.setPrefWidth(200);
		whoForComboBox.getItems().addAll("Paula", "Maggie", "Elizabeth");
		whoForComboBox.setValue("Paula");

		paulaVBox = new VBox();
		paulaVBox.setPadding(new Insets(10, 40, 40, 40));
		paulaVBox.setSpacing(20);

		maggieVBox = new VBox();
		maggieVBox.setPadding(new Insets(10, 40, 40, 40));
		maggieVBox.setSpacing(20);

		elizabethVBox = new VBox();
		elizabethVBox.setPadding(new Insets(10, 40, 40, 40));
		elizabethVBox.setSpacing(20);

		nameHBox = new HBox();
		// nameHBox.setAlignment(Pos.CENTER);
		nameHBox.setAlignment(Pos.TOP_CENTER);

		personMap = new TreeMap<>();
		fillMapByPerson(personMap);

		checkBoxMap = new HashMap<>();

		paulaVBox.getChildren().add(paulaLabel);
		maggieVBox.getChildren().add(maggieLabel);
		elizabethVBox.getChildren().add(elizabethLabel);

		for (Map.Entry<String, List<Task>> entry : personMap.entrySet()) {

			List<Task> theTasks = entry.getValue();

			if (entry.getKey().equals("Paula")) {
				for (Task myTask : theTasks) {
					CheckBox c = new CheckBox(myTask.getTaskDetail());
					c.setOnAction(this::processCheckIfDone);
				//	c.setFont(font2);
					paulaVBox.getChildren().add(c);
					checkBoxMap.put(c, myTask);
				}
			} else if (entry.getKey().equals("Maggie")) {
				for (Task myTask : theTasks) {
					CheckBox c = new CheckBox(myTask.getTaskDetail());
					c.setOnAction(this::processCheckIfDone);
			//		c.setFont(font2);
					maggieVBox.getChildren().add(c);
					checkBoxMap.put(c, myTask);
				}
			} else {
				for (Task myTask : theTasks) {
					CheckBox c = new CheckBox(myTask.getTaskDetail());
					c.setOnAction(this::processCheckIfDone);
			//		c.setFont(font2);
					elizabethVBox.getChildren().add(c);
					checkBoxMap.put(c, myTask);
				}
			}
		}

		nameHBox.getChildren().add(paulaVBox);
		nameHBox.getChildren().add(maggieVBox);
		nameHBox.getChildren().add(elizabethVBox);

		whoTaskLabelHBox.getChildren().add(whoForLabel);
		whoTaskLabelHBox.getChildren().add(whoForComboBox);

		taskInputHBox.getChildren().add(taskDetailLabel);
		taskInputHBox.getChildren().add(taskDetailTextField);

		buttonTaskHBox.getChildren().add(addTaskButton);
		buttonTaskHBox.getChildren().add(cancelTaskButton);

		addTaskVBox.getChildren().add(addTaskLabel);
		addTaskVBox.getChildren().add(whoTaskLabelHBox);
		addTaskVBox.getChildren().add(taskInputHBox);
		addTaskVBox.getChildren().add(buttonTaskHBox);

		taskVBox.getChildren().add(nameHBox);
		taskVBox.getChildren().add(addTaskVBox);

		taskVBox.getChildren().add(congratsLabel);

		toDoTab.setContent(taskVBox);

		// ********************************************************************************************************************
		// Set up the "Add Contact" Nodes
		// ********************************************************************************************************************

		addfirstNameLabel = new Label("Enter first name:");
		addfirstNameLabel.setFont(font1);

		addsecondNameLabel = new Label("Enter second name:");
		addsecondNameLabel.setFont(font1);

		addnumberLabel = new Label("Enter house number:");
		addnumberLabel.setFont(font1);

		addstreet1Label = new Label("Enter street:");
		addstreet1Label.setFont(font1);

		addstreet2Label = new Label("Enter street:");
		addstreet2Label.setFont(font1);

		addcityLabel = new Label("Enter city:");
		addcityLabel.setFont(font1);

		addstateLabel = new Label("Enter state or county:");
		addstateLabel.setFont(font1);

		addzipLabel = new Label("Enter zip:");
		addzipLabel.setFont(font1);

		addcountryLabel = new Label("Enter country:");
		addcountryLabel.setFont(font1);

		addbirthdayLabel = new Label("Enter birthday:");
		addbirthdayLabel.setFont(font1);

		addphoneLabel = new Label("Enter phone number:");
		addphoneLabel.setFont(font1);

		addemailLabel = new Label("Enter email:");
		addemailLabel.setFont(font1);

		addErrorLabel = new Label("");
		addErrorLabel.setFont(font1);

		addfirstNameText = new TextField();
		addfirstNameText.setFont(font2);
		addfirstNameText.setPrefWidth(200);
		addfirstNameText.setAlignment(Pos.CENTER);
		addfirstNameText.setOnAction(this::processReturnAdd);

		addsecondNameText = new TextField();
		addsecondNameText.setFont(font2);
		addsecondNameText.setPrefWidth(200);
		addsecondNameText.setAlignment(Pos.CENTER);
		addsecondNameText.setOnAction(this::processReturnAdd);

		addnumberText = new TextField();
		addnumberText.setFont(font2);
		addnumberText.setPrefWidth(200);
		addnumberText.setAlignment(Pos.CENTER);
		addnumberText.setOnAction(this::processReturnAdd);

		addstreet1Text = new TextField();
		addstreet1Text.setFont(font2);
		addstreet1Text.setPrefWidth(200);
		addstreet1Text.setAlignment(Pos.CENTER);
		addstreet1Text.setOnAction(this::processReturnAdd);

		addstreet2Text = new TextField();
		addstreet2Text.setFont(font2);
		addstreet2Text.setPrefWidth(200);
		addstreet2Text.setAlignment(Pos.CENTER);
		addstreet2Text.setOnAction(this::processReturnAdd);

		addcityText = new TextField();
		addcityText.setFont(font2);
		addcityText.setPrefWidth(200);
		addcityText.setAlignment(Pos.CENTER);
		addcityText.setOnAction(this::processReturnAdd);

		addstateText = new TextField();
		addstateText.setFont(font2);
		addstateText.setPrefWidth(200);
		addstateText.setAlignment(Pos.CENTER);
		addstateText.setOnAction(this::processReturnAdd);

		addzipText = new TextField();
		addzipText.setFont(font2);
		addzipText.setPrefWidth(200);
		addzipText.setAlignment(Pos.CENTER);
		addzipText.setOnAction(this::processReturnAdd);

		addcountryText = new TextField();
		addcountryText.setFont(font2);
		addcountryText.setPrefWidth(200);
		addcountryText.setAlignment(Pos.CENTER);
		addcountryText.setOnAction(this::processReturnAdd);

		addbirthdayText = new TextField();
		addbirthdayText.setFont(font2);
		addbirthdayText.setPrefWidth(200);
		addbirthdayText.setAlignment(Pos.CENTER);
		addbirthdayText.setText("mm-dd");
		addbirthdayText.setOnAction(this::processReturnAdd);

		addphoneText = new TextField();
		addphoneText.setFont(font2);
		addphoneText.setPrefWidth(200);
		addphoneText.setAlignment(Pos.CENTER);
		addphoneText.setOnAction(this::processReturnAdd);

		addemailText = new TextField();
		addemailText.setFont(font2);
		addemailText.setPrefWidth(200);
		addemailText.setAlignment(Pos.CENTER);
		addemailText.setOnAction(this::processReturnAdd);

		addContactButton = new Button("Add Contact");
		addContactButton.setOnAction(this::processReturnAdd);

		clearContactButton = new Button("Clear Contact");
		clearContactButton.setOnAction(this::processReturnClear);

		addcontactGridPane = new GridPane();
		addcontactGridPane.setHgap(40);
		addcontactGridPane.setVgap(20);
		addcontactGridPane.setPadding(new Insets(40, 0, 0, 0));
		addcontactGridPane.setAlignment(Pos.CENTER);

		GridPane.setConstraints(addfirstNameLabel, 0, 0);
		GridPane.setConstraints(addsecondNameLabel, 0, 1);
		GridPane.setConstraints(addnumberLabel, 0, 2);
		GridPane.setConstraints(addstreet1Label, 0, 3);
		GridPane.setConstraints(addstreet2Label, 0, 4);
		GridPane.setConstraints(addcityLabel, 0, 5);
		GridPane.setConstraints(addstateLabel, 0, 6);
		GridPane.setConstraints(addzipLabel, 0, 7);
		GridPane.setConstraints(addcountryLabel, 0, 8);
		GridPane.setConstraints(addbirthdayLabel, 0, 9);
		GridPane.setConstraints(addphoneLabel, 0, 10);
		GridPane.setConstraints(addemailLabel, 0, 11);
		GridPane.setConstraints(addContactButton, 0, 12, 1, 1, HPos.CENTER, VPos.CENTER);
		GridPane.setConstraints(addErrorLabel, 0, 13, 1, 1, HPos.CENTER, VPos.CENTER);

		GridPane.setConstraints(addfirstNameText, 1, 0);
		GridPane.setConstraints(addsecondNameText, 1, 1);
		GridPane.setConstraints(addnumberText, 1, 2);
		GridPane.setConstraints(addstreet1Text, 1, 3);
		GridPane.setConstraints(addstreet2Text, 1, 4);
		GridPane.setConstraints(addcityText, 1, 5);
		GridPane.setConstraints(addstateText, 1, 6);
		GridPane.setConstraints(addzipText, 1, 7);
		GridPane.setConstraints(addcountryText, 1, 8);
		GridPane.setConstraints(addbirthdayText, 1, 9);
		GridPane.setConstraints(addphoneText, 1, 10);
		GridPane.setConstraints(addemailText, 1, 11);
		GridPane.setConstraints(clearContactButton, 1, 12, 1, 1, HPos.CENTER, VPos.CENTER);

		addcontactGridPane.getChildren().addAll(addfirstNameLabel, addfirstNameText, addsecondNameLabel,
				addsecondNameText, addnumberLabel, addnumberText, addstreet1Label, addstreet1Text, addstreet2Label,
				addstreet2Text, addcityLabel, addcityText, addstateLabel, addstateText, addzipLabel, addzipText,
				addcountryLabel, addcountryText, addbirthdayLabel, addbirthdayText, addphoneLabel, addphoneText,
				addemailLabel, addemailText, addContactButton, clearContactButton, addErrorLabel);

		addContactTab.setContent(addcontactGridPane);

		// ********************************************************************************************************************
		// Set up the "Edit Contact" Nodes
		// ********************************************************************************************************************

		nameComboBox = new ComboBox<>();
		nameComboBox.getItems().addAll(nameSet);
		nameComboBox.setEditable(false);
		nameComboBox.setValue("");
		nameComboBox.setPrefWidth(200);
		nameComboBox.setOnAction(this::processFillTextFields);

		editfirstNameLabel = new Label("Select name:");
		editfirstNameLabel.setFont(font1);

		// editsecondNameLabel = new Label("Edit second name:");
		// editsecondNameLabel.setFont(font1);

		editnumberLabel = new Label("Edit house number:");
		editnumberLabel.setFont(font1);

		editstreet1Label = new Label("Edit street:");
		editstreet1Label.setFont(font1);

		editstreet2Label = new Label("Edit street:");
		editstreet2Label.setFont(font1);

		editcityLabel = new Label("Edit city:");
		editcityLabel.setFont(font1);

		editstateLabel = new Label("Edit state or county:");
		editstateLabel.setFont(font1);

		editzipLabel = new Label("Edit zip:");
		editzipLabel.setFont(font1);

		editcountryLabel = new Label("Edit country:");
		editcountryLabel.setFont(font1);

		editbirthdayLabel = new Label("Edit birthday:");
		editbirthdayLabel.setFont(font1);

		editphoneLabel = new Label("Edit phone number:");
		editphoneLabel.setFont(font1);

		editemailLabel = new Label("Edit email:");
		editemailLabel.setFont(font1);

		editErrorLabel = new Label("");
		editErrorLabel.setFont(font1);

		editnumberText = new TextField();
		editnumberText.setFont(font2);
		editnumberText.setPrefWidth(200);
		editnumberText.setAlignment(Pos.CENTER);
		// editnumberText.setOnAction(this::processReturnAdd);

		editstreet1Text = new TextField();
		editstreet1Text.setFont(font2);
		editstreet1Text.setPrefWidth(200);
		editstreet1Text.setAlignment(Pos.CENTER);
		// editstreet1Text.setOnAction(this::processReturnAdd);

		editstreet2Text = new TextField();
		editstreet2Text.setFont(font2);
		editstreet2Text.setPrefWidth(200);
		editstreet2Text.setAlignment(Pos.CENTER);
		// editstreet2Text.setOnAction(this::processReturnAdd);

		editcityText = new TextField();
		editcityText.setFont(font2);
		editcityText.setPrefWidth(200);
		editcityText.setAlignment(Pos.CENTER);
		// editcityText.setOnAction(this::processReturnAdd);

		editstateText = new TextField();
		editstateText.setFont(font2);
		editstateText.setPrefWidth(200);
		editstateText.setAlignment(Pos.CENTER);
		// editstateText.setOnAction(this::processReturnAdd);

		editzipText = new TextField();
		editzipText.setFont(font2);
		editzipText.setPrefWidth(200);
		editzipText.setAlignment(Pos.CENTER);
		// editzipText.setOnAction(this::processReturnAdd);

		editcountryText = new TextField();
		editcountryText.setFont(font2);
		editcountryText.setPrefWidth(200);
		editcountryText.setAlignment(Pos.CENTER);
		// editcountryText.setOnAction(this::processReturnAdd);

		editbirthdayText = new TextField();
		editbirthdayText.setFont(font2);
		editbirthdayText.setPrefWidth(200);
		editbirthdayText.setAlignment(Pos.CENTER);
		editbirthdayText.setText("mm-dd");
		// editbirthdayText.setOnAction(this::processReturnAdd);

		editphoneText = new TextField();
		editphoneText.setFont(font2);
		editphoneText.setPrefWidth(200);
		editphoneText.setAlignment(Pos.CENTER);
		// editphoneText.setOnAction(this::processReturnAdd);

		editemailText = new TextField();
		editemailText.setFont(font2);
		editemailText.setPrefWidth(200);
		editemailText.setAlignment(Pos.CENTER);
		// editemailText.setOnAction(this::processReturnAdd);

		editContactButton = new Button("Save Edits");
		editContactButton.setOnAction(this::processReturnEdit);

		editContactGridPane = new GridPane();
		editContactGridPane.setHgap(40);
		editContactGridPane.setVgap(20);
		editContactGridPane.setPadding(new Insets(40, 0, 0, 0));
		editContactGridPane.setAlignment(Pos.CENTER);

		GridPane.setConstraints(editfirstNameLabel, 0, 0);
		// GridPane.setConstraints(editsecondNameLabel, 0, 1);
		GridPane.setConstraints(editnumberLabel, 0, 1);
		GridPane.setConstraints(editstreet1Label, 0, 2);
		GridPane.setConstraints(editstreet2Label, 0, 3);
		GridPane.setConstraints(editcityLabel, 0, 4);
		GridPane.setConstraints(editstateLabel, 0, 5);
		GridPane.setConstraints(editzipLabel, 0, 6);
		GridPane.setConstraints(editcountryLabel, 0, 7);
		GridPane.setConstraints(editbirthdayLabel, 0, 8);
		GridPane.setConstraints(editphoneLabel, 0, 9);
		GridPane.setConstraints(editemailLabel, 0, 10);
		GridPane.setConstraints(editContactButton, 0, 11, 2, 1, HPos.CENTER, VPos.CENTER);
		GridPane.setConstraints(editErrorLabel, 0, 13, 1, 1, HPos.CENTER, VPos.CENTER);

		// GridPane.setConstraints(editfirstNameText, 1, 0);
		// GridPane.setConstraints(editsecondNameText, 1, 1);
		GridPane.setConstraints(nameComboBox, 1, 0);
		GridPane.setConstraints(editnumberText, 1, 1);
		GridPane.setConstraints(editstreet1Text, 1, 2);
		GridPane.setConstraints(editstreet2Text, 1, 3);
		GridPane.setConstraints(editcityText, 1, 4);
		GridPane.setConstraints(editstateText, 1, 5);
		GridPane.setConstraints(editzipText, 1, 6);
		GridPane.setConstraints(editcountryText, 1, 7);
		GridPane.setConstraints(editbirthdayText, 1, 8);
		GridPane.setConstraints(editphoneText, 1, 9);
		GridPane.setConstraints(editemailText, 1, 10);

		editContactGridPane.getChildren().addAll(editfirstNameLabel, nameComboBox, editnumberLabel, editnumberText,
				editstreet1Label, editstreet1Text, editstreet2Label, editstreet2Text, editcityLabel, editcityText,
				editstateLabel, editstateText, editzipLabel, editzipText, editcountryLabel, editcountryText,
				editbirthdayLabel, editbirthdayText, editphoneLabel, editphoneText, editemailLabel, editemailText,
				editContactButton, editErrorLabel);

		editContactTab.setContent(editContactGridPane);
		

		// ********************************************************************************************************************
		// Set up the "Menu Planner" Nodes
		// ********************************************************************************************************************
		
		GridPane menuPane = new GridPane();
					
	//	BackgroundImage myBackground= new BackgroundImage(new Image("applebackground.jpg",32,32,false,true),
		BackgroundImage myBackground= new BackgroundImage(new Image("applebackground.jpg",1100,968,true,true),
		        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		          BackgroundSize.DEFAULT);
		//then you set to your node
		menuPane.setBackground(new Background(myBackground));
		
		menuTitleLabel = new Label("Menu Planner");
		menuTitleLabel.setFont(font3);;
		menuTitleLabel.setAlignment(Pos.CENTER);
	
		day1MenuLabel= new Label(thisWeekArr[0].format(formatter));
		day1MenuLabel.setFont(font3);

		day2MenuLabel= new Label(thisWeekArr[1].format(formatter));
		day2MenuLabel.setFont(font3);
		
		day3MenuLabel= new Label(thisWeekArr[2].format(formatter));
		day3MenuLabel.setFont(font3);
		
		day4MenuLabel= new Label(thisWeekArr[3].format(formatter));
		day4MenuLabel.setFont(font3);
		
		day5MenuLabel= new Label(thisWeekArr[4].format(formatter));
		day5MenuLabel.setFont(font3);
		
		day6MenuLabel= new Label(thisWeekArr[5].format(formatter));
		day6MenuLabel.setFont(font3);
		
		day7MenuLabel= new Label(thisWeekArr[6].format(formatter));
		day7MenuLabel.setFont(font3);
		
		day1MenuText = new TextField();
		day1MenuText.setFont(font2);
		day1MenuText.setPrefWidth(450);
		day1MenuText.setAlignment(Pos.CENTER);
				
		day2MenuText = new TextField();
		day2MenuText.setFont(font2);
		day2MenuText.setPrefWidth(450);
		day2MenuText.setAlignment(Pos.CENTER);
		
		day3MenuText = new TextField();
		day3MenuText.setFont(font2);
		day3MenuText.setPrefWidth(450);
		day3MenuText.setAlignment(Pos.CENTER);
		
		day4MenuText = new TextField();
		day4MenuText.setFont(font2);
		day4MenuText.setPrefWidth(450);
		day4MenuText.setAlignment(Pos.CENTER);
		
		day5MenuText = new TextField();
		day5MenuText.setFont(font2);
		day5MenuText.setPrefWidth(450);
		day5MenuText.setAlignment(Pos.CENTER);
		
		day6MenuText = new TextField();
		day6MenuText.setFont(font2);
		day6MenuText.setPrefWidth(450);
		day6MenuText.setAlignment(Pos.CENTER);
		
		day7MenuText = new TextField();
		day7MenuText.setFont(font2);
		day7MenuText.setPrefWidth(400);
		day7MenuText.setAlignment(Pos.CENTER);
		
		if (menuMap.get(thisWeekArr[0]) != null) {
			day1MenuText.setText(menuMap.get(thisWeekArr[0]));
		}
		if (menuMap.get(thisWeekArr[1]) != null) {
			day2MenuText.setText(menuMap.get(thisWeekArr[1]));
		}
		if (menuMap.get(thisWeekArr[2]) != null) {
			day3MenuText.setText(menuMap.get(thisWeekArr[2]));
		}
		if (menuMap.get(thisWeekArr[3]) != null) {
			day4MenuText.setText(menuMap.get(thisWeekArr[3]));
		}
		if (menuMap.get(thisWeekArr[4]) != null) {
			day5MenuText.setText(menuMap.get(thisWeekArr[4]));
		}
		if (menuMap.get(thisWeekArr[5]) != null) {
			day6MenuText.setText(menuMap.get(thisWeekArr[5]));
		}
		if (menuMap.get(thisWeekArr[6]) != null) {
			day7MenuText.setText(menuMap.get(thisWeekArr[6]));
		}
		
		menuPane.setHgap(40);
		menuPane.setVgap(20);
		menuPane.setPadding(new Insets(40, 0, 0, 0));
		menuPane.setAlignment(Pos.CENTER);

	//	GridPane.setConstraints(menuTitleText, 0, 0, 2, 1);
		GridPane.setConstraints(menuTitleLabel, 0, 0, 2, 1, HPos.CENTER, VPos.CENTER);
		GridPane.setConstraints(day1MenuLabel, 0, 2);
		GridPane.setConstraints(day2MenuLabel, 0, 3);
		GridPane.setConstraints(day3MenuLabel, 0, 4);
		GridPane.setConstraints(day4MenuLabel, 0, 5);
		GridPane.setConstraints(day5MenuLabel, 0, 6);
		GridPane.setConstraints(day6MenuLabel, 0, 7);
		GridPane.setConstraints(day7MenuLabel, 0, 8);
	//	GridPane.setConstraints(addContactButton, 0, 12, 1, 1, HPos.CENTER, VPos.CENTER);
	//	GridPane.setConstraints(addErrorLabel, 0, 13, 1, 1, HPos.CENTER, VPos.CENTER);

		GridPane.setConstraints(day1MenuText, 1, 2);
		GridPane.setConstraints(day2MenuText, 1, 3);
		GridPane.setConstraints(day3MenuText, 1, 4);
		GridPane.setConstraints(day4MenuText, 1, 5);
		GridPane.setConstraints(day5MenuText, 1, 6);
		GridPane.setConstraints(day6MenuText, 1, 7);
		GridPane.setConstraints(day7MenuText, 1, 8);

		//menuPane.setGridLinesVisible(true);

		
		
		menuPane.getChildren().addAll(menuTitleLabel, day1MenuLabel, day2MenuLabel, day3MenuLabel, day4MenuLabel, day5MenuLabel, 
				day6MenuLabel, day7MenuLabel, day1MenuText, day2MenuText, day3MenuText, day4MenuText, day5MenuText,
				day6MenuText, day7MenuText);
	
		menuTab.setContent(menuPane);
		
		// ********************************************************************************************************************
		// Set up the "Expiring List" Nodes
		// ********************************************************************************************************************
		
		expiryListText = new Text("");
		expiryListText.setText(expiryListString);
		expiryListText.setFont(font1);
		
	    ScrollPane scrollPaneExpiry = new ScrollPane();
	    scrollPaneExpiry.setContent(expiryListText);
					
		expiryListMainLabel = new Label("Expiry List");
		expiryListMainLabel.setFont(font3);
		expiryListMainLabel.setStyle("-fx-text-fill: White");
		expiryListMainLabel.setAlignment(Pos.CENTER);
		
		itemLabel = new Label("Item");
		itemLabel.setFont(font3);

		expDateLabel = new Label("Expiry Date");
		expDateLabel.setFont(font3);
		
		itemText = new TextField("");
		itemText.setText("");
		itemText.setFont(font1);
		
		expDateText = new TextField("");
		expDateText.setText("");
		expDateText.setFont(font1);
		
		addExpItemButton = new Button();
		addExpItemButton.setText("Add Item");
		addExpItemButton.setOnAction(e -> addItem_Click());
		
		itemHBox = new HBox();
		expDateHBox = new HBox();
		expiryListVBox = new VBox();
		
		expiryListVBox.setPadding(new Insets(20, 20, 20, 20));
		expDateHBox.setPadding(new Insets(20, 20, 20, 20));
		itemHBox.setPadding(new Insets(20, 20, 20, 20));

		expDateHBox.setSpacing(20);
		itemHBox.setSpacing(140);

		itemHBox.getChildren().add(itemLabel);
		itemHBox.getChildren().add(itemText);

		expDateHBox.getChildren().add(expDateLabel);
		expDateHBox.getChildren().add(expDateText);

		itemHBox.setAlignment(Pos.CENTER);
		expDateHBox.setAlignment(Pos.CENTER);

		expiryListVBox.setAlignment(Pos.TOP_CENTER);
		
		expiryListVBox.getChildren().add(expiryListMainLabel);
		expiryListVBox.getChildren().add(scrollPaneExpiry);
		expiryListVBox.getChildren().add(itemHBox);
		expiryListVBox.getChildren().add(expDateHBox);
		expiryListVBox.getChildren().add(addExpItemButton);
		
		expiringItemTab.setContent(expiryListVBox);
		
		// ********************************************************************************************************************
		// Set the Scene and Show
		// ********************************************************************************************************************

		//taskDetailTextField.requestFocus();
		
	    scene.getStylesheets().add(getClass().getResource("lifehack.css").toExternalForm());

		primaryStage.setScene(scene);
		primaryStage.setTitle("Life Hack App");
		primaryStage.setOnCloseRequest(e -> {
			e.consume();
			btnClose_Click();
		});
		primaryStage.show();
		
		
	}

	// *****************************************************************************************************************************
	// COME HERE FROM "ADD CONTACT" TAB WHEN CONTACT BEING ADDED
	// *****************************************************************************************************************************
	public void processReturnAdd(ActionEvent event) {

		String firstName = addfirstNameText.getText();
		String secondName = addsecondNameText.getText();
		String number = addnumberText.getText();
		String street1 = addstreet1Text.getText();
		String street2 = addstreet2Text.getText();
		String city = addcityText.getText();
		String state = addstateText.getText();
		String zip = addzipText.getText();
		String country = addcountryText.getText();
		String birthday = addbirthdayText.getText();
		String phone = addphoneText.getText();
		String email = addemailText.getText();

		boolean ok = doBirthdayFormatChecking(birthday);

		if (ok) {
			try {
				out = new PrintWriter(new FileOutputStream("lifeHack.txt", true));
				out.print(firstName + "," + secondName + "," + number + "," + street1 + "," + street2 + "," + city + ","
						+ state + "," + zip + "," + country + "," + birthday + "," + phone + "," + email + "," + "\n");
				addErrorLabel.setText("Contact added - Thank you!");

				// String theKey = firstName + " " + secondName;
				// nameSet.add(theKey);
				nameComboBox.getItems().add(firstName + " " + secondName);

				Address theAddress = new Address.AddressBuilder(number, street1, zip).street2(street2).city(city)
						.state(state).country(country).build();

				String month = birthday.substring(0, 2);
				String day = birthday.substring(3);

				int intMonth = Integer.parseInt(month);
				int intDay = Integer.parseInt(day);
				MonthDay monthDay = MonthDay.of(intMonth, intDay);

				Contact contact = new Contact(firstName, secondName, theAddress, monthDay, phone, email);

				System.out.println(contact);

				String theKey = firstName + " " + secondName;

				contactMap.put(theKey, contact);

				processClearAdd();

			} catch (FileNotFoundException e) {
				System.out.println("File lifeHack.txt cannot be found");
			} finally {
				out.close();
			}
		} else {
			addErrorLabel.setText(
					"Contact was not added - birthday was not formatted correctly. Please try again with mm-dd.");
		}

	}

	// *****************************************************************************************************************************
	// COME HERE FROM "ADD CONTACT" PAGE WHEN "CLEAR" BUTTON PRESSED
	// *****************************************************************************************************************************
	public void processReturnClear(ActionEvent event) {

		addfirstNameText.clear();
		addsecondNameText.clear();
		addnumberText.clear();
		addstreet1Text.clear();
		addstreet2Text.clear();
		addcityText.clear();
		addstateText.clear();
		addzipText.clear();
		addcountryText.clear();
		addbirthdayText.setText("mm-dd");
		addphoneText.clear();
		addemailText.clear();
	}

	// *****************************************************************************************************************************
	// COME HERE WHEN A CONTACT IS SELECTED FROM THE COMBO BOX READY TO BE VIEWED OR
	// EDITED
	// *****************************************************************************************************************************
	public void processFillTextFields(ActionEvent event) {
		// System.out.println("hello there");

		editErrorLabel.setText("");

		String whichContact = nameComboBox.getValue();
		currentContact = contactMap.get(whichContact);

		editnumberText.setText(currentContact.getAddress().getNumber());
		editstreet1Text.setText(currentContact.getAddress().getStreet1());
		editstreet2Text.setText(currentContact.getAddress().getStreet2());
		editcityText.setText(currentContact.getAddress().getCity());
		editstateText.setText(currentContact.getAddress().getState());
		editzipText.setText(currentContact.getAddress().getZip1());
		editcountryText.setText(currentContact.getAddress().geCountry());

//		int extractedMonth = currentContact.getbirthday().getMonthValue();
//		int extractedDay = currentContact.getbirthday().getDayOfMonth();
//			
//		String monthStrLeadingZero = extractedMonth < 10 ? "0" + extractedMonth : String.valueOf(extractedMonth);
//		String dayStrLeadingZero = extractedDay < 10 ? "0" + extractedDay : String.valueOf(extractedDay);
//		
//		editbirthdayText.setText(monthStrLeadingZero + "-" + dayStrLeadingZero);

		editbirthdayText.setText(currentContact.getFormattedBirthday());

		editphoneText.setText(currentContact.getPhoneNumber());
		editemailText.setText(currentContact.getEmail());

	}

	// *****************************************************************************************************************************
	// COME HERE WHEN CONTACT IS BEING EDITED
	// *****************************************************************************************************************************
	public void processReturnEdit(ActionEvent event) {

		String whichContact = nameComboBox.getValue();
		Contact contactToEdit = contactMap.get(whichContact);

		String firstName = contactToEdit.getFirstName();
		String secondName = contactToEdit.getsecondName();

		String numberIn = editnumberText.getText();
		String street1In = editstreet1Text.getText();
		String street2In = editstreet2Text.getText();
		String cityIn = editcityText.getText();
		String stateIn = editstateText.getText();
		String zipIn = editzipText.getText();
		String countryIn = editcountryText.getText();
		String phoneIn = editphoneText.getText();
		String emailIn = editemailText.getText();
		String birthday = editbirthdayText.getText();

		boolean ok = doBirthdayFormatChecking(birthday);

		if (ok) {
			PrintWriter editedOut;

			contactMap.remove(whichContact);

			Address theAddress = new Address.AddressBuilder(numberIn, street1In, zipIn).street2(street2In).city(cityIn)
					.state(stateIn).country(countryIn).build();

			String month = birthday.substring(0, 2);
			String day = birthday.substring(3);

			int intMonth = Integer.parseInt(month);
			int intDay = Integer.parseInt(day);
			MonthDay monthDay = MonthDay.of(intMonth, intDay);

			Contact contact = new Contact(firstName, secondName, theAddress, monthDay, phoneIn, emailIn);

			String theKey = firstName + " " + secondName;

			contactMap.put(theKey, contact);

			// need to make sure we update the FILE HERE

			try {
				editedOut = new PrintWriter(new FileOutputStream("lifeHack.txt"));

				// contactMap.forEach((key, value) -> editedOut.write(key + "," + value +
				// System.lineSeparator()));
				contactMap.forEach((key,
						value) -> editedOut.write(value.getFirstName() + "," + value.getsecondName() + ","
								+ value.getAddress().getNumber() + "," + value.getAddress().getStreet1() + ","
								+ value.getAddress().getStreet2() + "," + value.getAddress().getCity() + ","
								+ value.getAddress().getState() + "," + value.getAddress().getZip1() + ","
								+ value.getAddress().geCountry() + "," + value.getFormattedBirthday() + ","
								+ value.getPhoneNumber() + "," + value.getEmail() + "," + "\n"));

				editedOut.close();

			} catch (FileNotFoundException e) {
				System.out.println("File lifeHack.txt cannot be found");
			}

			editErrorLabel.setText("Contact edited - Thank you!");
			processClearEdit();

		} else {
			editErrorLabel.setText(
					"Contact was not edited - birthday was not formatted correctly. Please try again with mm-dd.");
		}

	}

	// *****************************************************************************************************************************
	// COME HERE WHEN CHECKBOX CLICKED
	// *****************************************************************************************************************************
	public void processCheckIfDone(ActionEvent event) {

		// Figure out which Task this checkBox maps to ...

		Task t1 = checkBoxMap.get((CheckBox) event.getSource());

		// Update the info in the PersonMap ....

		if (((CheckBox) event.getSource()).isSelected()) {
			System.out.println("\n\nYIPEEEEE!!!!!!!");
			((CheckBox) event.getSource()).setStyle("-fx-text-fill: Gainsboro");

			t1.setComplete(true);
		} else {
			((CheckBox) event.getSource()).setStyle("-fx-text-fill: Black");
			t1.setComplete(false);
		}

		System.out.println("\nNOW!!! the checkBox map looks like : " + checkBoxMap);
		System.out.println("\nNOW!!! the person map looks like : " + personMap);

		// Check if all Tasks for a Person are complete .....
		checkIfTasksComplete(event, t1);

	}

	// *****************************************************************************************************************************
	// COME HERE WHEN CONTACT HAS BEEN ADDED AND ALL FIELDS SHOULD BE CLEARED
	// *****************************************************************************************************************************
	public void processClearAdd() {

		addfirstNameText.clear();
		addsecondNameText.clear();
		addnumberText.clear();
		addstreet1Text.clear();
		addstreet2Text.clear();
		addcityText.clear();
		addstateText.clear();
		addzipText.clear();
		addcountryText.clear();
		addbirthdayText.setText("mm-dd");
		addphoneText.clear();
		addemailText.clear();
	}

	// *****************************************************************************************************************************
	// COME HERE WHEN CONTACT HAS BEEN EDITED AND ALL FIELDS SHOULD BE CLEARED
	// *****************************************************************************************************************************
	public void processClearEdit() {

		editnumberText.clear();
		editstreet1Text.clear();
		editstreet2Text.clear();
		editcityText.clear();
		editstateText.clear();
		editzipText.clear();
		editcountryText.clear();
		editbirthdayText.setText("mm-dd");
		editphoneText.clear();
		editemailText.clear();
	}

	// *****************************************************************************************************************************
	// COME HERE WHEN TASK BEING ADDED - BUT CANCEL PRESSED INSTEAD
	// *****************************************************************************************************************************
	public void processClearTasks(ActionEvent event) {

		taskDetailTextField.clear();
	}

	// *****************************************************************************************************************************
	// COME HERE WHEN TASK BEING ADDED
	// *****************************************************************************************************************************
	public void processAddTask(ActionEvent event) {

		String addToWho = whoForComboBox.getValue();

		System.out.println("who?" + addToWho);

		CheckBox c = new CheckBox(taskDetailTextField.getText());
		c.setOnAction(this::processCheckIfDone);
		// c.setFont(font2);

		// System.out.println("task?" + taskDetailTextField.getText());

		Task t = null;

		switch (addToWho) {
		case "Paula":
			t = new Task("Paula", taskDetailTextField.getText(), false);
			paulaVBox.getChildren().add(c);
			break;
		case "Maggie":
			t = new Task("Maggie", taskDetailTextField.getText(), false);
			maggieVBox.getChildren().add(c);
			break;
		case "Elizabeth":
			t = new Task("Elizabeth", taskDetailTextField.getText(), false);
			elizabethVBox.getChildren().add(c);
			break;
		default:
		}

		checkBoxMap.put(c, t);

		taskDetailTextField.clear();
		
		taskDetailTextField.requestFocus();

		System.out.println("lastly ...");

		if (personMap.containsKey(t.getWhoseTask())) {

			List<Task> taskList = personMap.get(t.getWhoseTask());

			if (taskList == null) {
				taskList = new ArrayList<Task>();
			}
			taskList.add(t);
		} else {
			List<Task> taskList = new ArrayList<Task>();
			taskList.add(t);
			personMap.put(t.getWhoseTask(), taskList);
		}

		System.out.println("ADDED TO THE MAP!!!!!" + personMap);

		// Check if all Tasks for a Person are complete .....
		checkIfTasksComplete(event, t);

	}

	// *****************************************************************************************************************************
	// COME HERE FROM PROCESSRETURNADD METHOD (WHEN CONTACT BEING ADDED) OR WHEN
	// CONTACT BEING EDITED
	// *****************************************************************************************************************************
	public boolean doBirthdayFormatChecking(String birthday) {

		String month = birthday.substring(0, 2);
		String day = birthday.substring(3);
		int intDay = 0;
		int intMonth = 0;

		try {
			intMonth = Integer.parseInt(month);
			intDay = Integer.parseInt(day);
			if (intDay > 0 && intDay < 32 && intMonth > 0 && intMonth < 13) {
				return true;
			} else {
				return false;
			}
		} catch (NumberFormatException e) {
			return false;
		}
	}

	// *****************************************************************************************************************************
	// Fill up the personTaskMap Map
	// Key = String (name of person)
	// Value = List of Tasks Associated with that person
	// **************************************************************************************************************************
	private static void fillMapByPerson(Map<String, List<Task>> map) {

		Scanner lineScan = null;
		String line;
		lineScan = new Scanner("blank");

		try (Scanner fileScan = new Scanner(new FileReader(new File("OutstandingTasks.txt")))) {

			while (fileScan.hasNext()) {
				line = fileScan.nextLine(); // full line of data
				lineScan = new Scanner(line);

				Task newTask = createTask(lineScan);

				if (map.containsKey(newTask.getWhoseTask())) {

					List<Task> taskList = map.get(newTask.getWhoseTask());

					if (taskList == null) {
						taskList = new ArrayList<Task>();
					}
					taskList.add(newTask);
				} else {
					List<Task> taskList = new ArrayList<Task>();
					taskList.add(newTask);
					map.put(newTask.getWhoseTask(), taskList);
				}

			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			lineScan.close();
		}

		System.out.println("map looks like ....." + map);
	}

	// *****************************************************************************************************************************
	// Create a Task
	// ************************************************************************************************************************
	private static Task createTask(Scanner lineScan) {

		lineScan.useDelimiter(",");

		String whoseTask = lineScan.next();
		String taskDetail = lineScan.next();

		String isItComplete = lineScan.next();
		boolean complete;
		if (isItComplete.equalsIgnoreCase("true")) {
			complete = true;
		} else {
			complete = false;
		}

		Task newTask = new Task(whoseTask, taskDetail, complete);
		return newTask;
	}

	// *****************************************************************************************************************************
	// COME HERE TO CHECK WHETHER A PERSON HAS COMPLETED ALL THEIR TASKS
	// MIGHT COME AFTER CLICKING A TASK CHECKBOX OR ADDING A TASK
	// *****************************************************************************************************************************
	public void checkIfTasksComplete(ActionEvent event, Task t1) {

		System.out.println("\nAND THE TASK IS ------- " + t1 + "\n");

		// Figure out which Task this checkBox maps to ...
		// Task t1 = checkBoxMap.get((CheckBox)event.getSource());

		List<Task> tasksToCheck = personMap.get(t1.getWhoseTask());

		boolean allComplete = true;

		for (Task t : tasksToCheck) {
			if (!t.isComplete()) {
				allComplete = false;
			}
		}

		System.out.println("\nAre all tasks complete? " + allComplete);

		if (allComplete) {
			String person = t1.getWhoseTask();
			String congratsMessage = "Huge Congratulations " + person + " you've finished all of today's tasks!";
			congratsLabel.setText(congratsMessage);
			playMedia();
		} else {
			congratsLabel.setText("");
		}

	}
	
	// *****************************************************************************************************************************
	// COME HERE WHEN EXITING THE PROGRAM - EITHER BY CLIKING THE EXIT BUTTON OR THE CLOSE APPLICATION "X"
	// *****************************************************************************************************************************
	public void btnClose_Click() {

		boolean confirm = false;
		confirm = ConfirmationBox.show("Are you sure you want to exit?", "Confirmation", "Yes", "No");
		if (confirm) {
			// Write any non-completed tasks to a file .....
			try {
				out = new PrintWriter(new FileOutputStream("OutstandingTasks.txt"));
				for (List<Task> taskList : personMap.values()) {
					for (Task task : taskList) {
						if (!task.isComplete()) {
							out.print(task.getWhoseTask() + "," + task.getTaskDetail() + "," + task.getCompete() + ","
									+ "\n");
						}
					}
				}

			} catch (FileNotFoundException e) {
				System.out.println("File OutstandingTasks.txt cannot be found");
			} finally {
				out.close();
			}
			
			// Write any menu ideas to a file .....
			try {
				out = new PrintWriter(new FileOutputStream("MenuDetails.txt"));


				if (!day1MenuText.getText().trim().equals("")) {
					out.print(thisWeekArr[0] + "," + day1MenuText.getText() + "," + "\n");
				}
				if (!day2MenuText.getText().trim().equals("")) {
					out.print(thisWeekArr[1] + "," + day2MenuText.getText() + "," + "\n");
				}
				if (!day3MenuText.getText().trim().equals("")) {
					out.print(thisWeekArr[2] + "," + day3MenuText.getText() + "," + "\n");
				}
				if (!day4MenuText.getText().trim().equals("")) {
					out.print(thisWeekArr[3] + "," + day4MenuText.getText() + "," + "\n");
				}
				if (!day5MenuText.getText().trim().equals("")) {
					out.print(thisWeekArr[4] + "," + day5MenuText.getText() + "," + "\n");
				}
				if (!day6MenuText.getText().trim().equals("")) {
					out.print(thisWeekArr[5] + "," + day6MenuText.getText() + "," + "\n");
				}
				if (!day7MenuText.getText().trim().equals("")) {
					out.print(thisWeekArr[6] + "," + day7MenuText.getText() + "," + "\n");
				}
			} catch (FileNotFoundException e) {
				System.out.println("File MenuDetails.txt cannot be found");
			} finally {
				out.close();
			}
			stage.close();
		}
	}
	
	// *****************************************************************************************************************************
	// COME HERE WHEN BUTTON TO "PLAY MEDIA" IS PRESSED ON HOME PAGE
	// *****************************************************************************************************************************
	private void playMedia() {
		File f = new File(PATH);
		Media media = new Media(f.toURI().toString());
		MediaPlayer mplayer = new MediaPlayer(media);
		mplayer.setAutoPlay(true);
	}
	
	// *****************************************************************************************************************************
	// COME HERE WHEN ADDING AN EXPIRED ITEM 
	// *****************************************************************************************************************************
	private void addItem_Click() {
		
	
	}
	
}
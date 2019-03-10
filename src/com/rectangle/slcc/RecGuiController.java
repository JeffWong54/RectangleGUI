/********************************************************
 *
 *  Project :  Intro to GUIs with JavaFX
 *  File    :  RecGuiController
 *  Name    :  Ryan Vreeke
 *  Date    :  <3/9/2019(3/12/19)>
 *
 *  Description : (Narrative desciption, not code)
 *
 *    1) What is the purpose of the code; what problem does the code solve.
 *    		this class is used to add functionality to the GUI that was created in Main. 
 *    	this class will get the info from the textFields and use that information to calculate the area and perimeter. there is also a c
 *    	clear function that clears the txtFields.
 *
 *    2) this implements Initializable 
 *
 *    3) What algorithms, techniques, etc. are used in implementing the data structures.
 *    		ActionEvent is used in this class to detect interaction from the user. as well as Exception handling to catch user error
 *
 *    4) What methods are implemented (optional).
 *
 *  Changes :  <3/9/2019>
 *
 ********************************************************/

package com.rectangle.slcc;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RecGuiController implements Initializable {
	// fields for the javaFx window
	@FXML
	private Label lblPerimeter;

	@FXML
	private TextField txtLength;

	@FXML
	private TextField txtWidth;

	@FXML
	private TextField txtArea;

	@FXML
	private Label lblWidth;

	@FXML
	private Label lblLength;

	@FXML
	private Button btnCalculate;

	@FXML
	private TextField txtPerimeter;

	@FXML
	private Button btnClear;

	@FXML
	private Label lblArea;
	
	/****************************************************
	 * Method     : calculateAction
	 *
	 * Purpose    : this method waits for the user to press
	 *              the calculate btn, it then calls the 
	 *              calculate method.
	 *
	 * Parameters : ActionEvent event  - this is an object that looks for an action

	 * Returns    : This method does not return a value.
	 *
	 ****************************************************/
	//calculate btn action listener. when the button is pressed this method gets called
	@FXML
	void calculateAction(ActionEvent event) 
	{
		//passes the variable that was in the width text field and the length text field and sends them to the calculate method
		calculate(txtLength.getText(), txtWidth.getText());

	}
	/****************************************************
	 * Method     : clearAction
	 *
	 * Purpose    : this method waits for the user to press
	 *              the clear btn, it then calls the 
	 *              clear method.
	 *
	 * Parameters : ActionEvent event  - this is an object that looks for an action

	 * Returns    : This method does not return a value.
	 *
	 ****************************************************/
	//action listener for the clear btn
	@FXML
	void clearAction(ActionEvent event) 
	{
		//calls cleartext 
		this.clearText();

	}
	/****************************************************
	 * Method     : closeAppFunciton
	 *
	 * Purpose    : this method waits for the user to press
	 *              the close btn located in the menu, 
	 *              it them closes the program and the window
	 *
	 * Parameters : ActionEvent event  - this is an object that looks for an action

	 * Returns    : This method does not return a value.
	 *
	 ****************************************************/
	// action listener for the menu btn close
	@FXML
	public void closeAppFunction(ActionEvent event)
	{	
		//closes the window and turns of the program
		Platform.exit();
		System.exit(0);

	}
	/****************************************************
	 * Method     : aboutFunction
	 *
	 * Purpose    : this method waits for the user to press
	 *              the about btn, it creates a stage object 
	 *              as well as a Main object, these objects are used to
	 *              call newStage locatied in the Main class.
	 *              .
	 *
	 * Parameters : ActionEvent event  - this is an object that looks for an action

	 * Returns    : This method does not return a value.
	 *
	 ****************************************************/
	//action listener for the about btn in the menu
	@FXML
	public void aboutFunction(ActionEvent event) 
	{	
		
		//makes a new stage object
		Stage primaryStage = new Stage();
		Main mainStage = new Main();// creates a new main object this is needed to call the newStage method 
		mainStage.newStage(primaryStage);// calls the new stage method with the stage object that was made before. this creates the about window
		
		

	}
	/****************************************************
	 * Method     : initialize
	 *
	 * Purpose    : this method is required when you implement initializable
	 *
	 * Parameters : URL arg0
	 * 				ResourceBundle arg1

	 * Returns    : This method does not return a value.
	 *
	 ****************************************************/
	//method that needs to be created when you implement initializable 
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		// TODO Auto-generated method stub

	}
	/****************************************************
	 * Method     : calculate
	 *
	 * Purpose    : this method takes its parameters and converts them to 
	 * 				numbers. it uses the numbers to calc area and perimeter
	 * 				it finishes by setting the textFields of area and perimeter
	 *
	 * Parameters : Length - this is the length txt located in the txtField
	 *				width - this is the length txt located in the txtField
	 *
	 * Returns    : This method does not return a value.
	 *
	 ****************************************************/
	// calculates the area and perimeter as well as sets the textFields
	public void calculate(String length, String width) 
	{	
		
		try 
		{
			int nLength, nWidth;// makes new in fields
			// turns the string that is located in the textField into integers so it can be calculated
			nLength = Integer.parseInt(length);
			nWidth = Integer.parseInt(width);
			//sets the textFields
			txtArea.setText("" + nLength * nWidth);
			txtPerimeter.setText("" + ((2 * nLength) + (2 * nWidth)));
		} catch (NumberFormatException e) // catches the exception that is thrown when the txt field doesn't contain a number
		{
			JOptionPane.showMessageDialog(null, e + "\n                   Please Enter only numbers!!");//displays as a JOptionPane message telling the user that they need to put a number in the txt field 
		}

	}
	/****************************************************
	 * Method     : clear
	 *
	 * Purpose    : clears the textFields
	 *
	 * Parameters : none
	 *
	 * Returns    : This method does not return a value.
	 *
	 ****************************************************/
	//clear method called to clear the text fields
	public void clearText() 
	{

		txtLength.clear();
		txtWidth.clear();
		txtPerimeter.clear();
		txtArea.clear();

	}
	

}

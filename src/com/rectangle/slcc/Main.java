/********************************************************
 *
 *  Project :  Intro to GUIs with JavaFX
 *  File    :  Main
 *  Name    :  Ryan Vreeke
 *  Date    :  <3/9/2019(3/12/19)>
 *
 *  Description : (Narrative desciption, not code)
 *
 *    1) What is the purpose of the code; what problem does the code solve.
 *    		this code was made to calculate the perimeter and area of a rectangle, while offering the user a GUI using JavaFx
 *
 *    2) Main extends Application
 *
 *    3) What algorithms, techniques, etc. are used in implementing the data structures.
 *    		i used exception handling to catch errors in a way that doesn't ruin the experience for the user
 *    		JavaFX was used with scenebuilder to create a GUI that looks compelling as well a offering utility to the user
 *
 *    4) What methods are implemented (optional).
 *
 *  Changes :  <3/9/2019>
 *
 ********************************************************/

package com.rectangle.slcc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Main extends Application 
{
	/****************************************************
	 * Method     : start
	 *
	 * Purpose    : this method creates the initial GUI
	 *
	 * Parameters : stage primaryStage  - takes a stage object to use for the GUI

	 * Returns    : This method does not return a value.
	 *
	 ****************************************************/
	@Override
	public void start(Stage primaryStage) 
	{
		//makes the JavaFX window
		try 
		{
			Parent root = FXMLLoader.load(getClass().getResource("RecGui.fxml"));//loads the FXML file
			
			//sets stage title 
			primaryStage.setTitle("Rectangle");
			primaryStage.setScene(new Scene(root));//sets scene to the root that was initialized with the fxml file
			primaryStage.show();//shows the scene

		} catch (Exception e)//catches exception and prints the stack trace
		{
			e.printStackTrace();
		}

	}
	/****************************************************
	 * Method     : newStage
	 *
	 * Purpose    : the only purpose of this method is to create the about
	 * 				window at a later time. does it in the same way the start method does
	 *
	 * Parameters : stage secondStage  - takes a stage object to use for the GUI

	 * Returns    : This method does not return a value.
	 *
	 ****************************************************/
	// this is the method that build the about window when called. it does the same thing as the primary window but loads a different fxml file
	public void newStage(Stage secondStage) 
	{
		try 
		{
					
			Parent root = FXMLLoader.load(getClass().getResource("AboutWindow.fxml"));

			secondStage.setTitle("Rectangle");
			secondStage.setScene(new Scene(root));
			secondStage.show();

		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}
	/****************************************************
	 * Method     : main
	 *
	 * Purpose    : used to start the program
	 *
	 * Parameters : string array of arguments

	 * Returns    : This method does not return a value.
	 *
	 ****************************************************/
	//main method that calls a launch method with arguments passed in
	public static void main(String[] args)
	{
		launch(args);
	}
}

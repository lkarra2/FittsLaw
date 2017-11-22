*******************************
Read Me - Fitt's Law Experiment
*******************************

Download the project at https://github.com/lkarra2/FittsLaw

This Project is broken into 2 Modules:

 circledata
	CaptureData - Stores all data for each click
	CircleData - Gets and Sets all data values for each circle

 fittsmain
	FittsMain - Main function to be RUN
	FittsPanel - Class which defines experiment flow and UI
	GetCircle - Plots n given points onto a circle
	StopWatch - Keeps track of elapsed time

**Requirements to run the experiment:
1. Java
2. IDE (Preferably IntelliJ, optional)
3. R 

**This Folder consists of 2 Directories:

	fittslawhw3  :  The Java Application to be run
	fittslaw_data_analysis. :  The R Project to be run for data analysis 
	ReadMe  : This document explaining what is what
	ScreenShots  :  Folder containing screenshots of the project

**Steps to run the experiment:
1. Open the Java Application folder in an IDE (Preferably IntelliJ) - Compile and run the .java files
2. Run the FittsMain file
3. Once the user completes, the data can be found at ./fittslawhw3/data.csv

**Steps to analyse data:
1. Open the fittslaw_data_analysis in RStudio 
2. OR run the FittsLawDataAnalysis.R file

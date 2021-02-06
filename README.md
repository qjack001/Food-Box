<h1 align="center">
  <br>
  <img src="/Resources/github-logo.png" alt="Food Box Logo" width="100">
  <br>
  FoodBox
</h1>

<h4 align="center">FoodBox is a smart cat feeder.<br>Developed in 2016 for the cumulative Internet-of-Things project during Grade 12 AP Computer Science.</h4>

<p align="center">
  <a href="#description">Description</a> •
  <a href="#key-features">Key Features</a> •
  <a href="#screenshots">Screenshots</a> •
  <a href="#how-to-use">How to Use</a> •
  <a href="#authors">Authors</a>
</p> 

## Description

The software component of our AP Computer Science IoT project. Features a GUI developed with Java's Swing framework, made to mimic the appearence of a material design application. Users are able to immediatly feed their cat using the large "feed" button, or schedule times of day for the feeder to automatically feed their cat. Comunicates with Arduino over the Serial port. When instructed to feed, the Arduino spins a servo motor, rotating a wood cylinder 90 degrees. A hole drilled through the wood allows food to pour out in one position, while blocking food in the other.

## Key Features

- Material Design GUI
- Communication with Arduino over Serial port
- *Feed your cat with ease!*

## Screenshots

![main page screenshot](https://raw.githubusercontent.com/qjack001/Food-Box/master/screenshots/Screen%20Shot%202019-01-14%20at%205.08.20%20AM.png)
> Main page. Click the big button to feed your cat, time since last feeding displayed underneath


![timers page screenshot](https://raw.githubusercontent.com/qjack001/Food-Box/master/screenshots/Screen%20Shot%202019-01-14%20at%205.09.52%20AM.png)
> Timers page. Create, edit, and delete timers (scheduled feedings).

<img src="https://raw.githubusercontent.com/qjack001/Food-Box/master/screenshots/Screen%20Shot%202019-01-14%20at%205.10.02%20AM.png" alt="Dialog box screenshot" width="400">

> Example of material design dialog boxes

## How to Use

Compile and run the main method in `Driver.java` to launch application. Note: Serial no longer working. Instead it just prints output to console as proof-of-concept.

## Authors

[**Jack Guinane**](https://github.com/qjack001) - Software development, Front-end, Software design

[**Quinn Smith**](https://github.com/quinnwerks) - Hardware development (Arduino, Serial), Software design



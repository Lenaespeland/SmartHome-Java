# SmartHome – Java OOP Project

A Java-based smart home simulation developed as part of the **OBJ2000 – Object-Oriented Programming** course at the University of South-Eastern Norway (USN).

The project demonstrates object-oriented design through a system that manages different types of smart home devices.

## Features

- Register and manage smart home devices
- Turn individual devices on and off
- Display an overview of registered devices
- Search for devices by name
- Turn off all devices
- Execute scheduled actions for compatible devices
- Run a simple morning routine

## Technologies

- Java 21
- Object-Oriented Programming (OOP)
- Visual Studio Code
- Git & GitHub

## Object-Oriented Concepts

The project demonstrates several fundamental OOP principles:

- **Encapsulation:** Device properties and internal states are managed through class methods.
- **Inheritance:** Different device types extend the abstract `SmartDevice` class.
- **Polymorphism:** Devices can be managed through a common superclass while maintaining their individual behavior.
- **Abstraction:** Shared device functionality is defined in an abstract class.
- **Interfaces:** The `Schedulable` interface defines functionality for devices supporting scheduled actions.
- **Collections:** An `ArrayList` is used to manage registered devices.

## Project Structure

```text
src/
├── myphone/
│   └── MyPhone.java
├── smarthome/
│   ├── app/
│   │   └── SmartHomeApp.java
│   ├── core/
│   │   └── SmartHome.java
│   └── model/
│       ├── SmartDevice.java
│       ├── Light.java
│       ├── MotionSensor.java
│       ├── Thermostat.java
│       └── Schedulable.java
└── test/
    ├── SmartHomeTask1Test.java
    ├── SmartHomeTask2Test.java
    ├── SmartHomeTask3Test.java
    ├── SmartHomeTask4Test.java
    ├── SmartHomeTask5Test.java
    └── SmartHomeValidationTest.java
```

## Design Overview

The system is organized into separate components:

- `SmartHome` manages registered devices and coordinates operations.
- `SmartDevice` provides shared functionality for device types.
- `Light`, `Thermostat`, and `MotionSensor` represent different smart devices.
- `SmartHomeApp` provides an application layer for interacting with the smart home.
- `MyPhone` represents the phone component.

This structure separates responsibilities and makes the code easier to maintain and extend.

## Project Status

Academic coursework project focused on applying object-oriented programming principles in Java.

## Running the project

Requires **Java 21**. No Maven, Gradle or external libraries are needed.

From the repository root, compile the sources in PowerShell:

```powershell
javac -d out src/smarthome/model/*.java src/smarthome/core/*.java src/smarthome/app/*.java src/myphone/*.java src/test/*.java
```

Run the SmartHome demonstration:

```powershell
java -cp out test.SmartHomeTask5Test
```

Run the self-checking tests:

```powershell
java -cp out test.SmartHomeValidationTest
```

The five `SmartHomeTask*Test` classes are demonstration programs from the coursework. `SmartHomeValidationTest` checks expected behavior and invalid inputs automatically.

## Notes

This is a small educational simulation rather than a production smart-home controller. The scheduled action is triggered manually; there is no background scheduler or physical-device integration.

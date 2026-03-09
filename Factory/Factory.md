# Factory Design Pattern – Operating System Example

## Overview

The **Factory Design Pattern** is a **Creational Design Pattern** used to create objects without exposing the object creation logic to the client. Instead of instantiating objects directly using `new`, the client requests objects from a **factory method**.

In this example, we implement a factory that creates different types of **Operating Systems** such as:

- Windows
- Linux

The factory decides which object to create based on the input provided.

---

# Key Components of Factory Pattern

## 1. Abstract Class / Interface

This is the **base type** for which objects will be created.

In this example:

```
OperatingSystem
```

All operating system types will extend this abstract class.

### OperatingSystem.java

```java
package factories;

public abstract class OperatingSystem {
    private String version;
    private String architecture;

    public OperatingSystem(String version, String architecture) {
        this.version = version;
        this.architecture = architecture;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getArchitecture() {
        return architecture;
    }

    public void setArchitecture(String architecture) {
        this.architecture = architecture;
    }

    public abstract void changeDir(String dir);
    public abstract void removeDir(String dir);
}
```

---

# Concrete Implementations

These classes extend the abstract class and provide specific implementations.

---

## WindowsOperatingSystem

```java
package factories;

public class WindowsOperatingSysten extends OperatingSystem {

    public WindowsOperatingSysten(String version, String architecture) {
        super(version, architecture);
    }

    @Override
    public void changeDir(String dir) {
        // Windows command
    }

    @Override
    public void removeDir(String dir) {
        // Windows command
    }
}
```

---

## LinuxOperatingSystem

```java
package factories;

public class LinuxOperatingSystem extends OperatingSystem {

    public LinuxOperatingSystem(String version, String architecture) {
        super(version, architecture);
    }

    @Override
    public void changeDir(String dir) {
        // Linux command
    }

    @Override
    public void removeDir(String dir) {
        // Linux command
    }
}
```

---

# Factory Class

The **factory class** contains the object creation logic. The client simply calls the factory and does not worry about which class is instantiated.

### OperatingSystemFactory.java

```java
import factories.LinuxOperatingSystem;
import factories.OperatingSystem;
import factories.WindowsOperatingSysten;

public class OperatingSystemFactory {

    private OperatingSystemFactory() {
    }

    public static OperatingSystem getInstance(String type, String version, String architecture) {

        switch (type) {

            case "WINDOWS":
                return new WindowsOperatingSysten(version, architecture);

            case "LINUX":
                return new LinuxOperatingSystem(version, architecture);

            default:
                throw new IllegalArgumentException("OS Not supported");
        }
    }
}
```

---

# Example Usage

```java
OperatingSystem operatingSystem =
        OperatingSystemFactory.getInstance("WINDOWS", "WIN7", "x64");

OperatingSystem operatingSystem2 =
        OperatingSystemFactory.getInstance("LINUX", "DEB", "x64");
```

The client does not need to know which class is being created.

---

# Advantages of Factory Pattern

- Encapsulates object creation logic
- Reduces tight coupling between classes
- Makes code easier to extend
- Centralizes object creation
- Supports Open/Closed Principle

For example, if a **MacOperatingSystem** needs to be added later, only the factory needs modification.

---

# Real Java Examples of Factory Pattern

Java uses the factory pattern extensively.

### 1. Calendar.getInstance()

```java
Calendar calendar = Calendar.getInstance();
```

Based on **Locale** and **TimeZone**, Java returns the appropriate calendar implementation.

---

### 2. Class.forName()

```java
Class.forName("com.mysql.jdbc.Driver");
```

Loads the specified class dynamically.


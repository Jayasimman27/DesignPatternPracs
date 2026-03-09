# Abstract Factory Design Pattern – UI Component Example

## Overview

The **Abstract Factory Pattern** is a **Creational Design Pattern** that provides an interface for creating **families of related or dependent objects** without specifying their concrete classes.

Unlike the **Factory Pattern**, which creates **one type of object**, the **Abstract Factory** creates **multiple related objects**.

Example: A UI toolkit that creates components for different operating systems.

- Windows UI
- Mac UI

Each OS has its own **Button** and **Checkbox** styles.

---

# Key Components of Abstract Factory

1. **Abstract Products** – Interfaces for the products.
2. **Concrete Products** – Implementations of those products.
3. **Abstract Factory** – Interface for creating products.
4. **Concrete Factories** – Implementations that produce product families.

---

# Step 1: Abstract Products

## Button Interface

```java
package abstractfactory;

public interface Button {
    void paint();
}
```

## Checkbox Interface

```java
package abstractfactory;

public interface Checkbox {
    void paint();
}
```

---

# Step 2: Concrete Products

## Windows Button

```java
package abstractfactory;

public class WindowsButton implements Button {

    @Override
    public void paint() {
        System.out.println("Rendering Windows Button");
    }
}
```

## Mac Button

```java
package abstractfactory;

public class MacButton implements Button {

    @Override
    public void paint() {
        System.out.println("Rendering Mac Button");
    }
}
```

## Windows Checkbox

```java
package abstractfactory;

public class WindowsCheckbox implements Checkbox {

    @Override
    public void paint() {
        System.out.println("Rendering Windows Checkbox");
    }
}
```

## Mac Checkbox

```java
package abstractfactory;

public class MacCheckbox implements Checkbox {

    @Override
    public void paint() {
        System.out.println("Rendering Mac Checkbox");
    }
}
```

---

# Step 3: Abstract Factory

This interface declares methods for creating each product.

```java
package abstractfactory;

public interface GUIFactory {

    Button createButton();

    Checkbox createCheckbox();
}
```

---

# Step 4: Concrete Factories

Each factory creates a **family of related objects**.

---

## Windows Factory

```java
package abstractfactory;

public class WindowsFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}
```

---

## Mac Factory

```java
package abstractfactory;

public class MacFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}
```

---

# Step 5: Client Code

The client uses the factory without knowing the concrete classes.

```java
package abstractfactory;

public class Application {

    private Button button;
    private Checkbox checkbox;

    public Application(GUIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void paint() {
        button.paint();
        checkbox.paint();
    }

    public static void main(String[] args) {

        GUIFactory factory;

        String os = "WINDOWS";

        if(os.equals("WINDOWS")){
            factory = new WindowsFactory();
        }else{
            factory = new MacFactory();
        }

        Application app = new Application(factory);
        app.paint();
    }
}
```

---

# Output Example

```
Rendering Windows Button
Rendering Windows Checkbox
```

---

# Advantages of Abstract Factory

- Ensures **compatible product families**
- Encapsulates object creation
- Promotes **loose coupling**
- Makes switching product families easy

Example:

Switching from **Windows UI** to **Mac UI** only requires changing the factory.

---

# Factory vs Abstract Factory

| Feature | Factory Pattern | Abstract Factory |
|-------|-------|-------|
| Object Creation | Single object | Family of objects |
| Complexity | Simple | More structured |
| Example | OS factory | UI component factory |
| Usage | When only one product is needed | When multiple related products are required |

---

# Real Java Examples

### DocumentBuilderFactory

```java
DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
```

Creates families of XML parsers.

---

### javax.xml.transform.TransformerFactory

Creates related XML transformation objects.

---

# Summary

The **Abstract Factory Pattern** is useful when:

- Multiple **related objects** must be created together
- The system must remain **independent of concrete classes**
- Product families must remain **consistent**

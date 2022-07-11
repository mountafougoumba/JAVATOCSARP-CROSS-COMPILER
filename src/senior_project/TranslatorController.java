/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senior_project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Collections;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.commons.collections.MapUtils;

/**
 * FXML Controller class
 *
 * @author Mountafougoumba
 */
public class TranslatorController implements Initializable {

    @FXML
    private AnchorPane translatoranchorPane;
    @FXML
    private TextArea javacodetextarea;
    @FXML
    private TextArea cchapcodetextarea1;
    @FXML
    private Button javacodeontranslateID;
    @FXML
    private Button clearjavacodeID;
    @FXML
    private Button cchapcodeontranslateID;
    @FXML
    private Button clearclearcodeID;
    @FXML
    private Button javacodeontranslateID1;
    @FXML
    private Button clearjavacodeID1;
    @FXML
    private Button savejavacodeID;
    @FXML
    private Button loadcchapfileID;
    @FXML
    private Button CchapcodeontranslateID2;

    public AnchorPane getTranslatoranchorPane() {
        return translatoranchorPane;
    }

    public void setTranslatoranchorPane(AnchorPane translatoranchorPane) {
        this.translatoranchorPane = translatoranchorPane;
    }

    public TextArea getJavacodetextarea() {
        return javacodetextarea;
    }

    public void setJavacodetextarea(TextArea javacodetextarea) {
        this.javacodetextarea = javacodetextarea;
    }

    public TextArea getCchapcodetextarea1() {
        return cchapcodetextarea1;
    }

    public void setCchapcodetextarea1(TextArea cchapcodetextarea1) {
        this.cchapcodetextarea1 = cchapcodetextarea1;
    }

    public Button getJavacodeontranslateID() {
        return javacodeontranslateID;
    }

    public void setJavacodeontranslateID(Button javacodeontranslateID) {
        this.javacodeontranslateID = javacodeontranslateID;
    }

    public Button getClearjavacodeID() {
        return clearjavacodeID;
    }

    public void setClearjavacodeID(Button clearjavacodeID) {
        this.clearjavacodeID = clearjavacodeID;
    }

    public Button getCchapcodeontranslateID() {
        return cchapcodeontranslateID;
    }

    public void setCchapcodeontranslateID(Button cchapcodeontranslateID) {
        this.cchapcodeontranslateID = cchapcodeontranslateID;
    }

    public Button getClearclearcodeID() {
        return clearclearcodeID;
    }

    public void setClearclearcodeID(Button clearclearcodeID) {
        this.clearclearcodeID = clearclearcodeID;
    }

    Map<String, String> languageJAVaCchap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    Map<String, String> languageCchapJAVa = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    FileChooser fileChooser = new FileChooser();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadData();
    }

    @FXML
    private void javacodeontranslate(ActionEvent event) {
        //loadData();
    	//working area
    	System.out.println("hello");
    	cchapcodetextarea1.clear();
    	boolean test = translate(javacodetextarea,cchapcodetextarea1);
    	System.out.println("result is:"+test);
        /*if (javacodetextarea.getText().isEmpty() && cchapcodetextarea1.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("You need to input a either a java code or a C# code!");
            alert.showAndWait();
        }
        if (!javacodetextarea.getText().isEmpty() && cchapcodetextarea1.getText().isEmpty()) {
        	
        	
        	
        	
        	
            String text = javacodetextarea.getText();
            String text1 = languageJAVaCchap.get(text);
            if (text1 == null) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("This java code contains an error");
                alert.showAndWait();
                javacodetextarea.clear();

            } else {

                cchapcodetextarea1.setText(text1);
            }

        }*/
        /*if (!javacodetextarea.getText().isEmpty() && !cchapcodetextarea1.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("!!!!!!!!ERROR!!!!!!!!!!!!!!!");
            alert.showAndWait();
            cchapcodetextarea1.clear();
            javacodetextarea.clear();
        }*/

    }

    @FXML
    private void clearjavacode(ActionEvent event) {
        initialiser();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("The java code is successful cleared!");
        alert.showAndWait();
        javacodetextarea.clear();
    }

    @FXML
    private void clearclearcode(ActionEvent event) {
        initialiser();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("The C# code is successful cleared!");
        alert.showAndWait();
        cchapcodetextarea1.clear();
    }

    @FXML
    private void savecchapcodeFile(ActionEvent event) {
        initialiser();
        String s = cchapcodetextarea1.getText();
        fileChooser.setInitialDirectory(new File("C:\\Users\\Mountafougoumba\\Documents\\NetBeansProjects\\Senior_project\\src\\output"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text File", ".txt"));
        File file = fileChooser.showSaveDialog(new Stage());
        if (file != null) {
            try {
                saveSystem(file, cchapcodetextarea1.getText());
            } catch (FileNotFoundException ex) {
                Logger.getLogger(TranslatorController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("The C# code is successful saved in the file!");
        alert.showAndWait();
        cchapcodetextarea1.clear();
    }

    public void saveSystem(File file, String s) throws FileNotFoundException {
        try (PrintWriter printWriter = new PrintWriter(file)) {
            printWriter.write(s);
            printWriter.close();
        }
    }

    @FXML
    private void onloggout(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(new Scene((Pane) loader.load()));
        stage.show();
        Node closeWindow = (Node) event.getSource();
        Stage stage1 = (Stage) closeWindow.getScene().getWindow();
        stage1.close();
    }

    @FXML
    private void javacodeontranslateFile(ActionEvent event) {
        try {
            fileChooser.setInitialDirectory(new File("C:\\Users\\Mountafougoumba\\Documents\\NetBeansProjects\\Senior_project\\src\\inputJava"));
            File file = fileChooser.showOpenDialog(new Stage());
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                javacodetextarea.appendText(scan.nextLine() + "\n");
            }
        } catch (FileNotFoundException ex) {
            System.out.println("You should select a file");
            Logger.getLogger(TranslatorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Onsavejavacode(ActionEvent event) {
        initialiser();
        String s = javacodetextarea.getText();
        fileChooser.setInitialDirectory(new File("C:\\Users\\Mountafougoumba\\Documents\\NetBeansProjects\\Senior_project\\src\\output"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text File", ".txt"));
        File file = fileChooser.showSaveDialog(new Stage());
        if (file != null) {
            try {
                saveSystem(file, s);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(TranslatorController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("The Java code is successful saved in the file!");
        alert.showAndWait();
        javacodetextarea.clear();

    }

    @FXML
    private void Onloadfilecchap(ActionEvent event) {
        try {
            fileChooser.setInitialDirectory(new File("C:\\Users\\Mountafougoumba\\Documents\\NetBeansProjects\\Senior_project\\src\\inputCchap"));
            File file = fileChooser.showOpenDialog(new Stage());
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                cchapcodetextarea1.appendText(scan.nextLine() + "\n");
            }
        } catch (FileNotFoundException ex) {
            System.out.println("You should selec a file");
            Logger.getLogger(TranslatorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void initialiser() {
        loadData();
    }

    public void loadData() {
        languageJAVaCchap.put("public class Test\n"
                + "{\n"
                + "    public static void main(String[] args) {\n"
                + "        String say = \"Hello, World\";\n"
                + "        System.out.println(\"Hello, World\");\n"
                + "    }\n"
                + "}",
                "public class Test\n"
                + "{\n"
                + "    public static void Main(String[] args)\n"
                + "    {\n"
                + "        var say = \"Hello, World\";\n"
                + "        Console.WriteLine(\"Hello, World\");\n"
                + "    }\n"
                + "}"
        );

        languageJAVaCchap.put("public class PrimeNumber  {\n"
                + "	public static void main(String args[]) {\n"
                + "		int i, m = 0, flag = 0;\n"
                + "		int n = 3;// it is the number to be checked\n"
                + "		m = n / 2;\n"
                + "		if (n == 0 || n == 1) {\n"
                + "			System.out.println(n + \" is not prime number\");\n"
                + "		} else {\n"
                + "			for (i = 2; i <= m; i++) {\n"
                + "				if (n % i == 0) {\n"
                + "					System.out.println(n + \" is not prime number\");\n"
                + "					flag = 1;\n"
                + "					break;\n"
                + "				}\n"
                + "			}\n"
                + "			if (flag == 0) {\n"
                + "				System.out.println(n + \" is prime number\");\n"
                + "			}\n"
                + "		} // end of else\n"
                + "	}\n"
                + "}", "public class PrimeNumber \n"
                + "{\n"
                + "    public static void Main(String[] args)\n"
                + "    {\n"
                + "        int i;\n"
                + "        var m = 0;\n"
                + "        var flag = 0;\n"
                + "        var n = 3;\n"
                + "        // it is the number to be checked\n"
                + "        m = (int)(n / 2);\n"
                + "        if (n == 0 || n == 1)\n"
                + "        {\n"
                + "            Console.WriteLine(n.ToString() + \" is not prime number\");\n"
                + "        }\n"
                + "        else {\n"
                + "            for (i = 2; i <= m; i++)\n"
                + "            {\n"
                + "                if (n % i == 0)\n"
                + "                {\n"
                + "                    Console.WriteLine(n.ToString() + \" is not prime number\");\n"
                + "                    flag = 1;\n"
                + "                    break;\n"
                + "                }\n"
                + "            }\n"
                + "            if (flag == 0)\n"
                + "            {\n"
                + "                Console.WriteLine(n.ToString() + \" is prime number\");\n"
                + "            }\n"
                + "        }\n"
                + "    }\n"
                + "}");
        languageJAVaCchap.put("import java.util.Scanner;\n"
                + "\n"
                + "class Test {\n"
                + "	public static void main(String[] args) {\n"
                + "		Scanner sc = new Scanner(System.in);\n"
                + "		String x = sc.nextLine();\n"
                + "		System.out.println(x);\n"
                + "	}\n"
                + "}", "// Include namespace system\n"
                + "using System;\n"
                + "using System.IO;\n"
                + "\n"
                + "public class Test\n"
                + "{\n"
                + "    public static void Main(String[] args)\n"
                + "    {\n"
                + "        var sc =  \"Inputs\";\n"
                + "        var x = Console.ReadLine();\n"
                + "        Console.WriteLine(x);\n"
                + "    }\n"
                + "}");
        languageJAVaCchap.put("public class PalindromeNumber {\n"
                + "	public static void main(String[] args) {\n"
                + "		int r = 0;\n"
                + "		int sum = 0;\n"
                + "		int temp;\n"
                + "		int n = 454;// It is the number variable to be checked for palindrome\n"
                + "\n"
                + "		temp = n;\n"
                + "		while (n > 0) {\n"
                + "			r = n % 10; // getting remainder\n"
                + "			sum = (sum * 10) + r;\n"
                + "			n = n / 10;\n"
                + "		}\n"
                + "		if (temp == sum) {\n"
                + "			System.out.println(\"palindrome number \");\n"
                + "		} else {\n"
                + "			System.out.println(\"not palindrome\");\n"
                + "		}\n"
                + "	}\n"
                + "}", "// Include namespace system\n"
                + "using System;\n"
                + "public class PalindromeNumber\n"
                + "{\n"
                + "    public static void Main(String[] args)\n"
                + "    {\n"
                + "        var r = 0;\n"
                + "        var sum = 0;\n"
                + "        int temp;\n"
                + "        var n = 454;\n"
                + "        // It is the number variable to be checked for palindrome\n"
                + "        temp = n;\n"
                + "        while (n > 0)\n"
                + "        {\n"
                + "            r = n % 10;\n"
                + "            // getting remainder\n"
                + "            sum = (sum * 10) + r;\n"
                + "            n = (int)(n / 10);\n"
                + "        }\n"
                + "        if (temp == sum)\n"
                + "        {\n"
                + "            Console.WriteLine(\"palindrome number \");\n"
                + "        }\n"
                + "        else {\n"
                + "            Console.WriteLine(\"not palindrome\");\n"
                + "        }\n"
                + "    }\n"
                + "}");

        languageJAVaCchap.put("public class FactorialNumber {\n"
                + "	public static void main(String[] args) {\n"
                + "		int i = 1;\n"
                + "		int fact = 1;\n"
                + "		int number = 5;// It is the number to calculate factorial\n"
                + "		for (i = 1; i <= number; i++) {\n"
                + "			fact = fact * i;\n"
                + "		}\n"
                + "		System.out.println(\"Factorial of \" + number + \" is: \" + fact);\n"
                + "	}\n"
                + "}", "// Include namespace system\n"
                + "using System;\n"
                + "public class FactorialNumber\n"
                + "{\n"
                + "    public static void Main(String[] args)\n"
                + "    {\n"
                + "        var i = 1;\n"
                + "        var fact = 1;\n"
                + "        var number = 5;\n"
                + "        // It is the number to calculate factorial\n"
                + "        for (i = 1; i <= number; i++)\n"
                + "        {\n"
                + "            fact = fact * i;\n"
                + "        }\n"
                + "        Console.WriteLine(\"Factorial of \" + number.ToString() + \" is: \" + fact.ToString());\n"
                + "    }\n"
                + "}");
        languageJAVaCchap.put("public class Test {\n"
                + "  public static void main(String[] args) {\n"
                + "\n"
                + "    int number = 44;\n"
                + "    String size;\n"
                + "\n"
                + "    // switch statement to check size\n"
                + "    switch (number) {\n"
                + "\n"
                + "      case 29:\n"
                + "        size = \"Small\";\n"
                + "        break;\n"
                + "\n"
                + "      case 42:\n"
                + "        size = \"Medium\";\n"
                + "        break;\n"
                + "\n"
                + "      // match the value of week\n"
                + "      case 44:\n"
                + "        size = \"Large\";\n"
                + "        break;\n"
                + "\n"
                + "      case 48:\n"
                + "        size = \"Extra Large\";\n"
                + "        break;\n"
                + "      \n"
                + "      default:\n"
                + "        size = \"Unknown\";\n"
                + "        break;\n"
                + "\n"
                + "    }\n"
                + "    System.out.println(\"Size: \" + size);\n"
                + "  }\n"
                + "}", "// Include namespace system\n"
                + "using System;\n"
                + "public class Test\n"
                + "{\n"
                + "    public static void Main(String[] args)\n"
                + "    {\n"
                + "        var number = 44;\n"
                + "        String size;\n"
                + "        // switch statement to check size\n"
                + "        switch (number)\n"
                + "         {\n"
                + "            case 29:\n"
                + "                size = \"Small\";\n"
                + "                break;\n"
                + "            case 42:\n"
                + "                size = \"Medium\";\n"
                + "                break;\n"
                + "            // match the value of week\n"
                + "            case 44:\n"
                + "                size = \"Large\";\n"
                + "                break;\n"
                + "            case 48:\n"
                + "                size = \"Extra Large\";\n"
                + "                break;\n"
                + "            default:\n"
                + "                size = \"Unknown\";\n"
                + "                break;\n"
                + "        }\n"
                + "        Console.WriteLine(\"Size: \" + size);\n"
                + "    }\n"
                + "}");
        languageJAVaCchap.put("public class Test {\n"
                + "  public static void main(String[] args) {\n"
                + "\n"
                + "    int n = 5;\n"
                + "    // for loop  \n"
                + "    for (int i = 1; i <= n; ++i) {\n"
                + "      System.out.println(\"Java is fun\");\n"
                + "    }\n"
                + "  }\n"
                + "}", "// Include namespace system\n"
                + "using System;\n"
                + "public class Test\n"
                + "{\n"
                + "    public static void Main(String[] args)\n"
                + "    {\n"
                + "        var n = 5;\n"
                + "        // for loop\n"
                + "        for (int i = 1; i <= n; ++i)\n"
                + "        {\n"
                + "            Console.WriteLine(\"Java is fun\");\n"
                + "        }\n"
                + "    }\n"
                + "}");
        languageJAVaCchap.put("public class Test\n"
                + "{\n"
                + "    public static void main(String[] args) {\n"
                + "        String say = \"Hello, World\";\n"
                + "        System.out.println(\"Hello, World\");\n"
                + "	System.out.println(\"Hello, Mamadou\");\n"
                + "    }\n"
                + "}", "// Include namespace system\n"
                + "using System;\n"
                + "// Tested Code\n"
                + "public class Test\n"
                + "{\n"
                + "    public static void Main(String[] args)\n"
                + "    {\n"
                + "        var say = \"Hello, World\";\n"
                + "        Console.WriteLine(\"Hello, World\");\n"
                + "        Console.WriteLine(\"Hello, Mamadou\");\n"
                + "    }\n"
                + "}");

        languageJAVaCchap.put("class Rectangle {\n"
                + "    private double length;\n"
                + "    private double width;\n"
                + "\n"
                + "    public Rectangle(double length, double width) {\n"
                + "        this.length = length;\n"
                + "        this.width = width;\n"
                + "    }\n"
                + "\n"
                + "    public Rectangle() {\n"
                + "    }\n"
                + "\n"
                + "    public double getLength() {\n"
                + "        return length;\n"
                + "    }\n"
                + "\n"
                + "    public void setLength(double length) {\n"
                + "        this.length = length;\n"
                + "    }\n"
                + "\n"
                + "    public double getWidth() {\n"
                + "        return width;\n"
                + "    }\n"
                + "\n"
                + "    public void setWidth(double width) {\n"
                + "        this.width = width;\n"
                + "    }\n"
                + "    \n"
                + "    public double perimeter(){\n"
                + "        return (this.length+this.width)*2;\n"
                + "    }\n"
                + "    \n"
                + "    public double Area(){\n"
                + "        return (this.length*this.width);\n"
                + "    }\n"
                + "\n"
                + "    @Override\n"
                + "    public int hashCode() {\n"
                + "        int hash = 5;\n"
                + "        hash = 71 * hash + (int) (Double.doubleToLongBits(this.length) ^ (Double.doubleToLongBits(this.length) >>> 32));\n"
                + "        hash = 71 * hash + (int) (Double.doubleToLongBits(this.width) ^ (Double.doubleToLongBits(this.width) >>> 32));\n"
                + "        return hash;\n"
                + "    }\n"
                + "\n"
                + "    @Override\n"
                + "    public boolean equals(Object obj) {\n"
                + "        if (this == obj) {\n"
                + "            return true;\n"
                + "        }\n"
                + "        if (obj == null) {\n"
                + "            return false;\n"
                + "        }\n"
                + "        if (getClass() != obj.getClass()) {\n"
                + "            return false;\n"
                + "        }\n"
                + "        final Rectangle other = (Rectangle) obj;\n"
                + "        if (Double.doubleToLongBits(this.length) != Double.doubleToLongBits(other.length)) {\n"
                + "            return false;\n"
                + "        }\n"
                + "        if (Double.doubleToLongBits(this.width) != Double.doubleToLongBits(other.width)) {\n"
                + "            return false;\n"
                + "        }\n"
                + "        return true;\n"
                + "    }\n"
                + "\n"
                + "    @Override\n"
                + "    public String toString() {\n"
                + "        return \"Rectangle{\" + \"length=\" + length + \", width=\" + width + '}';\n"
                + "    }\n"
                + "    \n"
                + "    \n"
                + "}", "// Include namespace system\n"
                + "using System;\n"
                + "using System.Threading;\n"
                + "\n"
                + "\n"
                + "\n"
                + "// Tested Code\n"
                + "public class Rectangle\n"
                + "{\n"
                + "    private double length;\n"
                + "    private double width;\n"
                + "    public Rectangle(double length, double width)\n"
                + "    {\n"
                + "        this.length = length;\n"
                + "        this.width = width;\n"
                + "    }\n"
                + "    public double getLength()\n"
                + "    {\n"
                + "        return this.length;\n"
                + "    }\n"
                + "    public void setLength(double length)\n"
                + "    {\n"
                + "        this.length = length;\n"
                + "    }\n"
                + "    public double getWidth()\n"
                + "    {\n"
                + "        return this.width;\n"
                + "    }\n"
                + "    public void setWidth(double width)\n"
                + "    {\n"
                + "        this.width = width;\n"
                + "    }\n"
                + "    public double perimeter()\n"
                + "    {\n"
                + "        return (this.length + this.width) * 2;\n"
                + "    }\n"
                + "    public double Area()\n"
                + "    {\n"
                + "        return (this.length * this.width);\n"
                + "    }\n"
                + "    public int hashCode()\n"
                + "    {\n"
                + "        var hash = 5;\n"
                + "        hash = 71 * hash + (int)(System.BitConverter.DoubleToInt64Bits(this.length) ^ (System.BitConverter.DoubleToInt64Bits(this.length) >> 32));\n"
                + "        hash = 71 * hash + (int)(System.BitConverter.DoubleToInt64Bits(this.width) ^ (System.BitConverter.DoubleToInt64Bits(this.width) >> 32));\n"
                + "        return hash;\n"
                + "    }\n"
                + "    public bool equals(object obj)\n"
                + "    {\n"
                + "        if (this.this == obj)\n"
                + "        {\n"
                + "            return true;\n"
                + "        }\n"
                + "        if (obj == null)\n"
                + "        {\n"
                + "            return false;\n"
                + "        }\n"
                + "        if (this.getClass() != obj.GetType())\n"
                + "        {\n"
                + "            return false;\n"
                + "        }\n"
                + "        final var other = (Rectangle)obj;\n"
                + "        if (System.BitConverter.DoubleToInt64Bits(this.length) != System.BitConverter.DoubleToInt64Bits(other.length))\n"
                + "        {\n"
                + "            return false;\n"
                + "        }\n"
                + "        if (System.BitConverter.DoubleToInt64Bits(this.width) != System.BitConverter.DoubleToInt64Bits(other.width))\n"
                + "        {\n"
                + "            return false;\n"
                + "        }\n"
                + "        return true;\n"
                + "    }\n"
                + "    public String toString()\n"
                + "    {\n"
                + "        return \"Rectangle{\" + \"length=\" + this.length.ToString() + \", width=\" + this.width.ToString() + '}'.ToString();\n"
                + "    }\n"
                
                + "}");
        languageJAVaCchap.put("import java.util.Scanner;\n"
                + "\n"
                + "class Test {\n"
                + "	public static void main(String[] args) {\n"
                + "		Scanner sc = new Scanner(System.in);\n"
                + "		String x = sc.nextLine();\n"
                + "		System.out.println(x);\n"
                + "		System.out.println(x);\n"
                + "	}\n"
                + "}", "// Include namespace system\n"
                + "using System;\n"
                + "using System.IO;\n"
                + "\n"
                + "public class Test\n"
                + "{\n"
                + "    public static void Main(String[] args)\n"
                + "    {\n"
                + "        var sc =  \"Inputs\";\n"
                + "        var x = Console.ReadLine();\n"
                + "        Console.WriteLine(x);\n"
                + "        Console.WriteLine(x);\n"
                + "    }\n"
                + "}");

        languageJAVaCchap.put("import java.util.Scanner;\n"
                + "\n"
                + "public class Test {\n"
                + "	public static void main(String[] args) {\n"
                + "		Scanner sc = new Scanner(System.in);\n"
                + "		String x = sc.nextLine();\n"
                + "		System.out.println(x);\n"
                + "	}\n"
                + "}", "// Include namespace system\n"
                + "using System;\n"
                + "using System.IO;\n"
                + "\n"
                + "\n"
                + "public class Test\n"
                + "{\n"
                + "    public static void Main(String[] args)\n"
                + "    {\n"
                + "        var sc =  \"Inputs\";\n"
                + "        var x = Console.ReadLine();\n"
                + "        Console.WriteLine(x);\n"
                + "    }\n"
                + "}");
        languageJAVaCchap.put("public class PrimeNumber {\n"
                + "	public static void main(String args[]) {\n"
                + "		int i, m = 0, flag = 0;\n"
                + "		int n = 3;// it is the number to be checked\n"
                + "		m = n / 2;\n"
                + "		if (n == 0 || n == 1) {\n"
                + "			System.out.println(n + \" is not prime number\");\n"
                + "		} else {\n"
                + "			for (i = 2; i <= m; i++) {\n"
                + "				if (n % i == 0) {\n"
                + "					System.out.println(n + \" is not prime number\");\n"
                + "					flag = 1;\n"
                + "					break;\n"
                + "				}\n"
                + "			}\n"
                + "			if (flag == 0) {\n"
                + "				System.out.println(n + \" is prime number\");\n"
                + "			}\n"
                + "		} // end of else\n"
                + "	}\n"
                + "}", "// Include namespace system\n"
                + "using System;\n"
                + "\n"
                + "\n"
                + "public class PrimeNumber\n"
                + "{\n"
                + "    public static void Main(String[] args)\n"
                + "    {\n"
                + "        int i;\n"
                + "        var m = 0;\n"
                + "        var flag = 0;\n"
                + "        var n = 3;\n"
                + "        // it is the number to be checked\n"
                + "        m = (int)(n / 2);\n"
                + "        if (n == 0 || n == 1)\n"
                + "        {\n"
                + "            Console.WriteLine(n.ToString() + \" is not prime number\");\n"
                + "        }\n"
                + "        else \n"
                + "        {\n"
                + "            for (i = 2; i <= m; i++)\n"
                + "            {\n"
                + "                if (n % i == 0)\n"
                + "                {\n"
                + "                    Console.WriteLine(n.ToString() + \" is not prime number\");\n"
                + "                    flag = 1;\n"
                + "                    break;\n"
                + "                }\n"
                + "            }\n"
                + "            if (flag == 0)\n"
                + "            {\n"
                + "                Console.WriteLine(n.ToString() + \" is prime number\");\n"
                + "            }\n"
                + "        }\n"
                + "    }\n"
                + "}");
        languageJAVaCchap.put("public class Rectangle {\n"
                + "    private double length;\n"
                + "    private double width;\n"
                + "\n"
                + "    public Rectangle(double length, double width) {\n"
                + "        this.length = length;\n"
                + "        this.width = width;\n"
                + "    }\n"
                + "\n"
                + "    public Rectangle() {\n"
                + "    }\n"
                + "\n"
                + "    public double getLength() {\n"
                + "        return length;\n"
                + "    }\n"
                + "\n"
                + "    public void setLength(double length) {\n"
                + "        this.length = length;\n"
                + "    }\n"
                + "\n"
                + "    public double getWidth() {\n"
                + "        return width;\n"
                + "    }\n"
                + "\n"
                + "    public void setWidth(double width) {\n"
                + "        this.width = width;\n"
                + "    }\n"
                + "    \n"
                + "    public double perimeter(){\n"
                + "        return (this.length+this.width)*2;\n"
                + "    }\n"
                + "    \n"
                + "    public double Area(){\n"
                + "        return (this.length*this.width);\n"
                + "    }\n"
                + "\n"
                + "    @Override\n"
                + "    public int hashCode() {\n"
                + "        int hash = 5;\n"
                + "        hash = 71 * hash + (int) (Double.doubleToLongBits(this.length) ^ (Double.doubleToLongBits(this.length) >>> 32));\n"
                + "        hash = 71 * hash + (int) (Double.doubleToLongBits(this.width) ^ (Double.doubleToLongBits(this.width) >>> 32));\n"
                + "        return hash;\n"
                + "    }\n"
                + "\n"
                + "    @Override\n"
                + "    public boolean equals(Object obj) {\n"
                + "        if (this == obj) {\n"
                + "            return true;\n"
                + "        }\n"
                + "        if (obj == null) {\n"
                + "            return false;\n"
                + "        }\n"
                + "        if (getClass() != obj.getClass()) {\n"
                + "            return false;\n"
                + "        }\n"
                + "        final Rectangle other = (Rectangle) obj;\n"
                + "        if (Double.doubleToLongBits(this.length) != Double.doubleToLongBits(other.length)) {\n"
                + "            return false;\n"
                + "        }\n"
                + "        if (Double.doubleToLongBits(this.width) != Double.doubleToLongBits(other.width)) {\n"
                + "            return false;\n"
                + "        }\n"
                + "        return true;\n"
                + "    }\n"
                + "\n"
                + "    @Override\n"
                + "    public String toString() {\n"
                + "        return \"Rectangle{\" + \"length=\" + length + \", width=\" + width + '}';\n"
                + "    }\n"
                + "    public static void main(String[] args) {\n"
                + "        Rectangle rectangle = new Rectangle(5, 5);\n"
                + "        System.out.println(rectangle.toString());\n"
                + "    }\n"
                + "    \n"
                + "}\n"
                + "", "// Include namespace system\n"
                + "using System;\n"
                + "using System.Threading;\n"
                + "\n"
                + "\n"
                + "\n"
                + "public class Rectangle\n"
                + "{\n"
                + "    private double length;\n"
                + "    private double width;\n"
                + "    public Rectangle(double length, double width)\n"
                + "    {\n"
                + "        this.length = length;\n"
                + "        this.width = width;\n"
                + "    }\n"
                + "    public double getLength()\n"
                + "    {\n"
                + "        return this.length;\n"
                + "    }\n"
                + "    public void setLength(double length)\n"
                + "    {\n"
                + "        this.length = length;\n"
                + "    }\n"
                + "    public double getWidth()\n"
                + "    {\n"
                + "        return this.width;\n"
                + "    }\n"
                + "    public void setWidth(double width)\n"
                + "    {\n"
                + "        this.width = width;\n"
                + "    }\n"
                + "    public double perimeter()\n"
                + "    {\n"
                + "        return (this.length + this.width) * 2;\n"
                + "    }\n"
                + "    public double Area()\n"
                + "    {\n"
                + "        return (this.length * this.width);\n"
                + "    }\n"
                + "    public int hashCode()\n"
                + "    {\n"
                + "        var hash = 5;\n"
                + "        hash = 71 * hash + (int)(System.BitConverter.DoubleToInt64Bits(this.length) ^ (System.BitConverter.DoubleToInt64Bits(this.length) >> 32));\n"
                + "        hash = 71 * hash + (int)(System.BitConverter.DoubleToInt64Bits(this.width) ^ (System.BitConverter.DoubleToInt64Bits(this.width) >> 32));\n"
                + "        return hash;\n"
                + "    }\n"
                + "    public bool equals(object obj)\n"
                + "    {\n"
                + "        if (this.this == obj)\n"
                + "        {\n"
                + "            return true;\n"
                + "        }\n"
                + "        if (obj == null)\n"
                + "        {\n"
                + "            return false;\n"
                + "        }\n"
                + "        if (this.getClass() != obj.GetType())\n"
                + "        {\n"
                + "            return false;\n"
                + "        }\n"
                + "        final var other = (Rectangle)obj;\n"
                + "        if (System.BitConverter.DoubleToInt64Bits(this.length) != System.BitConverter.DoubleToInt64Bits(other.length))\n"
                + "        {\n"
                + "            return false;\n"
                + "        }\n"
                + "        if (System.BitConverter.DoubleToInt64Bits(this.width) != System.BitConverter.DoubleToInt64Bits(other.width))\n"
                + "        {\n"
                + "            return false;\n"
                + "        }\n"
                + "        return true;\n"
                + "    }\n"
                + "    public String toString()\n"
                + "    {\n"
                + "        return \"Rectangle{\" + \"length=\" + this.length.ToString() + \", width=\" + this.width.ToString() + '}'.ToString();\n"
                + "    }\n"
                + "    public static void Main(String[] args)\n"
                + "    {\n"
                + "        var rectangle = new Rectangle(5, 5);\n"
                + "        Console.WriteLine(rectangle.toString());\n"
                + "    }\n"
                + "}");
        languageCchapJAVa = MapUtils.invertMap(languageJAVaCchap);

    }

    @FXML
    private void cChapcodeontranslate(ActionEvent event) {
    	
    	
    	boolean test = translateToCchap(cchapcodetextarea1,javacodetextarea);
    	System.out.println("hello this is:"+test);
    	System.out.println("Hello this is:"+javacodetextarea.getText());
    	/*
        if (javacodetextarea.getText().isEmpty() && !cchapcodetextarea1.getText().isEmpty()) {
            String text = cchapcodetextarea1.getText();
            String text1 = languageCchapJAVa.get(text);
            if (text1 == null) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("This C# code contains an error");
                alert.showAndWait();
                cchapcodetextarea1.clear();

            } else {

                javacodetextarea.setText(text1);
            }

        }*/
    }
    
    
  //translate file from java to C#
  	@SuppressWarnings("deprecation")
  	static public boolean translate(TextArea ta, TextArea tc) {
  		System.out.println("Starting Translation");
  		boolean success = false;
  		
  		String content = ta.getText();
  		
  		String translation = "";
  		
  		StringBuilder sb = new StringBuilder();
          
          ANTLRInputStream input = new ANTLRInputStream(content);
          
          antlr.JavaLexer lexer = new antlr.JavaLexer(input);
          
          CommonTokenStream tokens = new CommonTokenStream(lexer);
          
          antlr.JavaParser parser = new antlr.JavaParser(tokens);
          
          
          antlr.JavaListener listener = new antlr.JavaListener();
          for(int i=0;i<listener.tokens.size();i++) {
          	System.out.println(listener.tokens.get(i));
          }
          
          ParseTree tree = parser.compilationUnit();
          
          //System.out.println(tree.toStringTree(parser));
          ParseTreeWalker.DEFAULT.walk(listener, tree);
          int indent = 0, forDepth = 0;
          boolean forLoop = false;
          boolean arrayInit = false;
          for(int i=0;i<listener.tokens.size();i++) {
          	if((listener.tokens.get(i).contentEquals("=")
          			||listener.tokens.get(i).contentEquals("+")
          			||listener.tokens.get(i).contentEquals("-")
          			||listener.tokens.get(i).contentEquals("*")
          			||listener.tokens.get(i).contentEquals("/")
          			||listener.tokens.get(i).contentEquals(";")
          			||listener.tokens.get(i).contentEquals(")"))
          			&&listener.tokens.get(i-2).contentEquals("]")
          			&&!listener.tokens.get(i-4).contentEquals("int")
          			&&!listener.tokens.get(i-4).contentEquals("String")
          			&&!listener.tokens.get(i-4).contentEquals("double")
          			&&!listener.tokens.get(i-4).contentEquals("float")
          			&&!listener.tokens.get(i-4).contentEquals("boolean")
          			&&!listener.tokens.get(i-4).contentEquals("short")
          			&&!listener.tokens.get(i-4).contentEquals("long")
          			&&!listener.tokens.get(i-4).contentEquals("char")) {
          		Collections.swap(listener.tokens,i-2 , i-1);
          	}if(listener.tokens.get(i).contentEquals(",")&&
          			listener.tokens.get(i+1).contentEquals("}")) {
          		listener.tokens.remove(i);
          	}if(listener.tokens.get(i).contentEquals("]")
          			&&listener.tokens.get(i+3).contentEquals("length")) {
          		Collections.swap(listener.tokens,i,i+1);
          	}if(listener.tokens.get(i).contentEquals("]")
          			&&listener.tokens.get(i+2).contentEquals("[")) {
          		Collections.swap(listener.tokens,i,i+1);
          	}if(listener.tokens.get(i).contentEquals("=")
          			&&listener.tokens.get(i-1).contentEquals("]")
          			&&listener.tokens.get(i-3).contentEquals("[")
          			&&(listener.tokens.get(i-6).contentEquals("int")
          			||listener.tokens.get(i-6).contentEquals("String")
          			||listener.tokens.get(i-6).contentEquals("double")
          			||listener.tokens.get(i-6).contentEquals("float")
          			||listener.tokens.get(i-6).contentEquals("boolean")
          			||listener.tokens.get(i-6).contentEquals("short")
          			||listener.tokens.get(i-6).contentEquals("long")
          			||listener.tokens.get(i-6).contentEquals("char"))) {
          		Collections.swap(listener.tokens,i-2,i-1);
          	}if(listener.tokens.get(i).contentEquals("==")
          			&&listener.tokens.get(i-2).contentEquals("]")
          			&&listener.tokens.get(i-3).contentEquals("[")) {
          		Collections.swap(listener.tokens,i-2,i-1);
          	}if(listener.tokens.get(i).contentEquals(")")
          			&&listener.tokens.get(i+1).contentEquals("{")
          			&&listener.tokens.get(i-1).contentEquals("]")
          			&&(listener.tokens.get(i-6).contentEquals("int")
          			||listener.tokens.get(i-6).contentEquals("String")
          			||listener.tokens.get(i-6).contentEquals("double")
          			||listener.tokens.get(i-6).contentEquals("float")
          			||listener.tokens.get(i-6).contentEquals("boolean")
          			||listener.tokens.get(i-6).contentEquals("short")
          			||listener.tokens.get(i-6).contentEquals("long")
          			||listener.tokens.get(i-6).contentEquals("char"))) {
          		Collections.swap(listener.tokens,i-2,i-1);
          	}if(listener.tokens.get(i).contentEquals("]")
          			&&listener.tokens.get(i-3).contentEquals("(")
          			&&listener.tokens.get(i+6).contentEquals("{")) {
          		Collections.swap(listener.tokens,i-2,i-1);
          	}
          	if(listener.tokens.get(i).contentEquals(")")
          			&&listener.tokens.get(i+1).contentEquals("{")
          			&&listener.tokens.get(i-1).contentEquals("]")
          			&&(listener.tokens.get(i-8).contentEquals("int")
          			||listener.tokens.get(i-8).contentEquals("String")
          			||listener.tokens.get(i-8).contentEquals("double")
          			||listener.tokens.get(i-8).contentEquals("float")
          			||listener.tokens.get(i-8).contentEquals("boolean")
          			||listener.tokens.get(i-8).contentEquals("short")
          			||listener.tokens.get(i-8).contentEquals("long")
          			||listener.tokens.get(i-8).contentEquals("char"))) {
          		Collections.swap(listener.tokens,i-2,i-1);
          	}
          	if(listener.tokens.get(i).contentEquals("=")
          			&&listener.tokens.get(i-1).contentEquals("]")
          			&&listener.tokens.get(i-3).contentEquals("[")
          			&&(listener.tokens.get(i-8).contentEquals("int")
          			||listener.tokens.get(i-8).contentEquals("String")
          			||listener.tokens.get(i-8).contentEquals("double")
          			||listener.tokens.get(i-8).contentEquals("float")
          			||listener.tokens.get(i-8).contentEquals("boolean")
          			||listener.tokens.get(i-8).contentEquals("short")
          			||listener.tokens.get(i-8).contentEquals("long")
          			||listener.tokens.get(i-8).contentEquals("char"))) {
          		Collections.swap(listener.tokens,i-1,i-2);
          	}if(listener.tokens.get(i).contentEquals("length")
          			&&listener.tokens.get(i-1).contentEquals(".")
          			&&listener.tokens.get(i-2).contentEquals("]")
          			&&listener.tokens.get(i-20).contentEquals("GetLength(1)")) {
          		listener.tokens.set(i, "GetLength(2)");
          		listener.tokens.remove(i-2);
          		listener.tokens.remove(i-3);
          		listener.tokens.remove(i-4);
          	}if(listener.tokens.get(i).contentEquals("length")
          			&&listener.tokens.get(i-1).contentEquals(".")
          			&&listener.tokens.get(i-2).contentEquals("]")
          			&&listener.tokens.get(i-20).contentEquals("GetLength(0)")) {
          		listener.tokens.set(i, "GetLength(1)");
          		listener.tokens.remove(i-2);
          		listener.tokens.remove(i-3);
          		listener.tokens.remove(i-4);
          	}if(listener.tokens.get(i).contentEquals("length")
          			&&listener.tokens.get(i+4).contentEquals(")")
          			&&listener.tokens.get(i+20).contentEquals("length")) {
          		listener.tokens.set(i,"GetLength(0)");
          	}
          	
          		
          }
          translation +=("using System;\n");
          
          for (int i = 0; i < listener.tokens.size() - 1; i++) {
          	if (listener.tokens.get(i).contentEquals("for")) {
          		forLoop = true;
          	}
          	if (listener.tokens.get(i).contentEquals("(") && forLoop) {
          		forDepth++;
          	}
          	else if (listener.tokens.get(i).contentEquals(")") && forLoop) {
          		forDepth--;
          		if (forDepth == 0) {
          			forLoop = false;
          		}
          	}
          	
          	if (listener.tokens.get(i).contentEquals("=") && listener.tokens.get(i + 1).contentEquals("{")) {
          		arrayInit = true;
          		
          	}
          	if (listener.tokens.get(i).contentEquals("}") && arrayInit) {
          		arrayInit = false;
          	}
          	
          	translation +=(listener.tokens.get(i));
          	if (!listener.tokens.get(i).contentEquals(";") 
          			&& !listener.tokens.get(i).contentEquals(".") 
          			&& !listener.tokens.get(i + 1).contentEquals(".")
          			&& !listener.tokens.get(i).contentEquals("(")
          			&& !listener.tokens.get(i + 1).contentEquals("(")
          			&& !listener.tokens.get(i + 1).contentEquals(")")
          			&& !listener.tokens.get(i + 1).contentEquals(";")) {
          		translation +=(" ");
          	}
          	
          	
          	
          	if (listener.tokens.get(i).contentEquals(";")) {
          		if (!forLoop) {
          			translation +=("\n");
          		}
          		if (!listener.tokens.get(i + 1).contentEquals("}") && !forLoop) {
          			for (int y = 0; y < indent; y++) {
              			translation += ("    ");
              		}
          		}
          		else if (!forLoop) {
          			for (int y = 0; y < indent - 1; y++) {
              			translation += ("    ");
              		}
          		}
          		else if (!listener.tokens.get(i + 1).contentEquals("}") && forLoop) {
          			for (int y = 0; y < indent; y++) {
              			translation += (" ");
              		}
          		}
          		else if (forLoop) {
          			for (int y = 0; y < indent - 1; y++) {
              			translation += (" ");
              		}
          		}
          	}
          	else if (listener.tokens.get(i).contentEquals("{") && !arrayInit) {
          		translation += ("\n");
          		indent++;
          		for (int y = 0; y < indent; y++) {
          			translation += ("    ");
          		}
          	}
          	else if (listener.tokens.get(i).contentEquals("}") && !listener.tokens.get(i + 1).contentEquals(";")) {
          		translation += ("\n");
          		indent--;
          		if (!listener.tokens.get(i + 1).contentEquals("}")) {
          			for (int y = 0; y < indent; y++) {
              			translation += ("    ");
              		}
          		}
          		else {
          			for (int y = 0; y < indent - 1; y++) {
              			translation += ("    ");
              		}
          		}
          	}
          }
          
          translation += (listener.tokens.get(listener.tokens.size() - 1));
          translation = translation.replace("System.out.println", "Console.WriteLine");
          translation = translation.replace("System.out.print", "Console.WriteLine");
          translation = translation.replace("main", "Main");
          translation = translation.replace(".length()", ".Length");
          translation = translation.replace(".length", ".Length");
          translation = translation.replace(".charAt(i)", "[i]");
          translation = translation.replaceAll("Scanner.*.*;","");
          translation = translation.replaceAll("=.*nextInt().*;","= Convert.ToInt32(Console.ReadLine());");
          translation = translation.replaceAll("=.*nextLine().*;","= Console.ReadLine();");
          translation = translation.replaceAll("=.*nextDouble().*;","= Convert.ToDouble(Console.ReadLine());");
          translation = translation.replaceAll("=.*nextFloat().*;","= float.Parse(Console.ReadLine());");
          translation = translation.replaceAll("=.*nextChar().*;","= Console.ReadLine()[0];");
          translation = translation.replaceAll("=.*nextShort().*;","= (short)Convert.ToInt32(Console.ReadLine());");
          translation = translation.replaceAll("=.*nextLong().*;","= (long)Convert.ToInt32(Console.ReadLine());");
          translation = translation.replaceAll("boolean","bool");
          translation = translation.replaceAll("=.*nextBoolean().*;","= bool.Parse(Console.ReadLine());");
          translation = translation.replaceAll("=.*nextByte().*;","= byte.Parse(Console.ReadLine());");
          translation = translation.replaceAll("\\] \\[",",");
          translation = translation.replaceAll("\\]\\[",",");
          translation = translation.replaceAll("extends",":");
          translation = translation.replaceAll("implements",":");
          
          tc.setText(translation);
          translation = "";
          
          System.out.println("Translation Sucessful");
  		return success;
  	}
  	
  	
  	
  	
  	
  //translate file from  C# to Java
  	@SuppressWarnings("deprecation")
  	static public boolean translateToCchap(TextArea ta, TextArea tc) {
  		System.out.println("Starting Translation");
  		boolean success = false;
  		
  		String content = ta.getText();
  		
  		String translation = "";
  		
  		StringBuilder sb = new StringBuilder();
          
          ANTLRInputStream input = new ANTLRInputStream(content);
          
          antlr.JavaLexer lexer = new antlr.JavaLexer(input);
          
          CommonTokenStream tokens = new CommonTokenStream(lexer);
          
          antlr.JavaParser parser = new antlr.JavaParser(tokens);
          
          
          antlr.JavaListener listener = new antlr.JavaListener();
          for(int i=0;i<listener.tokens.size();i++) {
          	System.out.println(listener.tokens.get(i));
          }
          
          ParseTree tree = parser.compilationUnit();
          
          //System.out.println(tree.toStringTree(parser));
          ParseTreeWalker.DEFAULT.walk(listener, tree);
          int indent = 0, forDepth = 0;
          boolean forLoop = false;
          boolean arrayInit = false;
          for(int i=0;i<listener.tokens.size();i++) {
          	if((listener.tokens.get(i).contentEquals("=")
          			||listener.tokens.get(i).contentEquals("+")
          			||listener.tokens.get(i).contentEquals("-")
          			||listener.tokens.get(i).contentEquals("*")
          			||listener.tokens.get(i).contentEquals("/")
          			||listener.tokens.get(i).contentEquals(";")
          			||listener.tokens.get(i).contentEquals(")"))
          			&&listener.tokens.get(i-2).contentEquals("]")
          			&&!listener.tokens.get(i-4).contentEquals("int")
          			&&!listener.tokens.get(i-4).contentEquals("String")
          			&&!listener.tokens.get(i-4).contentEquals("double")
          			&&!listener.tokens.get(i-4).contentEquals("float")
          			&&!listener.tokens.get(i-4).contentEquals("boolean")
          			&&!listener.tokens.get(i-4).contentEquals("short")
          			&&!listener.tokens.get(i-4).contentEquals("long")
          			&&!listener.tokens.get(i-4).contentEquals("char")) {
          		Collections.swap(listener.tokens,i-2 , i-1);
          	}if(listener.tokens.get(i).contentEquals(",")&&
          			listener.tokens.get(i+1).contentEquals("}")) {
          		listener.tokens.remove(i);
          	}if(listener.tokens.get(i).contentEquals("]")
          			&&listener.tokens.get(i+3).contentEquals("length")) {
          		Collections.swap(listener.tokens,i,i+1);
          	}if(listener.tokens.get(i).contentEquals("]")
          			&&listener.tokens.get(i+2).contentEquals("[")) {
          		Collections.swap(listener.tokens,i,i+1);
          	}if(listener.tokens.get(i).contentEquals("=")
          			&&listener.tokens.get(i-1).contentEquals("]")
          			&&listener.tokens.get(i-3).contentEquals("[")
          			&&(listener.tokens.get(i-6).contentEquals("int")
          			||listener.tokens.get(i-6).contentEquals("String")
          			||listener.tokens.get(i-6).contentEquals("double")
          			||listener.tokens.get(i-6).contentEquals("float")
          			||listener.tokens.get(i-6).contentEquals("boolean")
          			||listener.tokens.get(i-6).contentEquals("short")
          			||listener.tokens.get(i-6).contentEquals("long")
          			||listener.tokens.get(i-6).contentEquals("char"))) {
          		Collections.swap(listener.tokens,i-2,i-1);
          	}if(listener.tokens.get(i).contentEquals("==")
          			&&listener.tokens.get(i-2).contentEquals("]")
          			&&listener.tokens.get(i-3).contentEquals("[")) {
          		Collections.swap(listener.tokens,i-2,i-1);
          	}if(listener.tokens.get(i).contentEquals(")")
          			&&listener.tokens.get(i+1).contentEquals("{")
          			&&listener.tokens.get(i-1).contentEquals("]")
          			&&(listener.tokens.get(i-6).contentEquals("int")
          			||listener.tokens.get(i-6).contentEquals("String")
          			||listener.tokens.get(i-6).contentEquals("double")
          			||listener.tokens.get(i-6).contentEquals("float")
          			||listener.tokens.get(i-6).contentEquals("boolean")
          			||listener.tokens.get(i-6).contentEquals("short")
          			||listener.tokens.get(i-6).contentEquals("long")
          			||listener.tokens.get(i-6).contentEquals("char"))) {
          		Collections.swap(listener.tokens,i-2,i-1);
          	}if(listener.tokens.get(i).contentEquals("]")
          			&&listener.tokens.get(i-3).contentEquals("(")
          			&&listener.tokens.get(i+6).contentEquals("{")) {
          		Collections.swap(listener.tokens,i-2,i-1);
          	}
          	if(listener.tokens.get(i).contentEquals(")")
          			&&listener.tokens.get(i+1).contentEquals("{")
          			&&listener.tokens.get(i-1).contentEquals("]")
          			&&(listener.tokens.get(i-8).contentEquals("int")
          			||listener.tokens.get(i-8).contentEquals("String")
          			||listener.tokens.get(i-8).contentEquals("double")
          			||listener.tokens.get(i-8).contentEquals("float")
          			||listener.tokens.get(i-8).contentEquals("boolean")
          			||listener.tokens.get(i-8).contentEquals("short")
          			||listener.tokens.get(i-8).contentEquals("long")
          			||listener.tokens.get(i-8).contentEquals("char"))) {
          		Collections.swap(listener.tokens,i-2,i-1);
          	}
          	if(listener.tokens.get(i).contentEquals("=")
          			&&listener.tokens.get(i-1).contentEquals("]")
          			&&listener.tokens.get(i-3).contentEquals("[")
          			&&(listener.tokens.get(i-8).contentEquals("int")
          			||listener.tokens.get(i-8).contentEquals("String")
          			||listener.tokens.get(i-8).contentEquals("double")
          			||listener.tokens.get(i-8).contentEquals("float")
          			||listener.tokens.get(i-8).contentEquals("boolean")
          			||listener.tokens.get(i-8).contentEquals("short")
          			||listener.tokens.get(i-8).contentEquals("long")
          			||listener.tokens.get(i-8).contentEquals("char"))) {
          		Collections.swap(listener.tokens,i-1,i-2);
          	}if(listener.tokens.get(i).contentEquals("length")
          			&&listener.tokens.get(i-1).contentEquals(".")
          			&&listener.tokens.get(i-2).contentEquals("]")
          			&&listener.tokens.get(i-20).contentEquals("GetLength(1)")) {
          		listener.tokens.set(i, "GetLength(2)");
          		listener.tokens.remove(i-2);
          		listener.tokens.remove(i-3);
          		listener.tokens.remove(i-4);
          	}if(listener.tokens.get(i).contentEquals("length")
          			&&listener.tokens.get(i-1).contentEquals(".")
          			&&listener.tokens.get(i-2).contentEquals("]")
          			&&listener.tokens.get(i-20).contentEquals("GetLength(0)")) {
          		listener.tokens.set(i, "GetLength(1)");
          		listener.tokens.remove(i-2);
          		listener.tokens.remove(i-3);
          		listener.tokens.remove(i-4);
          	}if(listener.tokens.get(i).contentEquals("length")
          			&&listener.tokens.get(i+4).contentEquals(")")
          			&&listener.tokens.get(i+20).contentEquals("length")) {
          		listener.tokens.set(i,"GetLength(0)");
          	}
          	
          		
          }
          translation +=("using System;\n");
          
          for (int i = 0; i < listener.tokens.size() - 1; i++) {
          	if (listener.tokens.get(i).contentEquals("for")) {
          		forLoop = true;
          	}
          	if (listener.tokens.get(i).contentEquals("(") && forLoop) {
          		forDepth++;
          	}
          	else if (listener.tokens.get(i).contentEquals(")") && forLoop) {
          		forDepth--;
          		if (forDepth == 0) {
          			forLoop = false;
          		}
          	}
          	
          	if (listener.tokens.get(i).contentEquals("=") && listener.tokens.get(i + 1).contentEquals("{")) {
          		arrayInit = true;
          		
          	}
          	if (listener.tokens.get(i).contentEquals("}") && arrayInit) {
          		arrayInit = false;
          	}
          	
          	translation +=(listener.tokens.get(i));
          	if (!listener.tokens.get(i).contentEquals(";") 
          			&& !listener.tokens.get(i).contentEquals(".") 
          			&& !listener.tokens.get(i + 1).contentEquals(".")
          			&& !listener.tokens.get(i).contentEquals("(")
          			&& !listener.tokens.get(i + 1).contentEquals("(")
          			&& !listener.tokens.get(i + 1).contentEquals(")")
          			&& !listener.tokens.get(i + 1).contentEquals(";")) {
          		translation +=(" ");
          	}
          	
          	
          	
          	if (listener.tokens.get(i).contentEquals(";")) {
          		if (!forLoop) {
          			translation +=("\n");
          		}
          		if (!listener.tokens.get(i + 1).contentEquals("}") && !forLoop) {
          			for (int y = 0; y < indent; y++) {
              			translation += ("    ");
              		}
          		}
          		else if (!forLoop) {
          			for (int y = 0; y < indent - 1; y++) {
              			translation += ("    ");
              		}
          		}
          		else if (!listener.tokens.get(i + 1).contentEquals("}") && forLoop) {
          			for (int y = 0; y < indent; y++) {
              			translation += (" ");
              		}
          		}
          		else if (forLoop) {
          			for (int y = 0; y < indent - 1; y++) {
              			translation += (" ");
              		}
          		}
          	}
          	else if (listener.tokens.get(i).contentEquals("{") && !arrayInit) {
          		translation += ("\n");
          		indent++;
          		for (int y = 0; y < indent; y++) {
          			translation += ("    ");
          		}
          	}
          	else if (listener.tokens.get(i).contentEquals("}") && !listener.tokens.get(i + 1).contentEquals(";")) {
          		translation += ("\n");
          		indent--;
          		if (!listener.tokens.get(i + 1).contentEquals("}")) {
          			for (int y = 0; y < indent; y++) {
              			translation += ("    ");
              		}
          		}
          		else {
          			for (int y = 0; y < indent - 1; y++) {
              			translation += ("    ");
              		}
          		}
          	}
          }
          
          translation += (listener.tokens.get(listener.tokens.size() - 1));
          translation = translation.replace("Console.WriteLine","System.out.println");
          translation = translation.replace("Console.WriteLine","System.out.print");
          translation = translation.replace("Main","main");
          translation = translation.replace(".Length",".length()" );
          translation = translation.replace(".Length",".length");
          translation = translation.replace("[i]",".charAt(i)");
          translation = translation.replaceAll("Scanner.*.*;","");
          translation = translation.replaceAll("= Convert.ToInt32(Console.ReadLine());","=.*nextInt().*;");
          translation = translation.replaceAll("= Console.ReadLine();","=.*nextLine().*;");
          translation = translation.replaceAll("= Convert.ToDouble(Console.ReadLine());","=.*nextDouble().*;");
          translation = translation.replaceAll("= float.Parse(Console.ReadLine());","=.*nextFloat().*;");
          translation = translation.replaceAll("= Console.ReadLine()[0];","=.*nextChar().*;");
          translation = translation.replaceAll("= (short)Convert.ToInt32(Console.ReadLine());","=.*nextShort().*;");
          translation = translation.replaceAll("= (long)Convert.ToInt32(Console.ReadLine());","=.*nextLong().*;");
          translation = translation.replaceAll("boolean","bool");
          translation = translation.replaceAll("= bool.Parse(Console.ReadLine());","=.*nextBoolean().*;");
          translation = translation.replaceAll("= byte.Parse(Console.ReadLine());","=.*nextByte().*;");
          translation = translation.replaceAll(",","\\] \\[");
          translation = translation.replaceAll(",","\\]\\[");
          translation = translation.replaceAll(":","extends");
          translation = translation.replaceAll(":","implements");
          
          tc.setText(translation);
          translation = "";
          
          System.out.println("Translation Sucessful");
  		return success;
  	}


}

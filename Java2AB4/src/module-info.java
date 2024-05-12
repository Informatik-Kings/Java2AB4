module JavaAB4 {
	requires javafx.controls;
   requires javafx.graphics;
   requires javafx.base;
   requires java.desktop;
   requires java.datatransfer;
	
	opens application to javafx.graphics, javafx.fxml;
}

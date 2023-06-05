module hse.cs.se.klavogonki {
    requires javafx.controls;
    requires javafx.fxml;


    opens hse.cs.se.klavogonki to javafx.fxml;
    exports hse.cs.se.klavogonki;
}
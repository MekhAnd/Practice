module com.gmail.mekhanich.andrii.lesson_14_ch_contactbook {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.gmail.mekhanich.andrii.contactBook.lesson_14_ch_contactbook to javafx.fxml;
    exports com.gmail.mekhanich.andrii.contactBook.lesson_14_ch_contactbook;
    exports com.gmail.mekhanich.andrii.contactBook.lesson_14_ch_contactbook.datamodel;
    opens com.gmail.mekhanich.andrii.contactBook.lesson_14_ch_contactbook.datamodel to javafx.fxml;
}
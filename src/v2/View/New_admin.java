package v2.View;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class New_admin implements com.trolltech.qt.QUiForm<QDialog>
{
    public QWidget main;
    public QLineEdit firstname;
    public QLineEdit lastname;
    public QLineEdit tagid;
    public QLabel label;
    public QLabel label_2;
    public QLabel label_3;
    public QComboBox fpcombo;
    public QLabel label_4;
    public QComboBox spcombo;
    public QComboBox tpcombo;
    public QComboBox fpcombo_2;
    public QLabel label_5;
    public QLabel label_6;
    public QLabel label_7;
    public QLabel label_8;
    public QLabel banner;
    public QDialogButtonBox buttonBox;
    public QLabel label_9;
    public QLineEdit id;

    public New_admin() { super(); }

    public void setupUi(QDialog Dialog)
    {
        Dialog.setObjectName("Dialog");
        Dialog.resize(new QSize(397, 514).expandedTo(Dialog.minimumSizeHint()));
        Dialog.setModal(true);
        
        main = new QWidget(Dialog);
        main.setObjectName("main");
        main.setGeometry(new QRect(0, 0, 511, 531));
        main.setMaximumSize(new QSize(511, 531));
        main.setStyleSheet("#main{\n"+
				"	background-color: rgba(52,52,52,52);\n"+
				"}\n"+
				"\n"+
				"QLabel{\n"+
				"	color: black;\n"+
				"    font: 13pt \"Calibri\";\n"+
				"}\n"+
				"\n"+
				"QLineEdit{\n"+
				"    font: 13pt \"Calibri\";\n"+
				"}\n"+
				"\n"+
				"#banner{\n"+
				"	 font: 15pt \"Calibri\";\n"+
				"}");
        
        firstname = new QLineEdit(main);
        firstname.setObjectName("firstname");
        firstname.setGeometry(new QRect(140, 80, 191, 21));
        
        lastname = new QLineEdit(main);
        lastname.setObjectName("lastname");
        lastname.setGeometry(new QRect(140, 130, 191, 21));
        
        tagid = new QLineEdit(main);
        tagid.setObjectName("tagid");
        tagid.setGeometry(new QRect(140, 230, 191, 21));
        
        label = new QLabel(main);
        label.setObjectName("label");
        label.setGeometry(new QRect(40, 80, 81, 21));
        label.setStyleSheet("");
        
        label_2 = new QLabel(main);
        label_2.setObjectName("label_2");
        label_2.setGeometry(new QRect(40, 130, 81, 21));
        
        label_3 = new QLabel(main);
        label_3.setObjectName("label_3");
        label_3.setGeometry(new QRect(40, 230, 81, 21));
        
        fpcombo = new QComboBox(main);
        fpcombo.setObjectName("fpcombo");
        fpcombo.setGeometry(new QRect(50, 340, 121, 22));
        
        label_4 = new QLabel(main);
        label_4.setObjectName("label_4");
        label_4.setGeometry(new QRect(160, 285, 261, 21));
        label_4.setMinimumSize(new QSize(261, 21));
        
        spcombo = new QComboBox(main);
        spcombo.setObjectName("spcombo");
        spcombo.setGeometry(new QRect(220, 340, 121, 22));
        
        tpcombo = new QComboBox(main);
        tpcombo.setObjectName("tpcombo");
        tpcombo.setGeometry(new QRect(50, 410, 121, 22));
        
        fpcombo_2 = new QComboBox(main);
        fpcombo_2.setObjectName("fpcombo_2");
        fpcombo_2.setGeometry(new QRect(220, 410, 121, 22));
        
        label_5 = new QLabel(main);
        label_5.setObjectName("label_5");
        label_5.setGeometry(new QRect(50, 320, 81, 20));
        
        label_6 = new QLabel(main);
        label_6.setObjectName("label_6");
        label_6.setGeometry(new QRect(220, 320, 81, 20));
        
        label_7 = new QLabel(main);
        label_7.setObjectName("label_7");
        label_7.setGeometry(new QRect(50, 390, 81, 20));
        
        label_8 = new QLabel(main);
        label_8.setObjectName("label_8");
        label_8.setGeometry(new QRect(220, 390, 81, 20));
        
        banner = new QLabel(main);
        banner.setObjectName("banner");
        banner.setGeometry(new QRect(20, 20, 281, 51));
        
        buttonBox = new QDialogButtonBox(main);
        buttonBox.setObjectName("buttonBox");
        buttonBox.setGeometry(new QRect(90, 450, 191, 61));
        buttonBox.setOrientation(com.trolltech.qt.core.Qt.Orientation.Horizontal);
        buttonBox.setStandardButtons(com.trolltech.qt.gui.QDialogButtonBox.StandardButton.createQFlags(com.trolltech.qt.gui.QDialogButtonBox.StandardButton.Cancel,com.trolltech.qt.gui.QDialogButtonBox.StandardButton.Save));
        
        label_9 = new QLabel(main);
        label_9.setObjectName("label_9");
        label_9.setGeometry(new QRect(40, 180, 81, 21));
        
        id = new QLineEdit(main);
        id.setObjectName("id");
        id.setGeometry(new QRect(140, 180, 191, 21));
        
        retranslateUi(Dialog);
        buttonBox.accepted.connect(Dialog, "accept()");
        buttonBox.rejected.connect(Dialog, "reject()");

        Dialog.connectSlotsByName();
    } // setupUi

    void retranslateUi(QDialog Dialog)
    {
        Dialog.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Dialog", null));
        label.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "First Name:", null));
        label_2.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Last Name:", null));
        label_3.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Tag id:", null));
        label_4.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Timetable:", null));
        label_5.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Period 1:", null));
        label_6.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Period 2:", null));
        label_7.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Period 3:", null));
        label_8.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Period 4:", null));
        banner.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "                    New Administrator", null));
        label_9.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Admin id:", null));
    } // retranslateUi

}


package v2.View;
/********************************************************************************
 ** Form generated from reading ui file 'StuDialog.jui'
 **
 ** Created by: Qt User Interface Compiler version 4.8.6
 **
 ** WARNING! All changes made in this file will be lost when recompiling ui file!
 ********************************************************************************/
import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class New_student implements com.trolltech.qt.QUiForm<QDialog>
{
    public QWidget main;
    public QLineEdit namefedit;
    public QLineEdit nameledit;
    public QLineEdit tagidedit;
    public QLabel label;
    public QLabel label_2;
    public QLabel label_3;
    public QComboBox fpcombo;
    public QLabel label_4;
    public QComboBox spcombo;
    public QComboBox tpcombo;
    public QComboBox fopcombo;
    public QLabel label_5;
    public QLabel label_6;
    public QLabel label_7;
    public QLabel label_8;
    public QLabel banner;
    public QLabel label_9;
    public QLineEdit stuidedit;
    public QDialogButtonBox buttonBox;

    public New_student() { super(); }

    public void setupUi(QDialog Dialog)
    {
        Dialog.setObjectName("Dialog");
        Dialog.resize(new QSize(398, 514).expandedTo(Dialog.minimumSizeHint()));
        Dialog.setMinimumSize(new QSize(0, 507));
        Dialog.setMaximumSize(new QSize(497, 600));
        Dialog.setModal(true);
        main = new QWidget(Dialog);
        main.setObjectName("main");
        main.setGeometry(new QRect(0, 0, 511, 551));
        main.setMinimumSize(new QSize(511, 551));
        main.setMaximumSize(new QSize(511, 551));
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
        namefedit = new QLineEdit(main);
        namefedit.setObjectName("namefedit");
        namefedit.setGeometry(new QRect(140, 80, 191, 21));
        nameledit = new QLineEdit(main);
        nameledit.setObjectName("nameledit");
        nameledit.setGeometry(new QRect(140, 130, 191, 21));
        tagidedit = new QLineEdit(main);
        tagidedit.setObjectName("tagidedit");
        tagidedit.setGeometry(new QRect(140, 180, 191, 21));
        label = new QLabel(main);
        label.setObjectName("label");
        label.setGeometry(new QRect(40, 80, 81, 21));
        label.setStyleSheet("");
        label_2 = new QLabel(main);
        label_2.setObjectName("label_2");
        label_2.setGeometry(new QRect(40, 130, 81, 21));
        label_3 = new QLabel(main);
        label_3.setObjectName("label_3");
        label_3.setGeometry(new QRect(40, 180, 81, 21));
        fpcombo = new QComboBox(main);
        fpcombo.setObjectName("fpcombo");
        fpcombo.setGeometry(new QRect(50, 340, 121, 22));
        label_4 = new QLabel(main);
        label_4.setObjectName("label_4");
        label_4.setGeometry(new QRect(160, 280, 171, 21));
        spcombo = new QComboBox(main);
        spcombo.setObjectName("spcombo");
        spcombo.setGeometry(new QRect(220, 340, 121, 22));
        tpcombo = new QComboBox(main);
        tpcombo.setObjectName("tpcombo");
        tpcombo.setGeometry(new QRect(50, 410, 121, 22));
        fopcombo = new QComboBox(main);
        fopcombo.setObjectName("fopcombo");
        fopcombo.setGeometry(new QRect(220, 410, 121, 22));
        label_5 = new QLabel(main);
        label_5.setObjectName("label_5");
        label_5.setGeometry(new QRect(50, 320, 81, 20));
        label_6 = new QLabel(main);
        label_6.setObjectName("label_6");
        label_6.setGeometry(new QRect(220, 320, 81, 20));
        label_7 = new QLabel(main);
        label_7.setObjectName("label_7");
        label_7.setGeometry(new QRect(50, 390, 81, 21));
        label_8 = new QLabel(main);
        label_8.setObjectName("label_8");
        label_8.setGeometry(new QRect(220, 390, 81, 20));
        banner = new QLabel(main);
        banner.setObjectName("banner");
        banner.setGeometry(new QRect(50, 20, 241, 51));
        label_9 = new QLabel(main);
        label_9.setObjectName("label_9");
        label_9.setGeometry(new QRect(40, 230, 81, 21));
        stuidedit = new QLineEdit(main);
        stuidedit.setObjectName("stuidedit");
        stuidedit.setGeometry(new QRect(140, 230, 191, 21));
        buttonBox = new QDialogButtonBox(main);
        buttonBox.setObjectName("buttonBox");
        buttonBox.setGeometry(new QRect(30, 450, 251, 61));
        buttonBox.setOrientation(com.trolltech.qt.core.Qt.Orientation.Horizontal);
        buttonBox.setStandardButtons(com.trolltech.qt.gui.QDialogButtonBox.StandardButton.createQFlags(com.trolltech.qt.gui.QDialogButtonBox.StandardButton.Cancel,com.trolltech.qt.gui.QDialogButtonBox.StandardButton.Save));
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
        label_3.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Tag ID:", null));
        label_4.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Timetable:", null));
        label_5.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Period 1:", null));
        label_6.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Period 2:", null));
        label_7.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Period 3:", null));
        label_8.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Period 4:", null));
        banner.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "                    New Student", null));
        label_9.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Student id:", null));
    } // retranslateUi

}


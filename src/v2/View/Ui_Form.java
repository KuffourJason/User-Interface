package v2.View;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_Form implements com.trolltech.qt.QUiForm<QWidget>
{
    public QWidget holder;
    public QLabel fNameLabel;
    public QLabel lNameLabel;
    public QLabel tLatesLabel;
    public QLabel tAbsentLabel;
    public QLabel cStatusLabel;
    public QPushButton deleteButton;
    public static QLabel fname;
    public QLabel lname;
    public QLabel cStatus;
    public QLabel lates;
    public QLabel absents;
    public QPushButton expandButton;
    public QLabel timeLabel;
    public QLabel idLabel;
    public QLabel id;
    public QTableView timeTable;

    public Ui_Form() { super(); }

    public void setupUi(QWidget Form)
    {
        holder = new QWidget(Form);
        Form.layout().addWidget(holder);
        holder.setObjectName("holder");
        holder.setGeometry(new QRect(0, 0, 621, 101));
        
        QSizePolicy sizePolicy = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Minimum, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy.setHorizontalStretch((byte)0);
        sizePolicy.setVerticalStretch((byte)0);

        holder.setObjectName("holder");
        holder.setGeometry(new QRect(0, 0, 621, 101));
        QSizePolicy sizePolicy1 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Minimum, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy1.setHorizontalStretch((byte)0);
        sizePolicy1.setVerticalStretch((byte)0);
        sizePolicy1.setHeightForWidth(holder.sizePolicy().hasHeightForWidth());
        holder.setSizePolicy(sizePolicy1);
        holder.setMinimumSize(new QSize(621, 101));
        holder.setStyleSheet("QWidget#holder{\n"+
"	background-color:  rgba(52, 52, 52, 255);\n"+
"    border-style: solid;\n"+
"	border-color: rgba(255, 255, 255, 150);\n"+
"    border-width: 3px;\n"+
"}\n"+
"\n"+
"QLabel{\n"+
"	font: 13pt \"Calibri\";\n"+
"    color: white;\n"+
"}\n"+
"\n"+
"QPushButton{\n"+
"    background-color: white;\n"+
"	border-radius: 10px;\n"+
"}\n"+
"\n"+
"QPushButton:hover{\n"+
"	background-color: rgb(220, 220, 220);\n"+
"}");
        fNameLabel = new QLabel(holder);
        fNameLabel.setObjectName("fNameLabel");
        fNameLabel.setGeometry(new QRect(10, 0, 81, 31));
        lNameLabel = new QLabel(holder);
        lNameLabel.setObjectName("lNameLabel");
        lNameLabel.setGeometry(new QRect(10, 30, 81, 31));
        tLatesLabel = new QLabel(holder);
        tLatesLabel.setObjectName("tLatesLabel");
        tLatesLabel.setGeometry(new QRect(250, 0, 111, 31));
        tAbsentLabel = new QLabel(holder);
        tAbsentLabel.setObjectName("tAbsentLabel");
        tAbsentLabel.setGeometry(new QRect(250, 30, 111, 31));
        cStatusLabel = new QLabel(holder);
        cStatusLabel.setObjectName("cStatusLabel");
        cStatusLabel.setGeometry(new QRect(250, 60, 111, 31));
        deleteButton = new QPushButton(holder);
        deleteButton.setObjectName("deleteButton");
        deleteButton.setGeometry(new QRect(580, 10, 31, 31));
        fname = new QLabel(holder);
        fname.setObjectName("fname");
        fname.setGeometry(new QRect(130, 0, 101, 31));
        lname = new QLabel(holder);
        lname.setObjectName("lname");
        lname.setGeometry(new QRect(130, 30, 101, 31));
        cStatus = new QLabel(holder);
        cStatus.setObjectName("cStatus");
        cStatus.setGeometry(new QRect(370, 60, 101, 31));
        lates = new QLabel(holder);
        lates.setObjectName("lates");
        lates.setGeometry(new QRect(370, 0, 111, 31));
        absents = new QLabel(holder);
        absents.setObjectName("absents");
        absents.setGeometry(new QRect(370, 30, 111, 31));
        absents.setStyleSheet("");
        expandButton = new QPushButton(holder);
        expandButton.setObjectName("expandButton");
        expandButton.setGeometry(new QRect(580, 60, 31, 31));
        timeLabel = new QLabel(holder);
        timeLabel.setObjectName("timeLabel");
        timeLabel.setGeometry(new QRect(10, 110, 111, 31));
        idLabel = new QLabel(holder);
        idLabel.setObjectName("idLabel");
        idLabel.setGeometry(new QRect(10, 60, 111, 31));
        id = new QLabel(holder);
        id.setObjectName("id");
        id.setGeometry(new QRect(130, 60, 101, 31));
        timeTable = new QTableView(Form);
        timeTable.setObjectName("timeTable");
        timeTable.setGeometry(new QRect(130, 100, 431, 51));
        QSizePolicy sizePolicy2 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Minimum, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy2.setHorizontalStretch((byte)0);
        sizePolicy2.setVerticalStretch((byte)0);
        sizePolicy2.setHeightForWidth(timeTable.sizePolicy().hasHeightForWidth());
        timeTable.setSizePolicy(sizePolicy2);
        retranslateUi(Form);

    } // setupUi

    void retranslateUi(QWidget Form)
    {
        fNameLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "First name:", null));
        lNameLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "Last name:", null));
        tLatesLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "Total Lates:", null));
        tAbsentLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "Total Absents:", null));
        cStatusLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "Current Status:", null));
        deleteButton.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", " X", null));
        fname.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "TextLabel", null));
        lname.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "TextLabel", null));
        cStatus.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "TextLabel", null));
        lates.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "TextLabel", null));
        absents.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "TextLabel", null));
        expandButton.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "\\/", null));
        timeLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "Timetable:", null));
        idLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "Student ID:", null));
        id.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "TextLabel", null));
    } // retranslateUi

}


package v2.View;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

import v2.Controller.Controller;

public class AdminTabs implements com.trolltech.qt.QUiForm<QWidget>
{
    public QWidget holder;
    public QLabel fNameLabel;
    public QLabel lNameLabel;
    public QLabel locLabel;
    public QLabel cStatusLabel;
    public QPushButton deleteButton;
    public QLabel fname;
    public QLabel lname;
    public QLabel cStatus;
    public QLabel location;
    public QPushButton expandButton;
    public QLabel timeLabel;
    public QLabel idLabel;
    public QLabel id;
    public QLabel currclassLab;
    public QLabel currclass;
    public QLabel entryLabel;
    public QLabel exitLabel;
    public QLabel entryTime;
    public QLabel exitTime;
    public QLabel p1;
    public QLabel p2;
    public QLabel p3;
    public QLabel p4;
    public String _id;
    
    public QPixmap b;
    QLabel im;
    private Boolean expand;
    
    

    public AdminTabs() { super(); expand = false;}

    public void setupUi(QWidget Form)
    {
        holder = new QWidget(Form);
        Form.layout().addWidget(holder);
        holder.setObjectName("holder");
        holder.setGeometry(new QRect(0, 0, 621, 101));
        
        /*
        b = new QPixmap("classpath:admin_resource/eot_icon.png");
        im = new QLabel(holder);
        im.setGeometry(new QRect(470, 10, 100, 80));
        im.setObjectName("im");
        im.setScaledContents(true);
        im.setPixmap(b);
        */

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
				"	font: 16pt \"Calibri\";\n"+
				"    color: white;\n"+
				"}\n"+
				"#fNameLabel, #lNameLabel, #locLabel, #cStatusLabel, #currclassLab, #idLabel, #timeLabel{\n"+
				"	font: 12pt \"Calibri\";\n"+
				"    color: white;\n"+
				"}\n"+
				"\n"+
				"QPushButton{\n"+
				"    background-color: white;\n"+
				"	border-radius: 10px;\n"+
				"}\n"+
				"\n"+
				"QPushButton:hover{\n"+
				"	background-color: rgb(220, 220, 220);}\n"+
				"#holder:hover{\n"+
				"	    border-width: 4px; background-color:rgba(30, 30, 30, 255);\n"+
				"}\n"+
				"\n"+
				"#p1, #p2, #p3, #p4{\n"+
				"	border-style: solid;\n"+
				"	border-color: rgba(0,0,0,0);\n"+
				"    border-width: 3px;\n"+
				"    background-color: white;\n"+
				"    color: black;\n"+
				"}\n"+
				"\n"+
				"#p1, #p2, #p3{\n"+
				"	border-right-color: rgb(0, 0, 0);\n"+
				"\n"+
				"}");
        fNameLabel = new QLabel(holder);
        fNameLabel.setObjectName("fNameLabel");
        fNameLabel.setGeometry(new QRect(10, 0, 81, 31));
        lNameLabel = new QLabel(holder);
        lNameLabel.setObjectName("lNameLabel");
        lNameLabel.setGeometry(new QRect(10, 30, 81, 31));
        locLabel = new QLabel(holder);
        locLabel.setObjectName("locLabel");
        locLabel.setGeometry(new QRect(290, 30, 121, 31));
        cStatusLabel = new QLabel(holder);
        cStatusLabel.setObjectName("cStatusLabel");
        cStatusLabel.setGeometry(new QRect(290, 60, 111, 31));
        deleteButton = new QPushButton(holder);
        deleteButton.setObjectName("deleteButton");
        deleteButton.setGeometry(new QRect(580, 10, 31, 31));
        fname = new QLabel(holder);
        fname.setObjectName("fname");
        fname.setGeometry(new QRect(120, 0, 101, 31));
        lname = new QLabel(holder);
        lname.setObjectName("lname");
        lname.setGeometry(new QRect(120, 30, 101, 31));
        cStatus = new QLabel(holder);
        cStatus.setObjectName("cStatus");
        cStatus.setGeometry(new QRect(430, 60, 111, 31));
        location = new QLabel(holder);
        location.setObjectName("location");
        location.setGeometry(new QRect(430, 30, 111, 31));
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
        id.setGeometry(new QRect(120, 60, 101, 31));
        currclassLab = new QLabel(holder);
        currclassLab.setObjectName("currclassLab");
        currclassLab.setGeometry(new QRect(290, 0, 111, 31));
        currclass = new QLabel(holder);
        currclass.setObjectName("currclass");
        currclass.setGeometry(new QRect(430, 0, 111, 31));
        
        p1 = new QLabel(holder);
        p1.setObjectName("p1");
        p1.setGeometry(new QRect(130, 110, 101, 31));
        p2 = new QLabel(holder);
        p2.setObjectName("p2");
        p2.setGeometry(new QRect(230, 110, 101, 31));
        p3 = new QLabel(holder);
        p3.setObjectName("p3");
        p3.setGeometry(new QRect(330, 110, 101, 31));
        p4 = new QLabel(holder);
        p4.setObjectName("p4");
        p4.setGeometry(new QRect(430, 110, 101, 31));
                
        retranslateUi(Form);

    } // setupUi

    void retranslateUi(QWidget Form)
    {
    	this.expandButton.clicked.connect(this, "big()");
    	this.deleteButton.clicked.connect(this, "delete()");
    	this.expandButton.raise();
    	this.deleteButton.raise();
    	
        fNameLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "First name:", null));
        lNameLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "Last name:", null));
        locLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "Current location:", null));
        cStatusLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "Current Status:", null));
        deleteButton.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", " X", null));
        fname.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "TextLabel", null));
        lname.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "TextLabel", null));
        cStatus.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "TextLabel", null));
        location.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "TextLabel", null));
        expandButton.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "\\/", null));
        timeLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "Timetable:", null));
        idLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "Admin ID:", null));
        id.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "TextLabel", null));
        currclassLab.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "Current class:", null));
        currclass.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "TextLabel", null));
        p1.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "TextLabel", null));
        p2.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "TextLabel", null));
        p3.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "TextLabel", null));
        p4.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "TextLabel", null));
    } // retranslateUi

    public void big(){
    	if( !expand ){
        	holder.setFixedHeight(161);
        	expandButton.setText("/\\");
        	expandButton.setGeometry(expandButton.x(), 120, expandButton.width(), expandButton.height());
        	expand = true;
    	}
    	else{
        	holder.setFixedHeight(101);
        	expandButton.setText("\\/");
        	expandButton.setGeometry(expandButton.x(), 60, expandButton.width(), expandButton.height());
        	expand = false;
    	}
    }
    
    public void delete(){
    	boolean status = Controller.getInstance().deleteAdmin(_id);
		QMessageBox t = new QMessageBox();
		t.setWindowIcon(new QIcon(new QPixmap("classpath:admin_resource/eot_icon.png")));

    	if( status ){
    		holder.hide();
    		holder.close();
    		t.setText("The deletion was a success");
    		t.setWindowTitle("Success");
    		t.exec();
    	}
    	else{
    		t.setText("The deletion failed");
    		t.setWindowTitle("Failed");
    		t.exec();
    	}
    }
}


package v2.View;

import v2.Controller.Controller;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class StudentTabs implements com.trolltech.qt.QUiForm<QWidget>
{
    public QWidget holder;
    public QLabel fNameLabel;
    public QLabel lNameLabel;
    public QLabel tLatesLabel;
    public QLabel tAbsentLabel;
    public QLabel cStatusLabel;
    public QPushButton deleteButton;
    public QLabel fname;
    public QLabel lname;
    public QLabel cStatus;
    public QLabel lates;
    public QLabel absents;
    public QPushButton expandButton;
    public QLabel timeLabel;
    public QLabel idLabel;
    public QLabel id;
    public QLabel curLoclabel;
    public QLabel curLocation;
    public QLabel curclaslab;
    public QLabel currClass;
    public QLabel entryLabel;
    public QLabel exitLabel;
    public QLabel entryTime;
    public QLabel exitTime;
    public QLabel p1;
    public QLabel p2;
    public QLabel p3;
    public QLabel p4;
    public String _id;
    
    private boolean expand;

    public StudentTabs() { super(); expand=false;}

    public void setupUi(QWidget Form)
    {
        holder = new QWidget(Form);
        Form.layout().addWidget(holder);
        holder.setObjectName("holder");
        holder.setGeometry(new QRect(0, 0, 621, 101));
        
        /*
        QImage b = new QImage();
        b.load("classpath:admin_resource/eot_icon.png");
        QLabel image = new QLabel(holder);
        image.setGeometry(new QRect(470, 10, 100, 80));
        image.setObjectName("image");
        image.setScaledContents(true);
        image.setPixmap(QPixmap.fromImage(b));
        //image.setMask( QPixmap.fromImage(b).mask()  );
         
         */
        
        QSizePolicy sizePolicy = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Minimum, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy.setHorizontalStretch((byte)0);
        sizePolicy.setVerticalStretch((byte)0);
        sizePolicy.setHeightForWidth(holder.sizePolicy().hasHeightForWidth());
        holder.setSizePolicy(sizePolicy);
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
				"\n"+
				"#fNameLabel, #lNameLabel, #tLatesLabel, #tAbsentLabel, #cStatusLabel, #timeLabel, #idLabel, #curclaslab, #curLoclabel, #entryLabel, #exitLabel{\n"
				+ "font: 12pt \"Calibri\";\n"+
				"    color: white;\n"+
				"}\n" +
				"QPushButton{\n"+
				"    background-color: white;\n"+
				"	border-radius: 10px;\n"+
				"}\n"+
				"\n"+
				"QPushButton:hover{\n"+
				"	background-color: rgb(220, 220, 220); }\n"+
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
        fNameLabel.setGeometry(new QRect(10, 0, 101, 31));
        lNameLabel = new QLabel(holder);
        lNameLabel.setObjectName("lNameLabel");
        lNameLabel.setGeometry(new QRect(10, 30, 81, 31));
        tLatesLabel = new QLabel(holder);
        tLatesLabel.setObjectName("tLatesLabel");
        tLatesLabel.setGeometry(new QRect(10, 130, 111, 31));
        tAbsentLabel = new QLabel(holder);
        tAbsentLabel.setObjectName("tAbsentLabel");
        tAbsentLabel.setGeometry(new QRect(270, 130, 111, 31));
        cStatusLabel = new QLabel(holder);
        cStatusLabel.setObjectName("cStatusLabel");
        cStatusLabel.setGeometry(new QRect(270, 0, 111, 31));
        
        deleteButton = new QPushButton(holder);
        deleteButton.setObjectName("deleteButton");
        deleteButton.setGeometry(new QRect(580, 10, 31, 31));
        
        fname = new QLabel(holder);
        fname.setObjectName("fname");
        fname.setGeometry(new QRect(120, 0, 131, 31));
       
        lname = new QLabel(holder);
        lname.setObjectName("lname");
        lname.setGeometry(new QRect(120, 30, 131, 31));
       
        cStatus = new QLabel(holder);
        cStatus.setObjectName("cStatus");
        cStatus.setGeometry(new QRect(390, 0, 71, 31));
       
        lates = new QLabel(holder);
        lates.setObjectName("lates");
        lates.setGeometry(new QRect(120, 130, 111, 31));
       
        absents = new QLabel(holder);
        absents.setObjectName("absents");
        absents.setGeometry(new QRect(390, 130, 111, 31));
        absents.setStyleSheet("");
       
        expandButton = new QPushButton(holder);
        expandButton.setObjectName("expandButton");
        expandButton.setGeometry(new QRect(580, 60, 31, 31));
        
        timeLabel = new QLabel(holder);
        timeLabel.setObjectName("timeLabel");
        timeLabel.setGeometry(new QRect(10, 170, 111, 31));
        
        idLabel = new QLabel(holder);
        idLabel.setObjectName("idLabel");
        idLabel.setGeometry(new QRect(10, 60, 111, 31));
        id = new QLabel(holder);
        id.setObjectName("id");
        id.setGeometry(new QRect(120, 60, 131, 31));
        
        curLoclabel = new QLabel(holder);
        curLoclabel.setObjectName("curLoclabel");
        curLoclabel.setGeometry(new QRect(270, 100, 111, 31));
        curLocation = new QLabel(holder);
        curLocation.setObjectName("curLocation");
        curLocation.setGeometry(new QRect(390, 100, 121, 31));
        curLocation.setStyleSheet("");
        
        curclaslab = new QLabel(holder);
        curclaslab.setObjectName("curclaslab");
        curclaslab.setGeometry(new QRect(10, 100, 111, 31));
        currClass = new QLabel(holder);
        currClass.setObjectName("currClass");
        currClass.setGeometry(new QRect(120, 100, 121, 31));
        currClass.setStyleSheet("");
        
        entryLabel = new QLabel(holder);
        entryLabel.setObjectName("entryLabel");
        entryLabel.setGeometry(new QRect(270, 30, 121, 31));
        
        exitLabel = new QLabel(holder);
        exitLabel.setObjectName("exitLabel");
        exitLabel.setGeometry(new QRect(270, 60, 111, 31));
        
        entryTime = new QLabel(holder);
        entryTime.setObjectName("entryTime");
        entryTime.setGeometry(new QRect(390, 30, 71, 31));
        
        exitTime = new QLabel(holder);
        exitTime.setObjectName("exitTime");
        exitTime.setGeometry(new QRect(390, 60, 71, 31));
        
        p1 = new QLabel(holder);
        p1.setObjectName("p1");
        p1.setGeometry(new QRect(120, 170, 101, 31));
        p2 = new QLabel(holder);
        p2.setObjectName("p2");
        p2.setGeometry(new QRect(220, 170, 101, 31));
        p3 = new QLabel(holder);
        p3.setObjectName("p3");
        p3.setGeometry(new QRect(320, 170, 101, 31));
        p4 = new QLabel(holder);
        p4.setObjectName("p4");
        p4.setGeometry(new QRect(420, 170, 101, 31));
        
    	this.expandButton.clicked.connect(this, "big()");
    	this.deleteButton.clicked.connect(this, "delete()");

        retranslateUi(Form);

        //Form.connectSlotsByName();
    } // setupUi

    void retranslateUi(QWidget Form)
    {
    	this.tAbsentLabel.hide();
    	this.tLatesLabel.hide();
    	this.absents.hide();
    	this.lates.hide();

    	this.expandButton.raise();
    	this.deleteButton.raise();
    	holder.lower();
    	    	
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
        curLoclabel.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "Current location:", null));
        curLocation.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "TextLabel", null));
        curclaslab.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "Current class:", null));
        currClass.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "TextLabel", null));
        
        entryLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "Entry Time:", null));
        exitLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "Exit Time:", null));
        entryTime.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "Text Label", null));
        exitTime.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "Text Label", null));
        p1.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "TextLabel", null));
        p2.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "TextLabel", null));
        p3.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "TextLabel", null));
        p4.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "TextLabel", null));
    } // retranslateUi

    public void delete(){
    	boolean status = Controller.getInstance().deleteStudent(_id);
		QMessageBox t = new QMessageBox();
		t.setWindowIcon(new QIcon(new QPixmap("classpath:admin_resource/eot_icon.png")));

    	if( status ){
    		holder.hide();
    		holder.close();
    		t.setText("The deletion was a success");
    		t.setWindowTitle("Success");
    		t.exec();
    		Controller.getInstance().work();
    	}
    	else{
    		t.setText("The deletion failed");
    		t.setWindowTitle("Failed");
    		t.exec();
    		Controller.getInstance().work();
    	}
    }
    
    public void big(){
    	if( !expand ){
        	holder.setFixedHeight(215);
        	this.tAbsentLabel.show();
        	this.tLatesLabel.show();
        	this.absents.show();
        	this.lates.show();
        	expandButton.setText("/\\");
        	expandButton.setGeometry(expandButton.x(), 170, expandButton.width(), expandButton.height());
        	expand = true;
    	}
    	else{
        	holder.setFixedHeight(101);
        	this.tAbsentLabel.hide();
        	this.tLatesLabel.hide();
        	this.absents.hide();
        	this.lates.hide();
        	expandButton.setText("\\/");
        	expandButton.setGeometry(expandButton.x(), 60, expandButton.width(), expandButton.height());
        	expand = false;
    	}

    }

}
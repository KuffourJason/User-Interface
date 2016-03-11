package v2.View;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

import v2.Controller.Controller;

public class CourseTabs implements com.trolltech.qt.QUiForm<QWidget>
{
    public QWidget holder;
    public QLabel cNameLabel;
    public QLabel idLabel;
    public QLabel peLabel;
    public QLabel locationLabel;
    public QLabel durationLabel;
    public QPushButton deleteButton;
    public QLabel cname;
    public QLabel id;
    public QLabel duration;
    public QLabel period;
    public QLabel location;
    public QLabel startLabel;
    public QLabel start;
    public String _id;

    public CourseTabs() { super(); }

    public void setupUi(QWidget Form)
    {
        holder = new QWidget(Form);
        Form.layout().addWidget(holder);
        holder.setObjectName("holder");
        holder.setGeometry(new QRect(0, 80, 621, 101));
        
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
				"#cNameLabel, #locationLabel, #durationLabel, #idLabel, #peLabel, #startLabel{\n"+
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
				"	background-color: rgb(220, 220, 220); }\n"+
				"#holder:hover{\n"+
				"	    border-width: 4px; background-color:rgba(30, 30, 30, 255);\n"+
				"}\n"+
				"");
        cNameLabel = new QLabel(holder);
        cNameLabel.setObjectName("cNameLabel");
        cNameLabel.setGeometry(new QRect(10, 0, 101, 31));
        idLabel = new QLabel(holder);
        idLabel.setObjectName("idLabel");
        idLabel.setGeometry(new QRect(10, 30, 101, 31));
        peLabel = new QLabel(holder);
        peLabel.setObjectName("peLabel");
        peLabel.setGeometry(new QRect(300, 0, 111, 31));
        locationLabel = new QLabel(holder);
        locationLabel.setObjectName("locationLabel");
        locationLabel.setGeometry(new QRect(300, 30, 111, 31));
        durationLabel = new QLabel(holder);
        durationLabel.setObjectName("durationLabel");
        durationLabel.setGeometry(new QRect(300, 60, 111, 31));
        deleteButton = new QPushButton(holder);
        deleteButton.setObjectName("deleteButton");
        deleteButton.setGeometry(new QRect(580, 10, 31, 31));
        cname = new QLabel(holder);
        cname.setObjectName("cname");
        cname.setGeometry(new QRect(130, 0, 135, 31));
        id = new QLabel(holder);
        id.setObjectName("id");
        id.setGeometry(new QRect(130, 30, 101, 31));
        duration = new QLabel(holder);
        duration.setObjectName("duration");
        duration.setGeometry(new QRect(420, 60, 101, 31));
        period = new QLabel(holder);
        period.setObjectName("period");
        period.setGeometry(new QRect(420, 0, 111, 31));
        location = new QLabel(holder);
        location.setObjectName("location");
        location.setGeometry(new QRect(420, 30, 111, 31));
        location.setStyleSheet("");
        startLabel = new QLabel(holder);
        startLabel.setObjectName("startLabel");
        startLabel.setGeometry(new QRect(10, 60, 111, 31));
        start = new QLabel(holder);
        start.setObjectName("start");
        start.setGeometry(new QRect(130, 60, 101, 31));
        retranslateUi(Form);

        //Form.connectSlotsByName();
    } // setupUi

    void retranslateUi(QWidget Form)
    {    	
    	this.deleteButton.clicked.connect(this, "delete()");
    	
        cNameLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "Course name:", null));
        idLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "Course ID:", null));
        peLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "Period:", null));
        locationLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "Location:", null));
        durationLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "Duration:", null));
        deleteButton.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", " X", null));
        cname.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "TextLabel", null));
        id.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "TextLabel", null));
        duration.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "TextLabel", null));
        period.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "TextLabel", null));
        location.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "TextLabel", null));
        startLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "Start Time:", null));
        start.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "TextLabel", null));
    } // retranslateUi

    public void delete(){
    	boolean status = Controller.getInstance().deleteCourse(_id);
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


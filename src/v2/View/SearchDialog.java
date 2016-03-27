package v2.View;

import java.util.ArrayList;

import v2.Controller.Controller;
import v2.Model.JSONhandler;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class SearchDialog implements com.trolltech.qt.QUiForm<QDialog>
{
    public QDialogButtonBox buttonBox;
    public QWidget widget;
    public QWidget widgetBack;
    public QLabel titleLabel;
    public QLineEdit searchBox;
    public QComboBox criteriaList;
    public QLabel resultsLabel;
    public QLabel searchLabel;
    public QLabel criLabel;
    public QPushButton searchEnter;
    public QDialog m;

    public SearchDialog() { super(); }

    public void setupUi(QDialog Dialog)
    {
        Dialog.setObjectName("Dialog");
        Dialog.resize(new QSize(541, 413).expandedTo(Dialog.minimumSizeHint()));
        Dialog.setMinimumSize(new QSize(541, 413));
        Dialog.setMaximumSize(new QSize(541, 413));
        Dialog.setModal(true);
        Dialog.setWindowIcon(new QIcon(new QPixmap("classpath:admin_resource/eot_icon.png")));
        buttonBox = new QDialogButtonBox(Dialog);
        buttonBox.setObjectName("buttonBox");
        buttonBox.setGeometry(new QRect(-20, 360, 342, 32));
        buttonBox.setOrientation(com.trolltech.qt.core.Qt.Orientation.Horizontal);
        buttonBox.setStandardButtons(com.trolltech.qt.gui.QDialogButtonBox.StandardButton.createQFlags(com.trolltech.qt.gui.QDialogButtonBox.StandardButton.Close));
        widget = new QWidget(Dialog);
        widget.setObjectName("widget");
        widget.setGeometry(new QRect(-1, -1, 551, 421));
        widget.setMinimumSize(new QSize(551, 421));
        widget.setMaximumSize(new QSize(551, 421));
        widget.setStyleSheet("#widget{\n"+
			"    background-color: rgba(52,52,52, 200);\n"+
			"}");
        widgetBack = new QWidget(Dialog);
        widgetBack.setObjectName("widgetBack");
        widgetBack.setGeometry(new QRect(-1, -1, 551, 421));
        widgetBack.setMinimumSize(new QSize(551, 421));
        widgetBack.setMaximumSize(new QSize(551, 421));
        widgetBack.setStyleSheet("#widgetBack{\n"+
			"	background-image: url(classpath:admin_resource/tiger_white_updated.png);\n"+
			"}");
        widgetBack.lower();
        
        titleLabel = new QLabel(widget);
        titleLabel.setObjectName("titleLabel");
        titleLabel.setGeometry(new QRect(10, 10, 521, 41));
        titleLabel.setStyleSheet("#titleLabel{\n"+
			"	color: rgb(255, 255, 255);\n"+
			"	font: 20pt \"MS Shell Dlg 2\";\n"+
			"    qproperty-alignment: AlignCenter;\n"+
			"}");
        searchBox = new QLineEdit(widget);
        searchBox.setObjectName("searchBox");
        searchBox.setGeometry(new QRect(110, 80, 191, 21));
        searchBox.setStyleSheet("#searchBox{\n"+
			"	\n"+
			"	font: 10pt \"MS Shell Dlg 2\";\n"+
			"}");
        searchBox.setMaxLength(30);
        searchBox.setFrame(true);
        searchBox.setCursorMoveStyle(com.trolltech.qt.core.Qt.CursorMoveStyle.LogicalMoveStyle);
        criteriaList = new QComboBox(widget);
        criteriaList.setObjectName("criteriaList");
        criteriaList.setGeometry(new QRect(408, 81, 81, 21));
        resultsLabel = new QLabel(widget);
        resultsLabel.setObjectName("resultsLabel");
        resultsLabel.setGeometry(new QRect(35, 130, 471, 221));
        resultsLabel.setLayoutDirection(com.trolltech.qt.core.Qt.LayoutDirection.LeftToRight);
        resultsLabel.setStyleSheet("#resultsLabel{\n"+
			"	\n"+
			"	color: rgb(255, 255, 255);\n"+
			"	font: 14pt \"MS Shell Dlg 2\";\n"+
			"\n"+
			"}");
        resultsLabel.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignLeft,com.trolltech.qt.core.Qt.AlignmentFlag.AlignTop));
        resultsLabel.setWordWrap(true);
        searchLabel = new QLabel(widget);
        searchLabel.setObjectName("searchLabel");
        searchLabel.setGeometry(new QRect(40, 80, 61, 21));
        searchLabel.setStyleSheet("#searchLabel{\n"+
			"	\n"+
			"	color: rgb(255, 255, 255);\n"+
			"	font: 12pt \"MS Shell Dlg 2\";\n"+
			"}");
        criLabel = new QLabel(widget);
        criLabel.setObjectName("criLabel");
        criLabel.setGeometry(new QRect(335, 80, 71, 21));
        criLabel.setStyleSheet("#criLabel{\n"+
			"	\n"+
			"	color: rgb(255, 255, 255);\n"+
			"	font: 12pt \"MS Shell Dlg 2\";\n"+
			"}");
        searchEnter = new QPushButton(widget);
        searchEnter.setObjectName("searchEnter");
        searchEnter.setGeometry(new QRect(280, 80, 21, 21));
        searchEnter.setStyleSheet("");
        searchEnter.setCheckable(false);
        searchEnter.setAutoDefault(true);
        searchEnter.setDefault(false);
        searchEnter.setFlat(false);
        searchEnter.setIcon(new QIcon(new QPixmap("classpath:admin_resource/search_icon.png")));
        retranslateUi(Dialog);
        buttonBox.accepted.connect(Dialog, "accept()");
        buttonBox.rejected.connect(Dialog, "reject()");
        buttonBox.raise();
        m = Dialog;
        
        this.searchEnter.setFocus();
        Dialog.connectSlotsByName();
    } // setupUi

    void retranslateUi(QDialog Dialog)
    {
    	searchEnter.clicked.connect(this, "search()");
    	
        Dialog.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Search", null));
        titleLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Student Search", null));
        searchBox.setPlaceholderText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "...", null));
        criteriaList.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "<html><head/><body><p>Criteria</p></body></html>", null));
        criteriaList.setWhatsThis(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "<html><head/><body><p>Criterias</p></body></html>", null));
        resultsLabel.setText("");
        searchLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Search:", null));
        criLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Criteria:", null));
        searchEnter.setText("");
    } // retranslateUi

    
    public void search(){
    	
		this.searchLabel.setStyleSheet(" #searchLabel{ color: white; font: 12pt \"MS Shell Dlg 2\"; } ");
		resultsLabel.setText("");
		resultsLabel.setStyleSheet("#resultsLabel{	color: rgb(255, 255, 255); font: 14pt \"MS Shell Dlg 2\";}");
    	
    	if( this.searchBox.text().equals("...") ){
    		this.searchLabel.setStyleSheet(" #searchLabel{ color: red; font: 12pt \"MS Shell Dlg 2\";} ");
    		return;
    	}
    	
    	
    	if( titleLabel.text().equals("Admin Search") ){
    		ArrayList<JSONhandler> t = Controller.getInstance().search("admin", searchBox.text(), this.criteriaList.currentText() );
    		
    		if( t.size() > 0){
    			String output =          "Name               : " + t.get(0).toString("admin_first_name") + " " + t.get(0).toString("admin_last_name");
    			output = output + "\n" + "Admin id           : " + t.get(0).toString("admin_id");
    			output = output + "\n" + "Tag id             : " + t.get(0).toString("_id");
    			output = output + "\n" + "Admin location     : " + t.get(0).toString("admin_location");
    			output = output + "\n" + "Admin current class: " + t.get(0).toString("admin_current_class");
    			
    			resultsLabel.setText(output);
    	        resultsLabel.setStyleSheet("#resultsLabel{	color: rgb(255, 255, 255); font: 15pt \"MS Shell Dlg 2\";}");
    		}
    		else{
    			resultsLabel.setText("No such admin exists");
    		}
    	}
    	else if( titleLabel.text().equals("Course Search") ){
    		ArrayList<JSONhandler> t = Controller.getInstance().search( "course", searchBox.text(), this.criteriaList.currentText() );
    		
    		if( t.size() > 0){
    			String output =          "Course Name         : " + t.get(0).toString("class_name");
    			output = output + "\n" + "Course id           : " + t.get(0).toString("_id");
    			output = output + "\n" + "Course location     : " + t.get(0).toString("class_location");
    			output = output + "\n" + "Class Period        : " + t.get(0).toString("class_period");
    			resultsLabel.setText(output);
    	        resultsLabel.setStyleSheet("#resultsLabel{	color: rgb(255, 255, 255); font: 15pt \"MS Shell Dlg 2\";}");
    		}
    		else{
    			resultsLabel.setText("No such course exists");
    		}		
    	}
    	else{
    		ArrayList<JSONhandler> t = Controller.getInstance().search( "student",searchBox.text(), this.criteriaList.currentText() );
    		
    		if( t.size() > 0){
    			String output =          "Name                 : " + t.get(1).toString("user_first_name") + " " + t.get(1).toString("user_last_name");
    			output = output + "\n" + "Student id           : " + t.get(1).toString("user_id");
    			output = output + "\n" + "Tag id               : " + t.get(0).toString("_id");
    			output = output + "\n" + "Student's status    : " + t.get(0).toString("user_status");
    			output = output + "\n" + "Student's location : " + t.get(0).toString("user_current_location");
    			output = output + "\n" + "Student's class     : " + t.get(0).toString("user_current_class");
    			
    			output = output + "\n" + "Total absences     :" + t.get(1).toString("user_number_of_absences");
    			output = output + "\n" + "Total lates          : " + t.get(1).toString("user_number_of_lates");
    			resultsLabel.setText(output);
    	        resultsLabel.setStyleSheet("#resultsLabel{	color: rgb(255, 255, 255); font: 15pt \"MS Shell Dlg 2\";}");
    		}
    		else{
    			resultsLabel.setText("No such student exists");
    		}
    	}
    }
}


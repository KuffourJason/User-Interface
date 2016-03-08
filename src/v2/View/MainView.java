package v2.View;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class MainView implements com.trolltech.qt.QUiForm<QMainWindow>
{
    public QAction actionExit;
    public QAction actionLogout;
    public QAction actionSettings;
    public QAction actionSet;
    public QFrame mainFrame; 
    public QWidget centralwidget;
    public QWidget eotImage;
    public QWidget loginFormWidget;
    public QWidget bottomBar;
    public QWidget adminTab;
    public QWidget adminTabBack;
    public QWidget adminScrollWidget;
    public QWidget studentsTab;
    public QWidget stuTabBack;
    public QWidget classTab;
    public QWidget classesTabBack;
    public QWidget cScrollWidget;
    public QWidget stuScrollWidget; 
    public QLineEdit userText;
    public QLineEdit passText;
    public QLabel userlabel;
    public QLabel passLabel;
    public QPushButton loginButton;
    public QPushButton accountButton;
    public QLabel backlabel;
    public QLabel invalidLogin;
    public QToolButton logoutButton;
    public QToolButton refreshButton;
    public QToolButton searchButton;
    public QToolButton settingButton;
    public QToolButton fillButton;
    public QTabWidget tabWidget;
    public QScrollArea adminScroll;
    public QVBoxLayout verticalLayout_4;
    public QPushButton addAdminButton;

    public QScrollArea couScroll;
    
    public QVBoxLayout verticalLayout_3;
    public QPushButton addCourse;

    public QScrollArea stuScroll;
    public QVBoxLayout verticalLayout;
    public QToolButton addStu;
    public QMenuBar menubar;
    
    public QMenu fileMenu;
    public QMenu optionsMenu;
    
    public Settings settings;
    public New_student ns;
    public New_admin na;
    public New_course nc;
    
    public MainView() { 
    	super(); 
    	this.settings = new Settings();
    	this.nc = new New_course();
    	this.na = new New_admin();
    	this.ns = new New_student();
    }

    public void setupUi(QMainWindow MainWindow)
    {
        MainWindow.setObjectName("MainWindow");
        MainWindow.resize(new QSize(679, 560).expandedTo(MainWindow.minimumSizeHint()));
        QSizePolicy sizePolicy = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);
        sizePolicy.setHorizontalStretch((byte)0);
        sizePolicy.setVerticalStretch((byte)0);
        sizePolicy.setHeightForWidth(MainWindow.sizePolicy().hasHeightForWidth());
        MainWindow.setSizePolicy(sizePolicy);
        MainWindow.setMaximumSize(new QSize(696, 560));
        MainWindow.setSizeIncrement(new QSize(1, 1));
        MainWindow.setCursor(new QCursor(Qt.CursorShape.ArrowCursor));
        MainWindow.setWindowIcon(new QIcon(new QPixmap("classpath:admin_resource/eot_icon.png"))); ///////////////////////////////////
        MainWindow.setWindowOpacity(5);
        MainWindow.setLayoutDirection(com.trolltech.qt.core.Qt.LayoutDirection.LeftToRight);
        MainWindow.setAutoFillBackground(false);
        MainWindow.setStyleSheet("");
        actionExit = new QAction(MainWindow);
        actionExit.setObjectName("actionExit");
        actionExit.setIcon(new QIcon(new QPixmap("classpath:com/trolltech/tools/designer/folder.png"))); /////////////////////////////////////
        actionLogout = new QAction(MainWindow);
        actionLogout.setObjectName("actionLogout");
        actionSettings = new QAction(MainWindow);
        actionSettings.setObjectName("actionSettings");
        actionSet = new QAction(MainWindow);
        actionSet.setObjectName("actionSet");
        centralwidget = new QWidget(MainWindow);
        centralwidget.setObjectName("centralwidget");
        QSizePolicy sizePolicy1 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.MinimumExpanding, com.trolltech.qt.gui.QSizePolicy.Policy.MinimumExpanding);
        sizePolicy1.setHorizontalStretch((byte)0);
        sizePolicy1.setVerticalStretch((byte)0);
        sizePolicy1.setHeightForWidth(centralwidget.sizePolicy().hasHeightForWidth());
        centralwidget.setSizePolicy(sizePolicy1);
        centralwidget.setMinimumSize(new QSize(679, 539));
        centralwidget.setMaximumSize(new QSize(679, 539));
        centralwidget.setSizeIncrement(new QSize(1, 1));
        centralwidget.setStyleSheet("QWidget#centralwidget{\n}");
        mainFrame = new QFrame(centralwidget);
        mainFrame.setObjectName("mainFrame");
        mainFrame.setGeometry(new QRect(-1, -1, 711, 601));
        QSizePolicy sizePolicy2 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Maximum, com.trolltech.qt.gui.QSizePolicy.Policy.Maximum);
        sizePolicy2.setHorizontalStretch((byte)35);
        sizePolicy2.setVerticalStretch((byte)0);
        sizePolicy2.setHeightForWidth(mainFrame.sizePolicy().hasHeightForWidth());
        mainFrame.setSizePolicy(sizePolicy2);
        mainFrame.setSizeIncrement(new QSize(1, 1));
        mainFrame.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        mainFrame.setFrameShadow(com.trolltech.qt.gui.QFrame.Shadow.Raised);
        eotImage = new QWidget(mainFrame);
        eotImage.setObjectName("eotImage");
        eotImage.setEnabled(true);
        eotImage.setGeometry(new QRect(-10, -10, 721, 631));
        QSizePolicy sizePolicy3 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Maximum, com.trolltech.qt.gui.QSizePolicy.Policy.Maximum);
        sizePolicy3.setHorizontalStretch((byte)0);
        sizePolicy3.setVerticalStretch((byte)0);
        sizePolicy3.setHeightForWidth(eotImage.sizePolicy().hasHeightForWidth());
        eotImage.setSizePolicy(sizePolicy3);
        eotImage.setStyleSheet("QWidget#eotImage{\n"+
        			"   background-color: rgba(255, 250, 240, 0);\n"+
        			"/*qradialgradient(spread:pad, cx:0.5, cy:0.5, radius:0.5, fx:0.5, fy:0.5, stop:0 rgba(255, 255, 255, 255), stop:1 rgba(142, 142, 142, 142));*/\n"+
        			"}");
        loginFormWidget = new QWidget(eotImage);
        loginFormWidget.setObjectName("loginFormWidget");
        loginFormWidget.setEnabled(true);
        loginFormWidget.setGeometry(new QRect(-10, -10, 711, 601));
        QSizePolicy sizePolicy4 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.MinimumExpanding, com.trolltech.qt.gui.QSizePolicy.Policy.MinimumExpanding);
        sizePolicy4.setHorizontalStretch((byte)1);
        sizePolicy4.setVerticalStretch((byte)1);
        sizePolicy4.setHeightForWidth(loginFormWidget.sizePolicy().hasHeightForWidth());
        loginFormWidget.setSizePolicy(sizePolicy4);
        loginFormWidget.setMaximumSize(new QSize(711, 601));
        loginFormWidget.setSizeIncrement(new QSize(0, 0));
        loginFormWidget.setStyleSheet("QWidget#loginFormWidget{\n"+
				"	background-color: rgba(52,52,52, 255);\n"+
				"	background-image: url(classpath:resource/back.png);\n"+		////////////////////////////////////////////////
				"    opacity: 0.1;\n"+
				"}\n"+
				"\n"+
				"#backlabel{\n"+
				"	background-color: rgba(52,52,52, 225);\n"+
				"}\n"+
				"\n"+
				"#invalidLogin{\n"+
				"	font: 12pt \"MS Shell Dlg 2\";\n"+
				"	color: rgb(255, 255, 255);\n"+
				"\n"+
				"}\n"+
				"");
        userText = new QLineEdit(loginFormWidget);
        userText.setObjectName("userText");
        userText.setGeometry(new QRect(290, 210, 231, 41));
        userText.setStyleSheet("QLineEdit#userText{\n"+
        		"	background-color: rgb(229, 229, 229);\n"+
        		"}");
        passText = new QLineEdit(loginFormWidget);
        passText.setObjectName("passText");
        passText.setGeometry(new QRect(290, 270, 231, 41));
        passText.setStyleSheet("QLineEdit#passText{\n"+
        		"	background-color: rgb(229, 229, 229);\n"+
        		"}");
        passText.setEchoMode(com.trolltech.qt.gui.QLineEdit.EchoMode.Password);
        userlabel = new QLabel(loginFormWidget);
        userlabel.setObjectName("userlabel");
        userlabel.setGeometry(new QRect(180, 220, 101, 21));
        userlabel.setStyleSheet("QLabel#userlabel{\n"+
        		"	font: 12pt \"MS Shell Dlg 2\";\n"+
        		"	color: rgb(255, 255, 255);\n"+
        		"}");
        passLabel = new QLabel(loginFormWidget);
        passLabel.setObjectName("passLabel");
        passLabel.setGeometry(new QRect(180, 280, 101, 21));
        passLabel.setStyleSheet("QLabel#passLabel{\n"+
				"	color: rgb(255, 255, 255);\n"+
				"	font: 12pt \"MS Shell Dlg 2\";\n"+
				"}");
        loginButton = new QPushButton(loginFormWidget);
        loginButton.setObjectName("loginButton");
        loginButton.setGeometry(new QRect(220, 360, 111, 31));
        accountButton = new QPushButton(loginFormWidget);
        accountButton.setObjectName("accountButton");
        accountButton.setGeometry(new QRect(360, 360, 111, 31));
        backlabel = new QLabel(loginFormWidget);
        backlabel.setObjectName("backlabel");
        backlabel.setGeometry(new QRect(20, 20, 681, 541));
        backlabel.setStyleSheet("");
        invalidLogin = new QLabel(loginFormWidget);
        invalidLogin.setObjectName("invalidLogin");
        invalidLogin.setGeometry(new QRect(145, 412, 451, 51));
        bottomBar = new QWidget(eotImage);
        bottomBar.setObjectName("bottomBar");
        bottomBar.setGeometry(new QRect(10, 510, 701, 101));
        bottomBar.setStyleSheet("QWidget#bottomBar{\n"+
				"	background-color:rgba(220,220,220, 255);\n"+
				"}\n"+
				"\n"+
				"QToolButton#refreshButton{\n"+
				"border-style: solid;\n"+
				"background: rgba(52, 52, 52, 155);\n"+
				"}\n"+
				"\n"+
				"QToolButton#searchButton{\n"+
				"color: white;\n"+
				"border-style: solid;\n"+
				"background: rgba(52, 52, 52, 155);\n"+
				"}\n"+
				"\n"+
				"QToolButton#settingButton{\n"+
				"color: white;\n"+
				"border-style: solid;\n"+
				"background: rgba(52, 52, 52, 155);\n"+
				"}\n"+
				"\n"+
				"\n"+
				"QToolButton#logoutButton{\n"+
				"	border-style: solid;\n"+
				"    background: rgba(52, 52, 52, 155);\n"+
				"    color: white;\n"+
				"}\n"+
				"\n"+
				"QToolButton#refreshButton:hover{\n"+
				"	background: rgba(52, 52, 52, 255);\n"+
				"   color: green;\n"+
				"}\n"+
				"\n"+
				"QToolButton#searchButton:hover{\n"+
				"	background: rgba(52, 52, 52, 255);\n"+
				"}\n"+
				"\n"+
				"QToolButton#logoutButton:hover{\n"+
				"	background: rgba(52, 52, 52, 255);\n"+
				"}\n"+
				"\n"+
				"QToolButton#settingButton:hover{\n"+
				"	background: rgba(52, 52, 52, 255);\n"+
				"}\n"+
				"\n"+
				"#fillButton{\n"+
				"	background: rgba(52, 52, 52, 55);\n"+
				"}");
        logoutButton = new QToolButton(bottomBar);
        logoutButton.setObjectName("logoutButton");
        logoutButton.setGeometry(new QRect(610, 0, 71, 41));
        logoutButton.setPopupMode(com.trolltech.qt.gui.QToolButton.ToolButtonPopupMode.InstantPopup);
        refreshButton = new QToolButton(bottomBar);
        refreshButton.setObjectName("refreshButton");
        refreshButton.setGeometry(new QRect(70, 0, 81, 41));
        refreshButton.setStyleSheet("");
        refreshButton.setIcon(new QIcon(new QPixmap("classpath:admin_resource/refesh_good.png")));			///////////////////////////////////////////////////
       
        refreshButton.setCheckable(false);
        searchButton = new QToolButton(bottomBar);
        searchButton.setObjectName("searchButton");
        searchButton.setGeometry(new QRect(0, 0, 71, 41));
        searchButton.setIcon(new QIcon(new QPixmap("classpath:admin_resource/search_icon.png")));								/////////////////////////////////////////////////////
        searchButton.setPopupMode(com.trolltech.qt.gui.QToolButton.ToolButtonPopupMode.InstantPopup);
        settingButton = new QToolButton(bottomBar);
        settingButton.setObjectName("settingButton");
        settingButton.setGeometry(new QRect(150, 0, 71, 41));
        settingButton.setIcon(new QIcon(new QPixmap("classpath:admin_resource/save_icon.png")));								/////////////////////				
        settingButton.setPopupMode(com.trolltech.qt.gui.QToolButton.ToolButtonPopupMode.InstantPopup);
        fillButton = new QToolButton(bottomBar);
        fillButton.setObjectName("fillButton");
        fillButton.setEnabled(false);
        fillButton.setGeometry(new QRect(220, 0, 391, 41));
        fillButton.setStyleSheet("");
        fillButton.setPopupMode(com.trolltech.qt.gui.QToolButton.ToolButtonPopupMode.InstantPopup);
        tabWidget = new QTabWidget(eotImage);
        tabWidget.setObjectName("tabWidget");
        tabWidget.setGeometry(new QRect(-10, 10, 721, 561));
        QSizePolicy sizePolicy5 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.MinimumExpanding, com.trolltech.qt.gui.QSizePolicy.Policy.MinimumExpanding);
        sizePolicy5.setHorizontalStretch((byte)0);
        sizePolicy5.setVerticalStretch((byte)0);
        sizePolicy5.setHeightForWidth(tabWidget.sizePolicy().hasHeightForWidth());
        tabWidget.setSizePolicy(sizePolicy5);
        tabWidget.setSizeIncrement(new QSize(1, 1));
        tabWidget.setStyleSheet("QTabWidget::pane { /* The tab widget frame */\n"+
				"    border-top: 2px solid #C2C7CB;\n"+
				"    /*position: absolute;*/\n"+
				"    top: -6em;\n"+
				"}\n"+
				"\n"+
				"QTabWidget::tab-bar{   /*for the bar that holds the tab panes*/\n"+
				"	alignment: center;\n"+
				"    border: 2px solid #C4C4C3;\n"+
				"    width: 250ex;\n"+
				"    \n"+
				"}\n"+
				"\n"+
				"QTabBar::tab {	/*for the actual tabs */\n"+
				"    border: 0.5px solid 	rgba(54, 69, 79, 35);\n"+
				"    border-bottom-color: 	black; /* same as the pane color */\n"+
				"    border-bottom: none;\n"+
				"    width: 75ex;\n"+
				"    height: 12.5ex;\n"+
				"    padding:1px;\n"+
				"    background-color: rgba(54, 69, 79, 55);\n"+
				"	font: 10pt \"Arial Rounded MT Bold\";\n"+
				"}\n"+
				"\n"+
				"QTabBar::tab:selected {\n"+
				"    border-color: rgb(0, 0, 0);\n"+
				"    border-bottom-color:  	rgba(54, 69, 79, 35); /* same as pane color */\n"+
				"    border-bottom: none;\n"+
				"    color: white;\n"+
				"    height: 12.5ex;\n"+
				"    background-color: rgba(52, 52, 52, 152)\n"+
				" }\n"+
				"\n"+
				"QTabBar::tab:hover:!selected{\n"+
				"	background-color: rgba(54, 69, 79, 102);\n"+
				"}\n"+
				"");
        tabWidget.setTabPosition(com.trolltech.qt.gui.QTabWidget.TabPosition.North);
        tabWidget.setTabShape(com.trolltech.qt.gui.QTabWidget.TabShape.Rounded);
        tabWidget.setUsesScrollButtons(false);
        adminTab = new QWidget();
        adminTab.setObjectName("adminTab");
        adminTabBack = new QWidget(adminTab);
        adminTabBack.setObjectName("adminTabBack");
        adminTabBack.setGeometry(new QRect(10, 0, 701, 631));
        adminTabBack.setStyleSheet("QWidget#adminTabBack{\n"+
				"	background-color : rgba(220,220,220, 200);\n"+
				"/*qradialgradient(spread:pad, cx:0.5, cy:0.5, radius:0.5, fx:0.5, fy:0.5, stop:0 rgba(255, 255, 255, 255), stop:1 rgba(142, 142, 142, 142));\n"+
				"*/\n"+
				"}\n"+
				"\n"+
				"");
        adminScroll = new QScrollArea(adminTabBack);
        adminScroll.setObjectName("adminScroll");
        adminScroll.setGeometry(new QRect(30, 110, 641, 331));
        adminScroll.setMinimumSize(new QSize(641, 331));
        adminScroll.setMaximumSize(new QSize(641, 331));
        adminScroll.setMouseTracking(false);
        adminScroll.setStyleSheet("#adminScrollWidget{\n"+
        		"	background-color: rgba(52,52,52,20);\n"+
        		"}");
        adminScroll.setVerticalScrollBarPolicy(com.trolltech.qt.core.Qt.ScrollBarPolicy.ScrollBarAsNeeded);
        adminScroll.setHorizontalScrollBarPolicy(com.trolltech.qt.core.Qt.ScrollBarPolicy.ScrollBarAlwaysOff);
        adminScroll.setWidgetResizable(true);
        adminScroll.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignLeft,com.trolltech.qt.core.Qt.AlignmentFlag.AlignTop));
        adminScrollWidget = new QWidget();
        adminScrollWidget.setObjectName("adminScrollWidget");
        adminScrollWidget.setGeometry(new QRect(0, 0, 639, 329));
        verticalLayout_4 = new QVBoxLayout(adminScrollWidget);
        verticalLayout_4.setSpacing(0);
        verticalLayout_4.setObjectName("verticalLayout_4");
        verticalLayout_4.setContentsMargins(0, 0, 0, 308);
        adminScroll.setWidget(adminScrollWidget);
        addAdminButton = new QPushButton(adminTabBack);
        addAdminButton.setObjectName("addAdminButton");
        addAdminButton.setGeometry(new QRect(280, 470, 151, 31));
        tabWidget.addTab(adminTab, com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Administrators", null));
        classTab = new QWidget();
        classTab.setObjectName("classTab");
        classesTabBack = new QWidget(classTab);
        classesTabBack.setObjectName("classesTabBack");
        classesTabBack.setGeometry(new QRect(10, 0, 701, 631));
        classesTabBack.setStyleSheet("QWidget#classesTabBack{\n"+
        		"   background-color: rgba(220,220,220, 200);\n"+
        		"}\n"+
        		"");
        couScroll = new QScrollArea(classesTabBack);
        couScroll.setObjectName("couScroll");
        couScroll.setGeometry(new QRect(30, 110, 641, 331));
        couScroll.setMinimumSize(new QSize(641, 331));
        couScroll.setMaximumSize(new QSize(641, 331));
        couScroll.setMouseTracking(false);
        couScroll.setStyleSheet("#cScrollWidget{\n"+
        		"	background-color: rgba(52,52,52,20);\n"+
        		"}");
        couScroll.setVerticalScrollBarPolicy(com.trolltech.qt.core.Qt.ScrollBarPolicy.ScrollBarAsNeeded);
        couScroll.setHorizontalScrollBarPolicy(com.trolltech.qt.core.Qt.ScrollBarPolicy.ScrollBarAlwaysOff);
        couScroll.setWidgetResizable(true);
        couScroll.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignLeft,com.trolltech.qt.core.Qt.AlignmentFlag.AlignTop));
        cScrollWidget = new QWidget();
        cScrollWidget.setObjectName("cScrollWidget");
        cScrollWidget.setGeometry(new QRect(0, 0, 639, 329));
       
        verticalLayout_3 = new QVBoxLayout(cScrollWidget);
        verticalLayout_3.setSpacing(0);
        verticalLayout_3.setObjectName("verticalLayout_3");
        verticalLayout_3.setContentsMargins(0, 0, 0, 308);
        couScroll.setWidget(cScrollWidget);
        addCourse = new QPushButton(classesTabBack);
        addCourse.setObjectName("pushButton");
        addCourse.setGeometry(new QRect(280, 470, 151, 31));
        tabWidget.addTab(classTab, com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Classes", null));
        studentsTab = new QWidget();
        studentsTab.setObjectName("studentsTab");
        stuTabBack = new QWidget(studentsTab);
        stuTabBack.setObjectName("stuTabBack");
        stuTabBack.setGeometry(new QRect(0, -20, 701, 611));
        stuTabBack.setStyleSheet("QWidget#stuTabBack{\n"+
        		"	background-color: rgba(220,220,220, 200);\n"+
        		"/*qradialgradient(spread:pad, cx:0.5, cy:0.5, radius:0.5, fx:0.5, fy:0.5, stop:0 rgba(255, 255, 255, 255), stop:1 rgba(142, 142, 142, 142));\n"+
        		"*/\n"+
        		"}");
        stuScroll = new QScrollArea(stuTabBack);
        stuScroll.setObjectName("stuScroll");
        stuScroll.setGeometry(new QRect(40, 130, 641, 331));
        stuScroll.setMinimumSize(new QSize(641, 331));
        stuScroll.setMaximumSize(new QSize(641, 331));
        stuScroll.setMouseTracking(false);
        stuScroll.setStyleSheet("#stuScrollWidget{\n"+
        		"	background-color: rgba(52,52,52,20);\n"+
        		"}");
        stuScroll.setVerticalScrollBarPolicy(com.trolltech.qt.core.Qt.ScrollBarPolicy.ScrollBarAsNeeded);
        stuScroll.setHorizontalScrollBarPolicy(com.trolltech.qt.core.Qt.ScrollBarPolicy.ScrollBarAlwaysOff);
        stuScroll.setWidgetResizable(true);
        stuScroll.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignLeft,com.trolltech.qt.core.Qt.AlignmentFlag.AlignTop));
        stuScrollWidget = new QWidget();
        stuScrollWidget.setObjectName("stuScrollWidget");
        stuScrollWidget.setGeometry(new QRect(0, 0, 639, 329));
        verticalLayout = new QVBoxLayout(stuScrollWidget);
        verticalLayout.setSpacing(0);
        verticalLayout.setObjectName("verticalLayout");
        verticalLayout.setContentsMargins(0, 0, 0, 308);
        stuScroll.setWidget(stuScrollWidget);
        addStu = new QToolButton(stuTabBack);
        addStu.setObjectName("addStu");
        addStu.setGeometry(new QRect(290, 489, 151, 31));
        tabWidget.addTab(studentsTab, com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Students", null));
        MainWindow.setCentralWidget(centralwidget);
        menubar = new QMenuBar(MainWindow);
        menubar.setObjectName("menubar");
        menubar.setGeometry(new QRect(0, 0, 679, 21));
        fileMenu = new QMenu(menubar);
        fileMenu.setObjectName("fileMenu");
        optionsMenu = new QMenu(menubar);
        optionsMenu.setObjectName("optionsMenu");
        MainWindow.setMenuBar(menubar);
        menubar.addAction(fileMenu.menuAction());
        menubar.addAction(optionsMenu.menuAction());
        fileMenu.addAction(actionLogout);
        fileMenu.addSeparator();
        fileMenu.addAction(actionExit);
        optionsMenu.addAction(actionSet);
        retranslateUi(MainWindow);
        userText.returnPressed.connect(passText, "selectAll()");
        loginButton.clicked.connect(loginFormWidget, "hide()");
        logoutButton.clicked.connect(loginFormWidget, "show()");

        tabWidget.setCurrentIndex(0);
        bottomBar.raise();	//raises the bottom bar
        
        this.loginForm();
        actionExit.triggered.connect(MainWindow, "close()"); //connect menu exit button to shutdown software
        actionLogout.triggered.connect(this, "loginForm()");
        MainWindow.connectSlotsByName();
    } 

    void retranslateUi(QMainWindow MainWindow)
    {
    	settingButton.clicked.connect(this, "display()");
    	actionSet.triggered.connect(this, "display()");
    	
    	this.addStu.clicked.connect(this, "addStudent()");;
    	this.addAdminButton.clicked.connect(this, "addAdmin()");
    	this.addCourse.clicked.connect(this, "addCourse()");    	
    	
        MainWindow.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Eye of the tiger", null));
        actionExit.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Exit", null));
        actionExit.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "<html><head/><body><p>hello</p><p><br/></p></body></html>", null));
        actionLogout.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Logout", null));
        actionSettings.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Settings", null));
        actionSet.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Settings", null));
        userText.setPlaceholderText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Username", null));
        passText.setPlaceholderText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Password", null));
        userlabel.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Username", null));
        passLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Password", null));
        loginButton.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Login", null));
        accountButton.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Create Account", null));
        backlabel.setText("");
        invalidLogin.setText("");
        logoutButton.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "logout", null));
        refreshButton.setWhatsThis(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "<html><head/><body><p>Refresh the list currently being displayed</p></body></html>", null));
        searchButton.setWhatsThis(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "<html><head/><body><p>Search for a specific person</p></body></html>", null));
        searchButton.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "search", null));
        settingButton.setWhatsThis(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "<html><head/><body><p>Change the beacon configuration settings</p></body></html>", null));
        settingButton.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "setting", null));
        fillButton.setText("");
        addAdminButton.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Add Admin", null));
        tabWidget.setTabText(tabWidget.indexOf(adminTab), com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Administrators", null));
        addCourse.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Add Course", null));
        tabWidget.setTabText(tabWidget.indexOf(classTab), com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Classes", null));
        addStu.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Add Student", null));
        tabWidget.setTabText(tabWidget.indexOf(studentsTab), com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Students", null));
        fileMenu.setTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "File", null));
        optionsMenu.setTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Options", null));
    } // retranslateUi

    public void display(){
    	QDialog t = new QDialog();
    	t.connectSlotsByName();
    	this.settings.setupUi(t);
    	t.exec();
    }
    
    public void addStudent(){
    	QDialog t = new QDialog();
    	t.connectSlotsByName();
    	this.ns.setupUi(t);
    	t.exec();
    }
    
    public void addAdmin(){
    	QDialog t = new QDialog();
    	t.connectSlotsByName();
    	this.na.setupUi(t);
    	t.exec();
    }
    
    public void addCourse(){
    	QDialog addC = new QDialog();
    	addC.connectSlotsByName();
    	this.nc.setupUi(addC);
    	addC.exec();
    }
    
    /**
     * 
     */
    public void loginForm(){
    	adminScrollWidget.raise();
    	loginFormWidget.show();
        loginFormWidget.raise();
        userText.raise();
        userlabel.raise();
        passText.raise();
        passLabel.raise();
        invalidLogin.raise();
        accountButton.raise();
        loginButton.raise();
    }
    
    /**
     * @param args
     */
    public void activate(String args[]){
    	QApplication.initialize(args);
    	QMainWindow win = new QMainWindow();
    	this.setupUi(win);
    	win.show();    	
    }

}


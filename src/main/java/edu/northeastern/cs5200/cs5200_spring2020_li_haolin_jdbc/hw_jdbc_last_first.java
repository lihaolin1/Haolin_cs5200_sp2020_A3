package edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc;
//package edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.daos;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.daos.addressImpl;
import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.daos.developerImpl;
import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.daos.pageImpl;
import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.daos.phoneImpl;
import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.daos.roleImpl;
import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.daos.userImpl;
import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.daos.websiteImpl;
import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.daos.widgetImpl;
import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models.address;
import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models.developer;
import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models.page;
import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models.person;
import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models.phone;
import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models.role;
import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models.user;
import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models.website;
import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models.widget;

//import java.sql.SQLException;
////import java.time.LocalDate;
//import java.sql.Date;
//
//import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.daos.developerImpl;
//import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.daos.pageImpl;
//import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.daos.roleImpl;
//import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.daos.userImpl;
//import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.daos.websiteImpl;
//import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models.developer;
//import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models.page;
////import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models.person;
//import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models.user;
//import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models.website;
////import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models.website_role;
////import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models.widget;
//import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models.widget;

//import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.daos.developerImpl;

public class hw_jdbc_last_first {
	// create developer and user
	
		public static void main(String[] args){	
			////insert
//			hw_jdbc_last_first.insert_value_developer_user();
//			hw_jdbc_last_first.insert_value_website();
//			hw_jdbc_last_first.insert_value_page();
			hw_jdbc_last_first.insert_value_widget();
//			hw_jdbc_last_first.insert_value_phone();
//			hw_jdbc_last_first.insert_value_address();
			
			////update
			//update phone
//			hw_jdbc_last_first.updatephone();
			// update widget 
			hw_jdbc_last_first.updatewidget();
			//update page
			hw_jdbc_last_first.updatepage();
			//update page role, swap page role
			hw_jdbc_last_first.swaprole();
		
			/////delete
			//delete alice primary address
			hw_jdbc_last_first.deletealicepaddress();
			// delete last widget in in the Contact page
			hw_jdbc_last_first.deletelastwidgetincontact();
			// delete last update page in wikipidia
			hw_jdbc_last_first.deletelastupdatepagewiki();
			//delete CNET website
			hw_jdbc_last_first.deleteCNETwebite();
			
			////store procedure
			
		}
		
		public static void insert_value_developer_user(){
			//create developer and user
			developer d1 = new developer().setadddeveloper2(1, "4321rewq", 12, "Alice","Wonder", "alice","alice","alice@wonder.com","");
			developer d2 = new developer().setadddeveloper2(2, "5432trew", 23, "Bob","Marley", "bob", "bob", "bob@marley.com","");
			developer d3 = new developer().setadddeveloper2(3, "6543ytre",34, "Charles", "Garcia", "charlie","charlie","chuch@garcia.com", "") ;
			user u1 = new user().createusermore1(1, "", 45, "Dan", "Martin", "dan","dan","dan@martin.com","");
			user u2 = new user().createusermore1(2, "", 56, "Ed", "Karaz", "ed", "ed", "ed@kar.com", "");
			//create
			developerImpl developerI = new developerImpl();
			userImpl userI = new userImpl();
			//insert developer
			try {
				developerI.createdeveloper(d1);
				developerI.createdeveloper(d2);
				developerI.createdeveloper(d3);
				//insert user
				userI.createuser(u1);
				userI.createuser(u2);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//		
//		//create website
		public static void insert_value_website() {
			//DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date(2242020);
			website w1 = new website().websiteaddmore(123, "Facebook", "an online social media and social networking service", date, date, 1234234);
			website w2 = new website().websiteaddmore(234, "Twitter", "an online news and social networking service", date, date, 4321543);
			website w3 = new website().websiteaddmore(345, "Wikipedia", "a free online encyclopedia", date, date, 3456654);
			website w4 = new website().websiteaddmore(456, "CNN", "an American basic cable and satellite television news channel", date, date, 6543345);
			website w5 = new website().websiteaddmore(567, "CNET", "an American media website that publishes reviews, news, articles, blogs, podcasts and videos on technology and consumer electronics", date, date, 5433455);
			website w6 = new website().websiteaddmore(678, "Gizmodo", "a design, technology, science and science fiction website that also writes articles on politics",date, date, 4322345);
			// create website and website role
			roleImpl roleI = new roleImpl();
			websiteImpl websiteI = new websiteImpl();
			try{
				websiteI.createWebsiteForDeveloper(1,w1);
				websiteI.createWebsiteForDeveloper(2,w2);
				websiteI.createWebsiteForDeveloper(3,w3);
				websiteI.createWebsiteForDeveloper(1,w4);
				websiteI.createWebsiteForDeveloper(2,w5);
				websiteI.createWebsiteForDeveloper(3,w6);
				
				roleI.assignWebsiteRole(1, 123, 1); //  developer, website, role,
				roleI.assignWebsiteRole(2, 123, 4);
				roleI.assignWebsiteRole(3, 123, 2);
				roleI.assignWebsiteRole(2, 234, 1); // role, developer, website
				roleI.assignWebsiteRole(3, 234, 4);
				roleI.assignWebsiteRole(1, 234, 2);
				roleI.assignWebsiteRole(3, 345, 1); // role, developer, website
				roleI.assignWebsiteRole(1, 345, 4);
				roleI.assignWebsiteRole(2, 345, 2);
				roleI.assignWebsiteRole(1, 456, 1); // role, developer, website
				roleI.assignWebsiteRole(2, 456, 4);
				roleI.assignWebsiteRole(3, 456, 2);
				roleI.assignWebsiteRole(2, 567, 1); // role, developer, website
				roleI.assignWebsiteRole(3, 567, 4);
				roleI.assignWebsiteRole(1, 567, 2);
				roleI.assignWebsiteRole(3, 678, 1); // role, developer, website
				roleI.assignWebsiteRole(1, 678, 4);
				roleI.assignWebsiteRole(2, 678, 2);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//		
		public static void insert_value_page() {
			Date date = new Date(2242020);
			page pa1 = new page().setpagemore(123, "Home", "Landing page", date, date, 123434);
			page pa2 = new page().setpagemore(234, "About", "Website description", date, date, 234545);
			page pa3 = new page().setpagemore(345, "Contact", "Addresses, phones, and contact info", date, date, 345656);
			page pa4 = new page().setpagemore(456, "Preferences", "Where users can configure their preferences", date, date, 456776);
			page pa5 = new page().setpagemore(567, "Profile", "Users can configure their personal information", date, date, 567878);
			
			pageImpl pageI = new pageImpl();
			roleImpl roleI = new roleImpl();
			try {
				//insert page
				pageI.createPageForWebsite(567, pa1);
				pageI.createPageForWebsite(678, pa2);
				pageI.createPageForWebsite(345, pa3);
				pageI.createPageForWebsite(456, pa4);
				pageI.createPageForWebsite(567, pa5);
				//insert page role
				roleI.assignPageRole(1, 123, 4); //developer, page, role
				roleI.assignPageRole(2, 123, 5);
				roleI.assignPageRole(3, 123, 3);
				roleI.assignPageRole(2, 234, 4); //developer, page, role
				roleI.assignPageRole(3, 234, 5);
				roleI.assignPageRole(1, 234, 3);
				roleI.assignPageRole(3, 345, 4); //developer, page, role
				roleI.assignPageRole(1, 345, 5);
				roleI.assignPageRole(2, 345, 3);
				roleI.assignPageRole(1, 456, 4); //developer, page, role
				roleI.assignPageRole(2, 456, 5);
				roleI.assignPageRole(3, 456, 3);
				roleI.assignPageRole(2, 567, 4); //developer, page, role
				roleI.assignPageRole(3, 567, 5);
				roleI.assignPageRole(1, 567, 3);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public static void insert_value_widget() {
			widget wi1 = new widget().setwidgetmoremore(1, "head123", 0, 0, "", "", "Welcome", 0, 0,  "", "", "", false, false, "heading");
			widget wi2 = new widget().setwidgetmoremore(2, "post234", 0, 0, "", "", "<p>Lorem</p>", 0, 0,  "", "", "", false, false, "html");
			widget wi3 = new widget().setwidgetmoremore(3, "head345", 0, 0,  "", "", "Hi", 1, 0,  "", "", "", false, false, "heading");
			widget wi4 = new widget().setwidgetmoremore(4, "intro456", 0, 0,  "", "", "<h1>Hi</h1>", 2, 0,  "", "", "", false, false, "html");
			widget wi5 = new widget().setwidgetmoremore(5, "image345", 50, 100,  "", "", "", 3, 0, "", "/img/567.png", "", false, false, "image");
			widget wi6 = new widget().setwidgetmoremore(6, "video456", 400, 300,  "", "", "", 0, 0,  "", "", "https://youtu.be/h67VX51QXiQ", true, true, "youtube");
			widgetImpl widgetI = new widgetImpl();
			//roleImpl roleI = new roleImpl();
			try {
				//insert widget
				widgetI.createWidgetForPage(123, wi1);
				widgetI.createWidgetForPage(234, wi2);
				widgetI.createWidgetForPage(345, wi3);
				widgetI.createWidgetForPage(345, wi4);
				widgetI.createWidgetForPage(345, wi5);
				widgetI.createWidgetForPage(456, wi6);
				
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public static void insert_value_phone(){
			developerImpl d = new developerImpl();
				
			phoneImpl p = new phoneImpl();
			
			try {
				person p1 = d.findpersonbyId(12);//new person();
				person p2 = d.findpersonbyId(23);
				person p3 = d.findpersonbyId(34);
				
				phone ph1 = new phone().Phone_create(1, "123-234-3456", true, p1);
				phone ph2 = new phone().Phone_create(2, "234-345-4566", false, p1);
				phone ph3 = new phone().Phone_create(3, "345-456-5677", true, p2);
				phone ph4 = new phone().Phone_create(4, "321-432-5435", true, p3);
				phone ph5 = new phone().Phone_create(5, "432-432-5433", false, p3);
				phone ph6 = new phone().Phone_create(6, "543-543-6544", false, p3);
				
				p.createphone(ph1);
				p.createphone(ph2);
				p.createphone(ph3);
				p.createphone(ph4);
				p.createphone(ph5);
				p.createphone(ph6);
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public static void insert_value_address() {
			developerImpl d = new developerImpl();
			
			addressImpl a = new addressImpl();
			
			try {
				person p1 = d.findpersonbyId(12);//new person();
				person p2 = d.findpersonbyId(23);
				person p3 = d.findpersonbyId(34);
				
				address ad1 = new address().address_create(1, "123 Adam St","", " Alton", "", "01234", true, p1);
				address ad2 = new address().address_create(2, "234 Birch St","", "Boston", "", "02345", false, p1);
				address ad3 = new address().address_create(3, "345 Charles St","", "Chelms", ""," 03455", true, p2);
				address ad4 = new address().address_create(4, "456 Down St","", "Dalton", "", "04566",  false, p2);
				address ad5 = new address().address_create(5, "543 East St","", "Everett","", "01112", false, p2);
				address ad6 = new address().address_create(6, "654 Frank St","", "Foulton", "", "04322",  true, p3);
				
				a.createaddress(ad1);
				a.createaddress(ad2);
				a.createaddress(ad3);
				a.createaddress(ad4);
				a.createaddress(ad5);
				a.createaddress(ad6);
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public static void updatephone() {
			phoneImpl pI = new phoneImpl();
			phoneImpl pI1 = new phoneImpl();
			try {
				phone ph = new phone(); 
				ph = pI.findphoneBynumber("321-432-5435");
				pI1.updatephone(ph, "333-444-5555");
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public static void updatewidget() {
			widgetImpl wI = new widgetImpl();
			widgetImpl wI1 = new widgetImpl();
			try {
				widget w = new widget().setwidgetmoremore(3, "head345", 0, 0,  "", "", "Hi", 3, 0,  "", "", "", false, false, "heading");
				wI1.updateWidget(3, w);
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public static void updatepage() {
			pageImpl paI = new pageImpl();
			pageImpl paI1 = new pageImpl();
			Collection<page> page_collection = new ArrayList<page>();
			try {
				page_collection = paI.findPagesForWebsite(567);
				Iterator<page> it = page_collection.iterator();
				while(it.hasNext()) {
					page p = new page();
					p =(page) it.next();
					p.settitle("CNET-" + p.gettitle());
					paI1.updatePage(p.getpageId(), p);
				}
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public static void swaprole() {
			roleImpl pr = new roleImpl();
			roleImpl pr1 = new roleImpl();
			pageImpl paI2 = new pageImpl();
			try {
				//page p = new page();
				//p = paI2.findPageById(123);
				pr.deletePageRole(3, 123, 3);
				pr.assignPageRole(3, 123, 5);
				pr1.deletePageRole(2, 123, 5);
				pr1.assignPageRole(2, 123, 3);
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public static void deletealicepaddress() {
			addressImpl aI = new addressImpl();
			Collection<address> a_collect = new ArrayList<address>();
			try {
				a_collect = aI.findAlladdress();
				Iterator<address> it = a_collect.iterator();
				while(it.hasNext()) {
					address ad = new address();
					ad =(address) it.next();
					if (ad.getaddprimary() && ad.getpersonaddress().getId() == 12) {
						aI.deleteaddress(ad.getaddressId());
					}
				}
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public static void deletelastwidgetincontact() {
			widgetImpl wI = new widgetImpl();
			widgetImpl wI1 = new widgetImpl();
			try {
				Collection<widget> w_collection = wI.findWidgetsForPage(345);
				Iterator<widget> it = w_collection.iterator();
				widget save_wid = new widget();
				int max_o = 0;
				while(it.hasNext()) {
					widget wid = (widget) it.next();
					if (max_o < wid.getorder()) {
						max_o = wid.getorder();
						save_wid = wid;
					}
				}
				wI1.deleteWidget(save_wid.getwidgetId());
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public static void deletelastupdatepagewiki() {
			pageImpl peI = new pageImpl();
			pageImpl peI1 = new pageImpl();
			try {
				Collection<page> p_collection = peI.findPagesForWebsite(345);
				Iterator<page> it = p_collection.iterator();
				page save_page = new page();
				Date max_d = new Date(0);
				while(it.hasNext()) {
					page pa = (page) it.next();
					if (max_d.before(pa.getupdated()) || max_d.equals(pa.getupdated())) {
						max_d = pa.getupdated();
						save_page = pa;
					}
				}
				peI1.deletePage(save_page.getpageId());
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public static void deleteCNETwebite() {
			websiteImpl webI = new websiteImpl();
			try {
				webI.deleteWebsite(567);
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}


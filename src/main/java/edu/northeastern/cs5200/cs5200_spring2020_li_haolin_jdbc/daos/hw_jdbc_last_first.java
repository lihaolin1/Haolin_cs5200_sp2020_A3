package edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.daos;

import java.sql.SQLException;
//import java.time.LocalDate;
import java.sql.Date;

import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models.developer;
import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models.page;
//import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models.person;
import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models.user;
import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models.website;
//import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models.website_role;
//import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models.widget;
import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models.widget;

//import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.daos.developerImpl;

public class hw_jdbc_last_first {
	// create developer and user
	
	public static void main() {
		hw_jdbc_last_first.insert_value_developer_user();
		hw_jdbc_last_first.insert_value_website();
		hw_jdbc_last_first.insert_value_page();
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
	
	//create website
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
	
//	public static void insert_value_widget() {
//		widget wi1 = new widget().setwidgetmoremore(1, "head123", null, null, "", "", "Welcome", 0, null,  "", "", "", null, null, "heading");
//		widget wi2 = new widget().setwidgetmoremore(2, "post234", null, null, "", "", "<p>Lorem</p>", 0, null,  "", "", "", null, null, "html");
//		widget wi3 = new widget().setwidgetmoremore(3, "head345", null, null,  "", "", "Hi", 1, null,  "", "", "", null, null, "heading");
//		widget wi4 = new widget().setwidgetmoremore(4, "intro456", null, null,  "", "", "<h1>Hi</h1>", 2, null,  "", "", "", null, null, "html");
//		widget wi5 = new widget().setwidgetmoremore(5, "image345", 50, 100,  "", "", "", 3, null, "", "/img/567.png", "", null, null, "image");
//		widget wi6 = new widget().setwidgetmoremore(6, "video456", 400, 300,  "", "", "", 0, null,  "", "", "https://youtu.be/h67VX51QXiQ", 1, 1, "youtube");
//		widgetImpl widgetI = new widgetImpl();
//		roleImpl roleI = new roleImpl();
//		try {
//			//insert widget
//			widgetI.createWidgetForPage(123, wi1);
//			widgetI.createWidgetForPage(234, wi2);
//			widgetI.createWidgetForPage(345, wi3);
//			widgetI.createWidgetForPage(345, wi4);
//			widgetI.createWidgetForPage(345, wi5);
//			widgetI.createWidgetForPage(456, wi6);
//			
//		}catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}

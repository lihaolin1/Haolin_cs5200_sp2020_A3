package edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models;

import org.springframework.lang.Nullable;

//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//import java.util.Collection;
//import java.util.List;
//
//import javax.persistence.Entity;

//@Entity
public class widget {
	private int widget_id;
	private String name;
	private int width;
	private int height;
	@Nullable private String cssClass;
	@Nullable private String cssStyle;
	@Nullable private String text;
	@Nullable private int orders;
	
	@Nullable private int size;//heading;
	@Nullable private String src; //image
	@Nullable private String html; //html
	@Nullable private String url;   //youtube
	@Nullable private boolean sharble; 
	@Nullable private boolean expandable;
	private String Dtype;
	
	// id
	public int getwidgetId() {
		return widget_id;
	}
	public void setwidgetId(int widget_id) {
		this.widget_id = widget_id;
	}
	// name
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	// width
	public int getwidth() {
		return width;
	}
	public void setwidth(int width) {
		this.width = width;
	}
	// height
	public int getheight() {
		return height;
	}
	public void setheight(int height) {
		this.height = height;
	}
	// cssClass
	public String getcssClass() {
		return cssClass;
	}
	public void setcssClass(String cssClass) {
		this.cssClass = cssClass;
	}
	// cssStyle
	public String getcssStyle() {
		return cssStyle;
	}
	public void setcssStyle(String cssStyle) {
		this.cssStyle = cssStyle;
	}
	// text
	public String gettext() {
		return text;
	}
	public void settext(String text) {
		this.text = text;
	}
	//order
	public int getorder() {
		return orders;
	}
	public void setorder(int orders) {
		this.orders = orders;
	}
	
	// size
	public int getsize() {
		return size;
	}
	public void setsize(int size) {
		this.size = size;
	}
	
	// html
	public String gethtml() {
		return html;
	}
	public void sethtml(String html) {
		this.html = html;
	}
	
	// src
	public String getsrc() {
		return src;
	}
	public void setsrc(String src) {
		this.src = src;
	}
	
	// url
	public String geturl() {
		return url;
	}
	public void seturl(String url) {
		this.url = url;
	}
	// sharable
	public boolean getsharble() {
		return sharble;
	}
	public void setsharble(boolean sharble) {
		this.sharble = sharble;
	}
	//expandable
	public boolean getexpandable() {
		return expandable;
	}
	public void setexpandable(boolean expandable) {
		this.expandable = expandable;
	}
	// Dtype
	public String getDtype() {
		return Dtype;
	}
	public void setDtype(String Dtype) {
		this.Dtype = Dtype;
	}
		
	//add widget with more information
	public void setwidgetmore(int wid, String name, int width, int height, String cssStyle, String cssCLass, String text, int order) {
		this.widget_id = wid;
		this.name = name;
		this.width = width;
		this.height = height;
		this.cssStyle = cssStyle;
		this.cssClass = cssCLass;
		this.text = text;
		this.orders = order;
	}
	// add more more information
//	headingwidget headingwidget;
//	htmlwidget htmlwidget;
//	imagewidget imagewidget;
//	youtubewidget youtubewidget;
	public widget setwidgetmoremore(int wid, String name, int width, int height, @Nullable String cssStyle, @Nullable String cssCLass, @Nullable String text, int order, @Nullable int size, @Nullable String html, @Nullable String src, @Nullable String url, @Nullable boolean sharble, @Nullable boolean expandable, String type) {
		this.widget_id = wid;
		this.name = name;
		this.width = width;
		this.height = height;
		this.cssStyle = cssStyle;
		this.cssClass = cssCLass;
		this.text = text;
		this.orders = order;
		this.size = size;
		this.html = html;
		this.src = src;
		this.url = url;
		this.sharble = sharble;
		this.expandable = expandable;
		this.Dtype = type;
		return this;
//		// add more to child
//		if(type == "heading") {
//			//size
//			headingwidget.setsize(size);
//		}
//		else if(type == "html") {
//			//html
//			htmlwidget.sethtml(html);
//		}
//		else if(type == "image") {
//			//src
//			imagewidget.setsrc(src);
//		}
//		else { //youtube
//			//url, sharable, expandable
//			youtubewidget.set_all_together(url, sharble, expandable);
//			//youtubewidget.seturl(url);
//			//youtubewidget.setsharble(sharble);
//			//youtubewidget.setexpandable(expandable);
//		}
		
	}
	
	// page_id
	//@ManyToOne()
	//@JsonIgnore
	private page pageid; //foreigner key
	
	public page getpageforwidget() {
		return pageid;
	}
	
	//to headingwidget
	//@OneToMany(mappedBy = "widget_hid")
//	private Collection<headingwidget> widgetheadid;
//	//to htmlwidget
//	//@OneToMany(mappedBy = "widget_htid")
//	private Collection<htmlwidget> widgethtmlid;
//	//to imagewidget
//	//@OneToMany(mappedBy = "widget_iid")
//	private Collection<imagewidget> widgetimageid;
//	//to youtubewidget
//	//@OneToMany(mappedBy = "widget_yid")
//	private Collection<youtubewidget> widgetyoutubeid;
//	
	
	public widget() {
		
	}
}

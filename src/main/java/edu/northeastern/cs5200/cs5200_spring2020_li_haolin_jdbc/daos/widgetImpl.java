package edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.myConnection;
//import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models.page;
//import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models.page;
import edu.northeastern.cs5200.cs5200_spring2020_li_haolin_jdbc.models.widget;
@Service
public class widgetImpl implements widgetDao{
	public widgetImpl() {
		
	}
	@Override
	public void createWidgetForPage(int pageId, widget widget) throws SQLException {
		Connection conn = null;
        PreparedStatement ps = null;
        String sql = "insert into widget(widget_id, name, width, height, cssClass, cssStyle, text, orders, size, src, html, url, sharble, expandable, Dtype, pageid)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
        try {
            conn = myConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, widget.getwidgetId());
            ps.setString(2, widget.getname());
            ps.setInt(3, widget.getwidth());
            ps.setInt(4, widget.getheight());
            ps.setString(5, widget.getcssClass());
            ps.setString(6, widget.getcssStyle());
            ps.setString(7, widget.gettext());
            ps.setInt(8, widget.getorder());
            ps.setInt(9, widget.getsize());
            ps.setString(10, widget.getsrc());
            ps.setString(11, widget.gethtml());
            ps.setString(12, widget.geturl());
            ps.setBoolean(13, widget.getsharble());
            ps.setBoolean(14, widget.getexpandable());
            ps.setString(15, widget.getDtype());
            ps.setInt(16, pageId);//page.getwebdeveloperid().getwebsiteId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("failed create widget!");
        } finally {
            myConnection.closeConnection();
        }
        System.out.println("success create widget!");
	}
	
	@Override
	public Collection<widget> findAllWidgets() throws SQLException {
		List<widget> allwidget = new ArrayList<widget>();
		Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        widget wid = null;
        String sql = "select * from widget";
        try {
        	conn = myConnection.getConnection();
        	ps = conn.prepareStatement(sql);
        	rs = ps.executeQuery();
        	while(rs.next()) {
        		wid = new widget();
        		wid.setwidgetId(rs.getInt("widget_id"));
        		wid.setname(rs.getString("name"));
        		wid.setwidth(rs.getInt("width"));
        		wid.setheight(rs.getInt("height"));
        		wid.setcssClass(rs.getString("cssClass"));
        		wid.setcssStyle(rs.getString("cssStyle"));
        		wid.settext(rs.getString("csstext"));
        		wid.setorder(rs.getInt("orders"));
        		wid.setsize(rs.getInt("size"));
        		wid.setsrc(rs.getString("src"));
        		wid.sethtml(rs.getString("html"));
        		wid.seturl(rs.getString("url"));
        		wid.setsharble(rs.getBoolean("sharble"));
        		wid.setexpandable(rs.getBoolean("expandable"));
        		wid.setDtype(rs.getString("Dtype"));
        		//allwidget.createWidgetForPage(rs.getInt("pageid"), wid);
        		allwidget.add(wid);
        	}
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("failed to select all widget!");
        } finally {
        	myConnection.closeConnection();
        }
        System.out.println("success to selecct all widget!");
		return allwidget;
	}
	@Override
	public widget findWidgetById(int widgetId) throws SQLException {
		Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        widget wid = null;
        String sql = "select * from widget where widget_id = ?";
        try {
        	conn = myConnection.getConnection();
        	ps = conn.prepareStatement(sql);
        	ps.setInt(1, widgetId);
        	rs = ps.executeQuery();
        	if (rs.next()) {
        	wid = new widget();
        	wid.setwidgetId(rs.getInt("widget_id"));
        	wid.setname(rs.getString("name"));
        	wid.setwidth(rs.getInt("width"));
        	wid.setheight(rs.getInt("height"));
        	wid.setcssClass(rs.getString("cssClass"));
        	wid.setcssStyle(rs.getString("cssStyle"));
        	wid.settext(rs.getString("csstext"));
        	wid.setorder(rs.getInt("orders"));
        	wid.setsize(rs.getInt("size"));
        	wid.setsrc(rs.getString("src"));
        	wid.sethtml(rs.getString("html"));
        	wid.seturl(rs.getString("url"));
        	wid.setsharble(rs.getBoolean("sharble"));
        	wid.setexpandable(rs.getBoolean("expandable"));
        	wid.setDtype(rs.getString("Dtype"));
        	}
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("failed to select widget by id!");
        } finally {
        	myConnection.closeConnection();
        }
        System.out.println("success to selecct widget by id!");
		return wid;
	}
	
	@Override
	public Collection<widget> findWidgetsForPage(int pageId) throws SQLException {
		List<widget> findwidgetpage = new ArrayList<widget>();
		Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        widget wid = null;
        String sql = "select * from widget where pageid = ?";
        try {
        	conn = myConnection.getConnection();
        	ps = conn.prepareStatement(sql);
        	ps.setInt(1, pageId);
        	rs = ps.executeQuery();
        	while(rs.next()) {
        		wid = new widget();
        		wid.setwidgetId(rs.getInt("widget_id"));
        		wid.setname(rs.getString("name"));
        		wid.setwidth(rs.getInt("width"));
        		wid.setheight(rs.getInt("height"));
        		wid.setcssClass(rs.getString("cssClass"));
        		wid.setcssStyle(rs.getString("cssStyle"));
        		wid.settext(rs.getString("text"));
        		wid.setorder(rs.getInt("orders"));
        		wid.setsize(rs.getInt("size"));
        		wid.setsrc(rs.getString("src"));
        		wid.sethtml(rs.getString("html"));
        		wid.seturl(rs.getString("url"));
        		wid.setsharble(rs.getBoolean("sharble"));
        		wid.setexpandable(rs.getBoolean("expandable"));
        		wid.setDtype(rs.getString("Dtype"));
        		findwidgetpage.add(wid);
        	}
        }catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("failed to select widget by pageid!");
        } finally {
        	myConnection.closeConnection();
        }
        System.out.println("success to selecct widget by pageid!");
		return findwidgetpage;
	}
	
	@Override
	public int updateWidget(int widgetId, widget widget) throws SQLException {
		Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "update widget set name = ?, width = ?, height = ?, cssClass = ?, cssStyle = ?, text = ?, orders = ?, size = ?, src = ?, html = ?, url = ?, sharble = ?, expandable = ?, Dtype = ? where widget_id = ?";
        try {
        	conn = myConnection.getConnection();
        	ps = conn.prepareStatement(sql);
        	//ps.setInt(1, pageId);
        	//web = new website();
            ps.setString(1,widget.getname());
            ps.setInt(2, widget.getwidth());
            ps.setInt(3, widget.getheight());
            ps.setString(4, widget.getcssClass());
            ps.setString(5, widget.getcssStyle());
            ps.setString(6, widget.gettext());
            ps.setInt(7, widget.getorder());
            ps.setInt(8, widget.getsize());
            ps.setString(9, widget.getsrc());
            ps.setString(10, widget.gethtml());
            ps.setString(11, widget.geturl());
            ps.setBoolean(12, widget.getsharble());
            ps.setBoolean(13, widget.getexpandable());
            ps.setString(14, widget.getDtype());
            ps.setInt(15, widgetId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("failed to update by widget id!");
        } finally {
        	myConnection.closeConnection();
        }
        System.out.println("success to update by widget id!");
		return widgetId;
	}
	@Override
	public int deleteWidget(int widgetId) throws SQLException {
		Connection conn = null;
        PreparedStatement ps = null;
        String sql = "delete from widget where widget_id=?";
        try {
            conn = myConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,widgetId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("fail delete widget!");
        } finally {
            myConnection.closeConnection();
        }
        System.out.println("success delete widget!");
		return widgetId;
	}
}

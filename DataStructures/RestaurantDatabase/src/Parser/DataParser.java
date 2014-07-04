package Parser;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import Database.MainMenu;
import Database.MenuItem;
import Database.Restaurant;
import Database.SubMenu;
public class DataParser {

	URL url;
	
	DataParser(String WebsiteUrl){
		try {
			url = new URL(WebsiteUrl);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		init(url);
	}

    public DataParser() {
		// TODO Auto-generated constructor stub
	}

	public Restaurant mimiCafe(String mimiUrl) {
    	Restaurant res = new Restaurant("Mimis Cafe");
    	res.setURL(mimiUrl);
    	MainMenu mainmenu = new MainMenu();

    	SubMenu sb = getSubMenu(mimiUrl,"MenuBreakfast.aspx");
		mainmenu.addSubMenu(sb);
		sb = getSubMenu(mimiUrl,"MenuLunch.aspx");
		mainmenu.addSubMenu(sb);
		sb = getSubMenu(mimiUrl, "MenuDinner.aspx");
		mainmenu.addSubMenu(sb);
		
		res.setMainMenu(mainmenu);
		
		return res;
		
	}

	private SubMenu getSubMenu(String url,String string) {
		SubMenu submenu = new SubMenu();
		try {

			
			URL newurl = new URL(url+"/"+string);
			submenu.setName(string.replace(".aspx", ""));
			String MenuPageSrc = readPageToBuffer(newurl);
			int startPos=1,endPos=0;
			String MenuItemName,description,price;
			boolean veg;
			
			while(true){
				startPos = MenuPageSrc.indexOf("menuItem_title",startPos);

				MenuItem menuitem = new MenuItem();
				startPos = MenuPageSrc.indexOf("'>", startPos);
				endPos = MenuPageSrc.indexOf("</a>", startPos);
				MenuItemName = MenuPageSrc.substring(startPos+2,endPos);
				if(startPos == -1){
					break;
				}
				startPos = MenuPageSrc.indexOf("menuItem_desc",startPos);
				startPos = MenuPageSrc.indexOf(">", startPos);
				endPos = MenuPageSrc.indexOf("</div>", startPos);
				description = MenuPageSrc.substring(startPos+1,endPos);
				if(description.equals("")){
					break;
				}
				menuitem.setName(MenuItemName.replace("&nbsp", ""));
				menuitem.setDescription(description.replace("&nbsp", ""));
				
				setVegitem(menuitem);
				
				submenu.addMenuItem(menuitem);
			}	
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return submenu;
	}

	public void setVegitem(MenuItem m){
		String MenuItemName = m.getName().toLowerCase();
		String description = m.getDescription().toLowerCase();
		if(MenuItemName.contains("beef")||MenuItemName.contains("steak") ||MenuItemName.contains("egg") || MenuItemName.contains("crab") || MenuItemName.contains("chicken") ||MenuItemName.contains("omelette") ||
				MenuItemName.contains("bacon") || MenuItemName.contains("ham") || description.contains("steak")|| description.contains("crab")||description.contains("omelette")||
				description.contains("egg") || description.contains("chicken") ||description.contains("bacon") || description.contains("ham")|| description.contains("beef")){
			m.setVeg(false);	
		}
	}
	public Restaurant iHOP(String string) {
    	Restaurant res = new Restaurant("i-HOP");
    	res.setURL(string);
    	MainMenu mainmenu = new MainMenu();

    	SubMenu sb = getiHopSubMenu(string,"/index.php?option=com_content&task=view&id=228&Itemid=2");
		mainmenu.addSubMenu(sb);
		sb = getiHopSubMenu(string,"/index.php?option=com_content&task=view&id=229&Itemid=2");
		mainmenu.addSubMenu(sb);
		sb = getiHopSubMenu(string,"/index.php?option=com_content&task=view&id=230&Itemid=2");
		mainmenu.addSubMenu(sb);
		sb = getiHopSubMenu(string,"/index.php?option=com_content&task=view&id=231&Itemid=2");
		mainmenu.addSubMenu(sb);
		sb = getiHopSubMenu(string,"/index.php?option=com_content&task=view&id=232&Itemid=2");
		mainmenu.addSubMenu(sb);
		sb = getiHopSubMenu(string,"/index.php?option=com_content&task=view&id=233&Itemid=2");
		mainmenu.addSubMenu(sb);
		sb = getiHopSubMenu(string,"/index.php?option=com_content&task=view&id=234&Itemid=2");
		mainmenu.addSubMenu(sb);
		sb = getiHopSubMenu(string,"/index.php?option=com_content&task=view&id=235&Itemid=2");
		mainmenu.addSubMenu(sb);
		sb = getiHopSubMenu(string,"/index.php?option=com_content&task=view&id=236&Itemid=2");
		mainmenu.addSubMenu(sb);
		
		
		res.setMainMenu(mainmenu);
		return res;
		
	}

	private SubMenu getiHopSubMenu(String url, String string) {
		SubMenu submenu = new SubMenu();
		try {

			//submenu.setName("subMenu");
			URL newurl = new URL(url+string);
			
			String MenuPageSrc = readPageToBuffer(newurl);
			int startPos=0,endPos;
			String MenuItemName,description,price;
			boolean veg;
			
			startPos = MenuPageSrc.indexOf("menu_nav_on",0);
			startPos = MenuPageSrc.indexOf(">",startPos);
			endPos = MenuPageSrc.indexOf("<",startPos);
			submenu.setName(MenuPageSrc.substring(startPos,endPos));
			
			startPos = endPos = 0;
			while(true){
				startPos = MenuPageSrc.indexOf("menuitem_div",startPos);
				if(startPos == -1){
					break;
				}
				MenuItem menuitem = new MenuItem();
				startPos = MenuPageSrc.indexOf("<strong>", startPos);
				endPos = MenuPageSrc.indexOf("</strong>", startPos);
				MenuItemName = MenuPageSrc.substring(startPos+8,endPos);
				if(startPos == -1){
					break;
				}
				startPos = endPos+7;
				endPos = MenuPageSrc.indexOf("</div>", startPos);
				description = MenuPageSrc.substring(startPos+2,endPos);
				
				menuitem.setName(MenuItemName.replace("&nbsp;", ""));
				menuitem.setDescription(description.replace("&nbsp;", ""));
				
				setVegitem(menuitem);
				if(!description.contains("SIGNATURE FAVORITE")){
					submenu.addMenuItem(menuitem);
				}
				
			}	
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return submenu;
	}



	private void init(URL url) {
    	String HomepageSrc = readPageToBuffer(url);
    	TextScrapper txtScrapper = new TextScrapper(HomepageSrc.toLowerCase());
    	
    	String siteMaplink = txtScrapper.getSiteMapLink();
    	String SiteMappageSrc = "";
		try {
			URL siteMapUrl = new URL(this.url+"/"+siteMaplink);
			SiteMappageSrc = readPageToBuffer(siteMapUrl);
			
			if(SiteMappageSrc.contains("MENU")){
				String menuLink  = siteMaplink.replaceAll("sitemap", "menu");
				URL MenuUrl = new URL(menuLink);
				
			}
			
			
			
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);
		}
		
		//txtScrapper = new TextScrapper(SiteMappageSrc);
		
		//String menuLink = txtScrapper.getmenuLink();
	}
	
	public String readPageToBuffer(URL url) {
        //create a Stirng buffer object to read the URL page source text.
        StringBuffer response = new StringBuffer();
        try{
            //create a URL openstream connection
            //read the URL page obtained text into a bufferedReader
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            
            //declare a string 
            String str;
            
            //untill the URL reaches the end, keep reading it into a buffer
            while ((str = in.readLine()) != null) {
                // str is one line of text; readLine() strips the newline character(s)
                response.append(str);
            }
            
            //close the URL connection
            in.close();
        }
        //handle any IO exception
        catch (IOException e) {
            System.out.println("IOException");
            return "";
        }           
        
        //return the read response string
        return response.toString();
    }




}

package com.koroyan.valutecourse.model;


import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "channel",strict = false)
public class Channel {
    @Element(name = "title",required = false)
    private String title;
    @Element(name = "link",required = false)
    private String link;
    @Element(name = "description",required = false)
    private String description;
    @Element(name = "language",required = false)
    private String language;
    @Element(name = "copyright",required = false)
    private String copyright;
    @Element(name = "pubDate",required = false)
    private String pubDate;
    @Element(name = "lastBuildDate",required = false)
    private String lastBuildDate;
    @Element(name = "managingEditor",required = false)
    private String managingEditor;
    @Element(name = "webMaster",required = false)
    private String webMaster;
    @Element(name = "item",required = false)
    private Item item;

    public String getTitle() { return title; }
    public void setTitle(String value) { this.title = value; }

    public String getLink() { return link; }
    public void setLink(String value) { this.link = value; }

    public String getDescription() { return description; }
    public void setDescription(String value) { this.description = value; }

    public String getLanguage() { return language; }
    public void setLanguage(String value) { this.language = value; }

    public String getCopyright() { return copyright; }
    public void setCopyright(String value) { this.copyright = value; }

    public String getPubDate() { return pubDate; }
    public void setPubDate(String value) { this.pubDate = value; }

    public String getLastBuildDate() { return lastBuildDate; }
    public void setLastBuildDate(String value) { this.lastBuildDate = value; }

    public String getManagingEditor() { return managingEditor; }
    public void setManagingEditor(String value) { this.managingEditor = value; }

    public String getWebMaster() { return webMaster; }
    public void setWebMaster(String value) { this.webMaster = value; }

    public Item getItem() { return item; }
    public void setItem(Item value) { this.item = value; }
}

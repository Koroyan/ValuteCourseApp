package com.koroyan.valutecourse.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "item",strict = false)
public class Item {
    @Element(name = "title",required = false)
    private String title;
    @Element(name = "link",required = false)
    private String link;
    @Element(name = "description",required = false)
    private String description;
    @Element(name = "pubDate",required = false)
    private String pubDate;
    @Element(name = "guid",required = false)
    private String guid;

    public String getTitle() { return title; }
    public void setTitle(String value) { this.title = value; }

    public String getLink() { return link; }
    public void setLink(String value) { this.link = value; }

    public String getDescription() { return description; }
    public void setDescription(String value) { this.description = value; }

    public String getPubDate() { return pubDate; }
    public void setPubDate(String value) { this.pubDate = value; }

    public String getGUID() { return guid; }
    public void setGUID(String value) { this.guid = value; }
}


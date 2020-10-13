package com.koroyan.valutecourse.model;


import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "rss",strict = false)
public class RSS {
    @Element(name = "channel",required = false)
    private Channel channel;
    @Element(name = "version",required = false)
    private String version;

    public Channel getChannel() { return channel; }
    public void setChannel(Channel value) { this.channel = value; }

    public String getVersion() { return version; }
    public void setVersion(String value) { this.version = value; }
}

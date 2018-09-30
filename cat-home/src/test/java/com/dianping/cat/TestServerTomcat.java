package com.dianping.cat;

import org.apache.catalina.Context;
import org.apache.catalina.Globals;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import java.io.File;

import javax.servlet.ServletException;

public class TestServerTomcat {
    public static void main(String[] args){
        Tomcat tomcat = new Tomcat();
        String baseDir = ".";
        tomcat.setPort(8080);
        tomcat.setBaseDir(baseDir);
        tomcat.getHost().setAppBase(baseDir);
        tomcat.getHost().setAutoDeploy(true);
        tomcat.enableNaming();
        String webappDirLocation = "cat-home/src/main/webapp";
        String projectPath=new File(webappDirLocation).getAbsolutePath();
        try {
            Context webContext = tomcat.addWebapp("/cat",projectPath);
            webContext.getServletContext().setAttribute(Globals.ALT_DD_ATTR, projectPath + "/WEB-INF/web.xml");
            tomcat.start();
            tomcat.getServer().await();
        } catch (LifecycleException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}
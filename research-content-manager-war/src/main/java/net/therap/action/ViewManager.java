package net.therap.action;

import net.therap.domain.Property;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name="viewManager")
@ViewScoped
public class ViewManager   implements Serializable{

    private  ArrayList<Property>   cacheList = new ArrayList ();
    private Property item = new Property();
    public ViewManager() {
    }
    
    private boolean edit;

    public void add() {
        cacheList.add(item);
        item = new Property();

    }

    public void edit(Property item) {
        this.item = item;
        edit = true;
    }

    public void save() {
        item = new Property();  
        edit = false;
    }

    public void delete(Property item) {
        cacheList.remove(item);
    }

    public List getCacheList() {
        return cacheList;
    }
    public Property getItem() {
        return item;
    }

    public boolean isEdit() {
        return edit;
    }
}


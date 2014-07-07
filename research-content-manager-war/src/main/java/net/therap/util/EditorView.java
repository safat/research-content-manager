package net.therap.util;

/**
 * Created by shakhawat.hossain on 7/6/14.
 */
import javax.faces.bean.ManagedBean;

@ManagedBean
public class EditorView {

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
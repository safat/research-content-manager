package net.therap.action;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * Created by shakhawat.hossain on 7/1/14.
 */

@ManagedBean (name = "homeAction", eager = true)
@ApplicationScoped
public class HomeAction implements Serializable {

    public List<String> getResearchTopicList(){
        return Arrays.asList("data mining", "networking", "machine -learning");
    }
}

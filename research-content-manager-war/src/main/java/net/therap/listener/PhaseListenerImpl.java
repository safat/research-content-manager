package net.therap.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import java.util.List;

/**
 * Created by shakhawat.hossain on 7/7/14.
 */

public class PhaseListenerImpl implements PhaseListener {

    private int indent;
    private StringBuilder componentTreeStr;
    private UIComponent rootComponent;

    private Logger logger = LoggerFactory.getLogger(PhaseListenerImpl.class);

    @Override
    public void beforePhase(PhaseEvent phaseEvent) {
        componentTreeStr = new StringBuilder();
        componentTreeStr.append("\n\n#STARTING PHASE ----------------"+phaseEvent.getPhaseId()+"------------------\n\n");

        rootComponent = FacesContext.getCurrentInstance().getViewRoot();

    }

    @Override
    public void afterPhase(PhaseEvent phaseEvent) {
       rootComponent = FacesContext.getCurrentInstance().getViewRoot();
       PhaseId currentPhaseId = phaseEvent.getPhaseId();
       if( currentPhaseId == PhaseId.RESTORE_VIEW || currentPhaseId == PhaseId.RENDER_RESPONSE) {
            printComponentTree(rootComponent);
        }

       componentTreeStr.append("\n\n  #END PHASE ---------------------"+phaseEvent.getPhaseId()+"-----------------\n\n");
       logger.info(componentTreeStr.toString());
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }

    private void printComponentTree(UIComponent comp) {
        printComponentInfo(comp);

        List componentList =  comp.getChildren();

        if (componentList.size() > 0) {
            indent++;
        }

        for (int i = 0; i < componentList.size(); i++) {
            UIComponent uiComponent = (UIComponent) componentList.get(i);
            printComponentTree(uiComponent);
            if (i  == componentList.size() -1) {
                indent--;
            }
        }
    }

    public void printComponentInfo(UIComponent comp) {

        if (comp.getId() == null) {
            componentTreeStr.append("UIViewRoot" + " " + "(" + comp.getClass().getName() + ") # child count : "+ comp.getChildCount() +"\n");
        } else {
            printIndent();
            componentTreeStr.append("|\n");
            printIndent();
            componentTreeStr.append(comp.getId() + " " + "(" + comp.getClass().getCanonicalName()+ ")# child count : "+ comp.getChildCount() +"\n");
        }
    }

    public void printIndent() {
        for (int i = 0; i < indent; i++)
               componentTreeStr.append("\t");
    }
}

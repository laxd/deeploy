package uk.laxd.deepweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import uk.laxd.deepweb.plugin.PluginDefinition;
import uk.laxd.deepweb.service.BuildFlowStepExecutorService;

import java.util.Collection;

/**
 * Created by lawrence on 17/03/16.
 */
@Controller
@RequestMapping("/executor")
public class ExecutorController {

    @Autowired
    private BuildFlowStepExecutorService executorService;

    @RequestMapping(value = "modal")
    public @ResponseBody String getModal(String type) {
        Collection<PluginDefinition> definitions = executorService.getPluginDefinitions();

        for(PluginDefinition definition : definitions) {
            if(type.equals(definition.getName())) {
                return definition.getInstance().getConfigurationHtml();
            }
        }

        return "";
    }

}

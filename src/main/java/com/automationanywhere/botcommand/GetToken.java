package com.automationanywhere.botcommand;

import com.automationanywhere.bot.service.GlobalSessionContext;
import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.botcommand.exception.BotCommandException;
import com.automationanywhere.commandsdk.annotations.BotCommand;
import com.automationanywhere.commandsdk.annotations.CommandPkg;
import com.automationanywhere.commandsdk.annotations.Execute;

import static com.automationanywhere.commandsdk.model.DataType.STRING;
@BotCommand
@CommandPkg(label = "[[TokenTypeDemo.label]]",description = "[[TokenTypeDemo.description]]", icon = "sample.svg", name = "Get_Token" ,
        return_label = "[[TokenTypeDemo.return_label]]", return_type = STRING, return_required = true)
public class GetToken {


    @com.automationanywhere.commandsdk.annotations.GlobalSessionContext
    private GlobalSessionContext globalSessionContext;


    public void setGlobalSessionContext(GlobalSessionContext globalSessionContext) {
        this.globalSessionContext = globalSessionContext;
    }


    @Execute
    public Value<String> action() {

        try {
            String token = this.globalSessionContext.getUserToken();
            return new StringValue(token);
        } catch (Exception e) {
            throw new BotCommandException("Error Occurred while fetching credential: " + e);
        }



    }
}







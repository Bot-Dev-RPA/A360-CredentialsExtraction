package com.automationanywhere.botcommand;

import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.botcommand.exception.BotCommandException;
import com.automationanywhere.commandsdk.annotations.BotCommand;
import com.automationanywhere.commandsdk.annotations.CommandPkg;
import com.automationanywhere.commandsdk.annotations.Execute;
import com.automationanywhere.commandsdk.annotations.Idx;
import com.automationanywhere.commandsdk.annotations.Pkg;
import com.automationanywhere.commandsdk.annotations.rules.CredentialAllowPassword;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;
import com.automationanywhere.commandsdk.model.AttributeType;
import com.automationanywhere.core.security.SecureString;

import static com.automationanywhere.commandsdk.model.DataType.STRING;


@BotCommand
@CommandPkg(label = "[[CredentialTypeDemo.label]]",description = "[[CredentialTypeDemo.description]]", icon = "sample.svg", name = "Credential_Extraction" ,
        return_label = "[[CredentialTypeDemo.return_label]]", node_label = "Extract credential and save to {{returnTo}}",return_type = STRING, return_required = true)
public class GetCredential {

    @Execute
    public Value<String> action(@Idx(index = "1", type = AttributeType.CREDENTIAL)
                                    @Pkg(label = "[[CredentialTypeDemo.credentials.label]]") @NotEmpty
                                     @CredentialAllowPassword       SecureString credentials) {
        try {
            String result = credentials.getInsecureString();
            return new StringValue(result);
        } catch (Exception e) {
            throw new BotCommandException("Error Occurred while fetching credential: " + e);
        }



    }
}

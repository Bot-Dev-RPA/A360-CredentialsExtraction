package com.automationanywhere.botcommand;

import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.botcommand.exception.BotCommandException;
import com.automationanywhere.commandsdk.annotations.BotCommand;
import com.automationanywhere.commandsdk.annotations.CommandPkg;
import com.automationanywhere.commandsdk.annotations.Execute;
import com.automationanywhere.commandsdk.annotations.Idx;
import com.automationanywhere.commandsdk.annotations.Pkg;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;
import com.automationanywhere.commandsdk.model.AttributeType;
import com.automationanywhere.core.security.SecureString;

import static com.automationanywhere.commandsdk.model.DataType.STRING;


@BotCommand
@CommandPkg(label = "[[CredentialTypeDemo.label]]",description = "[[CredentialTypeDemo.description]]", icon = "sample.svg", name = "Credential_Extraction" ,
        return_label = "[[CredentialTypeDemo.return_label]]", return_type = STRING, return_required = true)
public class GetCredential {

    @Execute
    public Value<String> action(@Idx(index = "1", type = AttributeType.CREDENTIAL)
                                    @Pkg(label = "[[CredentialTypeDemo.credentials.label]]") @NotEmpty
                                            SecureString credentials) {
        // SecureString provides multiple way to access the data inside.
        // Let's try to get the user name and print it in logs.

        // To get the credential as String
        try {
            String result = credentials.getInsecureString();
            return new StringValue(result);
        } catch (Exception e) {
            throw new BotCommandException("Error Occurred while fetching credential: " + e);
        }



    }
}
